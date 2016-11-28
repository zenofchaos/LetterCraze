package PlayerFiles;

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

}
