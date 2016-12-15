package playerFiles;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPlayerBoard {
	PlayerSquare[][] squares = new PlayerSquare[6][6];
	PlayerBoard board;

	@Before
	public void setUp() throws Exception {
		for(int i = 0; i<= 5; i++){
			for(int j = 0; j <= 5; j++){
				squares[i][j] = new PlayerSquare(i, j);
			}
		}
		board = new PlayerBoard(squares);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRise() {
		try{
			assertNull(board.getSquare(0, 0));
		}
		catch(Exception e){
			assertTrue(true);
		}
		assertTrue(board.rise());
		assertNotNull(board.getSquare(0, 0));
		
	}
	
	@Test
	public void testReplace(){
		try{
			assertNull(board.getSquare(0, 0));
		}
		catch(Exception e){
			assertTrue(true);
		}
		assertTrue(board.replace());
		assertNotNull(board.getSquare(0, 0));
	}
	
	@Test
	public void testAddRemoveWord(){
		ArrayList<PlayerSquare> squares = new ArrayList<PlayerSquare>();
		PlayerSquare square1 = new PlayerSquare(0, 0);
		PlayerLetter letter1 = new PlayerLetter("C");
		square1.setLetter(letter1);
		PlayerSquare square2 = new PlayerSquare(0, 1);
		PlayerLetter letter2 = new PlayerLetter("A");
		square2.setLetter(letter2);
		PlayerSquare square3 = new PlayerSquare(0, 2);
		PlayerLetter letter3 = new PlayerLetter("T");
		square3.setLetter(letter3);
		squares.add(square1);
		squares.add(square2);
		squares.add(square3);
		PlayerWord word = new PlayerWord(squares);
		ArrayList<PlayerSquare> squares2 = new ArrayList<PlayerSquare>();
		squares2.add(square1);
		squares2.add(square2);
		squares2.add(square3);
		PlayerWord cat = new PlayerWord(squares2);
		
		board.addWord(word);
		assertEquals("C", board.getSquare(0, 0).getLetter().letter);
		assertEquals("A", board.getSquare(0, 1).getLetter().letter);
		assertEquals("T", board.getSquare(0, 2).getLetter().letter);
		
		
		board.removeWord(cat);
		
		try{
			assertNull(board.getSquare(0, 0).getLetter().letter);
		}
		catch(Exception e){
			assertTrue(true);
		}
		
		try{
			assertNull(board.getSquare(0, 1).getLetter().letter);
		}
		catch(Exception e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testSetSquare(){
		PlayerSquare[][] toSet = new PlayerSquare[6][6];
		
		for(int i = 0; i< toSet.length; i++){
			for(int j = 0; j < toSet.length; j++){
				toSet[i][j] = new PlayerSquare(i, j);
			}
		}
		
		PlayerSquare[][] failSet = new PlayerSquare[5][5];
		for(int i = 0; i< failSet.length; i++){
			for(int j = 0; j < failSet.length; j++){
				failSet[i][j] = new PlayerSquare(i, j);
			}
		}
		
		assertTrue(board.setSquareArray(toSet));
		assertFalse(board.setSquareArray(failSet));
		
	}
}
