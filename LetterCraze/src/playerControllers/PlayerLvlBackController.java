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


/**
 * The Class PlayerLvlBackController, a back button in the player gui to go back to the menu.
 */
public class PlayerLvlBackController implements ActionListener{

	/** The level view. */
	PlayerLevelGUI levelView;
	
	/** The level. */
	PlayerLevel level;
	
	/** The identifier. */
	String identifier;
	
	/**
	 * Instantiates a new player lvl back controller.
	 *
	 * @param window the window
	 */
	public PlayerLvlBackController(PlayerLevelGUI window){
		this.levelView = window;
		this.level = this.levelView.getLevel();
		this.identifier = this.levelView.getIdentifier();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int bestScore = this.level.getBestScore();
		if(this.level.getBestScore() < this.level.getPointScore()){
			bestScore = this.level.getPointScore();
		}
		
		int bestStars = this.level.getBestStars();
		int previousBestStars = this.level.getBestStars();
		if(this.level.getBestStars() < this.level.getStarCount()){
			bestStars = this.level.getStarCount();
		}
		
		boolean unlockNext = false;
		if((previousBestStars == 0) && (previousBestStars < bestStars)){
			unlockNext = true;
		}
		
		PlayerFileAccessController fileAccessController = new PlayerFileAccessController();
		
		if (this.level instanceof PlayerPuzzleLevel){
			try {
				fileAccessController.updatePuzzle(this.identifier.charAt(1) - 48,bestScore,bestStars);
				if(unlockNext){
					fileAccessController.unlockPuzzle();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		else if (this.level instanceof PlayerLightningLevel){
			try {
				fileAccessController.updateLightning(this.identifier.charAt(1) - 48,bestScore,bestStars);
				if(unlockNext){
					fileAccessController.unlockLightning();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else if (this.level instanceof PlayerThemeLevel){
			try {
				fileAccessController.updateTheme(this.identifier.charAt(1) - 48,bestScore,bestStars);
				if(unlockNext){
					fileAccessController.unlockTheme();
				}
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
