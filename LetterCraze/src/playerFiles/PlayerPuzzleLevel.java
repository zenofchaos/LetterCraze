package playerFiles;

import java.util.ArrayList;

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

	@Override
	public boolean isValidWord(PlayerWord w) {
		return w.isValidWord();
	}

	@Override
	public int wordScore(PlayerWord w) {
		return w.getPointVal();
	}

	@Override
	public void reset() {
		this.initBoard();
		this.pointScore = 0;
		this.selectedWord = new PlayerWord();
		this.starCount = 0;
		this.wordsEntered = new ArrayList<PlayerWord>();
	}
}
