package playerControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import playerGUI.PlayerLevelGUI;

import javax.swing.SwingUtilities;

import playerFiles.PlayerLevel;
import playerFiles.PlayerWord;

public class PlayerOutsideGridController implements MouseListener {

	PlayerLevelGUI levelView;
	PlayerLevel level;
	int row;
	int col;
	
	public PlayerOutsideGridController(PlayerLevelGUI window){
		this.levelView = window;
		this.level = window.getLevel();
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		levelView.refresh(this.level);
	}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			doMouseLeftPressed();
		} else if (SwingUtilities.isRightMouseButton(e)) {
			doMouseRightPressed();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	public boolean doMouseLeftPressed() {
		this.level.setSelectedWord(new PlayerWord());
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