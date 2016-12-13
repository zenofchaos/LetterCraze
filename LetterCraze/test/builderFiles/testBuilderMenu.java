package builderFiles;

import junit.framework.TestCase;

public class testBuilderMenu extends TestCase{

	BuilderMenu menu;

	@Override
	public void setUp(){
		menu = new BuilderMenu();
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
		String title = "The Level";
		int wordLimit = 20;
		BuilderLevel Plevel = new BuilderPuzzleLevel(starThresholds, title, wordLimit);

		//add a puzzle level and verify it was added correctly
		assertTrue(menu.addLevel(Plevel));
		assertEquals("The Level",menu.getLevels().get(0).get(0).getTitle());
		assertEquals(1,menu.numLevel("Puzzle"));

		//add another puzzle level and check if it was done properly
		BuilderLevel Plevel2 = new BuilderPuzzleLevel(starThresholds, "Level 2", wordLimit);
		assertTrue(menu.addLevel(Plevel2));
		assertEquals("Level 2",menu.getLevels().get(0).get(1).getTitle());
		assertEquals(2,menu.numLevel("Puzzle"));

		//add another puzzle level and check if it was done properly
		BuilderLevel Lightning = new BuilderLightningLevel(starThresholds, "Lightning", wordLimit);
		assertTrue(menu.addLevel(Lightning));
		assertEquals("Lightning",menu.getLevels().get(1).get(0).getTitle());
		assertEquals(1,menu.numLevel("Lightning"));

		//add another puzzle level and check if it was done properly
		BuilderLevel Theme = new BuilderThemeLevel(starThresholds, "Theme","", null, null);
		assertTrue(menu.addLevel(Theme));
		assertEquals("Theme", menu.getLevels().get(2).get(0).getTitle());
		assertEquals(1,menu.numLevel("Theme"));

		//Adding a null level should throw an exception
		assertFalse(menu.addLevel(null));
	}

	public void testGetLevel(){
		int[] starThresholds = new int[3];
		starThresholds[0] = 1;
		starThresholds[1] = 2;
		starThresholds[2] = 3;
		BuilderLevel P1 = new BuilderPuzzleLevel(starThresholds, "Puz1", 5);
		BuilderLevel P2 = new BuilderPuzzleLevel(starThresholds, "Puz2", 5);

		BuilderLevel T1 = new BuilderThemeLevel(starThresholds, "Theme1","", null, null);

		BuilderLevel L1 = new BuilderLightningLevel(starThresholds, "Light1", 5);
		BuilderLevel L2 = new BuilderLightningLevel(starThresholds, "Light2", 5);
		BuilderLevel L3 = new BuilderLightningLevel(starThresholds, "Light3", 5);

		assertTrue(menu.addLevel(P1));
		assertTrue(menu.addLevel(P2));
		assertTrue(menu.addLevel(T1));
		assertTrue(menu.addLevel(L1));
		assertTrue(menu.addLevel(L2));
		assertTrue(menu.addLevel(L3));

		assertEquals("Puz2",menu.getLevel("P2").getTitle());
		assertEquals("Theme1",menu.getLevel("T1").getTitle());
		assertEquals("Light3",menu.getLevel("L3").getTitle());
		assertEquals(null,menu.getLevel("T4"));

		assertTrue(menu.removeLevel("P1"));
		assertEquals("Puz2",menu.getLevel("P1").getTitle());
		assertEquals(null,menu.getLevel("P2"));

		assertTrue(menu.removeLevel("T1"));
		assertFalse(menu.removeLevel("L4"));
	}
}

