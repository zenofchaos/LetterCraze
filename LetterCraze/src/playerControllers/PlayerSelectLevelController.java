package playerControllers;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import playerFiles.PlayerLightningLevel;
import playerGUI.PlayerLevelGUI;
import playerGUI.PlayerSelectLevelGUI;

public class PlayerSelectLevelController implements ActionListener{

	PlayerSelectLevelGUI selectView;
	String btnPressed;
	
	public PlayerSelectLevelController(PlayerSelectLevelGUI window, String btnPressed){
		this.selectView = window;
		this.btnPressed = btnPressed;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Access files to build level
		//potentially for future: close window
		//open new window
		PlayerLevelGUI window = new PlayerLevelGUI(new PlayerLightningLevel(null, 3, 3, true,"test", 3));
		window.openWindow();
	}
}
