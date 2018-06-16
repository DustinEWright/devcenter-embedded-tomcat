package part2;

import java.util.ArrayList;
import java.util.Random;

public class MarkovFour extends AbstractMarkovModel {

	public MarkovFour() {
		myRandom = new Random();
		order = 4;
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
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length() - 4);
		String key = myText.substring(index, index + 4);
		sb.append(key);

		for (int k = 0; k < numChars - 4; k++) {
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
