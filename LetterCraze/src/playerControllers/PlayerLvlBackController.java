package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerFiles.PlayerLevel;
import playerFiles.PlayerLightningLevel;
import playerFiles.PlayerModel;
import playerFiles.PlayerPuzzleLevel;
import playerFiles.PlayerThemeLevel;
import playerGUI.PlayerLevelGUI;
import playerGUI.PlayerSelectLevelGUI;

public class PlayerLvlBackController implements ActionListener{

	PlayerLevelGUI levelView;
	PlayerLevel level;
	String identifier;
	
	public PlayerLvlBackController(PlayerLevelGUI window){
		this.levelView = window;
		this.level = this.levelView.getLevel();
		this.identifier = this.levelView.getIdentifier();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int bestScore = this.level.getBestScore();
		if(this.level.getBestScore() < this.level.getPointScore()){
			bestScore = this.level.getPointScore();
		}
		
		int bestStars = this.level.getBestStars();
		if(this.level.getBestStars() < this.level.getStarCount()){
			bestStars = this.level.getStarCount();
		}
		
		PlayerFileAccessController fileAccessController = new PlayerFileAccessController();
		
		if (this.level instanceof PlayerPuzzleLevel){
			try {
				fileAccessController.updatePuzzle(this.identifier.charAt(1) - 48,bestScore,bestStars);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		else if (this.level instanceof PlayerLightningLevel){
			try {
				System.out.println("Best Score " + bestScore);
				System.out.println("Identifier " + this.identifier);
				fileAccessController.updateLightning(this.identifier.charAt(1) - 48,bestScore,bestStars);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else if (this.level instanceof PlayerThemeLevel){
			try {
				fileAccessController.updateTheme(this.identifier.charAt(1) - 48,bestScore,bestStars);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		else{
			System.out.println("The level given to PlayerLvlBackController is not a puzzle, lightning, or theme level.");
		}
		
		this.level.reset();
		levelView.closeWindow();
		
		PlayerFileAccessController fileAccess = new PlayerFileAccessController();
		try{
			PlayerModel model = fileAccess.getModel();
			
			// Open level select window
			PlayerSelectLevelGUI selectView = new PlayerSelectLevelGUI(model.getMenu());
			selectView.openWindow();
		}
		catch (Exception exception){
			System.out.println("FileAccess threw an exception in PlayerOpenLevelController");
			exception.printStackTrace();
		}
	}
}
