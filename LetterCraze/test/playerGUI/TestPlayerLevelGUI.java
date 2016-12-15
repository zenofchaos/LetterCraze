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

	public void testGeneral() {
		PlayerSquare[][] s = new PlayerSquare[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				s[i][j] = new PlayerSquare(i, j);
				s[i][j].setActive(true); // bottom row is inactive
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
		themeWords.add("BUZZ");
		PlayerThemeLevel level = new PlayerThemeLevel(starThresholds, 0, 0, false, "Abracadabra", "Test-o Case-o!", themeWords, board);
		level.setBoard(board);
		PlayerLevelGUI levelView = new PlayerLevelGUI(level, "P0");
		levelView.openWindow();
	}
	
	public void testPuzzle() {
		
	}
	
	public void testLightning() {
		
	}

	public void testTheme() {
	
	}

}