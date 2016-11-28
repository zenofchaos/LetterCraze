package builderFiles;

import java.util.Random;

public class BuilderLetter {

	String letter;
	int points;

	//Constructor for a PlayerLetter object. Generates a random letter
	//	based on the provided letter frequency chart. Generates points
	//	for the letter based off of the same table.
	BuilderLetter(){
		letter = getRandomLetter();
		points = getPointVal(letter);
	}
	
	//Get method for letter
	String getLetter(){
		return this.letter;
	}
	
	//Get method for points
	int getPoints(){
		return this.points;
	}
	
	//Set method for letter
	boolean setLetter(String toSet){
		this.letter = toSet;
		return true;
	}
	
	//Set method for points
	boolean setPoints(int toSet){
		this.points = toSet;
		return true;
	}

	//Constructor for a PlayerLetter object using the given string. 
	//	Verifies the given string is a valid letter, and then generates
	//	a point value for the letter based off of the provided chart.
	BuilderLetter(String input){
		if (isValid(input)){
			letter = formatCapitals(input);
			points = getPointVal(letter);
		}
	}

	//Returns the point value of the given letter (or Qu)
	// Returns -1 if the given letter is invalid.
	int getPointVal(String letter) {
		if (isValid(letter)){
			switch(letter.charAt(0)){
			case 'E':
				return 1;
			case 'T':
				return 1;
			case 'A':
				return 2;
			case 'O':
				return 2;
			case 'I':
				return 2;
			case 'N':
				return 2;
			case 'S':
				return 2;
			case 'H':
				return 2;
			case 'R':
				return 2;
			case 'D':
				return 3;
			case 'L':
				return 3;
			case 'C':
				return 3;
			case 'U':
				return 3;
			case 'M':
				return 3;
			case 'W':
				return 3;
			case 'F':
				return 4;
			case 'G':
				return 4;
			case 'Y':
				return 4;
			case 'P':
				return 4;
			case 'B':
				return 4;
			case 'V':
				return 5;
			case 'K':
				return 5;
			case 'J':
				return 7;
			case 'X':
				return 7;
			case 'Q':
				return 11;
			case 'Z':
				return 8;
			default:
				return -1;
			}
		}
		else{
			return -1;
		}
	}

	//Returns a random letter based on the provided letter frequency table.
	String getRandomLetter(){

		Random rand = new Random();
		int val = rand.nextInt(10001); //generates a random value 1-9999

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
			return "Qu";
		}
		else if (val < 10000){
			return "Z";
		}
		else{
			return "Error: Random Value out of bounds (>10,000)";
		}
	}

	//Verifies whether the given string is a valid LetterCraze letter
	//	Valid letters are A-Z and Qu. Capitalization of the characters
	//	does NOT affect validity.
	boolean isValid(String toCheck){
		int length = toCheck.length();

		switch (length){
		case 1: //toCheck is 1 character long, so must be within A-Z or a-z
			if ((toCheck.charAt(0) >= 'A') && (toCheck.charAt(0) <= 'Z')){
				return true;
			}
			else if ((toCheck.charAt(0) >= 'a') && (toCheck.charAt(0) <= 'z')){
				return true;
			}
			else{
				return false;
			}

		case 2: //toCheck is 2 characters long, so needs to be "Qu"

			boolean firstIsQ = ((toCheck.charAt(0) == 'Q') || (toCheck.charAt(0) == 'q'));
			boolean secondIsU = ((toCheck.charAt(0) == 'U') || (toCheck.charAt(0) == 'u'));

			return (firstIsQ && secondIsU);

		default: //Improper input, so return false
			return false;
		}
	}

	//Returns the given string formatted as follows:
	//	-	The first character is upper case
	//	-	The second character (if any) is lower case.
	//	Note: Operates only on valid strings. Returns null
	//			if string is invalid.
	String formatCapitals(String toFormat){
		if (isValid(toFormat)){
			int length = toFormat.length();

			switch (length){
			case 1:
				return toFormat.toUpperCase();
			case 2:
				return "Qu";
			default:
				return null;
			}
		}
		else{
			return null;
		}
	}
}

