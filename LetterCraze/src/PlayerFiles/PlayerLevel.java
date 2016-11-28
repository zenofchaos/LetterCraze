package PlayerFiles;

import java.util.*;


public abstract class PlayerLevel {
	int pointScore;
	int starCount;
	ArrayList<PlayerWord[]> wordsEntered;
	int[] starThresholds;
	int bestScore;
	int bestStars;
	PlayerBoard board;
	boolean isLocked;
	
	PlayerLevel(int[] starThresholds, int bestScore, int bestStars, boolean isLocked){
		if(!(starThresholds.length == 3)){
			System.err.println ("incorrect number passed to create PlayerLevel");
		}
		else{
			this.starThresholds = starThresholds;
			this.bestScore = bestScore;
			this.bestStars = bestStars;
			this.isLocked = isLocked;
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
	
	int getPointScore(){
		return this.pointScore;
	}
	
	int getStarCount(){
		return this.starCount;
	}
	
	ArrayList<PlayerWord[]> getWordsEntered(){
		return this.wordsEntered;
	}
	
	int[] getStarThresholds(){
		return this.starThresholds;
	}
	
	int getBestScore(){
		return this.bestScore;
	}
	
	int getBestStars(){
		return this.bestStars;
	}
	
	PlayerBoard getBoard(){
		return this.board;
	}
	
	Boolean getIsLocked(){
		return this.isLocked;
	}
	
	Boolean setPointScore(int pointScore){
		this.pointScore = pointScore;
		return true;
	}
	
	Boolean setStarCount(int starCount){
		this.starCount = starCount;
		return true;
	}
	
	Boolean setWordsEntered(ArrayList<PlayerWord[]> wordsEntered){
		this.wordsEntered = wordsEntered;
		return true;
	}
	
	Boolean setStarThresholds(int[] starThresholds){
		this.starThresholds = starThresholds;
		return true;
	}
	
	Boolean setBestScore(int bestScore){
		this.bestScore = bestScore;
		return true;
	}
	
	Boolean setBestStars(int bestStars){
		this.bestStars = bestStars;
		return true;
	}
	
	Boolean setBoard(PlayerBoard board){
		this.board = board;
		return true;
	}
	
	Boolean setIsLocked(Boolean isLocked){
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
		return true;
	}
	
	
	

}
