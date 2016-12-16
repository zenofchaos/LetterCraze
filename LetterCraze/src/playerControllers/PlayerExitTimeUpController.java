package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import playerFiles.PlayerLevel;
import playerFiles.PlayerLightningLevel;
import playerFiles.PlayerModel;
import playerFiles.PlayerPuzzleLevel;
import playerFiles.PlayerThemeLevel;
import playerGUI.PlayerSelectLevelGUI;
import playerGUI.PlayerTimeUpGUI;


/**
 * The Class PlayerExitTimeUpController, exits the lightning when time is up.
 */
public class PlayerExitTimeUpController implements ActionListener{

	/** The window. */
	PlayerTimeUpGUI window;
	
	/** The level. */
	PlayerLevel level;
	
	/** The identifier. */
	String identifier;
	
	/**
	 * Instantiates a new player exit time up controller.
	 *
	 * @param w the w
	 */
	public PlayerExitTimeUpController(PlayerTimeUpGUI w){
		this.window = w;
		this.level = w.getLevel();
		this.identifier = w.getIdentifier();
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
		window.closeWindow();
		
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
