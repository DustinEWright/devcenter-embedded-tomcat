package dukejavac4w3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.duke.FileResource;
import part1.MarkovOne;
import part1.MarkovRunner;

public class Part1Tests {
	MarkovOne mo;
	ArrayList<String> result;

	@Before
	public void before() {
		mo = new MarkovOne();
		result = new ArrayList<>();
	}

	// Test scenario from a video
	@Test
	public void getFollowsTestChar() {
		System.out.println("========== getFollowsTestChar Begins ==========");
		mo.setMyText("an apple a day");
		List<String> lst = Arrays.asList("n", "p", " ", "y");
		assertEquals(lst, result = mo.getFollows("a"));
		System.out.println("========== getFollowsTestChar Ends ==========\n");
	}

	// Same test, but testing a string ending in a single char key "a"
	@Test
	public void getFollowsTestCharEndCase() {
		System.out.println("========== getFollowsTestCharEndCase Begins ==========");
		mo.setMyText("an apple a daya");
		List<String> lst = Arrays.asList("n", "p", " ", "y");
		assertEquals(lst, result = mo.getFollows("a"));
		System.out.println("========== getFollowsTestCharEndCase Ends ==========\n");
	}

	// These three are from the assignment
	// myText were “this is a test yes this is a test.”, then the call
	// getFollows(“t”) should return an ArrayList with the Strings “h”, “e”, “ “,
	// “h”, “e”, “.” as “t” appears 6 times. The call getFollows(“e”) should return
	// an ArrayList with the Strings “s”, “s”, “s”. Your method should work even if
	// key is a word. Thus, getFollows(“es”) should return an ArrayList with the
	// Strings “t”, “ “, “t”. Next we will write a method to test this method.

	@Test
	public void getFollowsTestCharT() {
		System.out.println("========== getFollowsTestCharT Begins ==========");
		mo.setMyText("this is a test yes this is a test.");
		List<String> lst = Arrays.asList("h", "e", " ", "h", "e", ".");
		assertEquals(lst, result = mo.getFollows("t"));
		System.out.println("========== getFollowsTestCharT Ends ==========\n");
	}

	@Test
	public void getFollowsTestCharE() {
		System.out.println("========== getFollowsTestCharE Begins ==========");
		mo.setMyText("this is a test yes this is a test.");
		List<String> lst = Arrays.asList("s", "s", "s");
		assertEquals(lst, result = mo.getFollows("e"));
		System.out.println("========== getFollowsTestCharE Ends ==========\n");
	}

	@Test
	public void getFollowsTestCharES() {
		System.out.println("========== getFollowsTestCharES Begins ==========");
		mo.setMyText("this is a test yes this is a test.");
		List<String> lst = Arrays.asList("t", " ", "t");
		assertEquals(lst, result = mo.getFollows("es"));
		System.out.println("========== getFollowsTestCharES Ends ==========\n");
	}

	@Test
	public void getFollowsTestCharPeriod() {
		System.out.println("========== getFollowsTestCharPeriod Begins ==========");
		mo.setMyText("this is a test yes this is a test.");
		List<String> lst = Arrays.asList();
		assertEquals(lst, result = mo.getFollows("."));
		System.out.println("========== getFollowsTestCharPeriod Ends ==========\n");
	}

	@Test
	public void getFollowsTestCharTperiod() {
		System.out.println("========== getFollowsTestCharTperiod Begins ==========");
		mo.setMyText("this is a test yes this is a test.");
		List<String> lst = Arrays.asList();
		assertEquals(lst, result = mo.getFollows("t."));
		System.out.println("========== getFollowsTestCharTperiod Ends ==========\n");
	}

	// Now let’s test getFollows on a file. In the Tester class, write the void
	// method testGetFollowsWithFile with no parameters. This method should create a
	// MarkovOne object, set the training text to a file the user selects (similar
	// to the methods in MarkovRunner), and then call getFollows. Run your program
	// on confucius.txt and look for the characters that f() {

	@Test
	public void getFollowsTesOnFile() {
		System.out.println("========== getFollowsTesOnFile begins ==========");
		FileResource fr = new FileResource("data/confucius.txt");
		// FileResource fr = new FileResource("data/smallTfile.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		mo.setTraining(st);
		System.out.println("results is: " + mo.getFollows("t").size());
		assertEquals(11548, mo.getFollows("t").size());
		// assertEquals(5, mo.getFollows("t").size());
		// mo.setRandom(42); // Check the video to make sure this is where this goes
		System.out.println("========== getFollowsTesOnFile Ends ==========\n");
	}

	// Utility functions can be tested aka "concrete example" steps 1 & 2 of the 7
	// step process
	@Test
	public void someConditionTest() {
		String myText2 = "an apple a daya";
		int pos = myText2.length();
		String key = "a";
		boolean result = mo.enoughRoom(myText2, pos, key);
		// an apple a daya
		// -012345678901234
		assertEquals(15, pos);
		assertEquals(false, result);
	}

	// You already modified the runMarkovOne method in the class MarkovRunner. Run
	// this method with the random seed as 42 and the file confucius.txt. The first
	// line of MarkovOne random text generated starts with:
	// nd are, Prevedowalvism n thastsour tr ndsang heag ti. the ffinthe

	@Test
	public void getFollowsMarkovOneConfuciusTest() {
		System.out.println("========== getFollowsMarkovOneConfuciusTest Begins ==========");
		MarkovRunner mr = new MarkovRunner();
		assertEquals("nd are, Prevedowalvism n thastsour tr ndsang heag ti. the ffinthe", mr.runMarkovOne());
		System.out.println("========== getFollowsMarkovOneConfuciusTest Ends ==========\n");
	}

}
