package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerGUI.PlayerMainMenuGUI;
import playerGUI.PlayerSelectLevelGUI;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerLSBackController.
 */
public class PlayerLSBackController implements ActionListener{

	/** The ls view. */
	PlayerSelectLevelGUI lsView;
	
	/**
	 * Instantiates a new player LS back controller.
	 *
	 * @param window the window
	 */
	public PlayerLSBackController(PlayerSelectLevelGUI window){
		this.lsView = window;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		lsView.closeWindow();
		PlayerMainMenuGUI menuView = new PlayerMainMenuGUI();
		menuView.openWindow();
	}
}
