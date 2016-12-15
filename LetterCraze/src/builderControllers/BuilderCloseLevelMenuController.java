package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderGUI.BuilderMainMenuGUI;
import builderGUI.BuilderSelectLevelGUI;

// TODO: Auto-generated Javadoc
/**
 * The Class BuilderCloseLevelMenuController.
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
