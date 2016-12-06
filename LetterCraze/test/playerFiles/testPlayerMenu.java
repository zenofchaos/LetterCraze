package playerFiles;

import junit.framework.TestCase;

public class testPlayerMenu extends TestCase{

	PlayerMenu menu;
	
	@Override
	public void setUp(){
		menu = new PlayerMenu();
	}
	
	public void testConstructor(){
		assertEquals(0,menu.numLevel("Puzzle"));
		assertEquals(0,menu.numLevel("Lightning"));
		assertEquals(0,menu.numLevel("Theme"));
	}
	
	public void testAddLevel(){
		int[] starThresholds = new int[3];
		starThresholds[0] = 1;
		starThresholds[1] = 2;
		starThresholds[2] = 3;
		int bestScore = 5;
		int bestStars = 3;
		boolean isLocked = true;
		String title = "The Level";
		int wordLimit = 20;
		PlayerLevel Plevel = new PlayerPuzzleLevel(starThresholds, bestScore, bestStars, isLocked, title, wordLimit);
		
		//add a puzzle level and verify it was added correctly
		assertTrue(menu.addLevel(Plevel));
		assertEquals("The Level",menu.getLevels().get(0).get(0).getTitle());
		assertEquals(1,menu.numLevel("Puzzle"));
		
		//add another puzzle level and check if it was done properly
		PlayerLevel Plevel2 = new PlayerPuzzleLevel(starThresholds, bestScore, bestStars, isLocked, "Level 2", wordLimit);
		assertTrue(menu.addLevel(Plevel2));
		assertEquals("Level 2",menu.getLevels().get(0).get(1).getTitle());
		assertEquals(2,menu.numLevel("Puzzle"));
		
		//add another puzzle level and check if it was done properly
		PlayerLevel Lightning = new PlayerLightningLevel(starThresholds, bestScore, bestStars, isLocked, "Lightning", wordLimit);
		assertTrue(menu.addLevel(Lightning));
		assertEquals("Lightning",menu.getLevels().get(1).get(0).getTitle());
		assertEquals(1,menu.numLevel("Lightning"));
		
		//add another puzzle level and check if it was done properly
		PlayerLevel Theme = new PlayerThemeLevel(starThresholds, bestScore, bestStars, isLocked, "Theme", null, null);
		assertTrue(menu.addLevel(Theme));
		assertEquals("Theme", menu.getLevels().get(2).get(0).getTitle());
		assertEquals(1,menu.numLevel("Theme"));
		
		//Adding a null level should throw an exception
		assertFalse(menu.addLevel(null));
	}
	
	public void testGetLevel(){
		PlayerLevel Plevel = new PlayerPuzzleLevel(null, 0, 0, true, "Puzzle", 5);
		
		//add a puzzle level and verify it was added correctly
		assertTrue(menu.addLevel(Plevel));
	}
}
