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

/**
 * The Class BuilderOpenNewEditorController opens a new blank level to be created of whatever type was selected.
 */
public class BuilderOpenNewEditorController implements MouseListener{

	/** The menu view. */
	BuilderSelectLevelGUI menuView;
	
	/** The type. */
	char type;
	
	/** The level identifier. */
	String levelIdentifier;
	
	/** The menu. */
	BuilderMenu menu;
	
	
	/**
	 * Instantiates a new builder open new editor controller.
	 *
	 * @param menuView the menu view
	 * @param levelIdentifier the level identifier
	 */
	public BuilderOpenNewEditorController(BuilderSelectLevelGUI menuView, String levelIdentifier) {
		this.menuView = menuView;
		this.levelIdentifier = levelIdentifier;
		this.type = levelIdentifier.charAt(0);
		this.menu = menuView.getMenu();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		openLevel();
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Open level is where the new level is build and the gui is opened. 
	 * Based on what type of level identifier was sent, a specific level type
	 * is created and sent to the gui when opening. 
	 *
	 * @return the builder editor GUI
	 */
	BuilderEditorGUI openLevel(){
		if(this.type == 'P'){
			int[] empty = new int[3];
			BuilderPuzzleLevel level = new BuilderPuzzleLevel(empty, "", 0);
			level.initEmptyBoard();
			BuilderEditorGUI window = new BuilderEditorGUI(level, levelIdentifier);
			window.openWindow();
			menuView.closeWindow();
			return window;
		}
		else if(this.type == 'T'){
			int[] empty = new int[3];
			LinkedList<String> words = new LinkedList<String>();
			BuilderThemeLevel level = new BuilderThemeLevel(empty, "", "", words, null);
			level.initEmptyBoard();
			BuilderEditorGUI window = new BuilderEditorGUI(level, levelIdentifier);
			window.openWindow();
			menuView.closeWindow();
			return window;
		}
		else if(this.type == 'L'){
			int[] empty = new int[3];
			BuilderLightningLevel level = new BuilderLightningLevel(empty, "", 0);
			level.initEmptyBoard();
			BuilderEditorGUI window = new BuilderEditorGUI(level, levelIdentifier);
			window.openWindow();
			menuView.closeWindow();
			return window;
		}
		else{
			System.out.println("Invalid type sent to BuilderOpenNewEditorController");
			int[] empty = new int[3];
			BuilderLightningLevel level = new BuilderLightningLevel(empty, "", 0);
			BuilderEditorGUI window = new BuilderEditorGUI(level, levelIdentifier);
			return window;
		}
	}

	
}
