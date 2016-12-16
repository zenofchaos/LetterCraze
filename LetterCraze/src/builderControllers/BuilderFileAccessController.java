package builderControllers;

import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.Scanner;

import builderFiles.*;

/**
 * BuilderFileAccessController is used to load and save information about the
 * levels to and from the text files located in the Levels directory. FileCount
 * contains metadata about how many of each level type are available as well as
 * which levels are unlocked. Each of the other files contain ASCII data about
 * one level.
 * 
 * @author Linda
 */
public class BuilderFileAccessController {

	// Store the number of available levels in the directory.
	int numL;
	int numP;
	int numT;

	int i; // handy dandy re-usable iterator through files
	int j; // and the backup
	java.io.File file;
	Scanner input;

	/**
	 * Constructor, does nothing useful.
	 * 
	 * @param menu
	 */
	public BuilderFileAccessController() {
	}

	/**
	 * Returns an entire model with all the levels generated. in code: opens the
	 * master FileCound file to get metadata about levels, then iterates through
	 * each to open and load into the menu.
	 * 
	 * @return the fully-fleshed model
	 * @throws Exception
	 *             because unless I made a mistake, the only exception I have to
	 *             account for is 404 file not found.
	 */
	public BuilderModel getModel() throws Exception {
		BuilderModel model = new BuilderModel();
		BuilderMenu menu = model.getMenu();

		// Open and Read FileCount

		// Open FileCount
		file = new java.io.File("Levels/FileCount.txt");
		input = new Scanner(file);

		numL = input.nextInt();
		numP = input.nextInt();
		numT = input.nextInt();

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

	/**
	 * Opens the lightning level file corresponding to the input number, reads
	 * it, and returns a lightning level.
	 * 
	 * @param number
	 *            the number of the level/file to open (i.e. passing 3 here
	 *            reads Levels/Lightning3.txt)
	 * @return One builder lightning level with all the proper data.
	 * @throws Exception
	 *             because there's always a remote possibility that the file
	 *             doesn't exist.
	 */
	public BuilderLevel readLightning(int number) throws Exception {
		file = new java.io.File("Levels/Lightning" + number + ".txt");
		input = new Scanner(file);

		// Skip high score and its stars
		input.next();
		input.next();
		input.nextLine(); // Advances the cursor to the next line
		String title = input.nextLine();

		int[] starThresholds = { input.nextInt(), input.nextInt(), input.nextInt() };

		// Now I process the bitmap.

		BuilderSquare[][] bitmap = new BuilderSquare[6][6];
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				bitmap[i][j] = new BuilderSquare(i, j);
				bitmap[i][j].setActive(input.nextInt() == 1);
			}
		}
		BuilderBoard board = new BuilderBoard(bitmap);

		int maxTime = input.nextInt();

		// That's the last entry in the file, now we're ready to put it all
		// together.

		BuilderLevel level = new BuilderLightningLevel(starThresholds, title, maxTime);
		level.setBoard(board);

		// Close File
		input.close();

