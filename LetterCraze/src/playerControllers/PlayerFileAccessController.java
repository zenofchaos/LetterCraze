package playerControllers;

import java.util.Scanner;

import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import playerFiles.*;

public class PlayerFileAccessController {

	// Store the number of available levels in the directory.
	int numL;
	int numP;
	int numT;

	// Store the number of unlocked levels in each category.
	int unlockedL;
	int unlockedP;
	int unlockedT;

	int i; // handy dandy re-usable iterator through files
	int j; // and the backup
	java.io.File file;
	Scanner input;

	public PlayerFileAccessController(PlayerMenu menu) {
	}

	// Returns an entire model with all the levels generated.
	// in code: opens the master FileCount file to get metadata about levels,
	// then iterates through each to open.
	public PlayerModel getModel() throws Exception {
		PlayerModel model = new PlayerModel();
		PlayerMenu menu = model.getMenu();

		// Open FileCount
		file = new java.io.File("Levels/FileCount.txt");
		input = new Scanner(file);

		numL = input.nextInt();
		numP = input.nextInt();
		numT = input.nextInt();

		unlockedL = input.nextInt();
		unlockedP = input.nextInt();
		unlockedT = input.nextInt();

		// Close FileCount
		input.close();

		// Iterate to add Puzzle levels
		for (int i = 1; i <= numP; i++) {
			menu.addLevel(readPuzzle(i));
		}

		// Iterate to add Lightning levels
		for (int i = 1; i <= numL; i++) {
			menu.addLevel(readLightning(i));
		}

		// Iterate to add Theme levels
		for (int i = 1; i <= numT; i++) {
			menu.addLevel(readTheme(i));
		}

		return model;
	}

