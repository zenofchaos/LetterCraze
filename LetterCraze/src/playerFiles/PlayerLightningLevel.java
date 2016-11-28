package playerFiles;

public class PlayerLightningLevel extends PlayerLevel {
	int maxTime;
	
	PlayerLightningLevel(int[] starThresholds, int bestScore, int bestStars, boolean isLocked, String title, int maxTime) {
		super(starThresholds, bestScore, bestStars, isLocked, title);
		this.maxTime = maxTime;
	}
	
	int getMaxTime(){
		return this.maxTime;
	}
	
	boolean setMaxTime(int maxTime){
		this.maxTime = maxTime;
		return true;
	}
}
