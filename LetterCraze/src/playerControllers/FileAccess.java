package playerControllers;

import java.util.Scanner;

import playerFiles.*;

public class FileAccess {

	// Store the number of available levels in the directory.
	int numL;
	int numP;
	int numT;

	// Store the number of unlocked levels in each category.
	int unlockedL;
	int unlockedP;
	int unlockedT;

	int i; // handy dandy re-usable iterator through files

	public FileAccess(PlayerMenu menu) throws Exception {

		// Generate FileCount file and its Scanner
		java.io.File file = new java.io.File("Levels/FileCount.txt");
		Scanner input = new Scanner(file);

		numL = input.nextInt();
		numP = input.nextInt();
		numT = input.nextInt();

		unlockedL = input.nextInt();
		unlockedP = input.nextInt();
		unlockedT = input.nextInt();

		// Close FileCount
		input.close();

		// At this point I need to iterate through a loop for each type of file.
		// This will happen a total of (numL+numP+numT) times.

		// For the player menu, I only need a locked boolean, high score,
		// corresponding stars, title, and thresholds for each level.

		// I'll start with Puzzle level generation.
		for (i = 1; i <= numP; i++) {

			file = new java.io.File("Levels/Puzzle" + i + ".txt");
			input = new Scanner(file);

			Boolean isLocked = (i <= unlockedP);

			int maxScore = input.nextInt();
			int maxStars = input.nextInt();
			String title = input.nextLine();
			// WARNING: layout below will possibly break (pass by reference). I
			// need to put these directly into the level constructor when that
			// line is made.
			int[] starThresholds = { input.nextInt(), input.nextInt(), input.nextInt() };

			PlayerLevel level = new PlayerPuzzleLevel(starThresholds, maxScore, maxStars, isLocked, title, i);
			
			menu.addLevel(level);
			
		}

	}
}
