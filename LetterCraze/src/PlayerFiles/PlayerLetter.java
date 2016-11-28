package PlayerFiles;

public class PlayerLetter {
	
	String letter;
	int points;
	
	//Constructor for a PlayerLetter object. Generates a random letter
	//	based on the provided letter frequency chart. Generates points
	//	for the letter based off of the same table.
	PlayerLetter(){
		letter = getRandomLetter();
		points = getPointVal(letter);
	}
	
	//Constructor for a PlayerLetter object using the given string. 
	//	Verifies the given string is a valid letter, and then generates
	//	a point value for the letter based off of the provided chart.
	PlayerLetter(String input){
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
		return "TODO";
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
