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

	public void testNewPuzzleSave(){
		BuilderFileAccessController file = new BuilderFileAccessController();
		BuilderMenu menu = new BuilderMenu();
		try{
			menu = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderSelectLevelGUI gui = new BuilderSelectLevelGUI(menu);
		BuilderOpenNewEditorController editor = new BuilderOpenNewEditorController(gui,"P6");

		BuilderEditorGUI Pgui = editor.openLevel();
		assertTrue(Pgui.getLevel() instanceof BuilderPuzzleLevel);
		BuilderAddTitle addTitle = new BuilderAddTitle(Pgui);
		addTitle.addTitle("Puzzle6");
		assertEquals("Puzzle6", Pgui.getLevel().getTitle());

		BuilderTypeSpecificInfoController p2 = new BuilderTypeSpecificInfoController(Pgui);
		BuilderPuzzleLevel levelP = (BuilderPuzzleLevel) Pgui.getLevel();
		p2.typeSpecificInfo("72");
		assertEquals(72, levelP.getWordLimit());


		BuilderSaveController save = new BuilderSaveController(Pgui, "P6");
		save.save();
		BuilderMenu menu2 = new BuilderMenu();
		try{
			menu2 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderPuzzleLevel level2 = (BuilderPuzzleLevel) menu2.getLevel("P6");
		assertEquals("Puzzle6", level2.getTitle());
		assertEquals(72, level2.getWordLimit());

		BuilderSelectLevelGUI gui2 = new BuilderSelectLevelGUI(menu);
		BuilderOpenNewEditorController editor2 = new BuilderOpenNewEditorController(gui2,"P7");
		BuilderEditorGUI Pgui2 = editor2.openLevel();

		BuilderAddTitle addTitle2 = new BuilderAddTitle(Pgui2);
		addTitle2.addTitle("Puzzle7");
		assertEquals("Puzzle7", Pgui2.getLevel().getTitle());


		BuilderSaveController save2 = new BuilderSaveController(Pgui2, "P7");
		save2.save();
	}

	public void testNewLightningSave(){
		BuilderFileAccessController file = new BuilderFileAccessController();
		BuilderMenu menu = new BuilderMenu();
		try{
			menu = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderSelectLevelGUI gui = new BuilderSelectLevelGUI(menu);
		BuilderOpenNewEditorController editor = new BuilderOpenNewEditorController(gui,"L6");

		BuilderEditorGUI Lgui = editor.openLevel();
		assertTrue(Lgui.getLevel() instanceof BuilderLightningLevel);
		BuilderAddTitle addTitle = new BuilderAddTitle(Lgui);
		addTitle.addTitle("Lightning6");
		assertEquals("Lightning6", Lgui.getLevel().getTitle());

		BuilderTypeSpecificInfoController l2 = new BuilderTypeSpecificInfoController(Lgui);
		BuilderLightningLevel levelL = (BuilderLightningLevel) Lgui.getLevel();
		l2.typeSpecificInfo("100");
		assertEquals(100, levelL.getMaxTime());


		BuilderSaveController save = new BuilderSaveController(Lgui, "L6");
		save.save();
		BuilderMenu menu2 = new BuilderMenu();
		try{
			menu2 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderLightningLevel level2 = (BuilderLightningLevel) menu2.getLevel("L6");
		assertEquals("Lightning6", level2.getTitle());
		assertEquals(100, level2.getMaxTime());

		BuilderSelectLevelGUI gui2 = new BuilderSelectLevelGUI(menu);
		BuilderOpenNewEditorController editor2 = new BuilderOpenNewEditorController(gui2,"L7");
		BuilderEditorGUI Lgui2 = editor2.openLevel();

		BuilderAddTitle addTitle2 = new BuilderAddTitle(Lgui2);
		addTitle2.addTitle("Lightning7");
		assertEquals("Lightning7", Lgui2.getLevel().getTitle());

		BuilderSaveController save2 = new BuilderSaveController(Lgui2, "L7");
		save2.save();
	}
	
	public void testNewThemeSave(){
		BuilderFileAccessController file = new BuilderFileAccessController();
		BuilderMenu menu = new BuilderMenu();
		try{
			menu = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderSelectLevelGUI gui = new BuilderSelectLevelGUI(menu);
		BuilderOpenNewEditorController editor = new BuilderOpenNewEditorController(gui,"T6");

		BuilderEditorGUI Tgui = editor.openLevel();
		assertTrue(Tgui.getLevel() instanceof BuilderThemeLevel);
		BuilderAddTitle addTitle = new BuilderAddTitle(Tgui);
		addTitle.addTitle("Theme6");
		assertEquals("Theme6", Tgui.getLevel().getTitle());

		BuilderTypeSpecificInfoController t2 = new BuilderTypeSpecificInfoController(Tgui);
		BuilderThemeLevel levelT = (BuilderThemeLevel) Tgui.getLevel();
		t2.typeSpecificInfo("Theme Desicription");
		assertEquals("Theme Desicription", levelT.getDescription());


		BuilderSaveController save = new BuilderSaveController(Tgui, "T6");
		save.save();
		BuilderMenu menu2 = new BuilderMenu();
		try{
			menu2 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderThemeLevel level2 = (BuilderThemeLevel) menu2.getLevel("T6");
		assertEquals("Theme6", level2.getTitle());
		assertEquals("Theme Desicription", level2.getDescription());

		BuilderSelectLevelGUI gui2 = new BuilderSelectLevelGUI(menu);
		BuilderOpenNewEditorController editor2 = new BuilderOpenNewEditorController(gui2,"T7");
		BuilderEditorGUI Tgui2 = editor2.openLevel();

		BuilderAddTitle addTitle2 = new BuilderAddTitle(Tgui2);
		addTitle2.addTitle("Theme7");
		assertEquals("Theme7", Tgui2.getLevel().getTitle());

		BuilderSaveController save2 = new BuilderSaveController(Tgui2, "T7");
		save2.save();
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
		BuilderDeleteLevelController delete = new BuilderDeleteLevelController(gui, "P6");
		delete.delete();
		BuilderMenu menu2 = new BuilderMenu();
		try{
			menu2 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		assertEquals(menu.getLevel("P7").getTitle(), menu2.getLevel("P6").getTitle());
		BuilderSelectLevelGUI gui2 = new BuilderSelectLevelGUI(menu2);
		BuilderDeleteLevelController delete2 = new BuilderDeleteLevelController(gui2, "P6");
		delete2.delete();

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
		BuilderDeleteLevelController delete = new BuilderDeleteLevelController(gui, "L6");
		delete.delete();
		BuilderMenu menu2 = new BuilderMenu();
		try{
			menu2 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		assertEquals(menu.getLevel("L7").getTitle(), menu2.getLevel("L6").getTitle());
		BuilderSelectLevelGUI gui2 = new BuilderSelectLevelGUI(menu2);
		BuilderDeleteLevelController delete2 = new BuilderDeleteLevelController(gui2, "L6");
		delete2.delete();

	}

//	public void testDeleteThemeLevel(){
//		BuilderFileAccessController file = new BuilderFileAccessController();
//		BuilderMenu menu = new BuilderMenu();
//		try{
//			menu = file.getModel().getMenu();
//		} catch(Exception e){
//			assertTrue(false);
//		}
//		BuilderSelectLevelGUI gui = new BuilderSelectLevelGUI(menu);
//		BuilderDeleteLevelController delete = new BuilderDeleteLevelController(gui, "T6");
//		delete.delete();
//		BuilderMenu menu2 = new BuilderMenu();
//		try{
//			menu2 = file.getModel().getMenu();
//		} catch(Exception e){
//			assertTrue(false);
//		}
//		assertEquals(menu.getLevel("T7").getTitle(), menu2.getLevel("T6").getTitle());
//		BuilderSelectLevelGUI gui2 = new BuilderSelectLevelGUI(menu2);
//		BuilderDeleteLevelController delete2 = new BuilderDeleteLevelController(gui2, "T6");
//		delete2.delete();
//
//	}

}
