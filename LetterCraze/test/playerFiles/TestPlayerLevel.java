package playerFiles;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPlayerLevel {
	PlayerLightningLevel ll;
	PlayerThemeLevel tl;

	@Before
	public void setUp() throws Exception {
		
		int[] lStarThresholds = new int[3];
		lStarThresholds[0] = 2;
		lStarThresholds[1] = 4;
		lStarThresholds[2] = 6;
		
		int[] tStarThresholds = new int[3];
		tStarThresholds[0] = 1;
		tStarThresholds[1] = 2;
		tStarThresholds[2] = 3;
		
		int bestScore = 3;
		
		int bestStars = 1;
		
		boolean isLocked = false;
		
		String title = "Lightning1";
		String theme = "Theme";
		String description = "This is a description";
		
		LinkedList<String> words = new LinkedList<String>();
		
		String themeWord1 = "apple";
		String themeWord2 = "banana";
		String themeWord3 = "pear";
		
		words.add(themeWord1);
		words.add(themeWord2);
		words.add(themeWord3);
		
		int maxTime = 35;
		
		ll = new PlayerLightningLevel(lStarThresholds, bestScore, bestStars, isLocked, title, maxTime);
		
		PlayerSquare[][] themeSquares = new PlayerSquare[6][6];
		for(int i = 0; i < themeSquares.length; i++){
			for(int j = 0; j < themeSquares.length; j++){
				themeSquares[i][j] = new PlayerSquare(i, j);
			}
		}
		
		PlayerBoard themeBoard = new PlayerBoard(themeSquares);
		
		ArrayList<PlayerSquare> appleStartSquares = new ArrayList<PlayerSquare>();
		PlayerSquare apple1 = new PlayerSquare(0, 0);
		PlayerLetter appleLetter1 = new PlayerLetter("A");
		apple1.setLetter(appleLetter1);
		PlayerSquare apple2 = new PlayerSquare(0, 1);
		PlayerLetter appleLetter2 = new PlayerLetter("P");
		apple1.setLetter(appleLetter2);
		PlayerSquare apple3 = new PlayerSquare(0, 2);
		PlayerLetter appleLetter3 = new PlayerLetter("P");
		apple1.setLetter(appleLetter3);
		PlayerSquare apple4 = new PlayerSquare(0, 3);
		PlayerLetter appleLetter4 = new PlayerLetter("L");
		apple1.setLetter(appleLetter4);
		PlayerSquare apple5 = new PlayerSquare(0, 4);
		PlayerLetter appleLetter5 = new PlayerLetter("E");
		apple1.setLetter(appleLetter5);
		
		
		
		
		tl = new PlayerThemeLevel(tStarThresholds, bestScore, bestStars, isLocked, theme, description, words, null);
		
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
		int[] thresh = new int[3];
		thresh[0] = 2;
		thresh[1] = 4;
		thresh[2] = 6;
		assertEquals(thresh[1], ll.getStarThresholds()[1]);
		
		assertFalse(ll.getIsLocked());
		
		assertEquals(1, ll.getBestStars());
		
		assertEquals(0, ll.getStarCount());
		
		assertEquals(35, ll.getMaxTime());
		assertTrue(ll.setMaxTime(50));
		assertEquals(50, ll.getMaxTime());
		
		assertEquals("Lightning1", ll.getTitle());
		assertTrue(ll.setTitle("Level1"));
		assertEquals("Level1", ll.getTitle());
		
		ArrayList<PlayerSquare> word1Squares = new ArrayList<PlayerSquare>();
		ArrayList<PlayerSquare> word2Squares = new ArrayList<PlayerSquare>();
		ArrayList<PlayerSquare> word3Squares = new ArrayList<PlayerSquare>();
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
		word3Squares.add(square1);
		word3Squares.add(square2);
		word3Squares.add(square3);
		PlayerWord word3 = new PlayerWord(word3Squares);
		ArrayList<PlayerWord> entered = new ArrayList<PlayerWord>();
		entered.add(word3);
		
		assertTrue(ll.setPointScore(1));
		
		board.addWord(word);
		
		assertTrue(ll.isValidWord(word2));
		assertEquals(1, ll.wordScore(word2));
		
		assertTrue(ll.setSelectedWord(word2));
		assertEquals(word2, ll.getSelectedWord());
		assertTrue(ll.setSelectedWord(word2));
		ll.submitSelectedWord();
		assertEquals(2, ll.pointScore);
		assertEquals(1, ll.getStarCount());
		assertEquals(entered.get(0).word, ll.getWordsEntered().get(0).word);
		
		ll.reset();
		
		assertEquals(0, ll.pointScore);
		assertEquals(0, ll.getStarCount());
		
		ll.setIsLocked(true);
		assertTrue(ll.getIsLocked());
	}
	
	@Test
	public void testThemeLevel(){
		
	}
}
