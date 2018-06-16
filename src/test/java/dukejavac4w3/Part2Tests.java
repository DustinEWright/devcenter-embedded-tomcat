package dukejavac4w3;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import part2.EfficientMarkovModel;

public class Part2Tests {

	@Test
	public void testHashMapFirstGramTT() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		emm.setTraining("ttayes-this-is-a-thin-pretty-pink-thistle");
		emm.buildMap();
		HashMap<String, ArrayList<String>> map = emm.getMap();
		System.out.println("JUnit Tests map: " + map);
		assertEquals(true, map.containsKey("tt"));
		// Don't recall why list is used and how to use it
		ArrayList<String> list = map.get("tt");
		// System.out.println("list: " + list);
		assertEquals(true, list.contains("y"));
		assertEquals(true, map.containsKey("n-"));
	}

	@Test
	public void testHashMapLastGramTL() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		emm.setTraining("ttayes-this-is-a-thin-pretty-pink-thistle");
		emm.buildMap();
		HashMap<String, ArrayList<String>> map = emm.getMap();
		System.out.println("JUnit Tests map: " + map);
		assertEquals(true, map.containsKey("tl"));
	}

	//@Test
	public void testHashMapSize26() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		emm.setTraining("ttayes-this-is-a-thin-pretty-pink-thistle");
		emm.buildMap();
		HashMap<String, ArrayList<String>> map = emm.getMap();
		assertEquals(26, map.size());
	}

	@Test
	public void testHashMapInvalidGramle() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		emm.setTraining("ttayes-this-is-a-thin-pretty-pink-thistle");
		emm.buildMap();
		HashMap<String, ArrayList<String>> map = emm.getMap();
		assertEquals(false, map.containsKey("le"));
	}

	@Test
	public void testHashMapAA() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		emm.setTraining("AA1");
		emm.buildMap();
		HashMap<String, ArrayList<String>> map = emm.getMap();
		System.out.println("JUnit Tests mapAA: " + map);
		assertEquals(true, map.containsKey("AA"));
	}

	@Test
	public void testHashMapAAFollowsChar1() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		emm.setTraining("AA1");
		emm.buildMap();
		HashMap<String, ArrayList<String>> map = emm.getMap();
		System.out.println("JUnit Tests map: " + map);
		ArrayList<String> list = map.get("AA");
		assertEquals(list, map.get("AA"));
	}

	@Test
	public void testHashMapInvalidGramA1() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		emm.setTraining("AA1");
		emm.buildMap();
		HashMap<String, ArrayList<String>> map = emm.getMap();
		System.out.println("JUnit Tests map: " + map);
		assertEquals(false, map.containsKey("A1"));
	}

	@Test
	public void testHashMap2A() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		emm.setTraining("AA1AA2AA3");
		emm.buildMap();
		HashMap<String, ArrayList<String>> map = emm.getMap();
		System.out.println("JUnit Tests map: " + map);
		assertEquals(true, map.containsKey("2A"));
	}

	@Test
	public void testHashMapInvalidGramA3() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		emm.setTraining("AB1CD2EF3");
		emm.buildMap();
		HashMap<String, ArrayList<String>> map = emm.getMap();
		System.out.println("JUnit Tests map: " + map);
		assertEquals(false, map.containsKey("F3"));
	}

	@Test
	public void testHashMapMultiElelementFollowsListAB12() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		emm.setTraining("AB1AB2CD3EF4");
		emm.buildMap();
		HashMap<String, ArrayList<String>> map = emm.getMap();
		System.out.println("JUnit Tests map: " + map);
		assertEquals(false, map.containsKey("F3"));
	}

	@Test
	public void testHashMapMultiElelementFollowsListAB123() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		emm.setTraining("AB1AB2CD3EF4AB3");
		emm.buildMap();
		HashMap<String, ArrayList<String>> map = emm.getMap();
		System.out.println("JUnit Tests map: " + map);
		assertEquals(false, map.containsKey("F3"));
	}

	@Test
	public void testHashMapMultiElelementFollowsListAB123IAB1() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		emm.setTraining("AB1AB2CD3EF4AB31A1Z");
		emm.buildMap();
		HashMap<String, ArrayList<String>> map = emm.getMap();
		System.out.println("JUnit Tests map: " + map);
		assertEquals(true, map.containsKey("1A"));
	}

	@Test
	public void testHashMapMultiElelementFollowsListIAB1() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		emm.setTraining("AB1AB2CD3EF4AB31A1Z");
		emm.buildMap();
		HashMap<String, ArrayList<String>> map = emm.getMap();
		System.out.println("JUnit Tests map: " + map);
		ArrayList<String> expectedB1 = new ArrayList<>();
		expectedB1.add("B");
		expectedB1.add("1");
		assertEquals(expectedB1, map.get("1A"));
	}

	@Test
	public void testHashMapPrintAllMapInfo() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		emm.setTraining("yes-this-is-a-thin-pretty-pink-thistle");
		emm.buildMap();
		HashMap<String, ArrayList<String>> map = emm.getMap();
		System.out.println("JUnit Tests map: " + map);
		assertEquals(true, map.containsKey("tl"));
	}

	@Test
	public void testHashMapSize() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		emm.setTraining("yes-this-is-a-thin-pretty-pink-thistle");
		emm.buildMap();
		HashMap<String, ArrayList<String>> map = emm.getMap();
		System.out.println("JUnit Tests map size: " + map);
		assertEquals(25, map.size());
	}

	@Test
	public void testExpectedKeys() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		emm.setTraining("yes-this-is-a-thin-pretty-pink-thistle");
		emm.buildMap();
		HashMap<String, ArrayList<String>> map = emm.getMap();
		List<String> lst = Arrays.asList("tt", "hi", "pr", "ty", "ye", "-a", "y-", "s-", "-i", "st", "k-", "-p", "in",
				"e", "-t", "is", "a-", "es", "et", "re", "th", "tl", "pi", "nk", "n-");
		Set<String> expected = new HashSet<>();
		expected.addAll(lst);
		for (String expectedKey : expected) {
			if (!map.keySet().contains(expectedKey)) {
				System.out.println("expectedKey not found " + "\"" + expectedKey + "\"");
			}
		}
		assertEquals(expected, map.keySet());
		
	/*
tt, hi, pr, ty, ye, -a, y-, s-, -i, st, k-, -p, in, e, -t, is, a-, es, et, re, th, tl, pi, nk, n-]> 
		
tt, hi, st, pr, k-, -p, in, ty, -t, is, ye, a-, es, et, re, th, -a, y-, tl, pi, s-, -i, nk, n-]>
	*/	


		
	}

	@Test
	public void printLargestMapValueTest() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		HashMap<String, ArrayList<String>> map = emm.getMap();
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("A");
		list1.add("B");
		list1.add("C");
		map.put("A1", list1);
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("D");
		map.put("A2", list2);
		ArrayList<String> list3 = new ArrayList<>();
		list3.add("E");
		list3.add("F");
		map.put("A3", list3);
		System.out.println("JUnit Tests map largest value: " + map);
		assertEquals(3, emm.findLargestMapValue(map));
	}

	@Test
	public void MaxKeyValueTest() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		HashMap<String, ArrayList<String>> map = emm.getMap();
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("A");
		list1.add("B");
		list1.add("C");
		map.put("A1", list1);
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("D");
		map.put("A2", list2);
		ArrayList<String> list3 = new ArrayList<>();
		list3.add("E");
		list3.add("F");
		list3.add("G");
		map.put("A3", list3);
		ArrayList<String> maxKeyList = new ArrayList<>();
		maxKeyList.add("A1");
		maxKeyList.add("A3");
		assertEquals(maxKeyList, emm.MaxKeyValue(map));

	}
	
	@Test
	public void getFollowsTest() {
		int keyLength = 2;
		EfficientMarkovModel emm = new EfficientMarkovModel(keyLength);
		HashMap<String, ArrayList<String>> map = emm.getMap();
		ArrayList<String> list1 = new ArrayList<>();
		list1.add("A");
		list1.add("B");
		list1.add("C");
		map.put("A1", list1);
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("D");
		map.put("A2", list2);
		ArrayList<String> list3 = new ArrayList<>();
		list3.add("E");
		list3.add("F");
		list3.add("G");
		map.put("A3", list3);
		ArrayList<String> maxKeyList = new ArrayList<>();
		maxKeyList.add("A1");
		maxKeyList.add("A3");
		System.out.println("getFollows() test: " + emm.getFollows("A1"));
		assertEquals(list1, emm.getFollows("A1"));
	}

}
