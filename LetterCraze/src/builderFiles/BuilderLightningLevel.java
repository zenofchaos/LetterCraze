package builderFiles;

public class BuilderLightningLevel extends BuilderLevel{

int maxTime;
	
	BuilderLightningLevel(int[] starThresholds, String title, int maxTime) {
		super(starThresholds, title);
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
