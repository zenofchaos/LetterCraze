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
	
	public BuilderSquare[][] getSquareArray(){
		return this.squares;
	}
	
	boolean setSquareArray(BuilderSquare[][] squares){
		if((squares.length == 6) && squares[0].length == 6){
			this.squares = squares;
			return true;
		}
		else{ 
			return false;
		}
	}
	
	public BuilderSquare getSquare(int row, int col){
		return this.squares[row][col];
	}
	
	public boolean setSquare(BuilderSquare toSet, int row, int col){
		this.squares[row][col] = toSet;
		return true;
	}
}
