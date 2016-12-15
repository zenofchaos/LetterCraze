package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.*;
import builderGUI.BuilderMainMenuGUI;
import builderGUI.BuilderSelectLevelGUI;

public class BuilderOpenLevelSelectController implements ActionListener{

	BuilderMainMenuGUI menuView;
	
	public BuilderOpenLevelSelectController(BuilderMainMenuGUI theWindow) {
		this.menuView = theWindow;
	}

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