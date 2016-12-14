package builderFiles;

public class BuilderPuzzleLevel extends BuilderLevel{

	int wordLimit;

	public BuilderPuzzleLevel(int[] starThresholds, String title, int wordLimit) {
		super(starThresholds, title);
		this.wordLimit = wordLimit;
	}
	
	public int getWordLimit(){
		return this.wordLimit;
	}
	
	public boolean setWordLimit(int wordLimit){
		this.wordLimit = wordLimit;
		return true;
	}
}