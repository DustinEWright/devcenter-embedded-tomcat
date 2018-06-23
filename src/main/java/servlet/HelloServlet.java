package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		//int size = 50;

		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		// http://localhost:8080/hello?length=75&training=ge
		String lengthString = req.getParameter("length");
		int length = Integer.parseInt(lengthString);
		// emm.setTraining("yes-this-is-a-thin-pretty-pink-thistle");
		// String text = emm.getTraining();
		// String text = "new material has now been added to our training set
		// yes-this-is-a-thin-pretty-pink-thistle";

		String abbreviation = req.getParameter("training");
		String trainingURL = getGutenburgUrl(abbreviation);
		String training = urlReader(trainingURL);
		emm.setTraining(training);

		emm.buildMap();
		MarkovRunnerWithInterface mrwi = new MarkovRunnerWithInterface();
		String markovText = mrwi.runModel(emm, training, length, seed);
		// String markovText = training + " : " + seed + " : " + size;
		markovText += "\nYou passed a value of length: " + length;

		ServletOutputStream out = resp.getOutputStream();
		out.write(markovText.getBytes());
		out.flush();
		out.close();
	}

	public String urlReader(String urlString) throws IOException {
		String inputLine = "";
		StringBuilder sb = new StringBuilder();
		URL url = new URL(urlString);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		while ((inputLine = in.readLine()) != null) {
			sb.append(inputLine);
		}
		in.close();
		return sb.toString();

	}

	public String getGutenburgUrl(String training) {
		if (training.equals("ts")) {
			training = "http://www.gutenberg.org/files/74/74-0.txt";
		} else if (training.equals("ge")) {
			training = "http://www.gutenberg.org/files/1400/1400-0.txt";
		}
		return training;
	}

}
