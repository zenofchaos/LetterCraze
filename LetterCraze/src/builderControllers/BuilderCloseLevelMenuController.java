package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderGUI.BuilderMainMenuGUI;
import builderGUI.BuilderNewLevelGUI;

public class BuilderCloseLevelMenuController implements ActionListener {
	BuilderNewLevelGUI levelMenuView;
	
	public BuilderCloseLevelMenuController(BuilderNewLevelGUI levelMenuView){
		this.levelMenuView = levelMenuView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		levelMenuView.closeWindow();
		BuilderMainMenuGUI mainMenu =  new BuilderMainMenuGUI();
		mainMenu.openWindow();
		
	}
}
