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
	
	public void testThresholds(){
		BuilderFileAccessController file = new BuilderFileAccessController();
		BuilderMenu menu = new BuilderMenu();
		try{
			menu = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderEditorGUI gui = new BuilderEditorGUI(menu.getLevel("P2"), "P2");
		BuilderAddStarThreshold controller = new BuilderAddStarThreshold(gui, 1);
		controller.setStar("3");
		assertEquals(3, gui.getLevel().getStarThresholds()[1]);
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
		
		
		BuilderMenu menu3 = new BuilderMenu();
		try{
			menu3 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderSelectLevelGUI gui3 = new BuilderSelectLevelGUI(menu3);
		BuilderOpenNewEditorController editor3 = new BuilderOpenNewEditorController(gui3,"L6");
		BuilderEditorGUI Lgui = editor3.openLevel();
		assertTrue(Lgui.getLevel() instanceof BuilderLightningLevel);
		BuilderAddTitle addTitle3 = new BuilderAddTitle(Lgui);
		addTitle3.addTitle("Lightning6");
		assertEquals("Lightning6", Lgui.getLevel().getTitle());
		BuilderTypeSpecificInfoController l2 = new BuilderTypeSpecificInfoController(Lgui);
		BuilderLightningLevel levelL = (BuilderLightningLevel) Lgui.getLevel();
		l2.typeSpecificInfo("100");
		assertEquals(100, levelL.getMaxTime());
		BuilderSaveController save3 = new BuilderSaveController(Lgui, "L6");
		save3.save();
		BuilderMenu menu4 = new BuilderMenu();
		try{
			menu4 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderLightningLevel level4 = (BuilderLightningLevel) menu4.getLevel("L6");
		assertEquals("Lightning6", level4.getTitle());
		assertEquals(100, level4.getMaxTime());
		BuilderSelectLevelGUI gui4 = new BuilderSelectLevelGUI(menu);
		BuilderOpenNewEditorController editor4 = new BuilderOpenNewEditorController(gui4,"L7");
		BuilderEditorGUI Lgui2 = editor4.openLevel();
		BuilderAddTitle addTitle4 = new BuilderAddTitle(Lgui2);
		addTitle4.addTitle("Lightning7");
		assertEquals("Lightning7", Lgui2.getLevel().getTitle());
		BuilderSaveController save4 = new BuilderSaveController(Lgui2, "L7");
		save4.save();
		
	
		BuilderMenu menu5 = new BuilderMenu();
		try{
			menu5 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderSelectLevelGUI gui5 = new BuilderSelectLevelGUI(menu5);
		BuilderOpenNewEditorController editor5 = new BuilderOpenNewEditorController(gui5,"T6");
		BuilderEditorGUI Tgui = editor5.openLevel();
		assertTrue(Tgui.getLevel() instanceof BuilderThemeLevel);
		BuilderAddTitle addTitle5 = new BuilderAddTitle(Tgui);
		addTitle5.addTitle("Theme6");
		assertEquals("Theme6", Tgui.getLevel().getTitle());
		BuilderTypeSpecificInfoController t2 = new BuilderTypeSpecificInfoController(Tgui);
		BuilderThemeLevel levelT = (BuilderThemeLevel) Tgui.getLevel();
		t2.typeSpecificInfo("Theme Desicription");
		assertEquals("Theme Desicription", levelT.getDescription());
		BuilderSaveController save5 = new BuilderSaveController(Tgui, "T6");
		save5.save();
		BuilderMenu menu6 = new BuilderMenu();
		try{
			menu6 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderThemeLevel level6 = (BuilderThemeLevel) menu6.getLevel("T6");
		assertEquals("Theme6", level6.getTitle());
		assertEquals("Theme Desicription", level6.getDescription());
		BuilderSelectLevelGUI gui6 = new BuilderSelectLevelGUI(menu);
		BuilderOpenNewEditorController editor6 = new BuilderOpenNewEditorController(gui6,"T7");
		BuilderEditorGUI Tgui2 = editor6.openLevel();
		BuilderAddTitle addTitle6 = new BuilderAddTitle(Tgui2);
		addTitle6.addTitle("Theme7");
		assertEquals("Theme7", Tgui2.getLevel().getTitle());
		BuilderSaveController save6 = new BuilderSaveController(Tgui2, "T7");
		save6.save();
		

		BuilderMenu menu7 = new BuilderMenu();
		try{
			menu7 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderSelectLevelGUI gui7 = new BuilderSelectLevelGUI(menu7);
		BuilderDeleteLevelController delete = new BuilderDeleteLevelController(gui7, "L6");
		delete.delete();
		BuilderMenu menu8 = new BuilderMenu();
		try{
			menu8 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		assertEquals(menu7.getLevel("L7").getTitle(), menu8.getLevel("L6").getTitle());
		BuilderSelectLevelGUI gui8 = new BuilderSelectLevelGUI(menu8);
		BuilderDeleteLevelController delete2 = new BuilderDeleteLevelController(gui8, "L6");
		delete2.delete();
		
		BuilderMenu menu9 = new BuilderMenu();
		try{
			menu9 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderSelectLevelGUI gui9 = new BuilderSelectLevelGUI(menu9);
		BuilderDeleteLevelController delete3 = new BuilderDeleteLevelController(gui9, "P6");
		delete3.delete();
		BuilderMenu menu10 = new BuilderMenu();
		try{
			menu10 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		assertEquals(menu9.getLevel("P7").getTitle(), menu10.getLevel("P6").getTitle());
		BuilderSelectLevelGUI gui10 = new BuilderSelectLevelGUI(menu10);
		BuilderDeleteLevelController delete4 = new BuilderDeleteLevelController(gui10, "P6");
		delete4.delete();
		
		BuilderMenu menu11 = new BuilderMenu();
		try{
			menu11 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderSelectLevelGUI gui11 = new BuilderSelectLevelGUI(menu11);
		BuilderDeleteLevelController delete5 = new BuilderDeleteLevelController(gui11, "T6");
		delete5.delete();
		BuilderMenu menu12 = new BuilderMenu();
		try{
			menu12 = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		assertEquals(menu11.getLevel("T7").getTitle(), menu12.getLevel("T6").getTitle());
		BuilderSelectLevelGUI gui12 = new BuilderSelectLevelGUI(menu12);
		BuilderDeleteLevelController delete6 = new BuilderDeleteLevelController(gui12, "T6");
		delete6.delete();

		
	}

//	public void testNewLightningSave(){
//		BuilderFileAccessController file = new BuilderFileAccessController();
//		BuilderMenu menu = new BuilderMenu();
//		try{
//			menu = file.getModel().getMenu();
//		} catch(Exception e){
//			assertTrue(false);
//		}
//		BuilderSelectLevelGUI gui = new BuilderSelectLevelGUI(menu);
//		BuilderOpenNewEditorController editor = new BuilderOpenNewEditorController(gui,"L6");
//
//		BuilderEditorGUI Lgui = editor.openLevel();
//		assertTrue(Lgui.getLevel() instanceof BuilderLightningLevel);
//		BuilderAddTitle addTitle = new BuilderAddTitle(Lgui);
//		addTitle.addTitle("Lightning6");
//		assertEquals("Lightning6", Lgui.getLevel().getTitle());
//
//		BuilderTypeSpecificInfoController l2 = new BuilderTypeSpecificInfoController(Lgui);
//		BuilderLightningLevel levelL = (BuilderLightningLevel) Lgui.getLevel();
//		l2.typeSpecificInfo("100");
//		assertEquals(100, levelL.getMaxTime());
//
//
//		BuilderSaveController save = new BuilderSaveController(Lgui, "L6");
//		save.save();
//		BuilderMenu menu2 = new BuilderMenu();
//		try{
//			menu2 = file.getModel().getMenu();
//		} catch(Exception e){
//			assertTrue(false);
//		}
//		BuilderLightningLevel level2 = (BuilderLightningLevel) menu2.getLevel("L6");
//		assertEquals("Lightning6", level2.getTitle());
//		assertEquals(100, level2.getMaxTime());
//
//		BuilderSelectLevelGUI gui2 = new BuilderSelectLevelGUI(menu);
//		BuilderOpenNewEditorController editor2 = new BuilderOpenNewEditorController(gui2,"L7");
//		BuilderEditorGUI Lgui2 = editor2.openLevel();
//
//		BuilderAddTitle addTitle2 = new BuilderAddTitle(Lgui2);
//		addTitle2.addTitle("Lightning7");
//		assertEquals("Lightning7", Lgui2.getLevel().getTitle());
//
//		BuilderSaveController save2 = new BuilderSaveController(Lgui2, "L7");
//		save2.save();
//	}
	
//	public void testNewThemeSave(){
//		BuilderFileAccessController file = new BuilderFileAccessController();
//		BuilderMenu menu = new BuilderMenu();
//		try{
//			menu = file.getModel().getMenu();
//		} catch(Exception e){
//			assertTrue(false);
//		}
//		BuilderSelectLevelGUI gui = new BuilderSelectLevelGUI(menu);
//		BuilderOpenNewEditorController editor = new BuilderOpenNewEditorController(gui,"T6");
//
//		BuilderEditorGUI Tgui = editor.openLevel();
//		assertTrue(Tgui.getLevel() instanceof BuilderThemeLevel);
//		BuilderAddTitle addTitle = new BuilderAddTitle(Tgui);
//		addTitle.addTitle("Theme6");
//		assertEquals("Theme6", Tgui.getLevel().getTitle());
//
//		BuilderTypeSpecificInfoController t2 = new BuilderTypeSpecificInfoController(Tgui);
//		BuilderThemeLevel levelT = (BuilderThemeLevel) Tgui.getLevel();
//		t2.typeSpecificInfo("Theme Desicription");
//		assertEquals("Theme Desicription", levelT.getDescription());
//
//
//		BuilderSaveController save = new BuilderSaveController(Tgui, "T6");
//		save.save();
//		BuilderMenu menu2 = new BuilderMenu();
//		try{
//			menu2 = file.getModel().getMenu();
//		} catch(Exception e){
//			assertTrue(false);
//		}
//		BuilderThemeLevel level2 = (BuilderThemeLevel) menu2.getLevel("T6");
//		assertEquals("Theme6", level2.getTitle());
//		assertEquals("Theme Desicription", level2.getDescription());
//
//		BuilderSelectLevelGUI gui2 = new BuilderSelectLevelGUI(menu);
//		BuilderOpenNewEditorController editor2 = new BuilderOpenNewEditorController(gui2,"T7");
//		BuilderEditorGUI Tgui2 = editor2.openLevel();
//
//		BuilderAddTitle addTitle2 = new BuilderAddTitle(Tgui2);
//		addTitle2.addTitle("Theme7");
//		assertEquals("Theme7", Tgui2.getLevel().getTitle());
//
//		BuilderSaveController save2 = new BuilderSaveController(Tgui2, "T7");
//		save2.save();
//	}


//	public void testDelete(){
//		BuilderFileAccessController file = new BuilderFileAccessController();
//		BuilderMenu menu = new BuilderMenu();
//		try{
//			menu = file.getModel().getMenu();
//		} catch(Exception e){
//			assertTrue(false);
//		}
//		BuilderSelectLevelGUI gui = new BuilderSelectLevelGUI(menu);
//		BuilderDeleteLevelController delete = new BuilderDeleteLevelController(gui, "P6");
//		delete.delete();
//		BuilderMenu menu2 = new BuilderMenu();
//		try{
//			menu2 = file.getModel().getMenu();
//		} catch(Exception e){
//			assertTrue(false);
//		}
//		assertEquals(menu.getLevel("P7").getTitle(), menu2.getLevel("P6").getTitle());
//		BuilderSelectLevelGUI gui2 = new BuilderSelectLevelGUI(menu2);
//		BuilderDeleteLevelController delete2 = new BuilderDeleteLevelController(gui2, "P6");
//		delete2.delete();
//		
//		BuilderFileAccessController file2 = new BuilderFileAccessController();
//		BuilderMenu menu3 = new BuilderMenu();
//		try{
//			menu3 = file2.getModel().getMenu();
//		} catch(Exception e){
//			assertTrue(false);
//		}
//		BuilderSelectLevelGUI gui3 = new BuilderSelectLevelGUI(menu);
//		BuilderDeleteLevelController delete3 = new BuilderDeleteLevelController(gui3, "L6");
//		delete3.delete();
//		BuilderMenu menu4 = new BuilderMenu();
//		try{
//			menu4 = file2.getModel().getMenu();
//		} catch(Exception e){
//			assertTrue(false);
//		}
//		assertEquals(menu3.getLevel("L7").getTitle(), menu4.getLevel("L6").getTitle());
//		BuilderSelectLevelGUI gui4 = new BuilderSelectLevelGUI(menu2);
//		BuilderDeleteLevelController delete4 = new BuilderDeleteLevelController(gui4, "L6");
//		delete4.delete();
//		
//		BuilderFileAccessController file3 = new BuilderFileAccessController();
//		BuilderMenu menu5 = new BuilderMenu();
//		try{
//			menu5 = file3.getModel().getMenu();
//		} catch(Exception e){
//			assertTrue(false);
//		}
//		BuilderSelectLevelGUI gui5 = new BuilderSelectLevelGUI(menu5);
//		BuilderDeleteLevelController delete5 = new BuilderDeleteLevelController(gui5, "T6");
//		delete5.delete();
//		BuilderMenu menu6 = new BuilderMenu();
//		try{
//			menu6 = file3.getModel().getMenu();
//		} catch(Exception e){
//			assertTrue(false);
//		}
//		assertEquals(menu5.getLevel("T7").getTitle(), menu6.getLevel("T6").getTitle());
//		BuilderSelectLevelGUI gui6 = new BuilderSelectLevelGUI(menu6);
//		BuilderDeleteLevelController delete6 = new BuilderDeleteLevelController(gui6, "T6");
//		delete6.delete();
//	}


//	public void testDeletePuzzleLevel(){
//		BuilderFileAccessController file = new BuilderFileAccessController();
//		BuilderMenu menu = new BuilderMenu();
//		try{
//			menu = file.getModel().getMenu();
//		} catch(Exception e){
//			assertTrue(false);
//		}
//		BuilderSelectLevelGUI gui = new BuilderSelectLevelGUI(menu);
//		BuilderDeleteLevelController delete = new BuilderDeleteLevelController(gui, "P6");
//		delete.delete();
//		BuilderMenu menu2 = new BuilderMenu();
//		try{
//			menu2 = file.getModel().getMenu();
//		} catch(Exception e){
//			assertTrue(false);
//		}
//		assertEquals(menu.getLevel("P7").getTitle(), menu2.getLevel("P6").getTitle());
//		BuilderSelectLevelGUI gui2 = new BuilderSelectLevelGUI(menu2);
//		BuilderDeleteLevelController delete2 = new BuilderDeleteLevelController(gui2, "P6");
//		delete2.delete();
//
//	}
//
//	public void testDeleteLightningLevel(){
//		BuilderFileAccessController file = new BuilderFileAccessController();
//		BuilderMenu menu = new BuilderMenu();
//		try{
//			menu = file.getModel().getMenu();
//		} catch(Exception e){
//			assertTrue(false);
//		}
//		BuilderSelectLevelGUI gui = new BuilderSelectLevelGUI(menu);
//		BuilderDeleteLevelController delete = new BuilderDeleteLevelController(gui, "L6");
//		delete.delete();
//		BuilderMenu menu2 = new BuilderMenu();
//		try{
//			menu2 = file.getModel().getMenu();
//		} catch(Exception e){
//			assertTrue(false);
//		}
//		assertEquals(menu.getLevel("L7").getTitle(), menu2.getLevel("L6").getTitle());
//		BuilderSelectLevelGUI gui2 = new BuilderSelectLevelGUI(menu2);
//		BuilderDeleteLevelController delete2 = new BuilderDeleteLevelController(gui2, "L6");
//		delete2.delete();
//
//	}
//
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
