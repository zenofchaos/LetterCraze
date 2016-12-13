package playerControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import playerGUI.PlayerLevelGUI;

import javax.swing.SwingUtilities;

import playerFiles.PlayerLevel;

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
			l().submitSelectedWord();
			levelView.refresh(l());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		levelView.refresh(l());
	}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	private PlayerLevel l() {
		return levelView.getLevel();
	}
}