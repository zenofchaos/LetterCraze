package playerControllers;

import java.util.Scanner;

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
		for (i = 1; i <= numP; i++) {
			menu.addLevel(readPuzzle(i));
		}

		// Iterate to add Lightning levels
		for (i = 1; i <= numL; i++) {
			menu.addLevel(readLightning(i));
		}

		// Iterate to add Theme levels
		for (i = 1; i <= numT; i++) {
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
		input.nextLine(); //Advances the cursor to the next line
		String title = input.nextLine();

		int[] starThresholds = { input.nextInt(), input.nextInt(), input.nextInt() };

		// Now I process the bitmap.

		PlayerSquare[][] hypercube = new PlayerSquare[6][6];
		// (get it? because I added 2 dimensions to a square? lol)
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				hypercube[i][j] = new PlayerSquare(i, j);
				hypercube[i][j].setActive(input.nextInt() == 1);
			}
		}
		PlayerBoard board = new PlayerBoard(hypercube);

		int maxTime = input.nextInt();

		// That's the last entry in the file, now we're ready to put it all
		// together.

		PlayerLevel level = new PlayerLightningLevel(starThresholds, bestScore, bestStars, isLocked, title, maxTime);
		level.setBoard(board);
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
		input.nextLine(); //Advances the cursor to the next line
		String title = input.nextLine();

		int[] starThresholds = { input.nextInt(), input.nextInt(), input.nextInt() };

		// Now process the bitmap.

		PlayerSquare[][] hypercube = new PlayerSquare[6][6];
		for (i = 0; i < 6; i++) {
			for (j = 0; j < 6; j++) {
				hypercube[i][j] = new PlayerSquare(i, j);
				hypercube[i][j].setActive(input.nextInt() == 1);
			}
		}
		PlayerBoard board = new PlayerBoard(hypercube);

		int moveNumber = input.nextInt();

		// That's the last entry in the file, now we're ready to put it all
		// together.

		PlayerLevel level = new PlayerPuzzleLevel(starThresholds, bestScore, bestStars, isLocked, title, moveNumber);
		level.setBoard(board);

		return level;
	}

	// opens the theme level file corresponding to number, reads, and
	// returns a theme level.
	//WARNING: NOT IMPLEMENTED YET
	public PlayerLevel readTheme(int number) {
		// OH GOD I'M NOT GONNA TOUCH THIS TILL THURSDAY AT LEAST
		int[] starThresholds = { 1, 1, 1 };
		PlayerLevel level = new PlayerLightningLevel(starThresholds, 1, 1, false, "Placeholder", 1);
		return level;
	}

}