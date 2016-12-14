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
	int row;
	int col;
	
	public PlayerSquareController(PlayerLevelGUI window, int i, int j){
		this.levelView = window;
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
			if (l().squareIsSelected(thisSquare())) {
				if (thisSquare().equals(l().getSelectedWord().recentSquare(2))) {
					l().getSelectedWord().removeSquare();
					levelView.refresh(l());
				}
			} else {
				l().getSelectedWord().addSquare(thisSquare());
				levelView.refresh(l());
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if ((SwingUtilities.isLeftMouseButton(e)) && (thisSquare().getActive())) {
			l().setSelectedWord(new PlayerWord(thisSquare()));
			levelView.refresh(l());
		} else if (SwingUtilities.isRightMouseButton(e)) {
			if (l().submitSelectedWord()) {
				levelView.refreshAndScroll(l());
			} else {
				levelView.refresh(l());
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	private PlayerLevel l() {
		return levelView.getLevel();
	}
	
	private PlayerSquare thisSquare() {
		return l().getBoard().getSquareArray()[row][col];
	}
	
	private boolean adjacencyRuleIsFollowed() {
		return     (l().getSelectedWord().getSquares().isEmpty())
				|| (thisSquare().isNeighbor(l().getSelectedWord().recentSquare(1)));
	}
}
