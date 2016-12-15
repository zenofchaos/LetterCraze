package playerGUI;

import java.util.LinkedList;

import junit.framework.TestCase;
import playerFiles.PlayerPuzzleLevel;
import playerFiles.PlayerSquare;
import playerFiles.PlayerBoard;
import playerFiles.PlayerLetter;
import playerFiles.PlayerLightningLevel;
import playerFiles.PlayerThemeLevel;

public class TestPlayerLevelGUI extends TestCase {
	
	public void testPuzzle() {
		// set up puzzle level with predetermined board
		PlayerSquare[][] s = new PlayerSquare[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				s[i][j] = new PlayerSquare(i, j);
				s[i][j].setActive(i < 5); // bottom row is inactive
			}
		}
		s[0][0].setLetter(new PlayerLetter("A")); s[0][1].setLetter(new PlayerLetter("G")); s[0][2].setLetter(new PlayerLetter("M")); s[0][3].setLetter(new PlayerLetter("S")); s[0][4].setLetter(new PlayerLetter("Y")); s[0][5].setLetter(new PlayerLetter("E"));
		s[1][0].setLetter(new PlayerLetter("B")); s[1][1].setLetter(new PlayerLetter("H")); s[1][2].setLetter(new PlayerLetter("N")); s[1][3].setLetter(new PlayerLetter("T")); s[1][4].setLetter(new PlayerLetter("Z")); s[1][5].setLetter(new PlayerLetter("F"));
		s[2][0].setLetter(new PlayerLetter("C")); s[2][1].setLetter(new PlayerLetter("I")); s[2][2].setLetter(new PlayerLetter("O")); s[2][3].setLetter(new PlayerLetter("U")); s[2][4].setLetter(new PlayerLetter("A")); s[2][5].setLetter(new PlayerLetter("G"));
		s[3][0].setLetter(new PlayerLetter("D")); s[3][1].setLetter(new PlayerLetter("J")); s[3][2].setLetter(new PlayerLetter("P")); s[3][3].setLetter(new PlayerLetter("V")); s[3][4].setLetter(new PlayerLetter("B")); s[3][5].setLetter(new PlayerLetter("H"));
		s[4][0].setLetter(new PlayerLetter("E")); s[4][1].setLetter(new PlayerLetter("K")); s[4][2].setLetter(new PlayerLetter("Q")); s[4][3].setLetter(new PlayerLetter("W")); s[4][4].setLetter(new PlayerLetter("C")); s[4][5].setLetter(new PlayerLetter("I"));
		s[5][0].setLetter(new PlayerLetter("F")); s[5][1].setLetter(new PlayerLetter("L")); s[5][2].setLetter(new PlayerLetter("R")); s[5][3].setLetter(new PlayerLetter("X")); s[5][4].setLetter(new PlayerLetter("D")); s[5][5].setLetter(new PlayerLetter("J"));
		PlayerBoard board = new PlayerBoard(s);
		int[] starThresholds = new int[3];
		starThresholds[0] = 20;
		starThresholds[1] = 40;
		starThresholds[2] = 60;
		PlayerPuzzleLevel level = new PlayerPuzzleLevel(starThresholds, 0, 0, false, "Abracadabra", 1);
		level.setBoard(board);
		PlayerLevelGUI levelView = new PlayerLevelGUI(level, "P0");
		levelView.openWindow();
		
		//assert
		
		// select word
		
		// hide level
		levelView.hideWindow();
		
		assertFalse(levelView.isVisible());
		
		// close level
		levelView.closeWindow();
		
