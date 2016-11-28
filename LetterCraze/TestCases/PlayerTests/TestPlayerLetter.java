package PlayerTests;

import static org.junit.Assert.*;

import org.junit.Test;

import PlayerFiles.PlayerLetter;
import junit.framework.TestCase;

public class TestPlayerLetter extends TestCase{

	@Override
	public void setUp(){
		
	}
	
	@Override
	public void tearDown(){
		
	}
	
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
		
		assertEquals("Qu",letter3.getLetter());
		assertEquals(11,letter3.getPoints());
		
		String toSet4 = "QU";
		PlayerLetter letter4 = new PlayerLetter(toSet4);
		
		assertEquals("Qu",letter4.getLetter());
		assertEquals(11,letter4.getPoints());
		
		String toSet5 = "qu";
		PlayerLetter letter5 = new PlayerLetter(toSet5);
		
		assertEquals("Qu",letter5.getLetter());
		assertEquals(11,letter5.getPoints());
	}
	
	public void testWithInvalidInput(){
		String toSet = " ";
		PlayerLetter letter = new PlayerLetter(toSet);
		assertEquals(null,letter.getLetter());
		assertEquals(0,letter.getPoints());
	}
}
