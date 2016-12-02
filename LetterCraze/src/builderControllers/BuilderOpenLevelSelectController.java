package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import builderFiles.*;
import builderGUI.BuilderMainMenuGUI;
import builderGUI.BuilderNewLevelGUI;
import playerFiles.PlayerMenu;
import playerGUI.PlayerSelectLevelGUI;
import playerGUI.PlayerMainMenuGUI;

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
		//FileAccessController fileAccess = new FileAccessController(new PlayerMenu());
		//PlayerModel model = fileAccess.getModel();th
		BuilderNewLevelGUI selectView = new BuilderNewLevelGUI(new BuilderMenu());
		selectView.openWindow();
	}
}