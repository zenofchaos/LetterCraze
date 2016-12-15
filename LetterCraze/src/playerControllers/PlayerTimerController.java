package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerFiles.PlayerLevel;
import playerGUI.PlayerLevelGUI;
import playerGUI.PlayerTimeUpGUI;

public class PlayerTimerController implements ActionListener{

	PlayerLevelGUI window;
	PlayerLevel level;
	String identifier;
	
	public PlayerTimerController(PlayerLevelGUI w){
		this.window = w;
		this.level = this.window.getLevel();
		this.identifier = this.window.getIdentifier();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		window.closeWindow();
		
		PlayerTimeUpGUI timeUpWindow = new PlayerTimeUpGUI(this.level,this.identifier);
		timeUpWindow.openWindow();
	}

}
