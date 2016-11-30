package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import builderFiles.*;
import builderGUI.BuilderLevelSelect;
import builderGUI.BuilderMainMenu;
import builderGUI.BuilderNewLevelGUI;
import playerFiles.PlayerMenu;
import playerGUI.PlayerSelectLevelGUI;
import playerGUI.PlayerMainMenuGUI;

public class BuilderOpenLevelSelectController implements ActionListener{

	BuilderMainMenu menuView;
	
	public BuilderOpenLevelSelectController(BuilderMainMenu theWindow) {
		this.menuView = theWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Close menu window
		menuView.close();
		//Generate the model
		//FileAccessController fileAccess = new FileAccessController(new PlayerMenu());
		//PlayerModel model = fileAccess.getModel();th
		BuilderNewLevelGUI selectView = new BuilderNewLevelGUI(new BuilderMenu());
		selectView.open();
	}
}