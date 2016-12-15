package builderControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import builderFiles.BuilderLevel;
import builderFiles.BuilderSquare;
import builderGUI.BuilderEditorGUI;

// TODO: Auto-generated Javadoc
/**
 * The Class BuilderSquareController.
 */
public class BuilderSquareController implements MouseListener {

	/** The level view. */
	BuilderEditorGUI levelView;
	
	/** The row. */
	int row;
	
	/** The col. */
	int col;
	
	/**
	 * Instantiates a new builder square controller.
	 *
	 * @param window the window
	 * @param i the i
	 * @param j the j
	 */
	public BuilderSquareController(BuilderEditorGUI window, int i, int j){
		this.levelView = window;
		this.row = i;
		this.col = j;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {}

	/* (non-Javadoc)
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

	/* (non-Javadoc)
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
	 * L.
	 *
	 * @return the builder level
	 */
	private BuilderLevel l() {
		return levelView.getLevel();
	}
	
	/**
	 * This square.
	 *
	 * @return the builder square
	 */
	private BuilderSquare thisSquare() {
		return l().getBoard().getSquareArray()[row][col];
	}
	
	/**
	 * Toggle.
	 */
	private void toggle() {
		thisSquare().setActive(!(thisSquare().getActive()));
	}
	
}