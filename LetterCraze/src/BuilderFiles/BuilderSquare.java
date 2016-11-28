package BuilderFiles;

public class BuilderSquare {

	BuilderLetter letter;
	int row;
	int col;
	
	//The constructor for a BuilderSquare
	//	Takes in the square's row and column.
	public BuilderSquare(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	//Get method for letter
	BuilderLetter getLetter(){
		return this.getLetter();
	}
	
	//Get method for row
	int getRow(){
		return this.row;
	}
	
	//Get method for column
	int getCol(){
		return this.col;
	}
	
	//Set method for letter
	boolean setLetter(BuilderLetter toSet){
		this.letter = toSet;
		return true;
	}
	
	//Set method for row
	boolean setRow (int toSet){
		this.row = toSet;
		return true;
	}
	
	//Set method for column
	boolean setCol (int toSet){
		this.row = toSet;
		return true;
	}
	
	//Replaces the letter held by this square with the given letter.
	//	Returns the letter previously held by this square (Returns
	//	null if this square held no letter)
	public BuilderLetter changeLetter (BuilderLetter toChange){
		if (this.letter == null){
			return null;
		}
		else{
			BuilderLetter tempLetter = this.letter;
			this.letter = toChange;
			return tempLetter;
		}
	}
	
	//Removes the letter currently held by this square
	//	Returns true if successful, returns false if this 
	//	Square was already empty
	public boolean removeLetter(){
		if (this.letter == null){
			return false;
		}
		else{
			this.letter = null;
			return true;
		}
	}
}

