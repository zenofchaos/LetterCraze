package PlayerFiles;

public class PlayerSquare {

	PlayerLetter letter;
	int row;
	int col;
	
	public PlayerSquare(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	PlayerLetter getLetter(){
		return this.getLetter();
	}
	
	int getRow(){
		return this.row;
	}
	
	int getCol(){
		return this.col;
	}
	
	boolean setLetter(PlayerLetter toSet){
		this.letter = toSet;
		return true;
	}
	
	boolean setRow (int toSet){
		this.row = toSet;
		return true;
	}
	
	boolean setCol (int toSet){
		this.row = toSet;
		return true;
	}
	
	//
	public PlayerLetter changeLetter (PlayerLetter toChange){
		if (this.letter == null){
			return null;
		}
		else{
			PlayerLetter tempLetter = this.letter;
			this.letter = toChange;
			return tempLetter;
		}
	}
}
