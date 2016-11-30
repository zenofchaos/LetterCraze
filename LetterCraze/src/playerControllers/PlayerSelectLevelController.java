package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerFiles.PlayerLetterCraze;
import playerFiles.PlayerLevel;

public class PlayerSelectLevelController implements ActionListener{

	PlayerLetterCraze theGame;
	PlayerLevel linkedLevel;
	
	public PlayerSelectLevelController(PlayerLetterCraze game, PlayerLevel toLink){
		this.theGame = game;
		this.linkedLevel = toLink;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//save active level
		theGame.setActiveLevel(this.linkedLevel);
		//close level select window
		//open 
	}
}