	// opens the lightning level file corresponding to number, reads, and
	// returns a lightning level.
	public PlayerLevel readLightning(int number) throws Exception {
		file = new java.io.File("Levels/Lightning" + number + ".txt");
		input = new Scanner(file);

		boolean isLocked = (i <= unlockedL);
		int bestScore = input.nextInt();
		int bestStars = input.nextInt();
		input.nextLine(); // Advances the cursor to the next line
		String title = input.nextLine();

		int[] starThresholds = { input.nextInt(), input.nextInt(), input.nextInt() };

		// Now I process the bitmap.

		PlayerSquare[][] bitmap = new PlayerSquare[6][6];
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				bitmap[i][j] = new PlayerSquare(i, j);
				bitmap[i][j].setActive(input.nextInt() == 1);
			}
		}
		PlayerBoard board = new PlayerBoard(bitmap);

		int maxTime = input.nextInt();

		// That's the last entry in the file, now we're ready to put it all
		// together.

		PlayerLevel level = new PlayerLightningLevel(starThresholds, bestScore, bestStars, isLocked, title, maxTime);
		level.setBoard(board);

		// Close File
		input.close();

		return level;
	}

	// opens the puzzle level file corresponding to number, reads, and
	// returns a puzzle level.
	public PlayerLevel readPuzzle(int number) throws Exception {
		file = new java.io.File("Levels/Puzzle" + number + ".txt");
		input = new Scanner(file);

		boolean isLocked = (i <= unlockedP);
		int bestScore = input.nextInt();
		int bestStars = input.nextInt();
		input.nextLine(); // Advances the cursor to the next line
		String title = input.nextLine();

		int[] starThresholds = { input.nextInt(), input.nextInt(), input.nextInt() };

		// Now process the bitmap.

		PlayerSquare[][] bitmap = new PlayerSquare[6][6];
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				bitmap[i][j] = new PlayerSquare(i, j);
				bitmap[i][j].setActive(input.nextInt() == 1);
			}
		}
		PlayerBoard board = new PlayerBoard(bitmap);

		int moveNumber = input.nextInt();

		// That's the last entry in the file, now we're ready to put it all
		// together.

		PlayerLevel level = new PlayerPuzzleLevel(starThresholds, bestScore, bestStars, isLocked, title, moveNumber);
		level.setBoard(board);

		// Close File
		input.close();

		return level;
	}

	// opens the theme level file corresponding to number, reads, and
	// returns a theme level.
	public PlayerLevel readTheme(int number) throws Exception {
		file = new java.io.File("Levels/Theme" + number + ".txt");
		input = new Scanner(file);

		boolean isLocked = (i > unlockedT);
		int bestScore = input.nextInt();
		int bestStars = input.nextInt();
		input.nextLine(); // Advances the cursor to the next line
		String title = input.nextLine();

		int[] starThresholds = { input.nextInt(), input.nextInt(), input.nextInt() };

		// Now process the bitmap.

		// first create the bitmap
		PlayerSquare[][] bitmap = new PlayerSquare[6][6];
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				// here I create a playerSquare in each cell of the array
				bitmap[i][j] = new PlayerSquare(i, j);
				// then I set whether the given square is active or inactive
				bitmap[i][j].setActive(input.nextInt() == 1);
			}
		}

		// now I add the starting characters

		input.nextLine();
		String tempString;
		PlayerLetter letter;
		for (i = 0; i < 6; i++) {
			input.nextLine();
			for (j = 0; j < 6; j++) {
				// here I put the next char into tempString, check if tempString
				// is actually supposed to be QU, create a letter with
				// tempString as its letter, then add that playerLetter to the
				// PlayerSquare of row i and column j.
				tempString = input.next();
				if (tempString.equals("*")) {
					// event of no letter being specified, necessitating use of
					// a random letter. in this case we want to leave the letter
					// null for this square. do nothing.
				} else if (tempString.equals("Q")) {
					// just the Q. need to add the u.
					letter = new PlayerLetter("QU");
					bitmap[i][j].setLetter(letter);
				} else {// any other letter
					letter = new PlayerLetter(tempString);
					bitmap[i][j].setLetter(letter);
				}
			}
		}

		PlayerBoard board = new PlayerBoard(bitmap);

		// now get the theme
		input.nextLine();
		input.nextLine();
		String description = input.nextLine();

		// now generate the linked list
		LinkedList<String> list = new LinkedList<String>();
		while (input.hasNext()) {
			list.add(input.next());
		}

		PlayerLevel level = new PlayerThemeLevel(starThresholds, bestScore, bestStars, isLocked, title, description,
				list, board);

		// Close File
		input.close();

		return level;
	}

	// opens a lightning level and replaces the previous high scores and stars
	// with the given values
	public void updateLightning(int levelnum, int bestScore, int bestStars) throws Exception {
		RandomAccessFile rAFile = new RandomAccessFile("Levels/Lightning" + levelnum + ".txt", "rw");
		rAFile.seek(0);

		// convert ints to strings
		String bestScoreString = String.format("%05d\r\n", bestScore);
		String bestStarsString = String.format("%01d", bestStars);

		rAFile.writeBytes(bestScoreString);
		rAFile.writeBytes(bestStarsString);

		// Close FileCount
		rAFile.close();
	}

	// opens a puzzle level and replaces the previous high scores and stars
	// with the given values
	public void updatePuzzle(int levelnum, int bestScore, int bestStars) throws Exception {
		RandomAccessFile rAFile = new RandomAccessFile("Levels/Puzzle" + levelnum + ".txt", "rw");
		rAFile.seek(0);

		// convert ints to strings
		String bestScoreString = String.format("%05d\r\n", bestScore);
		String bestStarsString = String.format("%01d", bestStars);

		rAFile.writeBytes(bestScoreString);
		rAFile.writeBytes(bestStarsString);

		// Close FileCount
		rAFile.close();
	}

	// opens a theme level and replaces the previous high scores and stars
	// with the given values
	public void updateTheme(int levelnum, int bestScore, int bestStars) throws Exception {
		RandomAccessFile rAFile = new RandomAccessFile("Levels/Theme" + levelnum + ".txt", "rw");
		rAFile.seek(0);

		// convert ints to strings
		String bestScoreString = String.format("%05d\r\n", bestScore);
		String bestStarsString = String.format("%01d", bestStars);

		rAFile.writeBytes(bestScoreString);
		rAFile.writeBytes(bestStarsString);

		// Close FileCount
		rAFile.close();
	}

	public void unlockLightning() throws Exception {
		RandomAccessFile rAFile = new RandomAccessFile("Levels/FileCount.txt", "rw");
		rAFile.seek(10); // maybe someday I'll remember to explain these numbers
							// (hint: it's the number of characters I have to
							// jump forward)

		String newNum = String.format("%02d", (unlockedL + 1));

		rAFile.writeBytes(newNum);

		rAFile.close();
	}

	public void unlockPuzzle() throws Exception {
		RandomAccessFile rAFile = new RandomAccessFile("Levels/FileCount.txt", "rw");
		rAFile.seek(13);

		String newNum = String.format("%02d", (unlockedP + 1));

		rAFile.writeBytes(newNum);

		rAFile.close();
	}

	public void unlockTheme() throws Exception {
		RandomAccessFile rAFile = new RandomAccessFile("Levels/FileCount.txt", "rw");
		rAFile.seek(16);

		String newNum = String.format("%02d", (unlockedT + 1));

		rAFile.writeBytes(newNum);

		rAFile.close();
	}

}
