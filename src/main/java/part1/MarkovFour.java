package part1;

import java.util.ArrayList;
import java.util.Random;

public class MarkovFour {
	private String myText;
	private Random myRandom;

	public MarkovFour() {
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

	public String getRandomText(int numChars) {	
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length() - 4);
		String key = myText.substring(index, index  + 4);
		sb.append(key);		

		for (int k = 0; k < numChars - 4; k++) {
			ArrayList<String> follows = getFollows(key);
			//System.out.println("key " + key + " " + follows);
			if (follows.size() == 0) {
				break;
			}
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			//System.out.println("Current key: " + key + " " + "follows: " + follows + " " + "next: " + next);
			key = key.substring(1) + next;
			//System.out.println("New key: " + key);
		}		
		return sb.toString();
	}


	public ArrayList<String> getFollows(String key) {
		ArrayList<String> follows = new ArrayList<>();

		int pos = 0;
		int myTextLength = myText.length();
		for (int index = 0; index < myText.length(); index++) {
			if (myTextLength != myText.length()) {
				//System.out.println("MyTextLength Change!!!");
			}
			if (follows.size() >= myTextLength) {
				//System.out.println("Follows Size Exceedes myTextLength!!!!!");
			}
			pos = index + key.length(); // The 1st index position of key
			//System.out.println("myText length: " + myText.length() + " index: " + index);
			if (enoughRoom(myText, pos, key)) {
				if (myText.substring(index, index + key.length()).equals(key)) {
					//System.out.println("outer if line 73: " + enoughRoom(myText, pos, key));
					String toBeAdded = myText.substring(pos, pos + 1);
					if ((toBeAdded.length() + index) < myText.length()) {
						//System.out.println(
						//		"key: " + "\"" + key + "\"" + " found at index: " + index + " follows: " + follows);
						//System.out.println("String toBeAdded to follows: " + "\"" + myText.substring(pos, pos + 1)
						//		+ "\"" + " index of the char to be added to follows: " + pos);
						follows.add(myText.substring(pos, pos + 1));
						//System.out.println("follows after.add: " + follows);
					}
				}
				//System.out.println("outer if line 85: " + enoughRoom(myText, pos, key) + "\n");
			}
		}
		//System.out.println("follows is: " + follows.size());
		return follows;
	}

	public boolean enoughRoom(String myText2, int pos, String key) {
		boolean enough = myText2.length() >= pos + 1;
		//System.out.println("enough is: " + enough + " at pos: " + pos);
		return enough;
	}

}
