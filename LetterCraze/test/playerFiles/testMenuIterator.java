package playerFiles;

import junit.framework.TestCase;

public class testMenuIterator extends TestCase{

	PlayerMenu menu;
	PlayerMenu empty;
	
	@Override
	public void setUp(){
		empty = new PlayerMenu();
		menu = new PlayerMenu();
		int[] starThresholds = new int[3];
		starThresholds[0] = 1;
		starThresholds[1] = 2;
		starThresholds[2] = 3;
		
		PlayerLevel P1 = new PlayerPuzzleLevel(starThresholds, 0, 0, true, "P1", 0);
		PlayerLevel P2 = new PlayerPuzzleLevel(starThresholds, 0, 0, true, "P2", 0);
		PlayerLevel P3 = new PlayerPuzzleLevel(starThresholds, 0, 0, true, "P3", 0);
		
		PlayerLevel L1 = new PlayerLightningLevel(starThresholds, 0, 0, true, "L1", 0);
		PlayerLevel L2 = new PlayerLightningLevel(starThresholds, 0, 0, true, "L2", 0);
		PlayerLevel L3 = new PlayerLightningLevel(starThresholds, 0, 0, true, "L3", 0);
		
		PlayerLevel T1 = new PlayerThemeLevel(starThresholds, 0, 0, true, "T1","", null, null);
		PlayerLevel T2 = new PlayerThemeLevel(starThresholds, 0, 0, true, "T2","", null, null);
		PlayerLevel T3 = new PlayerThemeLevel(starThresholds, 0, 0, true, "T3","", null, null);
		
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
		PlayerMenuIterator iterator = empty.iterator();
		
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
		PlayerMenuIterator iterator = menu.iterator();
		
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
