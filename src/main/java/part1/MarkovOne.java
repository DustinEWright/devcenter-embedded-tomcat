package part1;

import java.util.ArrayList;
import java.util.Random;

public class MarkovOne {
	private String myText;
	private Random myRandom;

	public MarkovOne() {
		myRandom = new Random();
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

	// In the class MarkovOne modify the method getRandomText so that it works
	// the way it should for MarkovOne. It should predict the next character, by
	// finding all the characters that follow the current character in the training
	// text, and then randomly picking one of them as the next character.

	public String getRandomText(int numChars) {
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length() - 1);
		String key = myText.substring(index, index + 1);
		sb.append(key);

		for (int k = 0; k < numChars - 1; k++) {
			ArrayList<String> follows = getFollows(key);
			if (follows.size() == 0) {
				break;
			}
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			key = next;
		}
		return sb.toString();
	}

	// In the class MarkovOne, write the method getFollows that has one String
	// parameter named key. This method should find all the characters from the
	// private variable myText in MarkovOne that follow key and put all these
	// characters into an ArrayList and then return this ArrayList. This algorithm
	// for this method was described in “Finding Follow Sets.” For example, if
	// myText were “this is a test yes this is a test.”, then the call
	// getFollows(“t”) should return an ArrayList with the Strings “h”, “e”, “ “,
	// “h”, “e”, “.” as “t” appears 6 times. The call getFollows(“e”) should return
	// an ArrayList with the Strings “s”, “s”, “s”. Your method should work even if
	// key is a word. Thus, getFollows(“es”) should return an ArrayList with the
	// Strings “t”, “ “, “t”. Next we will write a method to test this method.

	public ArrayList<String> getFollows(String key) {
		ArrayList<String> follows = new ArrayList<>();
		// --------------------111111
		// ----------0123456789012345
		// myText = "an apple a day";
		// ----------^n ^p--- ^- ^y

		// ------------111111111122222222223333
		// --0123456789012345678901234567890123
		// “this is a test yes this is a test.”
		// -------------^^---^^------------^^--

		int pos = 0;
		int myTextLength = myText.length();
		for (int index = 0; index < myText.length(); index++) {
			if (myTextLength != myText.length()) {
				// System.out.println("MyTextLength Change!!!");
			}
			if (follows.size() >= myTextLength) {
				// System.out.println("Follows Size Exceeds myTextLength!!!!!");
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
