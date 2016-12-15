package playerGUI;

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
				s[i][j].setActive(i < 5); // bottom row is inactive
			}
		}
		s[0][0].setLetter(new PlayerLetter("")); s[0][1].setLetter(new PlayerLetter("")); s[0][2].setLetter(new PlayerLetter("")); s[0][3].setLetter(new PlayerLetter("")); s[0][4].setLetter(new PlayerLetter("")); s[0][5].setLetter(new PlayerLetter(""));
		PlayerBoard board = new PlayerBoard(s);
		int[] starThresholds = new int[3];
		starThresholds[0] = 20;
		starThresholds[1] = 40;
		starThresholds[2] = 60;
		PlayerThemeLevel level = new PlayerThemeLevel(starThresholds, 0, 0, false, "Abracadabra", "Test-o Case-o!", null, board);
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