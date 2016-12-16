package playerControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import playerGUI.PlayerLevelGUI;

import javax.swing.SwingUtilities;

import playerFiles.PlayerLevel;
import playerFiles.PlayerSquare;
import playerFiles.PlayerWord;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerSquareController, controls everything for the mouse events for the squares.
 */
public class PlayerSquareController implements MouseListener {

	/** The level view. */
	PlayerLevelGUI levelView;
	
	/** The level. */
	PlayerLevel level;
	
	/** The row. */
	int row;
	
	/** The col. */
	int col;
	
	/**
	 * Instantiates a new player square controller.
	 *
	 * @param window the window
	 * @param i the i
	 * @param j the j
	 */
	public PlayerSquareController(PlayerLevelGUI window, int i, int j){
		this.levelView = window;
		this.level = levelView.getLevel();
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
	public void mouseEntered(MouseEvent e) {
		if (   (e.getModifiers() == MouseEvent.BUTTON1_MASK)
			&& (thisSquare().getActive())
			&& (adjacencyRuleIsFollowed())) {
			doMouseLeftHeldEntered();
		}
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
		if ((SwingUtilities.isLeftMouseButton(e)) && (thisSquare().getActive())) {
			doMouseLeftPressed();
		} else if (SwingUtilities.isRightMouseButton(e)) {
			doMouseRightPressed();
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {}
	
	/**
	 * This square.
	 *
	 * @return the player square
	 */
	private PlayerSquare thisSquare() {
		return this.level.getBoard().getSquareArray()[row][col];
	}
	
	/**
	 * Adjacency rule is followed.
	 *
	 * @return true, if successful
	 */
	private boolean adjacencyRuleIsFollowed() {
		return     (this.level.getSelectedWord().getSquares().isEmpty())
				|| (thisSquare().isNeighbor(this.level.getSelectedWord().recentSquare(1)));
	}
	
	public boolean doMouseLeftHeldEntered() {
		if (this.level.squareIsSelected(thisSquare())) {
			if (thisSquare().equals(this.level.getSelectedWord().recentSquare(2))) {
				this.level.getSelectedWord().removeSquare();
				levelView.refresh(this.level);
			}
		} else {
			this.level.getSelectedWord().addSquare(thisSquare());
			levelView.refresh(this.level);
			
		}
		return true;
	}
	
	public boolean doMouseLeftPressed() {
		try{
			this.level.setSelectedWord(new PlayerWord(thisSquare()));
		}
		catch(NullPointerException npe){
			
		}
		levelView.refresh(this.level);
		return true;
	}
	
	public boolean doMouseRightPressed() {
		if (this.level.submitSelectedWord()) {
			levelView.refreshAndScroll(this.level);
		} else {
			levelView.refresh(this.level);
		}
		return true;
	}
	
}
