package part2;
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
	protected String myText;
	protected Random myRandom;
	protected int order;

	public AbstractMarkovModel() {
		myRandom = new Random();
	}

	public void setRandom(int seed) {
		myRandom = new Random(seed);
	}

	public void setTraining(String s) {
		myText = s.trim();
	}

	abstract public String getRandomText(int numChars);

	public String toString() {
		return "MarkovModel of order " + order;
	}

	// Begin Assignment 2 here.
	// Copied from MarkovFour
	protected ArrayList<String> getFollows(String key) {
		ArrayList<String> follows = new ArrayList<>();

		int pos = 0;
		int myTextLength = myText.length();
		for (int index = 0; index < myText.length(); index++) {
			if (myTextLength != myText.length()) {
				// System.out.println("MyTextLength Change!!!");
			}
			if (follows.size() >= myTextLength) {
				// System.out.println("Follows Size Exceedes myTextLength!!!!!");
			}
			pos = index + key.length(); // The 1st index position of key
			// System.out.println("myText length: " + myText.length() + " index: " + index);
			if (enoughRoom(myText, pos, key)) {
				if (myText.substring(index, index + key.length()).equals(key)) {
					// System.out.println("outer if line 73: " + enoughRoom(myText, pos, key));
					String toBeAdded = myText.substring(pos, pos + 1);
					if ((toBeAdded.length() + index) < myText.length()) {
						// System.out.println(
						// "key: " + "\"" + key + "\"" + " found at index: " + index + " follows: " +
						// follows);
						// System.out.println("String toBeAdded to follows: " + "\"" +
						// myText.substring(pos, pos + 1)
						// + "\"" + " index of the char to be added to follows: " + pos);
						follows.add(myText.substring(pos, pos + 1));
						// System.out.println("follows after.add: " + follows);
					}
				}
				// System.out.println("outer if line 85: " + enoughRoom(myText, pos, key) +
				// "\n");
			}
		}
		// System.out.println("follows is: " + follows.size());
		return follows;
	}

	public boolean enoughRoom(String myText2, int pos, String key) {
		boolean enough = myText2.length() >= pos + 1;
		// System.out.println("enough is: " + enough + " at pos: " + pos);
		return enough;
	}

}
