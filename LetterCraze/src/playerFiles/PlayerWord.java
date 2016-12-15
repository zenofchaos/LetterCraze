package playerFiles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerWord.
 */
public class PlayerWord {

	/** The point val. */
	int pointVal;
	
	/** The squares. */
	List<PlayerSquare> squares;
	
	/** The word. */
	String word;
	
	/**
	 * Instantiates a new player word.
	 */
	//Constructs a word with this given square
	public PlayerWord() {
		this.squares = new ArrayList<PlayerSquare>();
		
		this.updateWord();
	}
	
	/**
	 * Instantiates a new player word.
	 *
	 * @param theSquare the the square
	 */
	//Constructs a word with this given square
	public PlayerWord(PlayerSquare theSquare){
		this.squares = new ArrayList<PlayerSquare>();
		
		//generate copy of the given square
		PlayerSquare toAdd = new PlayerSquare(theSquare.getRow(), theSquare.getCol());
		toAdd.setLetter(theSquare.getLetter());
		toAdd.setActive(theSquare.getActive());
		//add the copied square to this word
		this.squares.add(toAdd);
		
		this.updateWord();
	}
	
	/**
	 * Instantiates a new player word.
	 *
	 * @param theSquares the the squares
	 */
	//Constructs a word with the given list of squares
	public PlayerWord(List<PlayerSquare> theSquares){
		this.squares = theSquares;
		
		this.updateWord();
	}
	
	/**
	 * Gets the point val.
	 *
	 * @return the point val
	 */
	//The get method for pointVal
	public int getPointVal(){
		return this.pointVal;
	}
	
	/**
	 * Gets the squares.
	 *
	 * @return the squares
	 */
	//The get method for squares
	public List<PlayerSquare> getSquares(){
		return this.squares;
	}
	
	/**
	 * Gets the word.
	 *
	 * @return the word
	 */
	//The get method for word
	public String getWord(){
		return this.word;
	}
	
	/**
	 * Sets the point val.
	 *
	 * @param toSet the to set
	 * @return true, if successful
	 */
	//The set method for pointVal
	public boolean setPointVal(int toSet){
		this.pointVal = toSet;
		return true;
	}
	
	/**
	 * Sets the squares.
	 *
	 * @param toSet the to set
	 * @return true, if successful
	 */
	//The set method for squares
	public boolean setSquares(List<PlayerSquare> toSet){
		this.squares = toSet;
		return true;
	}
	
	/**
	 * Sets the word.
	 *
	 * @param toSet the to set
	 * @return true, if successful
	 */
	//The set method for word
	public boolean setWord(String toSet){
		this.word = toSet;
		return true;
	}
	
	/**
	 * Update word.
	 *
	 * @return true, if successful
	 */
	boolean updateWord(){
		this.word = toString(this.squares);
		this.pointVal = calcPoints(this.squares);
		return true;
	}
	
	/**
	 * To string.
	 *
	 * @param squares the squares
	 * @return the string
	 */
	//Returns the string contained within the given squares
	String toString(List<PlayerSquare> squares){
		String theString = "";
		
		Iterator<PlayerSquare> squaresIterator = squares.iterator();
		while (squaresIterator.hasNext()){
			PlayerSquare current = squaresIterator.next();
			theString += current.toString();
		}
		
		return theString;
	}
	
	//Returns the point value of the word defined by the given list of squares
	//The equation used to calculate points is:
	//	wordLength < 3  --> points = 0
	/**
	 * Calc points.
	 *
	 * @param squares the squares
	 * @return the int
	 */
	//	wordLength >= 3 --> points = sum(letterScores) * (wordLength - 2)
	int calcPoints(List<PlayerSquare> squares){
		int score = 0;
		int wordLength = 0;
		
		Iterator<PlayerSquare> squaresIterator = squares.iterator();
		while (squaresIterator.hasNext()){
			PlayerSquare current = squaresIterator.next();
			score += current.getPoints();
			wordLength ++;
		}
		
		if (wordLength < 3){
			return 0;
		}
		else{
			return (score * (wordLength - 2));
		}
	}
	
	/**
	 * Checks if is valid word.
	 *
	 * @return true, if is valid word
	 */
	//Returns true if this word is a valid word
	public boolean isValidWord(){
		return (this.word.length() >= 3) && (WordTable.isWord(this.word.toLowerCase()));
	}
	
	//Adds the given square to the end of this word
	/**
	 * Adds the square.
	 *
	 * @param square the square
	 * @return true, if successful
	 */
	//Returns false if the square has no letter
	public boolean addSquare(PlayerSquare square) {
		//make a copy of the given square
		PlayerSquare toAdd = new PlayerSquare(square.getRow(), square.getCol());
		toAdd.setLetter(square.getLetter());
		toAdd.setActive(square.getActive());
		
		if (toAdd.hasLetter()){
			this.squares.add(toAdd);
			return this.updateWord();
		}
		else{
			return false;
		}
	}
	
	//Adds the given square to this word at the given index
	/**
	 * Adds the square.
	 *
	 * @param square the square
	 * @param index the index
	 * @return true, if successful
	 */
	//Returns false if the square has no letter
	public boolean addSquare(PlayerSquare square, int index) {
		//make a copy of the given square
		PlayerSquare toAdd = new PlayerSquare(square.getRow(), square.getCol());
		toAdd.setLetter(square.getLetter());
		toAdd.setActive(square.getActive());
		
		if (toAdd.hasLetter()){
			this.squares.add(index, toAdd);
			return this.updateWord();
		}
		else{
			return false;
		}
	}
	
	//Removes the last square from the end of this word
	/**
	 * Removes the square.
	 *
	 * @return true, if successful
	 */
	//Returns false if there are no squares to remove
	public boolean removeSquare() {
		if (squares.isEmpty()) {
			return false;
		} else {
			squares.remove(squares.size() - 1);
			return updateWord();
		}
	}
	
	/**
	 * Recent square.
	 *
	 * @param n the n
	 * @return the nth-most recently added square in this word, or null if out of bounds
	 */
	public PlayerSquare recentSquare(int n) {
		if (squares.size() < n) {
			return null;
		} else {
			return squares.get(squares.size() - n);
		}
	}
	
	/**
	 * Contains.
	 *
	 * @param toCheck the to check
	 * @return true, if successful
	 */
	public boolean contains(PlayerSquare toCheck){
		boolean squareFound = false;
		int index = 0;
		PlayerSquare currentSquare;
		while (!squareFound && (index < this.squares.size())){
			currentSquare = this.squares.get(index);
			squareFound = currentSquare.equals(toCheck);
			index++;
		}
		return squareFound;
	}
}
