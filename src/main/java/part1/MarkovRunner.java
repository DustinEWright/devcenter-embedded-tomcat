package part1;
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;
import part1.MarkovZero;

public class MarkovRunner {

	MarkovZero mz = new MarkovZero();

	// Modify the runMarkovZero method to call the setRandom method with the seed
	// 42. Run this method at least twice. What do you observe? Now change to seed
	// to 101. Run it at least twice. You should get different text than you got
	// with the seed 42, but every time you run it you get the same text.

	// https://www.coursera.org/learn/java-programming-design-principles/discussions/weeks/3/threads/3qfrwYdXEeaqqQqH4Vl8gQ/replies/mxMKNofnEea3TAq7IWfZSQ
	public void runMarkovZero() {
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovZero markov = new MarkovZero();
		markov.setTraining(st);
		markov.setRandom(88);
		for (int k = 0; k < 3; k++) {
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}

	// In the class MarkovRunner, make a copy of the method runMarkovZero, and name
	// this method runMarkovOne. Then change the line MarkovZero markov = new
	// MarkovZero(); to MarkovOne markov = new MarkovOne();.

	public String runMarkovOne() {
		String result = "null - results not yet created";
		FileResource fr = new FileResource("data/confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovOne markov = new MarkovOne();
		markov.setTraining(st);
		markov.setRandom(273);
		for (int k = 0; k < 3; k++) {
			String text = markov.getRandomText(500);
			printOut(text);
			result = text;
		}
		return result;
	}

	public String runMarkovFour() {
		String result = "null - results not yet created";
		FileResource fr = new FileResource("data/confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovFour markov = new MarkovFour();
		markov.setTraining(st);
		markov.setRandom(371);
		for (int k = 0; k < 3; k++) {
			String text = markov.getRandomText(500);
			printOut(text);
			result = text;
		}
		return result;
	}

	// In the MarkovRunner class, create the method runMarkovModel to generate
	// random text using the
	// MarkovModel class. If you set the random seed with 38 and run this method
	// with N = 6 on confucius.txt,
	// the first line of text should start with:

	public String runMarkovModel(int keyLength) {
		String result = "null - results not yet created";
		FileResource fr = new FileResource("data/confucius.txt"); 
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovModel markov = new MarkovModel(keyLength);
		markov.setTraining(st);
		markov.setRandom(365);
		for (int k = 0; k < 3; k++) {
			String text = markov.getRandomText(500);
			printOut(text);
			result = text;
		}
		return result;

	}

	
	public void printOut(String s) {
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
