package playerFiles;

import java.util.Hashtable;
import java.util.Random;

/**
 * The Class PlayerLetter, a letter for the player.
 */
public class PlayerLetter {
	
	/** The letter. */
	String letter;
	
	/** The points. */
	int points;
	
	/**
	 * Instantiates a new player letter.
	 */
	public PlayerLetter(){
		letter = getRandomLetter();
		
		Hashtable<String,Integer> pointTable = this.generatePointsTable();
		points = getPointVal(this.formatCapitals(this.letter),pointTable);
	}
	
	/**
	 * Instantiates a new player letter using the given string if valid
	 * and sets the appropriate point for it.
	 *
	 * @param input the input
	 */
	public PlayerLetter(String input){
		if (isValid(input)){
			letter = formatCapitals(input);
			
			Hashtable<String,Integer> pointTable = this.generatePointsTable();
			points = getPointVal(this.formatCapitals(this.letter),pointTable);
		}
		else{
			System.err.println ("Invalid input to letter");
		}
	}
	
	/**
	 * Gets the letter.
	 *
	 * @return the letter
	 */
	//Get method for letter
	public String getLetter(){
		return this.letter;
	}
	
	/**
	 * Gets the points.
	 *
	 * @return the points
	 */
	//Get method for points
	public int getPoints(){
		return this.points;
	}
	
	/**
	 * Sets the letter.
	 *
	 * @param toSet the to set
	 * @return true, if successful
	 */
	//Set method for letter
	public boolean setLetter(String toSet){
		this.letter = toSet;
		return true;
	}
	
	/**
	 * Sets the points.
	 *
	 * @param toSet the to set
	 * @return true, if successful
	 */
	//Set method for points
	public boolean setPoints(int toSet){
		this.points = toSet;
		return true;
	}
	
	//Returns the point value of the given letter (or Qu)
	/**
	 * Gets the point val.
	 *
	 * @param letter the letter
	 * @param pointTable the point table
	 * @return the point val
	 */
	// Returns -1 if the given letter is invalid.
	int getPointVal(String letter, Hashtable<String,Integer> pointTable) {
		if (isValid(letter)){
			return pointTable.get(letter);
		}
		else{
			return -1;
		}
	}

	/**
	 * Generate points table.
	 *
	 * @return the hashtable
	 */
	Hashtable<String,Integer> generatePointsTable(){
		Hashtable<String,Integer> pointTable = new Hashtable<String,Integer>();
		
		pointTable.put("E", 1);
		pointTable.put("T", 1);
		pointTable.put("A", 2);
		pointTable.put("O", 2);
		pointTable.put("I", 2);
		pointTable.put("N", 2);
		pointTable.put("S", 2);
		pointTable.put("H", 2);
		pointTable.put("R", 2);
		pointTable.put("D", 3);
		pointTable.put("L", 3);
		pointTable.put("C", 3);
		pointTable.put("U", 3);
		pointTable.put("M", 3);
		pointTable.put("W", 3);
		pointTable.put("F", 4);
		pointTable.put("G", 4);
		pointTable.put("Y", 4);
		pointTable.put("P", 4);
		pointTable.put("B", 4);
		pointTable.put("V", 5);
		pointTable.put("K", 5);
		pointTable.put("J", 7);
		pointTable.put("X", 7);
		pointTable.put("QU", 11);
		pointTable.put("Z", 8);

		return pointTable;
	}
	
	/**
	 * Gets the random letter.
	 *
	 * @return the random letter
	 */
	//Returns a random letter based on the provided letter frequency table.
	String getRandomLetter(){
		
		Random rand = new Random();
		int val = rand.nextInt(10000); //generates a random value 0-9999
		
		if (val < 0){
			return "Error: Random Value out of bounds (negative)";
		}
		else if (val < 1270){
			return "E";
		}
		else if (val < 2176){
			return "T";
		}
		else if (val < 2993){
			return "A";
		}
		else if (val < 3743){
			return "O";
		}
		else if (val < 4440){
			return "I";
		}
		else if (val < 5115){
			return "N";
		}
		else if (val < 5747){
			return "S";
		}
		else if (val < 6357){
			return "H";
		}
		else if (val < 6956){
			return "R";
		}
		else if (val < 7381){
			return "D";
		}
		else if (val < 7783){
			return "L";
		}
		else if (val < 8062){
			return "C";
		}
		else if (val < 8337){
			return "U";
		}
		else if (val < 8578){
			return "M";
		}
		else if (val < 8814){
			return "W";
		}
		else if (val < 9037){
			return "F";
		}
		else if (val < 9238){
			return "G";
		}
		else if (val < 9436){
			return "Y";
		}
		else if (val < 9629){
			return "P";
		}
		else if (val < 9778){
			return "B";
		}
		else if (val < 9876){
			return "V";
		}
		else if (val < 9953){
			return "K";
		}
		else if (val < 9968){
			return "J";
		}
		else if (val < 9983){
			return "X";
		}
		else if (val < 9993){
			return "QU";
		}
		else if (val < 10000){
			return "Z";
		}
		else{
			return "Error: Random Value out of bounds (>10,000)";
		}
	}
	

	/**
	 * Checks if is valid Verifies whether the given string is a valid LetterCraze letter
	 * note: capitalizations do not effect this.
	 *
	 * @param toCheck the to check
	 * @return true, if is valid
	 */
	boolean isValid(String toCheck){
		int length = toCheck.length();
		
		switch (length){
			case 1: //toCheck is 1 character long, so must be within A-Z or a-z
				if ((toCheck.charAt(0) >= 'A') && (toCheck.charAt(0) <= 'Z')){
					return !(toCheck.charAt(0) == 'Q');
				}
				else if ((toCheck.charAt(0) >= 'a') && (toCheck.charAt(0) <= 'z')){
					return !(toCheck.charAt(0) == 'q');
				}
				else{
					return false;
				}
			
			case 2: //toCheck is 2 characters long, so needs to be "Qu"
				
				boolean firstIsQ = ((toCheck.charAt(0) == 'Q') || (toCheck.charAt(0) == 'q'));
				boolean secondIsU = ((toCheck.charAt(1) == 'U') || (toCheck.charAt(1) == 'u'));
				
				return (firstIsQ && secondIsU);
			
			default: //Improper input, so return false
				return false;
		}
	}
	
	/**
	 * Format capitals.
	 *
	 * @param toFormat the to format
	 * @return the string given but as all capitals
	 */
	String formatCapitals(String toFormat){
		if (isValid(toFormat)){
			int length = toFormat.length();
			
			switch (length){
				case 1:
					return toFormat.toUpperCase();
				case 2:
					return "QU";
				default:
					return null;
			}
		}
		else{
			return null;
		}
	}
}
