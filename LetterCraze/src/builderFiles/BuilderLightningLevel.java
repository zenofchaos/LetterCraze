<<<<<<< HEAD
package builderFiles;

public class BuilderLightningLevel extends BuilderLevel{

int maxTime;
	
	public BuilderLightningLevel(int[] starThresholds, String title, int maxTime) {
		super(starThresholds, title);
		this.maxTime = maxTime;
	}
	
	public int getMaxTime(){
		return this.maxTime;
	}
	
	boolean setMaxTime(int maxTime){
		this.maxTime = maxTime;
		return true;
	}
}
=======
package builderFiles;

public class BuilderLightningLevel extends BuilderLevel{

int maxTime;
	
	public BuilderLightningLevel(int[] starThresholds, String title, int maxTime) {
		super(starThresholds, title);
		this.maxTime = maxTime;
	}
	
	public int getMaxTime(){
		return this.maxTime;
	}
	
	boolean setMaxTime(int maxTime){
		this.maxTime = maxTime;
		return true;
	}
}
>>>>>>> branch 'master' of https://github.com/zenofchaos/LetterCraze.git
