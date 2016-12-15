package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerFiles.PlayerLevel;
import playerGUI.PlayerLevelGUI;

public class PlayerResetController implements ActionListener{

	PlayerLevelGUI levelView;
	PlayerLevel level;
	
	public PlayerResetController(PlayerLevelGUI window){
		this.levelView = window;
		this.level = levelView.getLevel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.level.reset();
		levelView.refresh(this.level);
	}
}
