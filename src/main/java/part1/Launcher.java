package part1;

import java.util.ArrayList;

import part1.MarkovRunner;

@SuppressWarnings("unused")
public class Launcher {

	public static void main(String[] args) {
		MarkovRunner mr = new MarkovRunner();
		//mr.runMarkovZero();
		//mr.runMarkovOne();
		//mr.runMarkovFour();
		mr.runMarkovModel(8);
		
		// Create a new class in this project named Tester and a void method in this
		// class named testGetFollows with no parameters. This method should create a
		// MarkovOne object, set the training text as “this is a test yes this is a
		// test.”. Then have it call getFollows and print out the resulting ArrayList
		// and also its size. Be sure to test it on the three examples above and also on
		// the Strings “.” and “t.”, which occur at the end of the String.

		// MarkovOne mo = new MarkovOne();
		// mo.setMyText("this is a test yes this is a test.");
		// System.out.println(mo.getFollows("es"));

		// ArrayList<String> results = mo.getFollows("es");
		// System.out.println("Results is: " + results.size() + " characters in
		// length.");
		// System.out.println(results);
		
//		Tester tsr = new Tester();
//		tsr.testGetFollowsWithFile();

	}

}
