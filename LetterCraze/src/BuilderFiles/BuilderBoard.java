package BuilderFiles;

public class BuilderBoard {

BuilderSquare[][] squares;
	
	BuilderBoard(BuilderSquare[][] squares){
		if((squares.length == 6) && squares[0].length == 6){
			this.squares = squares;
		}
		else{
			System.err.println ("incorrect square array passed to build board");
		}
		
	}
	
	BuilderSquare[][] getSquares(){
		return this.squares;
	}
	
	boolean setSquares(BuilderSquare[][] squares){
		if((squares.length == 6) && squares[0].length == 6){
			this.squares = squares;
			return true;
		}
		else{ 
			return false;
		}
	}
}
