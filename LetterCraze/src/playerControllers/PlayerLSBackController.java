package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerGUI.PlayerMainMenuGUI;
import playerGUI.PlayerSelectLevelGUI;

public class PlayerLSBackController implements ActionListener{

	PlayerSelectLevelGUI lsView;
	
	public PlayerLSBackController(PlayerSelectLevelGUI window){
		this.lsView = window;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		lsView.closeWindow();
		PlayerMainMenuGUI menuView = new PlayerMainMenuGUI();
		menuView.openWindow();
	}
}
