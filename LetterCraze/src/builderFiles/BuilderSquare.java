package builderFiles;

/**
 * The Class BuilderSquare, a square in the builder board.
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
	

	/**
	 * Instantiates a new builder square.
	 *
	 * @param row the row
	 * @param col the col
	 */
	public BuilderSquare(int row, int col){
		this.row = row;
		this.col = col;
		this.active = false;
	}
	
	/**
	 * Gets the letter in the square.
	 *
	 * @return the letter
	 */
	public BuilderLetter getLetter(){
		return this.letter;
	}
	
	/**
	 * Gets the row.
	 *
	 * @return the row
	 */
	public int getRow(){
		return this.row;
	}
	
	/**
	 * Gets the col.
	 *
	 * @return the col
	 */
	public int getCol(){
		return this.col;
	}
	
	/**
	 * Gets the active.
	 *
	 * @return the active
	 */
	public boolean getActive(){
		return this.active;
	}

	/**
	 * Sets the letter.
	 *
	 * @param toSet the to set
	 * @return true, if successful
	 */
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
	 * Checks for a letter in the square.
	 *
	 * @return true, if successful
	 */
	public boolean hasLetter(){
		return !(this.letter == null);
	}
	

	/**
	 * Change letter replaces the letter in the square with the given letter.
	 *
	 * @param toChange the to change
	 * @return the builder letter previously in the square
	 */
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
	
	/**
	 * Removes the letter currently in the square.
	 *
	 * @return true, if successful
	 */
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

