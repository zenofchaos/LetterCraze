package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerFiles.PlayerLevel;
import playerGUI.PlayerLevelGUI;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerRefreshController.
 */
public class PlayerRefreshController implements ActionListener{

	/** The window. */
	PlayerLevelGUI window;
	
	/** The level. */
	PlayerLevel level;
	
	/**
	 * Instantiates a new player refresh controller.
	 *
	 * @param w the w
	 */
	public PlayerRefreshController(PlayerLevelGUI w){
		this.window = w;
		this.level = w.getLevel();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.window.refresh(this.level);
	}

}
