package builderControllers;

import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.Scanner;

import builderFiles.*;
import playerFiles.PlayerPuzzleLevel;

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
	public BuilderFileAccessController(BuilderMenu menu) {
	}

	// Returns an entire model with all the levels generated.
	// in code: opens the master FileCount file to get metadata about levels,
	// then iterates through each to open.
	public BuilderModel getModel() throws Exception {
		BuilderModel model = new BuilderModel();
		BuilderMenu menu = model.getMenu();

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

	// opens the lightning level file corresponding to number, reads, and
	// returns a lightning level.
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
				bitmap[i][j].setIsActive(input.nextInt() == 1);
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

	// opens the puzzle level file corresponding to number, reads, and
	// returns a puzzle level.
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
				bitmap[i][j].setIsActive(input.nextInt() == 1);
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

	// opens the theme level file corresponding to number, reads, and
	// returns a theme level.
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
				bitmap[i][j].setIsActive(input.nextInt() == 1);
			}
		}

		// now I add the starting characters

		input.nextLine();
		String tempString;
		for (i = 0; i < 6; i++) {
			input.nextLine();
			for (j = 0; j < 6; j++) {
				// here I put the next char into tempString, check if tempString
				// is actually supposed to be QU, create a letter with
				// tempString as its letter, then add that playerLetter to the
				// PlayerSquare of row i and column j.
				tempString = input.next();
				if (tempString.equals("Q"))
					tempString = "QU";
				BuilderLetter letter = new BuilderLetter(tempString);
				bitmap[i][j].setLetter(letter);
			}
		}

		BuilderBoard board = new BuilderBoard(bitmap);

		// now generate the linked list
		LinkedList<String> list = new LinkedList<String>();
		while (input.hasNext()) {
			list.add(input.next());
		}

		BuilderLevel level = new BuilderThemeLevel(starThresholds, title, list, board);

		// Close File
		input.close();

		return level;
	}

	public void saveLightning(int levelNum, BuilderLightningLevel level) throws Exception {
		file = new java.io.File("Levels/Lightning" + levelNum + ".txt");
		file.createNewFile();

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
				if (level.getBoard().getSquares()[i][j].getIsActive()) {
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

	public void savePuzzle(int levelNum, BuilderPuzzleLevel level) throws Exception {
		file = new java.io.File("Levels/Puzzle" + levelNum + ".txt");
		file.createNewFile();

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
				if (level.getBoard().getSquares()[i][j].getIsActive()) {
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

	public void saveTheme(int levelNum, BuilderThemeLevel level) throws Exception {
		file = new java.io.File("Levels/Theme" + levelNum + ".txt");
		file.createNewFile();

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
				if (level.getBoard().getSquares()[i][j].getIsActive()) {
					writer.format("1 ");
				} else {
					writer.format("0 ");
				}
			}
			writer.format("\r\n");
		}
		writer.format("\r\n");

		// charmap
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				String buffer = level.getBoard().getSquares()[i][j].toString();
				if (buffer == "QU") {
					writer.format("Q ");
				} else {
					writer.format(buffer + " ");
				}
			}
			writer.format("\r\n");
		}
		writer.format("\r\n");

		for (String s : level.getThemeWords()) {
			writer.format(s + "\r\n");
		}

		/// and now the file is finished.

		// Close FileCount
		writer.close();
	}

	public void adjustLightningCount(int offset) throws Exception {
		RandomAccessFile rAFile = new RandomAccessFile("Levels/FileCount.txt", "rw");
		rAFile.seek(0); // the Lightning Count is always the first (2) byte(s)
						// in FileCount.

		String newCount = String.format("%02d", (numL + offset));

		rAFile.writeBytes(newCount);

		rAFile.close();
	}

	public void adjustPuzzleCount(int offset) throws Exception {
		RandomAccessFile rAFile = new RandomAccessFile("Levels/FileCount.txt", "rw");
		rAFile.seek(4);

		String newCount = String.format("%02d", (numP + offset));

		rAFile.writeBytes(newCount);

		rAFile.close();
	}

	public void adjustThemeCount(int offset) throws Exception {
		RandomAccessFile rAFile = new RandomAccessFile("Levels/FileCount.txt", "rw");
		rAFile.seek(8);

		String newCount = String.format("%02d", (numT + offset));

		rAFile.writeBytes(newCount);

		rAFile.close();
	}

}