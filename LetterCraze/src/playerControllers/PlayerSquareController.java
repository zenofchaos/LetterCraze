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
 * When added to a panel representing a square in a PlayerLevelGUI, an object of the class PlayerSquareController 
 * allows the panel to detect clicks and mouse motion by the user while the cursor is on the panel. The 
 * BuilderSquareController also updates the level entities and refreshes the display when appropriate.
 */
public class PlayerSquareController implements MouseListener {

	/** The graphical display of the level that is being played. */
	PlayerLevelGUI levelView;
	
	/** The level entity. */
	PlayerLevel level;
	
	/** The board row in which the associated panel is located. */
	int row;
	
	/** The board column in which the associated panel is located. */
	int col;
	
	/**
	 * Instantiates a new controller for a single panel.
	 *
	 * @param window the window containing level GUI components
	 * @param i the row of the panel within the board
	 * @param j the column of the panel within the board
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

	/**
	 * Adds this square to the selected word during a drag if active and adjacent to previous square.
	 * 
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

	/**
	 * Starts new selected word on left click or submits selected word on right click. Refreshes the display (and 
	 * scrolls the submission pane if submission occurs).
	 * 
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
	 * Gets the square being watched by the controller.
	 *
	 * @return the associated square entity
	 */
	private PlayerSquare thisSquare() {
		return this.level.getBoard().getSquareArray()[row][col];
	}
	
	/**
	 * Checks whether two squares are allowed to be selected one immediately after the other.
	 *
	 * @return true, if no word is selected or if the last selected square is adjacent to this square
	 */
	private boolean adjacencyRuleIsFollowed() {
		return     (this.level.getSelectedWord().getSquares().isEmpty())
				|| (thisSquare().isNeighbor(this.level.getSelectedWord().recentSquare(1)));
	}
	
	/** Testable helper method detailing the left mouse drag event. */
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
	
	/** Testable helper method detailing the left pressed event. */
	public boolean doMouseLeftPressed() {
		try{
			this.level.setSelectedWord(new PlayerWord(thisSquare()));
		}
		catch(NullPointerException npe){
			
		}
		levelView.refresh(this.level);
		return true;
	}
	
	/** Testable helper method detailing the right pressed event. */
	public boolean doMouseRightPressed() {
		if (this.level.submitSelectedWord()) {
			levelView.refreshAndScroll(this.level);
		} else {
			levelView.refresh(this.level);
		}
		return true;
	}
	
}
