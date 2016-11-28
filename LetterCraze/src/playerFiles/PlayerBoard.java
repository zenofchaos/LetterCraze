package playerFiles;

public class PlayerBoard {
	PlayerSquare[][] squares;
	
	PlayerBoard(PlayerSquare[][] squares){
		if((squares.length == 6) && squares[0].length == 6){
			this.squares = squares;
		}
		else{
			System.err.println ("incorrect square array passed to build board");
		}
		
	}
	
	PlayerSquare[][] getSquares(){
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

}
