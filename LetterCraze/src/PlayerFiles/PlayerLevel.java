package PlayerFiles;

import java.util.*;


public abstract class PlayerLevel {
	int pointScore;
	int starCount;
	ArrayList<PlayerWord[]> wordsEntered;
	int[] starThresholds = new int[10];
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
		return true;
	}
	
	
	

}
