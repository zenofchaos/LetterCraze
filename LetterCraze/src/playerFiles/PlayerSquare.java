package playerFiles;

public class PlayerSquare {

	PlayerLetter letter;
	int row;
	int col;
	boolean active;
	
	//The constructor for a PlayerSquare
	//	Takes in the square's row and column.
	//	Squares are inactive by default
	public PlayerSquare(int row, int col){
		this.row = row;
		this.col = col;
		this.active = false;
	}
	
	//Get method for letter
	public PlayerLetter getLetter(){
		return this.letter;
	}
	
	//Get method for row
	public int getRow(){
		return this.row;
	}
	
	//Get method for column
	public int getCol(){
		return this.col;
	}
	
	//Get method for isActive
	public boolean getActive(){
		return this.active;
	}
	
	//Set method for letter
	public boolean setLetter(PlayerLetter toSet){
		this.letter = toSet;
		return true;
	}
	
	//Set method for row
	public boolean setRow (int toSet){
		this.row = toSet;
		return true;
	}
	
	//Set method for column
	boolean setCol (int toSet){
		this.col = toSet;
		return true;
	}
	
	//Set method for isActive
	public boolean setActive(boolean toSet){
		this.active = toSet;
		return true;
	}
	
	//Returns a string of the letter(s) in this square
	//Throws a Null Pointer Exception if this square has no letter
	public String toString(){
		return this.letter.getLetter();
	}
	
	//Returns the point value of the letter in this square
	//Throws a Null Pointer Exception if this square has no letter
	public int getPoints(){
		return this.letter.getPoints();
	}
	
	//Returns true if this square has a letter
	//Otherwise, returns false
	public boolean hasLetter(){
		return !(this.letter == null);
	}
	
	//Replaces the letter held by this square with the given letter.
	//	Returns the letter previously held by this square (Returns
	//	null if this square held no letter)
	public PlayerLetter changeLetter (PlayerLetter toChange){
		PlayerLetter tempLetter = this.letter;
		this.letter = toChange;
		return tempLetter;
	}
	
	//Removes the letter currently held by this square
	//	Returns true if successful, returns false if this 
	//	Square was already empty
	public PlayerLetter removeLetter(){
		if (this.letter == null){
			return null;
		}
		else{
			PlayerLetter tempLetter = this.letter;
			this.letter = null;
			return tempLetter;
		}
	}
	
	//returns true if this square neighbors the given square. A neighbor is defined as
	//	a square which can be reached from this square by adding or subtracting 1 from
	//	the row and/or column.
	public boolean isNeighbor(PlayerSquare toCheck){
		
		boolean topleft = (this.row - 1 == toCheck.getRow()) && (this.col - 1 == toCheck.getCol());
		boolean topcenter = (this.row - 1 == toCheck.getRow()) && (this.col == toCheck.getCol());
		boolean topright = (this.row - 1 == toCheck.getRow()) && (this.col + 1 == toCheck.getCol());
		boolean left = (this.row == toCheck.getRow()) && (this.col - 1 == toCheck.getCol());
		boolean right = (this.row == toCheck.getRow()) && (this.col + 1 == toCheck.getCol());
		boolean bottomleft = (this.row + 1 == toCheck.getRow()) && (this.col - 1 == toCheck.getCol());
		boolean bottomcenter = (this.row + 1 == toCheck.getRow()) && (this.col == toCheck.getCol());
		boolean bottomright = (this.row + 1 == toCheck.getRow()) && (this.col + 1 == toCheck.getCol());
		
		return (topleft || topcenter || topright || left || right || bottomleft || bottomcenter || bottomright);
	}
	
	public boolean equals(PlayerSquare toMatch){
		boolean matchingLetter = this.toString() == toMatch.toString();
		boolean matchingRow = this.row == toMatch.getRow();
		boolean matchingCol = this.col == toMatch.getCol();
		boolean matchingActivity = this.active == toMatch.getActive();
		
		return matchingLetter && matchingRow && matchingCol && matchingActivity;
	}
}
