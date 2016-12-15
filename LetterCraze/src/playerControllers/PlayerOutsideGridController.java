package playerControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import playerGUI.PlayerLevelGUI;

import javax.swing.SwingUtilities;

import playerFiles.PlayerLevel;
import playerFiles.PlayerWord;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerOutsideGridController.
 */
public class PlayerOutsideGridController implements MouseListener {

	/** The level view. */
	PlayerLevelGUI levelView;
	
	/** The level. */
	PlayerLevel level;
	
	/** The row. */
	int row;
	
	/** The col. */
	int col;
	
	/**
	 * Instantiates a new player outside grid controller.
	 *
	 * @param window the window
	 */
	public PlayerOutsideGridController(PlayerLevelGUI window){
		this.levelView = window;
		this.level = window.getLevel();
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
		levelView.refresh(this.level);
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
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			this.level.setSelectedWord(new PlayerWord());
			levelView.refresh(this.level);
		} else if (SwingUtilities.isRightMouseButton(e)) {
			if (this.level.submitSelectedWord()) {
				levelView.refreshAndScroll(this.level);
			} else {
				levelView.refresh(this.level);
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {}
	
}