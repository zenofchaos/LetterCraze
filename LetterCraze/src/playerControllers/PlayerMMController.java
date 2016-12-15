package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderLightningLevel;
import playerFiles.*;
import playerGUI.PlayerSelectLevelGUI;
import playerGUI.PlayerMainMenuGUI;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerMMController.
 */
public class PlayerMMController implements ActionListener{

	/** The menu view. */
	PlayerMainMenuGUI menuView;
	
	/**
	 * Instantiates a new player MM controller.
	 *
	 * @param theWindow the the window
	 */
	public PlayerMMController(PlayerMainMenuGUI theWindow) {
		this.menuView = theWindow;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Close menu window
		menuView.closeWindow();
		//Generate the model
		PlayerFileAccessController fileAccess = new PlayerFileAccessController();
		try{
			PlayerModel model = fileAccess.getModel();
			
			// Open level select window
			PlayerSelectLevelGUI selectView = new PlayerSelectLevelGUI(model.getMenu());
			selectView.openWindow();
		}
		catch (Exception exception){
			System.out.println("FileAccess threw an exception in PlayerOpenLevelController");
			exception.printStackTrace();
		}
	}
}
