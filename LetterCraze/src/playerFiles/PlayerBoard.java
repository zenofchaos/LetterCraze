package playerFiles;

import java.util.ArrayList;
import java.util.List;

public class PlayerBoard {
	PlayerSquare[][] squares;
	
	public PlayerBoard(PlayerSquare[][] squares){
		if((squares.length == 6) && squares[0].length == 6){
			this.squares = squares;
		}
		else{
			System.err.println ("incorrect square array passed to build board");
		}
		
	}
	
	public PlayerSquare[][] getSquareArray(){
		return this.squares;
	}
	
	boolean setSquareArray(PlayerSquare[][] squares){
		if((squares.length == 6) && squares[0].length == 6){
			this.squares = squares;
			return true;
		}
		else{ 
			return false;
		}
	}
	
	public PlayerSquare getSquare(int row, int col){
		return this.squares[row][col];
	}
	
	public boolean setSquare(PlayerSquare toSet, int row, int col){
		this.squares[row][col] = toSet;
		return true;
	}
	
	//Implements 'gravity' in this board by raising 
	//	letters to fill empty squares where possible
	//If no letters remain below a square, the square
	//	remains empty
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
	
	//Returns a board with the square corresponding to the given row and column filled
	//	with the first letter found in the squares below or null if there are not letters
	//	below this square
	private PlayerSquare[][] findLetter(PlayerSquare[][] theBoard, int row, int col){
		try{
			if(!theBoard[row][col + 1].hasLetter()){
				theBoard = findLetter(theBoard,row,col+1);
			}
			theBoard[row][col].setLetter(theBoard[row][col + 1].removeLetter());
			return theBoard;
		}
		catch (Exception e){
			theBoard[row][col].setLetter(null);
			return theBoard;
		}
	}
	
	//Fills all empty squares with random letters
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
	
	public PlayerBoard addWord(PlayerWord toAdd){
		List<PlayerSquare> squaresToAdd = toAdd.getSquares();
		
		//while there are still squares to add
		while(squaresToAdd.size() > 0){
			PlayerSquare next = squaresToAdd.get(0);

			//make the next square to add the one highest up in the board (lowest column val)
			for(int i = 1; i < squaresToAdd.size(); i++){
				if (squaresToAdd.get(i).getCol() < next.getCol()){
					next = squaresToAdd.get(i);
				}
			}
			
			int rowToUpdate = next.getRow();
			int colToUpdate = next.getRow();
			PlayerLetter letterToAdd = next.getLetter();
			
			while(colToUpdate < 6){
				//replace the current square with the letter to add, saving the letter it held previously
				letterToAdd = this.squares[rowToUpdate][colToUpdate].changeLetter(letterToAdd);
				//increment the column
				colToUpdate++;
			}
		}
		return null;
	}
	
	public boolean removeWord(PlayerWord word){
		List<PlayerSquare> squares = word.getSquares();
		PlayerSquare toRemove;
		for(int i = 0; i < squares.size(); i++){
			toRemove = squares.get(i);
			int row = toRemove.getRow();
			int col = toRemove.getCol();
		}
		return false;
	}
}
