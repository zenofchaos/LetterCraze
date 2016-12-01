package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerGUI.PlayerLevelGUI;

public class PlayerBackBtnController implements ActionListener{

	PlayerLevelGUI levelView;
	
	public PlayerBackBtnController(PlayerLevelGUI window){
		this.levelView = window;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		levelView.closeWindow();
	}

}
