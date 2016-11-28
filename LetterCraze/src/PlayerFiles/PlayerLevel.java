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
