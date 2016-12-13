package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerGUI.PlayerLevelGUI;

public class PlayerLvlBackController implements ActionListener{

	PlayerLevelGUI levelView;
	
	public PlayerLvlBackController(PlayerLevelGUI window){
		this.levelView = window;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		levelView.closeWindow();
	}

}
