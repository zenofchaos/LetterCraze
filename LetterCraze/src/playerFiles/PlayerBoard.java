package playerFiles;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class PlayerBoard a baord for the player.
 */
public class PlayerBoard {
	
	/** The squares. */
	PlayerSquare[][] squares;
	
	/**
	 * Instantiates a new player board.
	 *
	 * @param squares the squares
	 */
	public PlayerBoard(PlayerSquare[][] squares){
		if((squares.length == 6) && squares[0].length == 6){
			this.squares = squares;
		}
		else{
			System.err.println ("incorrect square array passed to build board");
		}
		
	}
	
	/**
	 * Gets the square array.
	 *
	 * @return the square array
	 */
	public PlayerSquare[][] getSquareArray(){
		return this.squares;
	}
	
	/**
	 * Sets the square array.
	 *
	 * @param squares the squares
	 * @return true, if successful
	 */
	boolean setSquareArray(PlayerSquare[][] squares){
		if((squares.length == 6) && squares[0].length == 6){
			this.squares = squares;
			return true;
		}
		else{ 
			return false;
		}
	}
	
	/**
	 * Gets the square at a given row and column.
	 *
	 * @param row the row
	 * @param col the col
	 * @return the square
	 */
	public PlayerSquare getSquare(int row, int col){
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
	public boolean setSquare(PlayerSquare toSet, int row, int col){
		this.squares[row][col] = toSet;
		return true;
	}
	

	/**
	 * Rise Implements 'gravity' in this board by raising
	 * letters to fill empty squares where possible.
	 * If no letters remain below a square, the square
	 * remains empty
	 *
	 * @return true, if successful
	 */
	public boolean rise(){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(!this.squares[i][j].hasLetter()){
					this.squares = findLetter(this.squares, i,j);
				}
			}
		}
		return true;
	}
	
	
	/**
	 * Find letter Returns a board with the square corresponding 
	 * to the given row and column filled with the first letter found 
	 * in the squares below.
	 *
	 * @param theBoard the the board
	 * @param row the row
	 * @param col the col
	 * @return the player square[][]
	 */
	private PlayerSquare[][] findLetter(PlayerSquare[][] theBoard, int row, int col){
		try{
			if(!theBoard[row + 1][col].hasLetter()){
				theBoard = findLetter(theBoard,row + 1,col);
			}
			theBoard[row][col].setLetter(theBoard[row + 1][col].removeLetter());
			return theBoard;
		}
		catch (Exception e){
			theBoard[row][col].setLetter(null);
			return theBoard;
		}
	}
	
	/**
	 * Replace, once gravity happens fills all 
	 * empty squares with random letters.
	 *
	 * @return true, if successful
	 */
	boolean replace(){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(!this.squares[i][j].hasLetter()){
					this.squares[i][j].setLetter(new PlayerLetter());
				}
			}
		}
		return true;
	}
	
	/**
	 * Adds the word to the list of words.
	 *
	 * @param toAdd the to add
	 * @return the player board
	 */
	public PlayerBoard addWord(PlayerWord toAdd){
		List<PlayerSquare> squaresToAdd = toAdd.getSquares();
		
		//while there are still squares to add
		while(squaresToAdd.size() > 0){
			PlayerSquare next = squaresToAdd.get(0);

			//make the next square to add the one highest up in the board (lowest column val)
			for(int i = 1; i < squaresToAdd.size(); i++){
				if (squaresToAdd.get(i).getRow() < next.getRow()){
					next = squaresToAdd.get(i);
				}
			}
			
			int rowToUpdate = next.getRow();
			int colToUpdate = next.getCol();
			PlayerLetter letterToAdd = next.getLetter();
			
			while(rowToUpdate < 6){
				//replace the current square with the letter to add, saving the letter it held previously
				letterToAdd = this.squares[rowToUpdate][colToUpdate].changeLetter(letterToAdd);
				//increment the column
				rowToUpdate++;
			}
			squaresToAdd.remove(next);
		}
		return this;
	}
	
	/**
	 * Removes the word, from the list of words.
	 *
	 * @param word the word
	 * @return true, if successful
	 */
	public boolean removeWord(PlayerWord word){
		List<PlayerSquare> squares = word.getSquares();
		PlayerSquare toRemove;
		for(int i = 0; i < squares.size(); i++){
			toRemove = squares.get(i);
			this.squares[toRemove.getRow()][toRemove.getCol()].removeLetter();
		}
		return false;
	}
}
