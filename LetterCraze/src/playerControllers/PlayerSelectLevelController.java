package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerFiles.PlayerLetterCraze;
import playerFiles.PlayerLevel;
import playerGUI.PlayerLevelSelect;

public class PlayerSelectLevelController implements ActionListener{

	String btnPressed;
	
	public PlayerSelectLevelController(String btnPressed){
		this.btnPressed = btnPressed;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Access files to build level
		//potentially for future: close window
		//open new window
		PlayerLevel window = new PlayerLevel(level);
		window.frame.setVisible(true);
	}
}
