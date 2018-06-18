package servlet;

import java.io.IOException;

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
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		// emm.setTraining("yes-this-is-a-thin-pretty-pink-thistle");
		// String text = emm.getTraining();
		String text = "yes-this-is-a-thin-pretty-pink-thistle";
		// emm.buildMap();
		MarkovRunnerWithInterface mrwi = new MarkovRunnerWithInterface();
		String markovText = mrwi.runModel(emm, text, size, seed);
		ServletOutputStream out = resp.getOutputStream();
		out.write(markovText.getBytes());
		out.flush();
		out.close();
	}

}
