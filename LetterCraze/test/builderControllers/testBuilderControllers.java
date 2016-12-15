package builderControllers;

import builderFiles.BuilderLightningLevel;
import builderFiles.BuilderMenu;
import builderFiles.BuilderPuzzleLevel;
import builderFiles.BuilderThemeLevel;
import builderGUI.BuilderEditorGUI;
import builderGUI.BuilderSelectLevelGUI;
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
		assertEquals("Bugs", levelT.getDescription());
		t2.typeSpecificInfo("7");
		assertEquals("7", levelT.getDescription());
		t2.typeSpecificInfo("k");
		assertEquals("k", levelT.getDescription());
	}
	
	public void testSavePuzzle(){
		BuilderFileAccessController file = new BuilderFileAccessController();
		BuilderMenu menu = new BuilderMenu();
		try{
			menu = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderEditorGUI Pgui = new BuilderEditorGUI(menu.getLevel("P1"), "P1");
		assertTrue(Pgui.getLevel() instanceof BuilderPuzzleLevel);
		BuilderAddTitle addTitle = new BuilderAddTitle(Pgui);
		addTitle.addTitle("TestCase");
		assertEquals("TestCase", Pgui.getLevel().getTitle());
		
		BuilderTypeSpecificInfoController p2 = new BuilderTypeSpecificInfoController(Pgui);
		BuilderPuzzleLevel levelP = (BuilderPuzzleLevel) Pgui.getLevel();
		p2.typeSpecificInfo("72");
		assertEquals(72, levelP.getWordLimit());
		
		
		BuilderSaveController save = new BuilderSaveController(Pgui, "P1");
		save.save();
		BuilderMenu menu2 = new BuilderMenu();
		try{
			menu2 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderPuzzleLevel level2 = (BuilderPuzzleLevel) menu2.getLevel("P1");
		assertEquals("TestCase", level2.getTitle());
		assertEquals(72, level2.getWordLimit());
	}
	
	public void testSaveLightning(){
		BuilderFileAccessController file = new BuilderFileAccessController();
		BuilderMenu menu = new BuilderMenu();
		try{
			menu = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderEditorGUI Lgui = new BuilderEditorGUI(menu.getLevel("L1"), "L1");
		assertTrue(Lgui.getLevel() instanceof BuilderLightningLevel);
		BuilderAddTitle addTitle = new BuilderAddTitle(Lgui);
		addTitle.addTitle("TestCase");
		assertEquals("TestCase", Lgui.getLevel().getTitle());
		BuilderSaveController save = new BuilderSaveController(Lgui, "L1");
		save.save();
		BuilderMenu menu2 = new BuilderMenu();
		try{
			menu2 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		assertEquals("TestCase", menu2.getLevel("L1").getTitle());
	}
	
	public void testSaveTheme(){
		BuilderFileAccessController file = new BuilderFileAccessController();
		BuilderMenu menu = new BuilderMenu();
		try{
			menu = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderEditorGUI Tgui = new BuilderEditorGUI(menu.getLevel("T1"), "T1");
		assertTrue(Tgui.getLevel() instanceof BuilderThemeLevel);
		BuilderAddTitle addTitle = new BuilderAddTitle(Tgui);
		addTitle.addTitle("TestCase");
		assertEquals("TestCase", Tgui.getLevel().getTitle());
		BuilderSaveController save = new BuilderSaveController(Tgui, "T1");
		save.save();
		BuilderMenu menu2 = new BuilderMenu();
		try{
			menu2 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		assertEquals("TestCase", menu2.getLevel("T1").getTitle());
	}
	
	public void testDeletePuzzleLevel(){
		BuilderFileAccessController file = new BuilderFileAccessController();
		BuilderMenu menu = new BuilderMenu();
		try{
			menu = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderSelectLevelGUI gui = new BuilderSelectLevelGUI(menu);
		BuilderDeleteLevelController delete = new BuilderDeleteLevelController(gui, "P1");
		delete.delete();
		BuilderMenu menu2 = new BuilderMenu();
		try{
			menu2 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		assertEquals(menu.getLevel("P2").getTitle(), menu2.getLevel("P1").getTitle());
		
	}
	
	public void testDeleteLightningLevel(){
		BuilderFileAccessController file = new BuilderFileAccessController();
		BuilderMenu menu = new BuilderMenu();
		try{
			menu = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderSelectLevelGUI gui = new BuilderSelectLevelGUI(menu);
		BuilderDeleteLevelController delete = new BuilderDeleteLevelController(gui, "L1");
		delete.delete();
		BuilderMenu menu2 = new BuilderMenu();
		try{
			menu2 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		assertEquals(menu.getLevel("L2").getTitle(), menu2.getLevel("L1").getTitle());
		
	}
	
	public void testThemeLightningLevel(){
		BuilderFileAccessController file = new BuilderFileAccessController();
		BuilderMenu menu = new BuilderMenu();
		try{
			menu = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderSelectLevelGUI gui = new BuilderSelectLevelGUI(menu);
		BuilderDeleteLevelController delete = new BuilderDeleteLevelController(gui, "T1");
		delete.delete();
		BuilderMenu menu2 = new BuilderMenu();
		try{
			menu2 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		assertEquals(menu.getLevel("T2").getTitle(), menu2.getLevel("T1").getTitle());
		
	}
}
