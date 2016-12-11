package playerFiles;

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
	int wordScore(PlayerWord w) {
		return 1;
	}
}
