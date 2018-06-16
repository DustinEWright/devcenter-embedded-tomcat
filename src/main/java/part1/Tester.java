package part1;

import edu.duke.*;

public class Tester {
	MarkovOne mo;
	
	public Tester() {
		mo = new MarkovOne(); 
	}

	// Create a new class in this project named Tester and a void method in this
	// class named testGetFollows with no parameters. This method should create a
	// MarkovOne object, set the training text as “this is a test yes this is a
	// test.”. Then have it call getFollows and print out the resulting ArrayList
	// and also its size. Be sure to test it on the three examples above and also on
	// the Strings “.” and “t.”, which occur at the end of the String.

//	public void testGetFollows() {
//		
//	}

	// Now let’s test getFollows on a file. In the Tester class, write the void
	// method testGetFollowsWithFile with no parameters. This method should create a
	// MarkovOne object, set the training text to a file the user selects (similar
	// to the methods in MarkovRunner), and then call getFollows. Run your program
	// on confucius.txt and look for the characters that follow “t”. You should get
	// 11548.
	
	public void testGetFollowsWithFile() {
		FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		mo.setTraining(st);
		System.out.println("results is: " + mo.getFollows("o").size());
	}

}