		try {
			int w = (int)levelView.getBounds().getWidth();
			fail("Width (" + w + ") of a closed window should not exist.");
		} catch (Exception e) {}
		
	}
	
	public void testLightning() {
		// set up puzzle level with predetermined board
		PlayerSquare[][] s = new PlayerSquare[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				s[i][j] = new PlayerSquare(i, j);
				s[i][j].setActive(i < 5); // bottom row is inactive
			}
		}
		s[0][0].setLetter(new PlayerLetter("A")); s[0][1].setLetter(new PlayerLetter("G")); s[0][2].setLetter(new PlayerLetter("M")); s[0][3].setLetter(new PlayerLetter("S")); s[0][4].setLetter(new PlayerLetter("Y")); s[0][5].setLetter(new PlayerLetter("E"));
		s[1][0].setLetter(new PlayerLetter("B")); s[1][1].setLetter(new PlayerLetter("H")); s[1][2].setLetter(new PlayerLetter("N")); s[1][3].setLetter(new PlayerLetter("T")); s[1][4].setLetter(new PlayerLetter("Z")); s[1][5].setLetter(new PlayerLetter("F"));
		s[2][0].setLetter(new PlayerLetter("C")); s[2][1].setLetter(new PlayerLetter("I")); s[2][2].setLetter(new PlayerLetter("O")); s[2][3].setLetter(new PlayerLetter("U")); s[2][4].setLetter(new PlayerLetter("A")); s[2][5].setLetter(new PlayerLetter("G"));
		s[3][0].setLetter(new PlayerLetter("D")); s[3][1].setLetter(new PlayerLetter("J")); s[3][2].setLetter(new PlayerLetter("P")); s[3][3].setLetter(new PlayerLetter("V")); s[3][4].setLetter(new PlayerLetter("B")); s[3][5].setLetter(new PlayerLetter("H"));
		s[4][0].setLetter(new PlayerLetter("E")); s[4][1].setLetter(new PlayerLetter("K")); s[4][2].setLetter(new PlayerLetter("Q")); s[4][3].setLetter(new PlayerLetter("W")); s[4][4].setLetter(new PlayerLetter("C")); s[4][5].setLetter(new PlayerLetter("I"));
		s[5][0].setLetter(new PlayerLetter("F")); s[5][1].setLetter(new PlayerLetter("L")); s[5][2].setLetter(new PlayerLetter("R")); s[5][3].setLetter(new PlayerLetter("X")); s[5][4].setLetter(new PlayerLetter("D")); s[5][5].setLetter(new PlayerLetter("J"));
		PlayerBoard board = new PlayerBoard(s);
		int[] starThresholds = new int[3];
		starThresholds[0] = 20;
		starThresholds[1] = 40;
		starThresholds[2] = 60;
		PlayerLightningLevel level = new PlayerLightningLevel(starThresholds, 0, 0, false, "Abracadabra", 1);
		level.setBoard(board);
		PlayerLevelGUI levelView = new PlayerLevelGUI(level, "P0");
		levelView.openWindow();
		
		// assert
	}
	
	public void testTheme() {
		// set up theme level
		PlayerSquare[][] s = new PlayerSquare[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				s[i][j] = new PlayerSquare(i, j);
				s[i][j].setActive(i < 5); // bottom row is inactive
			}
		}
		s[0][0].setLetter(new PlayerLetter("")); s[0][1].setLetter(new PlayerLetter("")); s[0][2].setLetter(new PlayerLetter("")); s[0][3].setLetter(new PlayerLetter("")); s[0][4].setLetter(new PlayerLetter("")); s[0][5].setLetter(new PlayerLetter(""));
		s[1][0].setLetter(new PlayerLetter("")); s[1][1].setLetter(new PlayerLetter("")); s[1][2].setLetter(new PlayerLetter("")); s[1][3].setLetter(new PlayerLetter("")); s[1][4].setLetter(new PlayerLetter("")); s[1][5].setLetter(new PlayerLetter(""));
		s[2][0].setLetter(new PlayerLetter("")); s[2][1].setLetter(new PlayerLetter("")); s[2][2].setLetter(new PlayerLetter("")); s[2][3].setLetter(new PlayerLetter("")); s[2][4].setLetter(new PlayerLetter("")); s[2][5].setLetter(new PlayerLetter(""));
		s[3][0].setLetter(new PlayerLetter("")); s[3][1].setLetter(new PlayerLetter("")); s[3][2].setLetter(new PlayerLetter("")); s[3][3].setLetter(new PlayerLetter("")); s[3][4].setLetter(new PlayerLetter("")); s[3][5].setLetter(new PlayerLetter(""));
		s[4][0].setLetter(new PlayerLetter("")); s[4][1].setLetter(new PlayerLetter("")); s[4][2].setLetter(new PlayerLetter("")); s[4][3].setLetter(new PlayerLetter("")); s[4][4].setLetter(new PlayerLetter("")); s[4][5].setLetter(new PlayerLetter(""));
		s[5][0].setLetter(new PlayerLetter("")); s[5][1].setLetter(new PlayerLetter("")); s[5][2].setLetter(new PlayerLetter("")); s[5][3].setLetter(new PlayerLetter("")); s[5][4].setLetter(new PlayerLetter("")); s[5][5].setLetter(new PlayerLetter(""));
		PlayerBoard board = new PlayerBoard(s);
		int[] starThresholds = new int[3];
		starThresholds[0] = 20;
		starThresholds[1] = 40;
		starThresholds[2] = 60;
		LinkedList<String> themeWords = new LinkedList<String>();
		themeWords.add("MAGIC");
		PlayerThemeLevel level = new PlayerThemeLevel(starThresholds, 0, 0, false, "Abracadabra", "Test-o Case-o!", themeWords, board);
		level.setBoard(board);
		PlayerLevelGUI levelView = new PlayerLevelGUI(level, "P0");
		levelView.openWindow();
		
		//assert
		
		// select word
		
		//assert
		
		// attempt to submit non-word
		
		// assert
		
		// attempt to back up two letters
		
		//assert
		
		// back up one letter
		
		// assert
		
		// attempt to add non-adjacent letter
		
		// submit word
		
		// assert
		
		// select word
		
		// assert
		
		// click outside grid
		
		// assert
		
		// select word
		
		// assert
		
		// submit word
		
		// assert
		
		// select word
		
		// assert
		
		// attempt to submit 2-letter word
		
		// attempt to select word with inactive square
		
		// assert
		
		// undo last move
		
		// assert
		
		// reset board
		
		// assert
		
		// go back to level select screen
		
		// assert
	}

}