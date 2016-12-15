package builderControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import builderFiles.BuilderLightningLevel;
import builderFiles.BuilderMenu;
import builderFiles.BuilderPuzzleLevel;
import builderFiles.BuilderThemeLevel;
import builderGUI.BuilderEditorGUI;
import builderGUI.BuilderSelectLevelGUI;

public class BuilderOpenNewEditorController implements MouseListener{

	BuilderSelectLevelGUI menuView;
	char type;
	String levelIdentifier;
	BuilderMenu menu;
	
	
	public BuilderOpenNewEditorController(BuilderSelectLevelGUI menuView, String levelIdentifier) {
		this.menuView = menuView;
		this.levelIdentifier = levelIdentifier;
		this.type = levelIdentifier.charAt(0);
		this.menu = menuView.getMenu();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(this.type == 'P'){
			int[] empty = new int[3];
			BuilderPuzzleLevel level = new BuilderPuzzleLevel(empty, "", 0);
			level.initEmptyBoard();
			BuilderEditorGUI window = new BuilderEditorGUI(level, levelIdentifier);
			window.openWindow();
			menuView.closeWindow();
		}
		else if(this.type == 'T'){
			int[] empty = new int[3];
			LinkedList<String> words = new LinkedList<String>();
			BuilderThemeLevel level = new BuilderThemeLevel(empty, "", "", words, null);
			level.initEmptyBoard();
			BuilderEditorGUI window = new BuilderEditorGUI(level, levelIdentifier);
			window.openWindow();
			menuView.closeWindow();
		}
		else if(this.type == 'L'){
			int[] empty = new int[3];
			BuilderLightningLevel level = new BuilderLightningLevel(empty, "", 0);
			level.initEmptyBoard();
			BuilderEditorGUI window = new BuilderEditorGUI(level, levelIdentifier);
			window.openWindow();
			menuView.closeWindow();
		}
		else{
			System.out.println("Invalid type sent to BuilderOpenNewEditorController");
		}
		
		
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
