package builderFiles;

import java.util.LinkedList;

import junit.framework.TestCase;

public class testBuilderLevels extends TestCase {
	
	public void testPuzzleConstructor(){
		int[] thresholds = new int[3];
		thresholds[0] = 10;
		thresholds[1] = 12;
		thresholds[2] = 13;
		BuilderPuzzleLevel tl = new BuilderPuzzleLevel(thresholds, "theme", 3 );
		
		assertEquals(3, tl.getWordLimit());
		assertEquals("theme", tl.getTitle());
		assertEquals(thresholds, tl.getStarThresholds());
		
		tl.setWordLimit(4);
		assertEquals(4, tl.getWordLimit());
		
		int[] thresholds2 = new int[2];
		thresholds2[0] = 10;
		thresholds2[1] = 12;
		tl.setTitle("wow");
		
		assertEquals(false, tl.setStarThresholds(thresholds2));
		assertEquals(thresholds, tl.getStarThresholds());
		assertEquals("wow", tl.getTitle());
		
		int[] thresholds3 = new int[3];
		thresholds3[0] = 9;
		thresholds3[1] = 11;
		thresholds3[2] = 12;
		tl.setStarThresholds(thresholds3);
		
		assertEquals(thresholds3, tl.getStarThresholds());
	}
	
	public void testLightningConstructor(){
		
		int[] thresholds = new int[3];
		thresholds[0] = 10;
		thresholds[1] = 12;
		thresholds[2] = 13;
		BuilderLightningLevel ll = new BuilderLightningLevel(thresholds, "ll1", 3 );
		
		assertEquals(3, ll.getMaxTime());
		assertEquals("ll1", ll.getTitle());
		assertEquals(thresholds, ll.getStarThresholds());
		
		ll.setMaxTime(5);
		assertEquals(5, ll.getMaxTime());
	}
}
	
//	public void testThemeConstructor(){
//
//		int[] thresholds = new int[3];
//		thresholds[0] = 10;
//		thresholds[1] = 12;
//		thresholds[2] = 13;
//		LinkedList<String> list = new LinkedList();
//		list.add("bird");
//		list.add("fish");
//				
//		BuilderThemeLevel tl = new BuilderThemeLevel(thresholds, "tl1", list, new BuilderBoard(squares));
//}
