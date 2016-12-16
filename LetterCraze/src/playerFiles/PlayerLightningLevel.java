package playerFiles;

import java.util.ArrayList;

/**
 * The Class PlayerLightningLevel.
 */
public class PlayerLightningLevel extends PlayerLevel {
	
	/** The max time. */
	int maxTime;
	
	/**
	 * Instantiates a new player lightning level.
	 *
	 * @param starThresholds the star thresholds
	 * @param bestScore the best score
	 * @param bestStars the best stars
	 * @param isLocked the is locked
	 * @param title the title
	 * @param maxTime the max time
	 */
	public PlayerLightningLevel(int[] starThresholds, int bestScore, int bestStars, boolean isLocked, String title, int maxTime) {
		super(starThresholds, bestScore, bestStars, isLocked, title);
		this.maxTime = maxTime;
	}
	
	/**
	 * Gets the max time.
	 *
	 * @return the max time
	 */
	public int getMaxTime(){
		return this.maxTime;
	}
	
	/**
	 * Sets the max time.
	 *
	 * @param maxTime the max time
	 * @return true, if successful
	 */
	boolean setMaxTime(int maxTime){
		this.maxTime = maxTime;
		return true;
	}

	/* (non-Javadoc)
	 * @see playerFiles.PlayerLevel#wordScore(playerFiles.PlayerWord)
	 */
	@Override
	public int wordScore(PlayerWord w) {
		return 1;
	}

	/* (non-Javadoc)
	 * @see playerFiles.PlayerLevel#isValidWord(playerFiles.PlayerWord)
	 */
	@Override
	public boolean isValidWord(PlayerWord w) {
		return w.isValidWord();
	}

	/* (non-Javadoc)
	 * @see playerFiles.PlayerLevel#submitSelectedWord()
	 */
	@Override
	public boolean submitSelectedWord(){
		if (isValidWord(selectedWord)) {
			wordsEntered.add(selectedWord);
			pointScore += wordScore(selectedWord);
			if (pointScore >= starThresholds[2]){
				starCount = 3;
			}
			else if (pointScore >= starThresholds[1]){
				starCount = 2;
			}
			else if (pointScore >= starThresholds[0]){
				starCount = 1;
			}

			this.board.removeWord(selectedWord);
			this.board.rise();
			this.board.replace();
			
			selectedWord = new PlayerWord();
			return true;
		} else {
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see playerFiles.PlayerLevel#reset()
	 */
	@Override
	public void reset() {
		this.initBoard();
		this.pointScore = 0;
		this.selectedWord = new PlayerWord();
		this.starCount = 0;
		this.wordsEntered = new ArrayList<PlayerWord>();
	}
}
