package part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class EfficientMarkovModel extends AbstractMarkovModel {
	private int keyLength;
	private HashMap<String, ArrayList<String>> map;
	private String gram;

	public EfficientMarkovModel(int keyLength) {
		myRandom = new Random();
		this.keyLength = keyLength;
		order = keyLength;
		map = new HashMap<String, ArrayList<String>>();
	}

	public String toString() {
		return "EfficientMarkovModel of order " + order;
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

	// https://github.com/urakozz/java-duke-course/blob/master/src/main/java/com/urakozz/week3/interf/EfficientMarkovModel.java
	// might help
	// https://www.coursera.org/learn/java-programming-design-principles/discussions/weeks/3/threads/-lGg4LQTEeW2NBLvq9LZHQ?sort=createdAtAsc&page=1
	// .....eee
	// .....023
	// .....ee
	// ......ee
	// Make private when testing is complete
	public void buildMap() {
		for (int i = 0; i < myText.length(); i++) {
			if (i + order < myText.length()) {
				gram = myText.substring(i, i + order);
			} else {
				gram = myText.substring(i);
			}
			int gramLength = gram.length();
			int gramIndex = myText.indexOf(gram);
			int myTextLength = myText.length();
			int endGramIndex = gramLength + gramIndex;
			// Checks for valid grams. FollowsChar not checked yet
			if (endGramIndex <= myTextLength) {
				if (!map.containsKey(gram)) {
					map.put(gram, new ArrayList<String>());
				}
			}
		}
		// System.out.println("++++++++++++map size " + map.size());
		ArrayList<String> gramList = new ArrayList<String>(map.keySet());
		Collections.sort(gramList);
		// System.out.println("gramList " + gramList);
		// Runs through each gram gathering all chars that follow adding each to it's
		// list in the map
		String followsChar = "Unknown";
		for (String currentKey : map.keySet()) {
			int currentKeyIndex = 0;
			while (currentKeyIndex != -1) {
				currentKeyIndex = myText.indexOf(currentKey, currentKeyIndex);
				if (currentKeyIndex + order + 1 <= myText.length()) {
					followsChar = myText.substring(currentKeyIndex + order, currentKeyIndex + order + 1);
					ArrayList<String> currentList = map.get(currentKey);
					// System.out.println("map does not contain " + followsChar + " in map " +
					// map.get(currentKey));
					currentList.add(followsChar);
					map.put(currentKey, currentList);
					// System.out.println("checking map after add " + map.get(currentKey));
				}
				currentKeyIndex = myText.indexOf(currentKey, currentKeyIndex + 1);
			}
		}
		Set<String> keySet = map.keySet();
		ArrayList<String> keyList = new ArrayList<String>();
		keyList.addAll(keySet);

		for (String key : keyList) {
			ArrayList<String> value = map.get(key);
			if (value.isEmpty()) {
				// System.out.println(" **" + key);
				map.remove(key);
			}
		}
	}

	// a getFollows method, but this getFollows method should be much shorter, as it
	// can look up the ArrayList of Strings, instead of computing it each time.

	public ArrayList<String> getFollows(String key) {
		System.out.println("key " + key + " follows: " + map.get(key));
		return map.get(key);
	}

	// To test your HashMap to make sure it is built correctly, write the void
	// method printHashMapInfo in the EfficientMarkovModel class. Make sure to call
	// this method immediately after building the map. This method should print out
	// the following information about the HashMap:

	// Print the HashMap (all the keys and their corresponding values). Only do this
	// if the HashMap is small.
	// Print the number of keys in the HashMap
	// Print the size of the largest value in the HashMap—that is, the size of the
	// largest ArrayList of characters
	// Print the keys that have the maximum size value.

	public void printHashMapInfo() {
		System.out.println("********** Printing HashMapInfo Begins **********\n");
		if (map.size() < 50) {
			System.out.println(map);
		} else {
			System.out.println("Map is too large to print.");
		}
		System.out.println("Number of keys: " + map.size());
		System.out.println("Largest map value: " + findLargestMapValue(map));
		System.out.println("Largest value keys: " + MaxKeyValue(map) + "\n");

		System.out.println("\n********** Printing HashMapInfo Ends **********");
	}

	public int findLargestMapValue(HashMap<String, ArrayList<String>> map) {
		int largestValue = 0;
		int currentValueSize = 0;
		for (String key : map.keySet()) {
			currentValueSize = map.get(key).size();
			if (currentValueSize > largestValue) {
				largestValue = currentValueSize;
			}
		}
		return largestValue;
	}

	public ArrayList<String> MaxKeyValue(HashMap<String, ArrayList<String>> map) {
		ArrayList<String> maxKeyList = new ArrayList<>();
		for (String key : map.keySet()) {
			if (findLargestMapValue(map) == map.get(key).size()) {
				maxKeyList.add(key);
			}
		}
	//	System.out.println(maxKeyList);
		return maxKeyList;
	}

	// Just in case I need a reference
	// https://github.com/briennakh/java-programming-and-software-engineering-fundamentals/blob/master/4.%20Java%20programming%20-%20principles%20of%20software%20design/Week%203/2.%20Programming%20exercise%20-%20interface%20and%20abstract%20class/EfficientMarkovModel.java

	public String getRandomText(int numChars) {
		System.out.println("getRandomText Efficient Markov Model Called");
		// compare with Brienna
		// don't know why she has this
		if (myText == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length() - keyLength);
		String key = myText.substring(index, index + keyLength);
		sb.append(key);

		for (int k = 0; k < numChars - keyLength; k++) {
			ArrayList<String> follows = getFollows(key);

			// if (follows.size() == 0) {
			// break;
			// }
			
			if (follows == null) {
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

	public HashMap<String, ArrayList<String>> getMap() {
		return map;
	}

}
