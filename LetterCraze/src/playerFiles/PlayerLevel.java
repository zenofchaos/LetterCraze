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
			this.wordsEntered = new ArrayList<>();
			
			//Initialize the level board
			if(this.initBoard()){
				// board initialized 
			}
			else{
				System.err.println ("board initialization failed");
			}
			
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
	
	int getBestScore(){
		return this.bestScore;
	}
	
	int getBestStars(){
		return this.bestStars;
	}
	
	public PlayerBoard getBoard(){
		return this.board;
	}
	
	boolean getIsLocked(){
		return this.isLocked;
	}
	
	boolean setTitle(String title){
		this.title = title;
		return true;
	}
	
	boolean setPointScore(int pointScore){
		this.pointScore = pointScore;
		return true;
	}
	
	boolean setStarCount(int starCount){
		this.starCount = starCount;
		return true;
	}
	
	boolean setWordsEntered(ArrayList<PlayerWord> wordsEntered){
		this.wordsEntered = wordsEntered;
		return true;
	}
	
	boolean setStarThresholds(int[] starThresholds){
		if (starThresholds.length == 3){
			this.starThresholds = starThresholds;
			return true;
		}
		else{
			return false;
		}
	}
	
	boolean setBestScore(int bestScore){
		this.bestScore = bestScore;
		return true;
	}
	
	boolean setBestStars(int bestStars){
		this.bestStars = bestStars;
		return true;
	}
	
	public boolean setBoard(PlayerBoard board){
		this.board = board;
		return true;
	}
	
	boolean setIsLocked(Boolean isLocked){
		this.isLocked = isLocked;
		return true;
	}
	
	
	public boolean initBoard(){
		PlayerSquare[][] squareArray = new PlayerSquare[6][6];
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				squareArray[row][col] = new PlayerSquare(row, col);
				squareArray[row][col].setLetter(new PlayerLetter());
			}
		}
		PlayerBoard newBoard = new PlayerBoard(squareArray);
		this.board = newBoard;
		return true;
	}
	
}
