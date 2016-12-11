package playerControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import playerGUI.PlayerLevelGUI;

import javax.swing.SwingUtilities;

import playerFiles.PlayerLevel;
import playerFiles.PlayerWord;

public class PlayerOutsideGridController implements MouseListener {

	PlayerLevelGUI levelView;
	int row;
	int col;
	
	public PlayerOutsideGridController(PlayerLevelGUI window){
		this.levelView = window;
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
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			l().setMouseHeld(false);
		}
	}
	
	private PlayerLevel l() {
		return levelView.getLevel();
	}
}