		return level;
	}

	/**
	 * Opens the puzzle level file corresponding to the input number, reads it,
	 * and returns a lightning level.
	 * 
	 * @param number
	 *            the number of the level/file to open (i.e. 5 opens
	 *            Levels/Puzzle5.txt)
	 * @return builder puzzle level with all fields filled
	 * @throws Exception
	 *             in case someone deletes the file
	 */
	public BuilderLevel readPuzzle(int number) throws Exception {
		file = new java.io.File("Levels/Puzzle" + number + ".txt");
		input = new Scanner(file);

		// Skip high score and its stars
		input.next();
		input.next();
		input.nextLine(); // Advances the cursor to the next line
		String title = input.nextLine();

		int[] starThresholds = { input.nextInt(), input.nextInt(), input.nextInt() };

		// Now process the bitmap.

		BuilderSquare[][] bitmap = new BuilderSquare[6][6];
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				bitmap[i][j] = new BuilderSquare(i, j);
				bitmap[i][j].setActive(input.nextInt() == 1);
			}
		}
		BuilderBoard board = new BuilderBoard(bitmap);

		int moveNumber = input.nextInt();

		// That's the last entry in the file, now we're ready to put it all
		// together.

		BuilderLevel level = new BuilderPuzzleLevel(starThresholds, title, moveNumber);
		level.setBoard(board);

		// Close File
		input.close();

		// WILL BE USED TO TEST THE SAVE METHODS ONCE I CAN COMPILE
		// savePuzzle(number + 10, (BuilderPuzzleLevel) level);

		return level;
	}

	/**
	 * Opens the theme level file corresponding to the input number, reads it,
	 * and returns a lightning level.
	 * 
	 * @param number
	 *            opens the number-th level/file in the directory
	 * @return complete builder theme level, ready to be deployed
	 * @throws Exception
	 *             for the slim "file not found" possibility
	 */
	public BuilderLevel readTheme(int number) throws Exception {
		file = new java.io.File("Levels/Theme" + number + ".txt");
		input = new Scanner(file);

		// skip highest score and stars
		input.nextInt();
		input.nextInt();
		input.nextLine(); // Advances the cursor to the next line
		String title = input.nextLine();

		int[] starThresholds = { input.nextInt(), input.nextInt(), input.nextInt() };

		// Now process the bitmap.

		// first create the bitmap
		BuilderSquare[][] bitmap = new BuilderSquare[6][6];
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				// here I create a playerSquare in each cell of the array
				bitmap[i][j] = new BuilderSquare(i, j);
				// then I set whether the given square is active or inactive
				bitmap[i][j].setActive(input.nextInt() == 1);
			}
		}

		// now I add the starting characters

		input.nextLine();
		String tempString;
		BuilderLetter letter;
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
					letter = new BuilderLetter("QU");
					bitmap[i][j].setLetter(letter);
				} else {
					letter = new BuilderLetter(tempString);
					bitmap[i][j].setLetter(letter);
				}
			}
		}

		BuilderBoard board = new BuilderBoard(bitmap);

		// now get the theme
		input.nextLine();
		input.nextLine();
		String description = input.nextLine();

		// now generate the linked list
		LinkedList<String> list = new LinkedList<String>();
		while (input.hasNext()) {
			list.add(input.next());
		}

		BuilderLevel level = new BuilderThemeLevel(starThresholds, title, description, list, board);

		// Close File
		input.close();

		return level;
	}

	/**
	 * "saves" (completely re-writes) an edited lightning level back to disk
	 * 
	 * @param levelNum
	 *            number you want to save the level to (like, a 3 would save it
	 *            over Levels/Lightning3.txt)
	 * @param level
	 *            the level you want to save
	 * @throws Exception
	 *             the omni-present concern for losing a file that happens EVERY
	 *             SINGLE TIME I open a file
	 */
	public void saveLightning(int levelNum, BuilderLightningLevel level) throws Exception {
		file = new java.io.File("Levels/Lightning" + levelNum + ".txt");
		if (file.createNewFile()) adjustLightningCount(+1);

		PrintWriter writer = new PrintWriter(file);

		writer.format("00000\r\n");
		writer.format("0\r\n");
		writer.format("%s\r\n", level.getTitle());
		writer.format("%d\r\n", level.getStarThresholds()[0]);
		writer.format("%d\r\n", level.getStarThresholds()[1]);
		writer.format("%d\r\n\n", level.getStarThresholds()[2]);

		// bitmap
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				if (level.getBoard().getSquareArray()[i][j].getActive()) {
					writer.format("1 ");
				} else {
					writer.format("0 ");
				}
			}
			writer.format("\r\n");
		}
		writer.format("\r\n");

		writer.format("%d", ((BuilderLightningLevel) level).getMaxTime());

		/// and now the file is finished.

		// Close FileCount
		writer.close();
	}

	/**
	 * saves a puzzle level to the disk. could be a new level, or an edit
	 * @param levelNum number of file to save level to (i.e. 6 -> Puzzle6.txt)
	 * @param level BuilderPuzzleLevel to save
	 * @throws Exception for filenotfound exception
	 */
	public void savePuzzle(int levelNum, BuilderPuzzleLevel level) throws Exception {
		file = new java.io.File("Levels/Puzzle" + levelNum + ".txt");
		if (file.createNewFile()) adjustPuzzleCount(+1);

		PrintWriter writer = new PrintWriter(file);

		writer.format("00000\r\n");
		writer.format("0\r\n");
		writer.format("%s\r\n", level.getTitle());
		writer.format("%d\r\n", level.getStarThresholds()[0]);
		writer.format("%d\r\n", level.getStarThresholds()[1]);
		writer.format("%d\r\n\n", level.getStarThresholds()[2]);

		// bitmap
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				if (level.getBoard().getSquareArray()[i][j].getActive()) {
					writer.format("1 ");
				} else {
					writer.format("0 ");
				}
			}
			writer.format("\r\n");
		}
		writer.format("\r\n");

		writer.format("%d", ((BuilderPuzzleLevel) level).getWordLimit());

		/// and now the file is finished.

		// Close FileCount
		writer.close();
	}

	/**
	 * saves a theme level to the disk. could be a new level, or an edit
	 * @param levelNum number of file to save level to (i.e. 1 -> Theme1.txt)
	 * @param level BuilderThemeLevel to save
	 * @throws Exception 404
	 */
	public void saveTheme(int levelNum, BuilderThemeLevel level) throws Exception {
		file = new java.io.File("Levels/Theme" + levelNum + ".txt");
		if (file.createNewFile()) adjustThemeCount(+1);

		PrintWriter writer = new PrintWriter(file);

		writer.format("00000\r\n");
		writer.format("0\r\n");
		writer.format("%s\r\n", level.getTitle());
		writer.format("%d\r\n", level.getStarThresholds()[0]);
		writer.format("%d\r\n", level.getStarThresholds()[1]);
		writer.format("%d\r\n\n", level.getStarThresholds()[2]);

		// bitmap
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				if (level.getBoard().getSquareArray()[i][j].getActive()) {
					writer.format("1 ");
				} else {
					writer.format("0 ");
				}
			}
			writer.format("\r\n");
		}
		writer.format("\r\n");

		// charmap
		String buffer;
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				if (level.getBoard().getSquareArray()[i][j].getLetter() != null) {
					buffer = level.getBoard().getSquareArray()[i][j].getLetter().getLetter();
					if (buffer == "Qu" || buffer == "QU") {
						writer.format("Q ");
					} else {
						writer.format(buffer + " ");
						}
				} else {	//if null, meant to be a random letter. Represented by an asterisk in file.
					writer.format("* ");
				}
			}
			writer.format("\r\n");
		}
		writer.format("\r\n");

		// write theme
		writer.format(level.getDescription() + "\r\n\n");

		// iterate through theme words
		for (String s : level.getThemeWords()) {
			writer.format(s + "\r\n");
		}

		/// and now the file is finished.

		// Close FileCount
		writer.close();
	}

	/**
	 * changes the number of lightning levels by an offset. Used to add a level, or delete.
	 * @param offset a delta to adjust the number of levels by. generally +1 or -1
	 * @throws Exception inevitable filenotfound exception
	 */
	public void adjustLightningCount(int offset) throws Exception {

		// Open and read FileCount

		// Open FileCount
		java.io.File fileCount = new java.io.File("Levels/FileCount.txt");
		input = new Scanner(fileCount);

		numL = input.nextInt();
		numP = input.nextInt();
		numT = input.nextInt();

		// Close FileCount
		input.close();

		// open FileCount again for writing
		RandomAccessFile rAFile = new RandomAccessFile("Levels/FileCount.txt", "rw");
		rAFile.seek(0); // the Lightning Count is always the first (2) byte(s)
						// in FileCount.

		String newCount = String.format("%02d", (numL + offset));

		rAFile.writeBytes(newCount);

		rAFile.close();
	}

	/**
	 * changes the number of puzzle levels by an offset. Used to add a level, or delete.
	 * @param offset a delta to adjust the number of levels by. generally +1 or -1
	 * @throws Exception filenotfound
	 */
	public void adjustPuzzleCount(int offset) throws Exception {

		// Open and read FileCount

		// Open FileCount
		java.io.File fileCount = new java.io.File("Levels/FileCount.txt");
		input = new Scanner(fileCount);

		numL = input.nextInt();
		numP = input.nextInt();
		numT = input.nextInt();

		// Close FileCount
		input.close();

		// open FileCount again for writing

		RandomAccessFile rAFile = new RandomAccessFile("Levels/FileCount.txt", "rw");
		rAFile.seek(3);

		String newCount = String.format("%02d", (numP + offset));

		rAFile.writeBytes(newCount);

		rAFile.close();
	}

	/**
	 * changes the number of theme levels by an offset. Used to add a level, or delete.
	 * @param offset a delta to adjust the number of levels by. generally +1 or -1
	 * @throws Exception filenotfound
	 */
	public void adjustThemeCount(int offset) throws Exception {

		// Open and read FileCount

		// Open FileCount
		java.io.File fileCount = new java.io.File("Levels/FileCount.txt");
		input = new Scanner(fileCount);

		numL = input.nextInt();
		numP = input.nextInt();
		numT = input.nextInt();

		// Close FileCount
		input.close();

		// open FileCount again for writing
		RandomAccessFile rAFile = new RandomAccessFile("Levels/FileCount.txt", "rw");
		rAFile.seek(6);

		String newCount = String.format("%02d", (numT + offset));

		rAFile.writeBytes(newCount);

		rAFile.close();
	}

}