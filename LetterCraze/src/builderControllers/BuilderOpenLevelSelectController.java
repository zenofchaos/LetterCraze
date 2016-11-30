package builderControllers;

import java.util.Scanner;

import builderFiles.*;

public class OpenLevelSelectController {

	// Store the number of available levels in the directory.
	int numL;
	int numP;
	int numT;

	int i; // handy dandy re-usable iterator through files

	public OpenLevelSelectController(BuilderMenu Menu) throws Exception {

		// Generate FileCount file and its Scanner
		java.io.File file = new java.io.File("Levels/FileCount.txt");
		Scanner input = new Scanner(file);

		numL = input.nextInt();
		numP = input.nextInt();
		numT = input.nextInt();

		// Close FileCount
		input.close();

		// At this point I need to iterate through a loop for each type of file.
		// This will happen a total of (numL+numP+numT) times.

		// For the builder menu, I only need title and thresholds for each level.

		// I'll start with Lightning level generation.
		for (i = 1; i <= numL; i++) {
			
			file = new java.io.File("Levels/Lightning" + i + ".txt");
			input = new Scanner(file);

			input.nextInt(); //skip the high score
			input.nextInt(); //skip the max stars
			String title = input.nextLine();
			// WARNING: layout below will possibly break (pass by reference). I
			// need to put these directly into the level constructor when that
			// line is made.
			int[] starThresholds = { input.nextInt(), input.nextInt(), input.nextInt() };

			// TODO create a level and add this data
			// TODO menu.add(level) (add the level to the menu?)
			
			// Close current File
			input.close();
		}

		
		
		
	}
}
