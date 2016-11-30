package builderControllers;

import java.util.Scanner;

import builderFiles.*;

public class BuilderFileAccessController {


	// Store the number of available levels in the directory.
	int numL;
	int numP;
	int numT;


	int i; // handy dandy re-usable iterator through files
	int j; // and the backup
	java.io.File file;
	Scanner input;

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
	public BuilderLevel readLightning(int number) throws Exception {
		file = new java.io.File("Levels/Lightning" + number + ".txt");
		input = new Scanner(file);

		//Skip high score and its stars
		input.next();
		input.next();
		String title = input.nextLine();

		int[] starThresholds = { input.nextInt(), input.nextInt(), input.nextInt() };

		// Now I process the bitmap.

		BuilderSquare[][] hypercube = new BuilderSquare[6][6];
		// (get it? because I added 2 dimensions to a square? lol)
		for (i = 0; i <= 6; i++) {
			for (j = 0; j <= 6; j++) {
				hypercube[i][j] = new BuilderSquare(i, j);
				hypercube[i][j].setIsActive(input.nextInt() == 1);
			}
		}
		BuilderBoard board = new BuilderBoard(hypercube);

		int maxTime = input.nextInt();

		// That's the last entry in the file, now we're ready to put it all
		// together.

		BuilderLevel level = new BuilderLightningLevel(starThresholds, title, maxTime);
		level.setBoard(board);
		return level;
	}

	// opens the puzzle level file corresponding to number, reads, and
	// returns a puzzle level.
	public BuilderLevel readPuzzle(int number) throws Exception {
		file = new java.io.File("Levels/Puzzle" + number + ".txt");
		input = new Scanner(file);

		//Skip high score and its stars
		input.next();
		input.next();
		String title = input.nextLine();

		int[] starThresholds = { input.nextInt(), input.nextInt(), input.nextInt() };

		// Now process the bitmap.

		BuilderSquare[][] hypercube = new BuilderSquare[6][6];
		for (i = 0; i <= 6; i++) {
			for (j = 0; j <= 6; j++) {
				hypercube[i][j] = new BuilderSquare(i, j);
				hypercube[i][j].setIsActive(input.nextInt() == 1);
			}
		}
		BuilderBoard board = new BuilderBoard(hypercube);

		int moveNumber = input.nextInt();

		// That's the last entry in the file, now we're ready to put it all
		// together.

		BuilderLevel level = new BuilderPuzzleLevel(starThresholds, title, moveNumber);
		level.setBoard(board);

		return level;
	}

	// opens the theme level file corresponding to number, reads, and
	// returns a theme level.
	//WARNING: NOT IMPLEMENTED YET
	public BuilderLevel readTheme(int number) {
//this is going to take more work and isn't required for Phase 1, which is why I'm giving it a lower priority
		int[] starThresholds = { 1, 1, 1 };
		BuilderLevel level = new BuilderLightningLevel(starThresholds, "Placeholder", 1);
		return level;
	}

}