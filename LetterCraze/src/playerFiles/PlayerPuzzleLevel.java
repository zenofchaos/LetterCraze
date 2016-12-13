package playerFiles;

public class PlayerPuzzleLevel extends PlayerLevel {
	
	int wordLimit;

	public PlayerPuzzleLevel(int[] starThresholds, int bestScore, int bestStars, boolean isLocked, String title, int wordLimit) {
		super(starThresholds, bestScore, bestStars, isLocked, title);
		this.wordLimit = wordLimit;
	}
	
	public int getWordLimit(){
		return this.wordLimit;
	}
	
	boolean setWordLimit(int wordLimit){
		this.wordLimit = wordLimit;
		return true;
	}
	
	@Override
	public boolean submitSelectedWord(){
		if ((isValidWord(selectedWord)) && (wordsEntered.size() <= wordLimit)) {
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
			selectedWord = new PlayerWord();
			return true;
		} else {
			return false;
		}
	}
}
