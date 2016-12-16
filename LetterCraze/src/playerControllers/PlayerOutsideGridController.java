package playerControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import playerGUI.PlayerLevelGUI;

import javax.swing.SwingUtilities;

import playerFiles.PlayerLevel;
import playerFiles.PlayerWord;

// TODO: Auto-generated Javadoc
/**
 * When added to the panel containing all other components of a PlayerLevelGUI, an object of the class 
 * PlayerOutsideGridController allows the panel to detect clicks and mouse motion by the user while the cursor is not 
 * on any other GUI component. The BuilderSquareController updates level entities and refreshes the display when 
 * appropriate.
 */
public class PlayerOutsideGridController implements MouseListener {

	/** The The graphical display of the level that is being played. */
	PlayerLevelGUI levelView;
	
	/** The level entity. */
	PlayerLevel level;
	
	/**
	 * Instantiates a new controller for the content panel.
	 *
	 * @param window the window containing level GUI components
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

	/**
	 * Refreshes the display. Is useful after the user resizes the game window to ensure that all components resize
	 * along with the window before the user attempts to interact with them.
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
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
	
	/** Testable helper method detailing the left pressed event. */
	public boolean doMouseLeftPressed() {
		this.level.setSelectedWord(new PlayerWord());
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