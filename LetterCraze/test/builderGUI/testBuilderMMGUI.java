package builderGUI;

import java.awt.event.MouseEvent;

import builderControllers.BuilderFileAccessController;
import builderFiles.BuilderMenu;
import junit.framework.TestCase;

public class testBuilderMMGUI extends TestCase {

	public void testMMButton(){
		BuilderMainMenuGUI mm = new BuilderMainMenuGUI();

		mm.openWindow();
		assertEquals(true, mm.isVisible());
		mm.hideWindow();
		assertEquals(false, mm.isVisible());

		mm.closeWindow();
	}

	public void testBuilderLSGUI() {
		BuilderFileAccessController file = new BuilderFileAccessController();
		BuilderMenu menu = new BuilderMenu();
		try{
			menu = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderSelectLevelGUI ls = new BuilderSelectLevelGUI(menu);
		ls.openWindow();
		assertEquals(menu,ls.getMenu());
		assertEquals("nine", ls.getMenu().getLevel("P2").getTitle());
		
		ls.closeWindow();
	}
	
	public void testBuilderGUI() {
		BuilderFileAccessController file = new BuilderFileAccessController();
		BuilderMenu menu = new BuilderMenu();
		try{
			menu = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		BuilderEditorGUI editor = new BuilderEditorGUI(menu.getLevel("P2"), "P2");
		editor.openWindow();
		assertTrue(editor.isVisible());
		
		assertEquals(true, menu.getLevel("P2").getBoard().getSquare(2, 1).getActive());
		assertEquals(false, menu.getLevel("P2").getBoard().getSquare(3, 0).getActive());
		
	}
}

