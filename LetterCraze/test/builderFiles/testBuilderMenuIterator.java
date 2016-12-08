package builderFiles;

import junit.framework.TestCase;

public class testBuilderMenuIterator extends TestCase{
	BuilderMenu menu;
	BuilderMenu empty;
	
	@Override
	public void setUp(){
		empty = new BuilderMenu();
		menu = new BuilderMenu();
		int[] starThresholds = new int[3];
		starThresholds[0] = 1;
		starThresholds[1] = 2;
		starThresholds[2] = 3;
		
		BuilderLevel P1 = new BuilderPuzzleLevel(starThresholds, "P1", 0);
		BuilderLevel P2 = new BuilderPuzzleLevel(starThresholds, "P2", 0);
		BuilderLevel P3 = new BuilderPuzzleLevel(starThresholds, "P3", 0);
		
		BuilderLevel L1 = new BuilderLightningLevel(starThresholds, "L1", 0);
		BuilderLevel L2 = new BuilderLightningLevel(starThresholds, "L2", 0);
		BuilderLevel L3 = new BuilderLightningLevel(starThresholds, "L3", 0);
		
		BuilderLevel T1 = new BuilderThemeLevel(starThresholds, "T1", null, null);
		BuilderLevel T2 = new BuilderThemeLevel(starThresholds, "T2", null, null);
		BuilderLevel T3 = new BuilderThemeLevel(starThresholds, "T3", null, null);
		
		menu.addLevel(P1);
		menu.addLevel(P2);
		menu.addLevel(P3);
		
		menu.addLevel(T1);
		menu.addLevel(T2);
		menu.addLevel(T3);
		
		menu.addLevel(L1);
		menu.addLevel(L2);
		menu.addLevel(L3);
	}
	
	public void testEmptyMenu(){
		BuilderMenuIterator iterator = empty.iterator();
		
		assertFalse(iterator.hasNext("Puzzle"));
		assertFalse(iterator.hasNext("Lightning"));
		assertFalse(iterator.hasNext("Theme"));
		
		try{
			iterator.next("Puzzle");
			assertTrue(false);
		}
		catch (Exception e){
			assertTrue(true);
		}
	}
	
	public void testFilledMenu(){
		BuilderMenuIterator iterator = menu.iterator();
		
		assertTrue(iterator.hasNext("Puzzle"));
		assertEquals("P1",iterator.next("Puzzle").getTitle());
		assertTrue(iterator.hasNext("Theme"));
		assertEquals("T1",iterator.next("Theme").getTitle());
		assertTrue(iterator.hasNext("Puzzle"));
		assertEquals("P2",iterator.next("Puzzle").getTitle());
		assertTrue(iterator.hasNext("Lightning"));
		assertEquals("L1",iterator.next("Lightning").getTitle());
		assertTrue(iterator.hasNext("Theme"));
		assertEquals("T2",iterator.next("Theme").getTitle());
		assertTrue(iterator.hasNext("Theme"));
		assertEquals("T3",iterator.next("Theme").getTitle());
		assertFalse(iterator.hasNext("Theme"));
		
		assertEquals(false,iterator.hasNext("Pizza"));
		assertEquals(null,iterator.next("Pizza"));
	}
}

