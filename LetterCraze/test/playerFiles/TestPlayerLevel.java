package playerFiles;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPlayerLevel {
	PlayerLightningLevel ll;

	@Before
	public void setUp() throws Exception {
		
		int[] starThresholds = new int[3];
		starThresholds[0] = 2;
		starThresholds[1] = 4;
		starThresholds[2] = 6;
		
		int bestScore = 3;
		
		int bestStars = 1;
		
		boolean isLocked = false;
		
		String title = "Lightning1";
		
		int maxTime = 35;
		
		ll = new PlayerLightningLevel(starThresholds, bestScore, bestStars, isLocked, title, maxTime);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLightning1() {
		assertEquals(35, ll.getMaxTime());
		assertTrue(ll.setMaxTime(50));
		assertEquals(50, ll.getMaxTime());
	}

}
