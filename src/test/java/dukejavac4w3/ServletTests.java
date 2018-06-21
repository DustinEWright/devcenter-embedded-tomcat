package dukejavac4w3;

import static org.junit.Assert.*;

import org.junit.Test;

import servlet.HelloServlet;

public class ServletTests {

	// @Before
	// public void creatClass() {
	// HelloServlet hs = new HelloServlet();
	// }

	@Test
	public void getGutenburgUrlTestTS() {
		HelloServlet hs = new HelloServlet();
		String training = "http://www.gutenberg.org/files/74/74-0.txt";
		assertEquals(training, hs.getGutenburgUrl(training));
	}

	@Test
	public void getGutenburgUrlTestGE() {
		HelloServlet hs = new HelloServlet();
		String training = "http://www.gutenberg.org/files/1400/1400-0.txt";
		assertEquals(training, hs.getGutenburgUrl(training));
	}
}
