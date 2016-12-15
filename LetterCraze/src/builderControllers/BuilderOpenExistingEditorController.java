package builderControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import builderFiles.BuilderLevel;
import builderFiles.BuilderMenu;
import builderGUI.BuilderEditorGUI;
import builderGUI.BuilderSelectLevelGUI;

public class BuilderOpenExistingEditorController implements MouseListener {
	
	BuilderSelectLevelGUI menuView;
	String levelIdentifier;
	BuilderMenu menu;
	
	public BuilderOpenExistingEditorController(BuilderSelectLevelGUI menuView, String levelIdentifier) {
		this.menuView = menuView;
		this.levelIdentifier = levelIdentifier;
		this.menu = menuView.getMenu();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		BuilderLevel level = menu.getLevel(levelIdentifier);
		level.initBoard();
		BuilderEditorGUI window = new BuilderEditorGUI(level, levelIdentifier);
		window.openWindow();
		menuView.closeWindow();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
