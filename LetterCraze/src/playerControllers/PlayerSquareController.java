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
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			if (!(l().getMouseHeld())) {
				l().submitSelectedWord();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if ((l().getMouseHeld()) && (thisSquare().isNeighbor(l().getSelectedWord().recentSquare(1)))) {
			if (l().squareIsSelected(thisSquare())) {
				if (thisSquare() == l().getSelectedWord().recentSquare(2)) {
					l().getSelectedWord().removeSquare();
				}
			} else {
				l().getSelectedWord().addSquare(thisSquare());
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			l().setSelectedWord(new PlayerWord(thisSquare()));
			l().setMouseHeld(true);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			l().setMouseHeld(false);
		}
	}
	
	private PlayerLevel l() {
		return levelView.getLevel();
	}
	
	private PlayerSquare thisSquare() {
		return l().getBoard().getSquares()[row][col];
	}
}
