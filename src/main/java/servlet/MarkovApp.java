package servlet;

import part2.EfficientMarkovModel;
import part2.MarkovRunnerWithInterface;

public class MarkovApp {

	public static void main(String[] args) {
		int keyLength = 2;
		int seed = 42;
		int size = 5000;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		//emm.setTraining("yes-this-is-a-thin-pretty-pink-thistle");
		//String text = emm.getTraining();
		String text = "aaaaaaaaaaaaaaayes-this-is-a-thin-pretty-pink-thistle";
		//emm.buildMap();
		MarkovRunnerWithInterface mrwi = new MarkovRunnerWithInterface();
		String markovText = mrwi.runModel(emm, text, size, seed);
		System.out.format("markovText = '%s'\n", markovText);
	}
}
