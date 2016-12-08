package playerFiles;

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
	
	public PlayerSquare[][] getSquares(){
		return this.squares;
	}
	
	boolean setSquares(PlayerSquare[][] squares){
		if((squares.length == 6) && squares[0].length == 6){
			this.squares = squares;
			return true;
		}
		else{ 
			return false;
		}
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
}
