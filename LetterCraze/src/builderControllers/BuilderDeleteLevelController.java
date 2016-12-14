package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import builderFiles.BuilderMenu;

public class BuilderDeleteLevelController implements ActionListener {

	public BuilderDeleteLevelController(String levelID) {
//		levelID.get
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	/**
	 * safely deletes the Lightning Level file corresponding to levelNum, then
	 * properly decrements the names of each and decrements in FileCount.txt so
	 * that the next getModel won't explode into a tangled mess of errors.
	 * 
	 * @param levelNum
	 *            the number of the lightning level to be deleted
	 */
	public void deleteLightning(int levelNum) {
		BuilderFileAccessController fileAccess = new BuilderFileAccessController(new BuilderMenu());
		java.io.File fileCount = new java.io.File("Levels/FileCount.txt");
		java.io.File to = new java.io.File("Levels/Lightning" + levelNum + ".txt");
		java.io.File from = new java.io.File("Levels/Lightning" + (levelNum + 1) + ".txt");

		try {
			Scanner input = new Scanner(fileCount);

			int numL = input.nextInt();

			// Close FileCount
			input.close();

			to.delete(); // delete

			// loop to decrement the name of each of the following files
			// (i.e. if I delete Lightning3.txt, I need Lightning4 to become
			// Lightning3, Lightning5->Lightning4, etc.)
			for (int i = levelNum; i < numL; i++) {
				from = new java.io.File("Levels/Lightning" + (i + 1) + ".txt");
				to = new java.io.File("Levels/Lightning" + i + ".txt");
				from.renameTo(to);
			}

			fileAccess.adjustLightningCount(-1);

		} catch (Exception e) {
			System.out.println("accessing FileCount.txt encountered an error (probably)");
			e.printStackTrace();
		}

	}

	/**
	 * safely deletes the Puzzle Level file corresponding to levelNum, then
	 * properly decrements the names of each and decrements in FileCount.txt.
	 * 
	 * @param levelNum
	 *            the number of the Puzzle level to be deleted
	 */
	public void deletePuzzle(int levelNum) {
		BuilderFileAccessController fileAccess = new BuilderFileAccessController(new BuilderMenu());
		java.io.File fileCount = new java.io.File("Levels/FileCount.txt");
		java.io.File to = new java.io.File("Levels/Puzzle" + levelNum + ".txt");
		java.io.File from = new java.io.File("Levels/Puzzle" + (levelNum + 1) + ".txt");

		try {
			Scanner input = new Scanner(fileCount);

			int numL = input.nextInt();
			int numP = input.nextInt();

			// Close FileCount
			input.close();

			to.delete(); // delete the file

			// loop to decrement the name of each of the following files
			for (int i = levelNum; i < numP; i++) {
				from = new java.io.File("Levels/Puzzle" + (i + 1) + ".txt");
				to = new java.io.File("Levels/Puzzle" + i + ".txt");
				from.renameTo(to);
			}

			fileAccess.adjustPuzzleCount(-1);

		} catch (Exception e) {
			System.out.println("accessing FileCount.txt encountered an error (probably)");
			e.printStackTrace();
		}

	}

	
	/**
	 * safely deletes the Theme Level file corresponding to levelNum, then
	 * properly decrements the names of each and decrements in FileCount.txt.
	 * 
	 * @param levelNum
	 *            the number of the Theme level to be deleted
	 */
	public void deleteTheme(int levelNum) {
		BuilderFileAccessController fileAccess = new BuilderFileAccessController(new BuilderMenu());
		java.io.File fileCount = new java.io.File("Levels/FileCount.txt");
		java.io.File to = new java.io.File("Levels/Theme" + levelNum + ".txt");
		java.io.File from = new java.io.File("Levels/Theme" + (levelNum + 1) + ".txt");

		try {
			Scanner input = new Scanner(fileCount);

			int numL = input.nextInt();
			int numP = input.nextInt();
			int numT = input.nextInt();


			// Close FileCount
			input.close();

			to.delete(); // delete the file

			// loop to decrement the name of each of the following files
			for (int i = levelNum; i < numT; i++) {
				from = new java.io.File("Levels/Theme" + (i + 1) + ".txt");
				to = new java.io.File("Levels/Theme" + i + ".txt");
				from.renameTo(to);
			}

			fileAccess.adjustThemeCount(-1);

		} catch (Exception e) {
			System.out.println("accessing FileCount.txt encountered an error (probably)");
			e.printStackTrace();
		}

	}

}
