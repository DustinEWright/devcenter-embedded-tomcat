package part2;

import java.util.ArrayList;
import java.util.HashMap;

public class Practice {

	public void buildMap() {
		int order = 2;
		String myText = "ttayes-this-is-a-thin-pretty-pink-thistle";
		String gram = "";
		HashMap<String, ArrayList<String>> map = new HashMap<>();

		for (int i = 0; i <= myText.length() - order; i++) {
			gram = myText.substring(i, i + order);
			int gramLength = gram.length();
			int gramIndex = myText.indexOf(gram);
			int myTextLength = myText.length();
			int endGramIndex = gramLength + gramIndex;

			// This only builds the HashMap adding the keys (grams)
			if (endGramIndex < myTextLength) {
				// String followsChar = myText.substring(gramIndex + gramLength, endGramIndex +
				// 1);
				System.out.println("\nat index " + i);
				System.out.println("gram " + "\"" + gram + "\"" + " is valid will have the follows char " + "\""
						+ "unknown" + "\"");
				System.out.println("indexs of gram " + gramIndex + " - " + endGramIndex);
				System.out.println("myText length " + myTextLength);
			} else {
				System.out.println("\nat index " + i);
				System.out.println("gram " + "\"" + gram + "\"" + " is not valid");
				System.out.println("index of gram " + gramIndex);
				System.out.println("endGramIndex " + endGramIndex);
				System.out.println("myText length " + myTextLength);
			}

			if (map.containsKey(gram)) {
				map.put(gram, map.get(gram));
			} else {
				map.put(gram, new ArrayList<String>());
			}
		}
		System.out.println("map size: " + map.size());
		System.out.println(map.toString());
	}
	
	// This runs each gram though the training text finding all follow chars for a given gram
	
	
}

// -ttayes-this-is-a-thin-pretty-pink-thistle
// -----------1111111111222222222223333333333
// -01234567890123456789012345678901234567890
