package builderControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import builderFiles.BuilderLevel;
import builderFiles.BuilderSquare;
import builderGUI.BuilderEditorGUI;

// TODO: Auto-generated Javadoc
/**
 * When added to a panel representing a square in a BuilderEditorGUI, an object of the class BuilderSquareController 
 * allows the panel to detect clicks and mouse motion by the user while the cursor is on the panel. The 
 * BuilderSquareController also updates the level entities and refreshes the display when appropriate.
 */
public class BuilderSquareController implements MouseListener {

	/** The graphical display of the level that is being built. */
	BuilderEditorGUI levelView;
	
	/** The board row in which the associated panel is located. */
	int row;
	
	/** The board column in which the associated panel is located. */
	int col;
	
	/**
	 * Instantiates a new controller for a single panel.
	 *
	 * @param window the window containing editor GUI components
	 * @param i the row of the panel within the board
	 * @param j the column of the panel within the board
	 */
	public BuilderSquareController(BuilderEditorGUI window, int i, int j){
		this.levelView = window;
		this.row = i;
		this.col = j;
	}

	/* ftdh
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {}

	/**
	 * Toggles the activity of the panel during a drag and refreshes the display.
	 *
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e) && ((e.getModifiers() == MouseEvent.BUTTON1_MASK))) {
			toggle();
			levelView.refresh(l());
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {}

	/**
	 * Toggles the activity of the panel and refreshes the display.
	 * 
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		/*if (SwingUtilities.isLeftMouseButton(e))*/ {
			toggle();
			levelView.refresh(l());
		}
	}
	
	/**
	 * Gets the level being edited.
	 *
	 * @return the associated level entity
	 */
	private BuilderLevel l() {
		return levelView.getLevel();
	}
	
	/**
	 * Gets the square being watched by the controller.
	 *
	 * @return the associated square entity
	 */
	private BuilderSquare thisSquare() {
		return l().getBoard().getSquareArray()[row][col];
	}
	
	/**
	 * Sets this square as active if currently inactive and vice versa.
	 */
	private void toggle() {
		thisSquare().setActive(!(thisSquare().getActive()));
	}
	
}