package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerFiles.PlayerLevel;
import playerGUI.PlayerLevelGUI;

public class PlayerLvlBackController implements ActionListener{

	PlayerLevelGUI levelView;
	PlayerLevel level;
	
	public PlayerLvlBackController(PlayerLevelGUI window){
		this.levelView = window;
		this.level = this.levelView.getLevel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.level.reset();
		levelView.closeWindow();
	}

}
