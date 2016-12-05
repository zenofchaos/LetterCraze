package builderFiles;

public class BuilderBoard {

BuilderSquare[][] squares;
	
	public BuilderBoard(BuilderSquare[][] squares){
		if((squares.length == 6) && squares[0].length == 6){
			this.squares = squares;
		}
		else{
			System.err.println ("incorrect square array passed to build board");
		}
		
	}
	
	public BuilderSquare[][] getSquares(){
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
