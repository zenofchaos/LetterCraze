package playerFiles;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPlayerLevel {
	PlayerLightningLevel ll;

	@Before
	public void setUp() throws Exception {
		
		int[] starThresholds = new int[3];
		starThresholds[0] = 2;
		starThresholds[1] = 4;
		starThresholds[2] = 6;
		
		int bestScore = 3;
		
		int bestStars = 1;
		
		boolean isLocked = false;
		
		String title = "Lightning1";
		
		int maxTime = 35;
		
		ll = new PlayerLightningLevel(starThresholds, bestScore, bestStars, isLocked, title, maxTime);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLightning1() {
		
		PlayerSquare[][] boardSquares = new PlayerSquare[6][6];
		for(int i = 0; i < boardSquares.length; i++){
			for(int j = 0; j < boardSquares.length; j++){
				boardSquares[i][j] = new PlayerSquare(i, j);
			}
		}
		
		PlayerBoard board = new PlayerBoard(boardSquares);
		
		ll.initBoard();
		
		assertEquals(35, ll.getMaxTime());
		assertTrue(ll.setMaxTime(50));
		assertEquals(50, ll.getMaxTime());
		
		assertEquals("Lightning1", ll.getTitle());
		assertTrue(ll.setTitle("Level1"));
		assertEquals("Level1", ll.getTitle());
		
		ArrayList<PlayerSquare> word1Squares = new ArrayList<PlayerSquare>();
		ArrayList<PlayerSquare> word2Squares = new ArrayList<PlayerSquare>();
		PlayerSquare square1 = new PlayerSquare(0, 0);
		PlayerLetter letter1 = new PlayerLetter("C");
		square1.setLetter(letter1);
		PlayerSquare square2 = new PlayerSquare(0, 1);
		PlayerLetter letter2 = new PlayerLetter("A");
		square2.setLetter(letter2);
		PlayerSquare square3 = new PlayerSquare(0, 2);
		PlayerLetter letter3 = new PlayerLetter("T");
		square3.setLetter(letter3);
		word1Squares.add(square1);
		word1Squares.add(square2);
		word1Squares.add(square3);
		PlayerWord word = new PlayerWord(word1Squares);
		word2Squares.add(square1);
		word2Squares.add(square2);
		word2Squares.add(square3);
		PlayerWord word2 = new PlayerWord(word2Squares);
		
		board.addWord(word);
		
		assertTrue(ll.isValidWord(word2));
		assertEquals(1, ll.wordScore(word2));
		
		assertTrue(ll.setSelectedWord(word2));
		ll.submitSelectedWord();
		assertEquals(1, ll.pointScore);
		
		ll.reset();
		
		assertEquals(0, ll.pointScore);
	}

}
