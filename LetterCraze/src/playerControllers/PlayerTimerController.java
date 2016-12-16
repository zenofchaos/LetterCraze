package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerFiles.PlayerLevel;
import playerGUI.PlayerLevelGUI;
import playerGUI.PlayerTimeUpGUI;

/**
 * The Class PlayerTimerController, controlls the time for the lightning levels.
 */
public class PlayerTimerController implements ActionListener{

	/** The window. */
	PlayerLevelGUI window;
	
	/** The level. */
	PlayerLevel level;
	
	/** The identifier. */
	String identifier;
	
	/**
	 * Instantiates a new player timer controller.
	 *
	 * @param w the w
	 */
	public PlayerTimerController(PlayerLevelGUI w){
		this.window = w;
		this.level = this.window.getLevel();
		this.identifier = this.window.getIdentifier();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		window.closeWindow();
		
		PlayerTimeUpGUI timeUpWindow = new PlayerTimeUpGUI(this.level,this.identifier);
		timeUpWindow.openWindow();
	}

}
