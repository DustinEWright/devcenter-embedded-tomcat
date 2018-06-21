package dukejavac4w3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import servlet.HelloServlet;

public class ServletTests {
	
//	@Before
//	public void creatClass() {
//	HelloServlet hs = new HelloServlet();
//	}
	
	@Test
	public void getGutenburgUrlTest() {
		HelloServlet hs = new HelloServlet();
		assertEquals("ts", hs.getGutenburgUrl(training));
	}
	
	// I don't know what I'm doing

}
