package playerControllers;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import playerFiles.PlayerLevel;
import playerFiles.PlayerLightningLevel;
import playerFiles.PlayerMenu;
import playerGUI.PlayerLevelGUI;
import playerGUI.PlayerSelectLevelGUI;

/**
 * The Class PlayerLSController, opens a level selection gui from the main menu.
 */
public class PlayerLSController implements MouseListener{

	/** The select view. */
	PlayerSelectLevelGUI selectView;
	
	/** The menu. */
	PlayerMenu menu;
	
	/** The level identifier. */
	String levelIdentifier;
	
	/**
	 * Instantiates a new player LS controller.
	 *
	 * @param window the window
	 * @param levelIdentifier the level identifier
	 */
	public PlayerLSController(PlayerSelectLevelGUI window, String levelIdentifier){
		this.selectView = window;
		this.levelIdentifier = levelIdentifier;
		this.menu = window.getMenu();
	}
	

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		//Access files to build level
		//potentially for future: close window
		//open new window
		PlayerLevel level = menu.getLevel(levelIdentifier);
		System.out.println(levelIdentifier);
		level.initBoard();
		PlayerLevelGUI window = new PlayerLevelGUI(level, levelIdentifier);
		window.openWindow();
		this.selectView.closeWindow();
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
