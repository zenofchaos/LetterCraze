package playerControllers;

import java.util.Scanner;

public class OpenLevelSelectController {

	// Store the number of available levels in the directory.
	int numL;
	int numP;
	int numT;

	// Store the number of unlocked levels in each category.
	int unlockedL;
	int unlockedP;
	int unlockedT;

	int i; // handy dandy re-usable iterator through files

	public OpenLevelSelectController() throws Exception {

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

	}
}
