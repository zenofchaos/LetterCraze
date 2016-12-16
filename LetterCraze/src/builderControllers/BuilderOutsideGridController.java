package builderControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import builderGUI.BuilderEditorGUI;

import builderFiles.BuilderLevel;

/**
 * When added to the panel containing all other components of a BuilderEditorGUI, an object of the class 
 * BuilderOutsideGridController allows the panel to detect clicks and mouse motion by the user while the cursor is not 
 * on any other GUI component. The BuilderSquareController refreshes the display when appropriate.
 */
public class BuilderOutsideGridController implements MouseListener {

	/** The The graphical display of the level that is being built. */
	BuilderEditorGUI levelView;
	
	/**
	 * Instantiates a new controller for the content panel.
	 *
	 * @param window the window containing editor GUI components
	 */
	public BuilderOutsideGridController(BuilderEditorGUI window){
		this.levelView = window;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {}

	/**
	 * Refreshes the display. Is useful after the user resizes the game window to ensure that all components resize
	 * along with the window before the user attempts to interact with them.
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		//levelView.refresh(l());
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {}
	
	/**
	 * Gets the level being edited.
	 *
	 * @return the associated level entity
	 */
	private BuilderLevel l() {
		return levelView.getLevel();
	}
}