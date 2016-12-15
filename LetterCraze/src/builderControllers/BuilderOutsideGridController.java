package builderControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import builderGUI.BuilderEditorGUI;

import builderFiles.BuilderLevel;

// TODO: Auto-generated Javadoc
/**
 * The Class BuilderOutsideGridController.
 */
public class BuilderOutsideGridController implements MouseListener {

	/** The level view. */
	BuilderEditorGUI levelView;
	
	/** The row. */
	int row;
	
	/** The col. */
	int col;
	
	/**
	 * Instantiates a new builder outside grid controller.
	 *
	 * @param window the window
	 */
	public BuilderOutsideGridController(BuilderEditorGUI window){
		this.levelView = window;
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
	 * L.
	 *
	 * @return the builder level
	 */
	private BuilderLevel l() {
		return levelView.getLevel();
	}
}