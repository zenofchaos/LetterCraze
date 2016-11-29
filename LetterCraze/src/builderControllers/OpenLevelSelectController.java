package builderControllers;

import java.util.Scanner;

public class OpenLevelSelectController {
	
	//Store the number of available levels in the directory.
	int numL;
	int numP;
	int numT;	
	
	int i; // handy dandy re-usable iterator through files

	public OpenLevelSelectController() throws Exception {

		// Generate FileCount file and its Scanner
		java.io.File file = new java.io.File("Levels/FileCount.txt");
		Scanner input = new Scanner(file);

		numL = input.nextInt();
		numP = input.nextInt();
		numT = input.nextInt();

		// Close FileCount
		input.close();

	}
}
