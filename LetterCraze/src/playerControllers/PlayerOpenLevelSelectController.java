package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import playerFiles.*;
import playerGUI.PlayerLevelSelect;
import playerGUI.PlayerMainMenu;

public class PlayerOpenLevelSelectController implements ActionListener{

	PlayerMainMenu menuView;
	
	public PlayerOpenLevelSelectController(PlayerMainMenu theWindow) {
		this.menuView = theWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Close menu window
		menuView.close();
		//Generate the model
		FileAccessController fileAccess = new FileAccessController(new PlayerMenu());
		try{
			PlayerModel model = fileAccess.getModel();
			// Open level select window
			PlayerLevelSelect selectView = new PlayerLevelSelect(model.getMenu());
			selectView.open();
		}
		catch (Exception exception){
			System.out.println("FileAccess threw and exception in PlayerOpenLevelController");
			exception.printStackTrace();
		}
	}
}
