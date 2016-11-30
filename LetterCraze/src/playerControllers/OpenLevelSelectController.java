package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import playerFiles.*;
import playerGUI.PlayerLevelSelect;
import playerGUI.PlayerMainMenu;

public class OpenLevelSelectController implements ActionListener{

	PlayerMainMenu menuView;
	
	public OpenLevelSelectController(PlayerMainMenu theWindow) {
		this.menuView = theWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Close menu window
		menuView.close();
		//Generate the model
		//FileAccessController fileAccess = new FileAccessController(new PlayerMenu());
		//PlayerModel model = fileAccess.getModel();
		// Open level select window
		PlayerLevelSelect selectView = new PlayerLevelSelect(new PlayerMenu());
		selectView.open();
	}
}
