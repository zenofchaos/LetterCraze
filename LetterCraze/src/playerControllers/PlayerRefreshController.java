package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerFiles.PlayerLevel;
import playerGUI.PlayerLevelGUI;

public class PlayerRefreshController implements ActionListener{

	PlayerLevelGUI window;
	PlayerLevel level;
	
	public PlayerRefreshController(PlayerLevelGUI w){
		this.window = w;
		this.level = w.getLevel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.window.refresh(this.level);
	}

}
