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

public class PlayerLSController implements MouseListener{

	PlayerSelectLevelGUI selectView;
	PlayerMenu menu;
	String levelIdentifier;
	
	public PlayerLSController(PlayerSelectLevelGUI window, String levelIdentifier){
		this.selectView = window;
		this.levelIdentifier = levelIdentifier;
		this.menu = window.getMenu();
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//Access files to build level
		//potentially for future: close window
		//open new window
		PlayerLevel level = menu.getLevel(levelIdentifier);
		System.out.println(levelIdentifier);
		level.initBoard();
		PlayerLevelGUI window = new PlayerLevelGUI(level);
		window.openWindow();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
