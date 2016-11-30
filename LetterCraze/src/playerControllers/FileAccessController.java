package playerControllers;

import java.util.Scanner;

import playerFiles.*;

public class FileAccessController {

	/*
	 * NEEDED METHODS: PlayerModel getModel(); readLightning (int); readPuzzle
	 * (int); readTheme (int);
	 * 
	 */

	// Store the number of available levels in the directory.
	int numL;
	int numP;
	int numT;

	// Store the number of unlocked levels in each category.
	int unlockedL;
	int unlockedP;
	int unlockedT;

	int i; // handy dandy re-usable iterator through files
	
	java.io.File file;
	Scanner input;

	public FileAccessController(PlayerMenu menu) {
	}

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

	
	public PlayerLevel readLightning(int number) {
		int[] starThresholds = { 1, 1, 1 };
		PlayerLevel level = new PlayerLightningLevel(starThresholds, 1, 1, true, "No", 1);
		return level;
	}

	public PlayerLevel readPuzzle(int number) {
		int[] starThresholds = { 1, 1, 1 };
		PlayerLevel level = new PlayerLightningLevel(starThresholds, 1, 1, true, "No", 1);
		return level;
	}

	public PlayerLevel readTheme(int number) {
		int[] starThresholds = { 1, 1, 1 };
		PlayerLevel level = new PlayerLightningLevel(starThresholds, 1, 1, true, "No", 1);
		return level;
	}

}