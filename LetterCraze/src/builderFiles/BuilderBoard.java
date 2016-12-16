package builderFiles;

import playerFiles.PlayerLetter;

// TODO: Auto-generated Javadoc
/**
 * The Class BuilderBoard.
 */
public class BuilderBoard {

/** The squares. */
BuilderSquare[][] squares;
	
	/**
	 * Instantiates a new builder board.
	 *
	 * @param squares the squares
	 */
	public BuilderBoard(BuilderSquare[][] squares){
		if((squares.length == 6) && squares[0].length == 6){
			this.squares = squares;
		}
		else{
			System.err.println ("incorrect square array passed to build board");
		}
		
	}
	
	/**
	 * Replace.
	 *
	 * @return true, if successful
	 */
	boolean replace(){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(!this.squares[i][j].hasLetter()){
					this.squares[i][j].setLetter(new BuilderLetter());
				}
			}
		}
		return true;
	}
	
	/**
	 * Gets the square array.
	 *
	 * @return the square array
	 */
	public BuilderSquare[][] getSquareArray(){
		return this.squares;
	}
	
	/**
	 * Sets the square array.
	 *
	 * @param squares the squares
	 * @return true, if successful
	 */
	boolean setSquareArray(BuilderSquare[][] squares){
		if((squares.length == 6) && squares[0].length == 6){
			this.squares = squares;
			return true;
		}
		else{ 
			return false;
		}
	}
	
	/**
	 * Gets the square.
	 *
	 * @param row the row
	 * @param col the col
	 * @return the square
	 */
	public BuilderSquare getSquare(int row, int col){
		return this.squares[row][col];
	}
	
	/**
	 * Sets the square.
	 *
	 * @param toSet the to set
	 * @param row the row
	 * @param col the col
	 * @return true, if successful
	 */
	public boolean setSquare(BuilderSquare toSet, int row, int col){
		this.squares[row][col] = toSet;
		return true;
	}
}
