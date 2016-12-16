package playerFiles;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerPuzzleLevel.
 */
public class PlayerPuzzleLevel extends PlayerLevel {
	
	/** The word limit. */
	int wordLimit;

	/**
	 * Instantiates a new player puzzle level.
	 *
	 * @param starThresholds the star thresholds
	 * @param bestScore the best score
	 * @param bestStars the best stars
	 * @param isLocked the is locked
	 * @param title the title
	 * @param wordLimit the word limit
	 */
	public PlayerPuzzleLevel(int[] starThresholds, int bestScore, int bestStars, boolean isLocked, String title, int wordLimit) {
		super(starThresholds, bestScore, bestStars, isLocked, title);
		this.wordLimit = wordLimit;
	}
	
	/**
	 * Gets the word limit.
	 *
	 * @return the word limit
	 */
	public int getWordLimit(){
		return this.wordLimit;
	}
	
	/**
	 * Sets the word limit.
	 *
	 * @param wordLimit the word limit
	 * @return true, if successful
	 */
	boolean setWordLimit(int wordLimit){
		this.wordLimit = wordLimit;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see playerFiles.PlayerLevel#submitSelectedWord()
	 */
	@Override
	public boolean submitSelectedWord(){
		if ((isValidWord(selectedWord)) && (wordsEntered.size() < wordLimit)) {
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
	 * @see playerFiles.PlayerLevel#isValidWord(playerFiles.PlayerWord)
	 */
	@Override
	public boolean isValidWord(PlayerWord w) {
		return w.isValidWord();
	}

	/* (non-Javadoc)
	 * @see playerFiles.PlayerLevel#wordScore(playerFiles.PlayerWord)
	 */
	@Override
	public int wordScore(PlayerWord w) {
		return w.getPointVal();
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
