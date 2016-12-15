package builderFiles;

import builderFiles.BuilderSquare;
import playerFiles.PlayerLetter;

// TODO: Auto-generated Javadoc
/**
 * The Class BuilderLevel.
 */
public abstract class BuilderLevel {
	
		/** The title. */
		String title;
		
		/** The star thresholds. */
		int[] starThresholds;
		
		/** The board. */
		BuilderBoard board;
		
		/**
		 * Instantiates a new builder level.
		 *
		 * @param starThresholds the star thresholds
		 * @param title the title
		 */
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
		
		/**
		 * Gets the title.
		 *
		 * @return the title
		 */
		public String getTitle(){
			return this.title;
		}
		
		
		/**
		 * Gets the star thresholds.
		 *
		 * @return the star thresholds
		 */
		public int[] getStarThresholds(){
			return this.starThresholds;
		}
		
		/**
		 * Gets the board.
		 *
		 * @return the board
		 */
		public BuilderBoard getBoard(){
			return this.board;
		}
		
		/**
		 * Sets the title.
		 *
		 * @param title the title
		 * @return true, if successful
		 */
		public boolean setTitle(String title){
			this.title = title;
			return true;
		}
		
		
		/**
		 * Sets the star thresholds.
		 *
		 * @param starThresholds the star thresholds
		 * @return true, if successful
		 */
		public boolean setStarThresholds(int[] starThresholds){
			if(starThresholds.length == 3){
				this.starThresholds = starThresholds;
				return true;
			}
			else{
				return false;
			}
		}
		
		/**
		 * Sets the board.
		 *
		 * @param board the board
		 * @return true, if successful
		 */
		public boolean setBoard(BuilderBoard board){
			this.board = board;
			return true;
		}
		
		/**
		 * Inits the empty board.
		 *
		 * @return true, if successful
		 */
		public boolean initEmptyBoard(){
			BuilderSquare[][] squareArray = new BuilderSquare[6][6];
			for(int row = 0; row < 6; row++){
				for(int col = 0; col < 6; col++){
					squareArray[row][col] = new BuilderSquare(row, col);
				}
			}
			BuilderBoard newBoard = new BuilderBoard(squareArray);
			this.board = newBoard;
			return true;
		}
		
		/**
		 * Inits the board.
		 *
		 * @return true, if successful
		 */
		public boolean initBoard(){
			for(int row = 0; row < 6; row++){
				for(int col = 0; col < 6; col++){
					this.board.getSquareArray()[row][col].setLetter(new BuilderLetter());
				}
			}
			return true;
		}
	
}
