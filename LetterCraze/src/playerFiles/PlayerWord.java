package playerFiles;

import java.util.Iterator;
import java.util.List;

public class PlayerWord {

	int pointVal;
	List<PlayerSquare> squares;
	String word;
	
	public PlayerWord(List<PlayerSquare> theSquares){
		this.squares = theSquares;
		this.word = toString(this.squares);
		this.pointVal = calcPoints(this.squares);
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
	public boolean isValid(){
		if (this.word.length() < 3){
			return false;
		}
		else{
			return WordTable.isWord(this.word);
		}
	}
	
}
