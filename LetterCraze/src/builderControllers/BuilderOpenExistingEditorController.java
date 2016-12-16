package builderControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import builderFiles.BuilderLevel;
import builderFiles.BuilderMenu;
import builderGUI.BuilderEditorGUI;
import builderGUI.BuilderSelectLevelGUI;

/**
 * The Class BuilderOpenExistingEditorController opens an existing level to be edited from the level menu gui.
 */
public class BuilderOpenExistingEditorController implements MouseListener {
	
	/** The menu view. */
	BuilderSelectLevelGUI menuView;
	
	/** The level identifier. */
	String levelIdentifier;
	
	/** The menu. */
	BuilderMenu menu;
	
	/**
	 * Instantiates a new builder open existing editor controller.
	 *
	 * @param menuView the menu view
	 * @param levelIdentifier the level identifier
	 */
	public BuilderOpenExistingEditorController(BuilderSelectLevelGUI menuView, String levelIdentifier) {
		this.menuView = menuView;
		this.levelIdentifier = levelIdentifier;
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
		BuilderLevel level = menu.getLevel(levelIdentifier);
		level.initBoard();
		BuilderEditorGUI window = new BuilderEditorGUI(level, levelIdentifier);
		window.openWindow();
		menuView.closeWindow();
		
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

}
