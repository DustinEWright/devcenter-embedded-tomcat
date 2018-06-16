package part2;

import java.util.ArrayList;
import java.util.Random;

public class MarkovModel extends AbstractMarkovModel {
	private int keyLength;

	public MarkovModel(int keyLength) {
		myRandom = new Random();
		this.keyLength = keyLength;
		order = keyLength;
	}

	public void setMyText(String value) {
		this.myText = value;
	}

	public void setRandom(int seed) {
		myRandom = new Random(seed);
	}

	public void setTraining(String s) {
		myText = s.trim();
	}

	public String getRandomText(int numChars) {
		System.out.println("getRandomText MarkovModel called");
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length() - keyLength);
		String key = myText.substring(index, index + keyLength);
		sb.append(key);

		for (int k = 0; k < numChars - keyLength; k++) {
			ArrayList<String> follows = getFollows(key);
			// System.out.println("key " + key + " " + follows);
			if (follows.size() == 0) {
				break;
			}
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			// System.out.println("Current key: " + key + " " + "follows: " + follows + " "
			// + "next: " + next);
			key = key.substring(1) + next;
			// System.out.println("New key: " + key);
		}
		return sb.toString();
	}

}
