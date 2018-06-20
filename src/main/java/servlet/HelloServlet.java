package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import part2.EfficientMarkovModel;
import part2.MarkovRunnerWithInterface;

@WebServlet(name = "MyServlet", urlPatterns = { "/hello" })
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int keyLength = 2;
		int seed = 42;
		int size = 5000;
		String length = req.getParameter("length");
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		// emm.setTraining("yes-this-is-a-thin-pretty-pink-thistle");
		// String text = emm.getTraining();
		String text = "new material has now been added to our training set yes-this-is-a-thin-pretty-pink-thistle";
		// emm.buildMap();
		MarkovRunnerWithInterface mrwi = new MarkovRunnerWithInterface();
		String markovText = mrwi.runModel(emm, text, size, seed);
		markovText += "\nYou passed a value of length: " + length;

		ServletOutputStream out = resp.getOutputStream();
		out.write(markovText.getBytes());
		out.flush();
		out.close();
	}

	public String urlReader(String urlString) throws IOException {
		URL ts = new URL("http://www.gutenberg.org/files/74/74-0.txt");
		URL ge = new URL("http://www.gutenberg.org/files/1400/1400-0.txt");
		String inputLine = "none found";

		if (urlString.equals(ts.toString())) {
			BufferedReader in = new BufferedReader(new InputStreamReader(ts.openStream()));
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
			in.close();
		}

		if (urlString.equals(ge.toString())) {
			BufferedReader in = new BufferedReader(new InputStreamReader(ge.openStream()));
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
			in.close();
		}
		return inputLine;
	}
}
