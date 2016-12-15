package playerControllers;

import java.util.Scanner;

import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import playerFiles.*;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerFileAccessController.
 */
public class PlayerFileAccessController {

	/** The num L. */
	// Store the number of available levels in the directory.
	int numL;
	
	/** The num P. */
	int numP;
	
	/** The num T. */
	int numT;

	/** The unlocked L. */
	// Store the number of unlocked levels in each category.
	int unlockedL;
	
	/** The unlocked P. */
	int unlockedP;
	
	/** The unlocked T. */
	int unlockedT;

	/** The i. */
	int i; // handy dandy re-usable iterator through files
	
	/** The j. */
	int j; // and the backup
	
	/** The file. */
	java.io.File file;
	
	/** The input. */
	Scanner input;

	/**
	 * Instantiates a new player file access controller.
	 */
	public PlayerFileAccessController() {
		// Open FileCount
		file = new java.io.File("Levels/FileCount.txt");
		try{
			input = new Scanner(file);
		}
		catch (Exception e){
			System.out.print(e);
		}

		numL = input.nextInt();
		numP = input.nextInt();
		numT = input.nextInt();

		unlockedL = input.nextInt();
		unlockedP = input.nextInt();
		unlockedT = input.nextInt();

		// Close FileCount
		input.close();
	}

	/**
	 * Returns an entire model with all the levels generated. in code: opens the master FileCount file to get metadata about levels, then iterates through each to open.
	 * @return the model, complete with every level, board, square and letter.
	 * @throws Exception I couldn't write this without throwing an exception, so that's why it's here
	 */
	public PlayerModel getModel() throws Exception {
		PlayerModel model = new PlayerModel();
		PlayerMenu menu = model.getMenu();

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
	/**
	 * Read lightning.
	 *
	 * @param number the number
	 * @return the player level
	 * @throws Exception the exception
	 */
	// returns a lightning level.
	public PlayerLevel readLightning(int number) throws Exception {
		file = new java.io.File("Levels/Lightning" + number + ".txt");
		input = new Scanner(file);

		boolean isLocked = (number > unlockedL);
		int bestScore = input.nextInt();
		int bestStars = input.nextInt();
		input.nextLine(); // Advances the cursor to the next line
		String title = input.nextLine();

		int[] starThresholds = { input.nextInt(), input.nextInt(), input.nextInt() };

		// Now I process the bitmap.

		PlayerSquare[][] bitmap = new PlayerSquare[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
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
	/**
	 * Read puzzle.
	 *
	 * @param number the number
	 * @return the player level
	 * @throws Exception the exception
	 */
	// returns a puzzle level.
	public PlayerLevel readPuzzle(int number) throws Exception {
		file = new java.io.File("Levels/Puzzle" + number + ".txt");
		input = new Scanner(file);

		boolean isLocked = (number > unlockedP);
		int bestScore = input.nextInt();
		int bestStars = input.nextInt();
		input.nextLine(); // Advances the cursor to the next line
		String title = input.nextLine();

		int[] starThresholds = { input.nextInt(), input.nextInt(), input.nextInt() };

		// Now process the bitmap.

		PlayerSquare[][] bitmap = new PlayerSquare[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
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
	/**
	 * Read theme.
	 *
	 * @param number the number
	 * @return the player level
	 * @throws Exception the exception
	 */
	// returns a theme level.
	public PlayerLevel readTheme(int number) throws Exception {
		file = new java.io.File("Levels/Theme" + number + ".txt");
		input = new Scanner(file);

		
		boolean isLocked = (number > unlockedT);
		int bestScore = input.nextInt();
		int bestStars = input.nextInt();
		input.nextLine(); // Advances the cursor to the next line
		String title = input.nextLine();

		int[] starThresholds = { input.nextInt(), input.nextInt(), input.nextInt() };

		// Now process the bitmap.

		// first create the bitmap
		PlayerSquare[][] bitmap = new PlayerSquare[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
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
		for (int i = 0; i < 6; i++) {
			input.nextLine();
			for (int j = 0; j < 6; j++) {
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
	/**
	 * Update lightning.
	 *
	 * @param levelnum the levelnum
	 * @param bestScore the best score
	 * @param bestStars the best stars
	 * @throws Exception the exception
	 */
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
	/**
	 * Update puzzle.
	 *
	 * @param levelnum the levelnum
	 * @param bestScore the best score
	 * @param bestStars the best stars
	 * @throws Exception the exception
	 */
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
	/**
	 * Update theme.
	 *
	 * @param levelnum the levelnum
	 * @param bestScore the best score
	 * @param bestStars the best stars
	 * @throws Exception the exception
	 */
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

	/**
	 * Unlock lightning.
	 *
	 * @throws Exception the exception
	 */
	public void unlockLightning() throws Exception {
		RandomAccessFile rAFile = new RandomAccessFile("Levels/FileCount.txt", "rw");
		rAFile.seek(10); // maybe someday I'll remember to explain these numbers
							// (hint: it's the number of characters I have to
							// jump forward)

		String newNum = String.format("%02d", (unlockedL + 1));

		rAFile.writeBytes(newNum);

		rAFile.close();
	}

	/**
	 * Unlock puzzle.
	 *
	 * @throws Exception the exception
	 */
	public void unlockPuzzle() throws Exception {
		RandomAccessFile rAFile = new RandomAccessFile("Levels/FileCount.txt", "rw");
		rAFile.seek(13);
		System.out.println("unlockedP = " + unlockedP);
		String newNum = String.format("%02d", (unlockedP + 1));

		rAFile.writeBytes(newNum);

		rAFile.close();
	}

	/**
	 * Unlock theme.
	 *
	 * @throws Exception the exception
	 */
	public void unlockTheme() throws Exception {
		RandomAccessFile rAFile = new RandomAccessFile("Levels/FileCount.txt", "rw");
		rAFile.seek(16);

		String newNum = String.format("%02d", (unlockedT + 1));

		rAFile.writeBytes(newNum);

		rAFile.close();
	}

}
