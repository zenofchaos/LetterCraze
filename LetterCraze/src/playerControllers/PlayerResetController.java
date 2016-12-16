package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerFiles.PlayerLevel;
import playerGUI.PlayerLevelGUI;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerResetController, works the reset button on the player.
 */
public class PlayerResetController implements ActionListener{

	/** The level view. */
	PlayerLevelGUI levelView;
	
	/** The level. */
	PlayerLevel level;
	
	/**
	 * Instantiates a new player reset controller.
	 *
	 * @param window the window
	 */
	public PlayerResetController(PlayerLevelGUI window){
		this.levelView = window;
		this.level = levelView.getLevel();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.level.reset();
		levelView.refresh(this.level);
	}
}
