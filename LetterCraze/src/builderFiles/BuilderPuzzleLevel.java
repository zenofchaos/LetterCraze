package builderFiles;

public class BuilderPuzzleLevel extends BuilderLevel{

	int wordLimit;

	BuilderPuzzleLevel(int[] starThresholds, String title, int wordLimit) {
		super(starThresholds, title);
		this.wordLimit = wordLimit;
	}
	
	int getWordLimit(){
		return this.wordLimit;
	}
	
	boolean setWordLimit(int wordLimit){
		this.wordLimit = wordLimit;
		return true;
	}
}
