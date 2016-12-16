package builderFiles;

/**
 * The Class BuilderPuzzleLevel, a puzzle level for the builder.
 */
public class BuilderPuzzleLevel extends BuilderLevel{

	/** The word limit. */
	int wordLimit;

	/**
	 * Instantiates a new builder puzzle level.
	 *
	 * @param starThresholds the star thresholds
	 * @param title the title
	 * @param wordLimit the word limit
	 */
	public BuilderPuzzleLevel(int[] starThresholds, String title, int wordLimit) {
		super(starThresholds, title);
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
	public boolean setWordLimit(int wordLimit){
		this.wordLimit = wordLimit;
		return true;
	}
}