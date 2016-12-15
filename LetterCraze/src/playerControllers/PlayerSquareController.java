package playerControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import playerGUI.PlayerLevelGUI;

import javax.swing.SwingUtilities;

import playerFiles.PlayerLevel;
import playerFiles.PlayerSquare;
import playerFiles.PlayerWord;

public class PlayerSquareController implements MouseListener {

	PlayerLevelGUI levelView;
	PlayerLevel level;
	int row;
	int col;
	
	public PlayerSquareController(PlayerLevelGUI window, int i, int j){
		this.levelView = window;
		this.level = levelView.getLevel();
		this.row = i;
		this.col = j;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (   (e.getModifiers() == MouseEvent.BUTTON1_MASK)
			&& (thisSquare().getActive())
			&& (adjacencyRuleIsFollowed())) {
			doMouseLeftHeldEntered();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if ((SwingUtilities.isLeftMouseButton(e)) && (thisSquare().getActive())) {
			doMouseLeftPressed();
		} else if (SwingUtilities.isRightMouseButton(e)) {
			doMouseRightPressed();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	private PlayerSquare thisSquare() {
		return this.level.getBoard().getSquareArray()[row][col];
	}
	
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
