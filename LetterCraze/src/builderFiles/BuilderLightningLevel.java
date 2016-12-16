package builderFiles;

/**
 * The Class BuilderLightningLevel is a lightning level for builder.
 */
public class BuilderLightningLevel extends BuilderLevel{

/** The max time. */
int maxTime;
	
	/**
	 * Instantiates a new builder lightning level.
	 *
	 * @param starThresholds the star thresholds
	 * @param title the title
	 * @param maxTime the max time
	 */
	public BuilderLightningLevel(int[] starThresholds, String title, int maxTime) {
		super(starThresholds, title);
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
	public boolean setMaxTime(int maxTime){
		this.maxTime = maxTime;
		return true;
	}
}
