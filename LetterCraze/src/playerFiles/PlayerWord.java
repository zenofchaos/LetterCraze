package playerFiles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerWord {

	int pointVal;
	List<PlayerSquare> squares;
	String word;
	
	//Constructs a word with this given square
	public PlayerWord() {
		this.squares = new ArrayList<PlayerSquare>();
		
		this.updateWord();
	}
	
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
	
	//Constructs a word with the given list of squares
	public PlayerWord(List<PlayerSquare> theSquares){
		this.squares = theSquares;
		
		this.updateWord();
	}
	
	//The get method for pointVal
	public int getPointVal(){
		return this.pointVal;
	}
	//The get method for squares
	public List<PlayerSquare> getSquares(){
		return this.squares;
	}
	//The get method for word
	public String getWord(){
		return this.word;
	}
	//The set method for pointVal
	public boolean setPointVal(int toSet){
		this.pointVal = toSet;
		return true;
	}
	//The set method for squares
	public boolean setSquares(List<PlayerSquare> toSet){
		this.squares = toSet;
		return true;
	}
	//The set method for word
	public boolean setWord(String toSet){
		this.word = toSet;
		return true;
	}
	
	boolean updateWord(){
		this.word = toString(this.squares);
		this.pointVal = calcPoints(this.squares);
		return true;
	}
	
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
	
	//Returns true if this word is a valid word
	public boolean isValidWord(){
		return (this.word.length() >= 3) && (WordTable.isWord(this.word.toLowerCase()));
	}
	
	//Adds the given square to the end of this word
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
	 * @return the nth-most recently added square in this word, or null if out of bounds
	 */
	public PlayerSquare recentSquare(int n) {
		if (squares.size() < n) {
			return null;
		} else {
			return squares.get(squares.size() - n);
		}
	}
	
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
