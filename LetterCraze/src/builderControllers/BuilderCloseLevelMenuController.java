package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderGUI.BuilderMainMenuGUI;
import builderGUI.BuilderSelectLevelGUI;

/**
 * The Class BuilderCloseLevelMenuController closes the level menu gui when the back button is pressed and opens the main menu.
 */
public class BuilderCloseLevelMenuController implements ActionListener {
	
	/** The level menu view. */
	BuilderSelectLevelGUI levelMenuView;
	
	/**
	 * Instantiates a new builder close level menu controller.
	 *
	 * @param levelMenuView the level menu view
	 */
	public BuilderCloseLevelMenuController(BuilderSelectLevelGUI levelMenuView){
		this.levelMenuView = levelMenuView;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		levelMenuView.closeWindow();
		BuilderMainMenuGUI mainMenu =  new BuilderMainMenuGUI();
		mainMenu.openWindow();
		
	}
}
