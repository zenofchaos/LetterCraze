package playerFiles;

import java.util.ArrayList;

public class PlayerLightningLevel extends PlayerLevel {
	int maxTime;
	
	public PlayerLightningLevel(int[] starThresholds, int bestScore, int bestStars, boolean isLocked, String title, int maxTime) {
		super(starThresholds, bestScore, bestStars, isLocked, title);
		this.maxTime = maxTime;
	}
	
	public int getMaxTime(){
		return this.maxTime;
	}
	
	boolean setMaxTime(int maxTime){
		this.maxTime = maxTime;
		return true;
	}

	@Override
	public int wordScore(PlayerWord w) {
		return 1;
	}

	@Override
	public boolean isValidWord(PlayerWord w) {
		return w.isValidWord();
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
