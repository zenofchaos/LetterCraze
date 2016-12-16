package builderFiles;

// TODO: Auto-generated Javadoc
/**
 * The Class BuilderSquare.
 */
public class BuilderSquare {

	/** The letter. */
	BuilderLetter letter;
	
	/** The row. */
	int row;
	
	/** The col. */
	int col;
	
	/** The active. */
	boolean active;
	
	//The constructor for a BuilderSquare
	/**
	 * Instantiates a new builder square.
	 *
	 * @param row the row
	 * @param col the col
	 */
	//	Takes in the square's row and column.
	public BuilderSquare(int row, int col){
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
	public BuilderLetter getLetter(){
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
	public boolean setLetter(BuilderLetter toSet){
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
	public boolean setCol (int toSet){
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
	
	/**
	 * Checks for letter.
	 *
	 * @return true, if successful
	 */
	public boolean hasLetter(){
		return !(this.letter == null);
	}
	
	//Replaces the letter held by this square with the given letter.
	//	Returns the letter previously held by this square (Returns
	/**
	 * Change letter.
	 *
	 * @param toChange the to change
	 * @return the builder letter
	 */
	//	null if this square held no letter)
	public BuilderLetter changeLetter (BuilderLetter toChange){
		if (this.letter == null){
			this.letter = toChange;
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
	/**
	 * Removes the letter.
	 *
	 * @return true, if successful
	 */
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

