package playerControllers;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import playerGUI.PlayerLevel;
import playerGUI.PlayerLevelSelect;

public class PlayerSelectLevelController implements ActionListener{

	PlayerLevelSelect selectView;
	String btnPressed;
	
	public PlayerSelectLevelController(PlayerLevelSelect window, String btnPressed){
		this.selectView = window;
		this.btnPressed = btnPressed;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Access files to build level
		//potentially for future: close window
		//open new window
		PlayerLevel window = new PlayerLevel();
		window.open();
	}
}
