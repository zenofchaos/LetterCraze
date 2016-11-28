package playerFiles;

public class PlayerPuzzleLevel extends PlayerLevel {
	
	int wordLimit;

	PlayerPuzzleLevel(int[] starThresholds, int bestScore, int bestStars, boolean isLocked, String title, int wordLimit) {
		super(starThresholds, bestScore, bestStars, isLocked, title);
		this.wordLimit = wordLimit;
	}
	
	int getWordLimit(){
		return this.wordLimit;
	}
	
	boolean setWordLimit(int wordLimit){
		this.wordLimit = wordLimit;
		return true;
	}

}
