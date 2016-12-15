package playerControllers;

import playerFiles.PlayerMenu;
import playerFiles.PlayerModel;
import junit.framework.TestCase;

public class testPlayerControllers extends TestCase {
		
	public void testFileAccess(){
		PlayerFileAccessController fileAccess = new PlayerFileAccessController();
		PlayerModel model;
		try {
			model = fileAccess.getModel();
			assertEquals(0, model.getMenu().getLevel("L1").getBestScore());	//needs to be changed when I put a real number in. yeah, I know. 
		} catch (Exception e) {
			System.out.println("getModel threw an exception");
			e.printStackTrace();
		}
	}
}
