package playerFiles;

import java.util.*;


public abstract class PlayerLevel {
	String title;
	int pointScore;
	int starCount;
	ArrayList<PlayerWord> wordsEntered;
	int[] starThresholds;
	int bestScore;
	int bestStars;
	PlayerBoard board;
	PlayerWord selectedWord;
	boolean isLocked;
	
	PlayerLevel(int[] starThresholds, int bestScore, int bestStars, boolean isLocked, String title){
		if(!(starThresholds.length == 3)){
			System.err.println ("incorrect number passed to create PlayerLevel");
		}
		else{
			this.starThresholds = starThresholds;
			this.bestScore = bestScore;
			this.bestStars = bestStars;
			this.isLocked = isLocked;
			this.title = title;
			this.pointScore = 0;
			this.starCount = 0;
			this.wordsEntered = new ArrayList<PlayerWord>();
			this.selectedWord = new PlayerWord();			
		}
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public int getPointScore(){
		return this.pointScore;
	}
	
	public int getStarCount(){
		return this.starCount;
	}
	
	public ArrayList<PlayerWord> getWordsEntered(){
		return this.wordsEntered;
	}
	
	public int[] getStarThresholds(){
		return this.starThresholds;
	}
	
	public int getBestScore(){
		return this.bestScore;
	}
	
	public int getBestStars(){
		return this.bestStars;
	}
	
	public PlayerBoard getBoard(){
		return this.board;
	}
	
	public PlayerWord getSelectedWord() {
		return this.selectedWord;
	}
	
	public boolean getIsLocked(){
		return this.isLocked;
	}
	
	public boolean setTitle(String title){
		this.title = title;
		return true;
	}
	
	public boolean setPointScore(int pointScore){
		this.pointScore = pointScore;
		return true;
	}
	
	public boolean setStarCount(int starCount){
		this.starCount = starCount;
		return true;
	}
	
	public boolean setWordsEntered(ArrayList<PlayerWord> wordsEntered){
		this.wordsEntered = wordsEntered;
		return true;
	}
	
	public boolean setStarThresholds(int[] starThresholds){
		if (starThresholds.length == 3){
			this.starThresholds = starThresholds;
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean setBestScore(int bestScore){
		this.bestScore = bestScore;
		return true;
	}
	
	public boolean setBestStars(int bestStars){
		this.bestStars = bestStars;
		return true;
	}
	
	public boolean setBoard(PlayerBoard board){
		this.board = board;
		return true;
	}
	
	public boolean setSelectedWord(PlayerWord selectedWord){
		this.selectedWord = selectedWord;
		return true;
	}
	
	public boolean setIsLocked(boolean isLocked){
		this.isLocked = isLocked;
		return true;
	}
	
	public boolean initBoard(){
		if (this.board != null) {
		} else { // This means the board doesn't exist. go through and make all
					// the squares real quick before continuing.
			PlayerSquare[][] emptyarray = new PlayerSquare[6][6];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					emptyarray[i][j] = new PlayerSquare(i, j);
				}
			}
			PlayerBoard board = new PlayerBoard(emptyarray);
			this.setBoard(board);
		}

		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				this.board.getSquareArray()[row][col].setLetter(new PlayerLetter());
			}
		}
		return true;
	}

	abstract public boolean submitSelectedWord();

	abstract public boolean isValidWord(PlayerWord w);
	
	abstract public int wordScore(PlayerWord w);
	
	public boolean squareIsSelected(PlayerSquare s) {
		try{
			return selectedWord.contains(s);
		}
		catch (NullPointerException e){
			return false;
		}
	}
	
	abstract public void reset();
}
