package BuilderFiles;

import BuilderFiles.BuilderSquare;

public abstract class BuilderLevel {
	
		String title;
		int[] starThresholds;
		BuilderBoard board;
		
		BuilderLevel(int[] starThresholds, String title){
			if(!(starThresholds.length == 3)){
				System.err.println ("incorrect number passed to create PlayerLevel");
			}
			else{
				this.starThresholds = starThresholds;
				this.title = title;
				
				//Initialize the level board
				if(this.initEmptyBoard()){
					// board initialized 
				}
				else{
					System.err.println ("empty board initialization failed");
				}
				
			}
		}
		
		String getTitle(){
			return this.title;
		}
		
		
		int[] getStarThresholds(){
			return this.starThresholds;
		}
		
		BuilderBoard getBoard(){
			return this.board;
		}
		
		boolean setTitle(String title){
			this.title = title;
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
		
		boolean setBoard(BuilderBoard board){
			this.board = board;
			return true;
		}
		
		public boolean initEmptyBoard(){
			BuilderSquare[][] squareArray = new BuilderSquare[6][6];
			for(int row = 0; row < 6; row++){
				for(int col = 0; col < 6; col++){
					squareArray[row][col] = new BuilderSquare(row, col);
					squareArray[row][col] = null;
				}
			}
			BuilderBoard newBoard = new BuilderBoard(squareArray);
			this.board = newBoard;
			return true;
		}
		
		public boolean initBoard(){
			BuilderSquare[][] squareArray = new BuilderSquare[6][6];
			for(int row = 0; row < 6; row++){
				for(int col = 0; col < 6; col++){
					squareArray[row][col] = new BuilderSquare(row, col);
					squareArray[row][col].setLetter(new BuilderLetter());
				}
			}
			BuilderBoard newBoard = new BuilderBoard(squareArray);
			this.board = newBoard;
			return true;
		}
	
}
