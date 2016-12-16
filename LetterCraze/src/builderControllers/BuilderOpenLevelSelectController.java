package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.*;
import builderGUI.BuilderMainMenuGUI;
import builderGUI.BuilderSelectLevelGUI;

/**
 * The Class BuilderOpenLevelSelectController opens the menu gui with the levels from the main menu.
 */
public class BuilderOpenLevelSelectController implements ActionListener{

	/** The menu view. */
	BuilderMainMenuGUI menuView;
	
	/**
	 * Instantiates a new builder open level select controller.
	 *
	 * @param theWindow the the window
	 */
	public BuilderOpenLevelSelectController(BuilderMainMenuGUI theWindow) {
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
		BuilderFileAccessController fileAccess = new BuilderFileAccessController();
		BuilderModel model;
		try{
			model = fileAccess.getModel();
			BuilderSelectLevelGUI selectView = new BuilderSelectLevelGUI(model.getMenu());
			selectView.openWindow();
			
		}
		catch (Exception exception){
			System.out.println("Builder File Access threw an exception");
			exception.printStackTrace();
		}
	}
}