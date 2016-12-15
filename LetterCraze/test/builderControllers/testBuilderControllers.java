package builderControllers;

import builderFiles.BuilderLightningLevel;
import builderFiles.BuilderMenu;
import builderFiles.BuilderPuzzleLevel;
import builderFiles.BuilderThemeLevel;
import builderGUI.BuilderEditorGUI;
import junit.framework.TestCase;

public class testBuilderControllers extends TestCase{
	
	public void testAddLetter(){
		BuilderFileAccessController file = new BuilderFileAccessController();
		BuilderMenu menu = new BuilderMenu();
		try{
			menu = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderEditorGUI gui = new BuilderEditorGUI(menu.getLevel("P2"), "P2");
		BuilderAddLetterController controller = new BuilderAddLetterController(gui, 2, 2);
		assertTrue(controller.isValidLetter("A"));
		assertTrue(controller.isValidLetter("b"));
		assertTrue(controller.isValidLetter("QU"));
		assertTrue(controller.isValidLetter("qu"));
		assertTrue(controller.isValidLetter("Qu"));
		assertTrue(controller.isValidLetter("qU"));
		assertFalse(controller.isValidLetter("Ab"));
		assertFalse(controller.isValidLetter("9"));
		assertFalse(controller.isValidLetter("-"));
		assertFalse(controller.isValidLetter("askdf"));
		
		controller.addLetter("a");
		assertEquals("A", menu.getLevel("P2").getBoard().getSquare(2, 2).getLetter().getLetter());
		controller.addLetter("9");
		assertEquals("A", menu.getLevel("P2").getBoard().getSquare(2, 2).getLetter().getLetter());
		controller.addLetter("Q");
		assertEquals("QU", menu.getLevel("P2").getBoard().getSquare(2, 2).getLetter().getLetter());
	}
	
	public void testTypeSpecific(){
		BuilderFileAccessController file = new BuilderFileAccessController();
		BuilderMenu menu = new BuilderMenu();
		try{
			menu = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderEditorGUI Pgui = new BuilderEditorGUI(menu.getLevel("P2"), "P2");
		assertTrue(Pgui.getLevel() instanceof BuilderPuzzleLevel);
		BuilderTypeSpecificInfoController p2 = new BuilderTypeSpecificInfoController(Pgui);
		
		assertTrue(p2.isValidNumber("3"));
		assertTrue(p2.isValidNumber("39"));
		assertTrue(p2.isValidNumber("329"));
		assertFalse(p2.isValidNumber("3 9"));
		assertFalse(p2.isValidNumber("28k"));
		assertFalse(p2.isValidNumber("j"));
		assertFalse(p2.isValidNumber("="));
		
		BuilderPuzzleLevel levelP = (BuilderPuzzleLevel) Pgui.getLevel();
		p2.typeSpecificInfo("72");
		assertEquals(72, levelP.getWordLimit());
		p2.typeSpecificInfo("7");
		assertEquals(7, levelP.getWordLimit());
		p2.typeSpecificInfo("k");
		assertEquals(7, levelP.getWordLimit());
		
		
		BuilderEditorGUI Lgui = new BuilderEditorGUI(menu.getLevel("L2"), "L2");
		BuilderTypeSpecificInfoController l2 = new BuilderTypeSpecificInfoController(Lgui);
		
		BuilderLightningLevel levelL = (BuilderLightningLevel) menu.getLevel("L2");
		l2.typeSpecificInfo("89");
		assertEquals(89, levelL.getMaxTime());
		l2.typeSpecificInfo("7");
		assertEquals(7, levelL.getMaxTime());
		l2.typeSpecificInfo("k");
		assertEquals(7, levelL.getMaxTime());
		
		BuilderEditorGUI Tgui = new BuilderEditorGUI(menu.getLevel("T2"), "T2");
		BuilderTypeSpecificInfoController t2 = new BuilderTypeSpecificInfoController(Tgui);
		
		BuilderThemeLevel levelT = (BuilderThemeLevel) menu.getLevel("T2");
		t2.typeSpecificInfo("Bugs");
		assertEquals("bugs", levelT.getDescription());
		t2.typeSpecificInfo("7");
		assertEquals(7, levelT.getDescription());
		t2.typeSpecificInfo("k");
		assertEquals("k", levelT.getDescription());
	}

}
