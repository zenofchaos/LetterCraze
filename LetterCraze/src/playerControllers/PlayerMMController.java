package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderLightningLevel;
import playerFiles.*;
import playerGUI.PlayerSelectLevelGUI;
import playerGUI.PlayerMainMenuGUI;

public class PlayerMMController implements ActionListener{

	PlayerMainMenuGUI menuView;
	
	public PlayerMMController(PlayerMainMenuGUI theWindow) {
		this.menuView = theWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Close menu window
		menuView.closeWindow();
		//Generate the model
		PlayerFileAccessController fileAccess = new PlayerFileAccessController(new PlayerMenu());
		try{
			PlayerModel model = fileAccess.getModel();
			
			// Open level select window
			PlayerSelectLevelGUI selectView = new PlayerSelectLevelGUI(model.getMenu());
			selectView.openWindow();
		}
		catch (Exception exception){
			System.out.println("FileAccess threw an exception in PlayerOpenLevelController");
			exception.printStackTrace();
		}
	}
}
