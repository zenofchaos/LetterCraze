package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderGUI.BuilderMainMenuGUI;
import builderGUI.BuilderSelectLevelGUI;

public class BuilderCloseLevelMenuController implements ActionListener {
	BuilderSelectLevelGUI levelMenuView;
	
	public BuilderCloseLevelMenuController(BuilderSelectLevelGUI levelMenuView){
		this.levelMenuView = levelMenuView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		levelMenuView.closeWindow();
		BuilderMainMenuGUI mainMenu =  new BuilderMainMenuGUI();
		mainMenu.openWindow();
		
	}
}
