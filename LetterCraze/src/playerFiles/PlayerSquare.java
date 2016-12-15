package playerFiles;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerSquare.
 */
public class PlayerSquare {

	/** The letter. */
	PlayerLetter letter;
	
	/** The row. */
	int row;
	
	/** The col. */
	int col;
	
	/** The active. */
	boolean active;
	
	//The constructor for a PlayerSquare
	//	Takes in the square's row and column.
	/**
	 * Instantiates a new player square.
	 *
	 * @param row the row
	 * @param col the col
	 */
	//	Squares are inactive by default
	public PlayerSquare(int row, int col){
		this.row = row;
		this.col = col;
		this.active = false;
	}
	
	/**
	 * Gets the letter.
	 *
	 * @return the letter
	 */
	//Get method for letter
	public PlayerLetter getLetter(){
		return this.letter;
	}
	
	/**
	 * Gets the row.
	 *
	 * @return the row
	 */
	//Get method for row
	public int getRow(){
		return this.row;
	}
	
	/**
	 * Gets the col.
	 *
	 * @return the col
	 */
	//Get method for column
	public int getCol(){
		return this.col;
	}
	
	/**
	 * Gets the active.
	 *
	 * @return the active
	 */
	//Get method for isActive
	public boolean getActive(){
		return this.active;
	}
	
	/**
	 * Sets the letter.
	 *
	 * @param toSet the to set
	 * @return true, if successful
	 */
	//Set method for letter
	public boolean setLetter(PlayerLetter toSet){
		this.letter = toSet;
		return true;
	}
	
	/**
	 * Sets the row.
	 *
	 * @param toSet the to set
	 * @return true, if successful
	 */
	//Set method for row
	public boolean setRow (int toSet){
		this.row = toSet;
		return true;
	}
	
	/**
	 * Sets the col.
	 *
	 * @param toSet the to set
	 * @return true, if successful
	 */
	//Set method for column
	boolean setCol (int toSet){
		this.col = toSet;
		return true;
	}
	
	/**
	 * Sets the active.
	 *
	 * @param toSet the to set
	 * @return true, if successful
	 */
	//Set method for isActive
	public boolean setActive(boolean toSet){
		this.active = toSet;
		return true;
	}
	
	//Returns a string of the letter(s) in this square
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	//Throws a Null Pointer Exception if this square has no letter
	public String toString(){
		return this.letter.getLetter();
	}
	
	//Returns the point value of the letter in this square
	/**
	 * Gets the points.
	 *
	 * @return the points
	 */
	//Throws a Null Pointer Exception if this square has no letter
	public int getPoints(){
		return this.letter.getPoints();
	}
	
	//Returns true if this square has a letter
	/**
	 * Checks for letter.
	 *
	 * @return true, if successful
	 */
	//Otherwise, returns false
	public boolean hasLetter(){
		return !(this.letter == null);
	}
	
	//Replaces the letter held by this square with the given letter.
	//	Returns the letter previously held by this square (Returns
	/**
	 * Change letter.
	 *
	 * @param toChange the to change
	 * @return the player letter
	 */
	//	null if this square held no letter)
	public PlayerLetter changeLetter (PlayerLetter toChange){
		PlayerLetter tempLetter = this.letter;
		this.letter = toChange;
		return tempLetter;
	}
	
	//Removes the letter currently held by this square
	//	Returns true if successful, returns false if this 
	/**
	 * Removes the letter.
	 *
	 * @return the player letter
	 */
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
	/**
	 * Checks if is neighbor.
	 *
	 * @param toCheck the to check
	 * @return true, if is neighbor
	 */
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
	
	/**
	 * Equals.
	 *
	 * @param toMatch the to match
	 * @return true, if successful
	 */
	public boolean equals(PlayerSquare toMatch){
		boolean matchingLetter = this.toString() == toMatch.toString();
		boolean matchingRow = this.row == toMatch.getRow();
		boolean matchingCol = this.col == toMatch.getCol();
		boolean matchingActivity = this.active == toMatch.getActive();
		
		return matchingLetter && matchingRow && matchingCol && matchingActivity;
	}
}
