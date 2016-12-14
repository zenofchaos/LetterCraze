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
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		levelView.refresh(l());
	}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			l().setSelectedWord(new PlayerWord());
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
}