package playerFiles;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;
import playerFiles.PlayerLetter;

public class TestPlayerLetter extends TestCase{
	
	//Test the constructor which takes an input string
	//	using valid input
	public void testWithValidInput(){
		String toSet = "A";
		PlayerLetter letter = new PlayerLetter(toSet);
		
		assertEquals("A",letter.getLetter());
		assertEquals(2,letter.getPoints());
		
		String toSet2 = "b";
		PlayerLetter letter2 = new PlayerLetter(toSet2);
		
		assertEquals("B",letter2.getLetter());
		assertEquals(4,letter2.getPoints());
		
		String toSet3 = "Qu";
		PlayerLetter letter3 = new PlayerLetter(toSet3);
		
		assertEquals("QU",letter3.getLetter());
		assertEquals(11,letter3.getPoints());
		
		String toSet4 = "QU";
		PlayerLetter letter4 = new PlayerLetter(toSet4);
		
		assertEquals("QU",letter4.getLetter());
		assertEquals(11,letter4.getPoints());
		
		String toSet5 = "qu";
		PlayerLetter letter5 = new PlayerLetter(toSet5);
		
		assertEquals("QU",letter5.getLetter());
		assertEquals(11,letter5.getPoints());
	}
	
	public void testWithInvalidInput(){
		String toSet = "Q";
		PlayerLetter letter = new PlayerLetter(toSet);
		assertEquals(null,letter.getLetter());
		assertEquals(0,letter.getPoints());
		
		String toSet2 = "q";
		PlayerLetter letter2 = new PlayerLetter(toSet2);
		assertEquals(null,letter2.getLetter());
		assertEquals(0,letter2.getPoints());
		
		String toSet3 = "]";
		PlayerLetter letter3 = new PlayerLetter(toSet3);
		assertEquals(null,letter3.getLetter());
		assertEquals(0,letter3.getPoints());
	}
	
	public void testWithoutInput(){
		for (int i = 0; i < 10000; i++){
			PlayerLetter letter = new PlayerLetter();
			assertTrue(letter.isValid(letter.getLetter()));
		}
	}
}
