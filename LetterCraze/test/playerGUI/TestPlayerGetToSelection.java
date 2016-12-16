package playerGUI;

import junit.framework.TestCase;
import playerControllers.PlayerFileAccessController;
import playerFiles.PlayerMenu;

public class TestPlayerGetToSelection extends TestCase {

	public void testGameFromScratch() {
		PlayerSplashGUI.main(null);
	}
	
	public void testPlayerSelectLevelGUI(){
		PlayerFileAccessController file = new PlayerFileAccessController();
		PlayerMenu menu = new PlayerMenu();
		try{
			menu = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		PlayerSelectLevelGUI gui = new PlayerSelectLevelGUI(menu);
		gui.openWindow();
		assertEquals("Introduction" , gui.getMenu().getLevel("P1").getTitle());
		gui.closeWindow();
	}
	
	public void testTimeOutGUI(){
		PlayerFileAccessController file = new PlayerFileAccessController();
		PlayerMenu menu = new PlayerMenu();
		try{
			menu = file.getModel().getMenu();
		} catch(Exception e){
			assertTrue(false);
		}
		PlayerTimeUpGUI gui = new PlayerTimeUpGUI(menu.getLevel("L2"), "L2");
		gui.openWindow();
		assertEquals("Circle" , gui.getLevel().getTitle());
		gui.closeWindow();
		
		
	}
	
}
