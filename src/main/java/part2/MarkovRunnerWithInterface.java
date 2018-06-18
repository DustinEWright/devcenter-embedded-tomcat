package part2;
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

public class MarkovRunnerWithInterface {

	// Write a new method named testHashMap in the MarkovRunnerWithInterface class.
	// This method should create an order-2 EfficientMarkovModel with
	// seed 42
	// the training text is “yes-this-is-a-thin-pretty-pink-thistle”
	// the size of the text generated is 50
	// Note that “le” occurs only once at the end of the training text

	public void testHashMap() {
		EfficientMarkovModel emm = new EfficientMarkovModel(2);
		int seed = 42;
		String text = "yes-this-is-a-thin-pretty-pink-thistle";
		int size = 50;
		runModel(emm, text, size, seed);
		emm.buildMap();
		emm.printHashMapInfo();
	}

	// In the MarkovRunnerWithInterface class, create a void method named
	// compareMethods that runs a MarkovModel and an EfficientMarkovModel. In
	// particular,

	// Make both order-2 Markov models
	// Use seed 42 and set the length of text to generate to be 1000
	// Both should call runModel that generates random text three times for each.
	// Run the MarkovModel first and then the EfficientMarkovModel with the file
	// “hawthorne.txt” as the training text. One of them should be noticeably
	// faster. You can calculate the time each takes by using System.nanoTime() for
	// the current time.

	public void compareMethods() {
		FileResource fr = new FileResource("data/hawthorne.txt");
		String text = fr.asString();
		text = text.replace('\n', ' ');
		EfficientMarkovModel emm = new EfficientMarkovModel(2);
		int seed = 42;
		int size = 1000;
		runModel(emm, text, size, seed);
		emm.buildMap();
		emm.printHashMapInfo();

		MarkovModel mm = new MarkovModel(2);
		runModel(mm, text, size, seed);
	}

	// Modify your program so that you can set a seed in the runMarkov method in the
	// MarkovRunnerWithInterface class and pass it to the
	// runModel method (add a 4th parameter named seed) to set the random seed for
	// any markov object. In the runModel class* you should be
	// able to set this seed with the line:

	// markov.setRandom(seed).
	// class is used in the assignment. That's wrong, should be method.

	public String runModel(IMarkovModel markov, String text, int size, int seed) {
		markov.setTraining(text);
		markov.setRandom(seed);
		StringBuilder sb = new StringBuilder();
		System.out.println("running with " + markov);
		for (int k = 0; k < 3; k++) {
			String st = markov.getRandomText(size);
			sb.append(st);
		}
		return sb.toString();
	}

	public void runMarkov(int seed) {
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 200;

		MarkovZero mz = new MarkovZero();
		runModel(mz, st, size, seed);

		MarkovOne mOne = new MarkovOne();
		runModel(mOne, st, size, seed);

		MarkovModel mThree = new MarkovModel(3);
		runModel(mThree, st, size, seed);

		MarkovFour mFour = new MarkovFour();
		runModel(mFour, st, size, seed);

	}

	private void printOut(String s) {
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for (int k = 0; k < words.length; k++) {
			System.out.print(words[k] + " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}

}
