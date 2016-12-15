package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import builderGUI.BuilderSelectLevelGUI;

public class BuilderDeleteLevelController implements ActionListener {

	int levNum;
	String levelID;
	BuilderSelectLevelGUI gui;

	/**
	 * Construct a BuilderDeleteLevelController
	 * 
	 * @param builderSelectLevelGUI
	 *            just passed in so I can refresh the menu afterwards
	 * @param levelID
	 *            the 2-character identifier for the level to delete, so I can
	 *            parse it to determine the level to delete
	 */
	public BuilderDeleteLevelController(BuilderSelectLevelGUI builderSelectLevelGUI, String levelID) {

		this.levelID = levelID;
		this.gui = builderSelectLevelGUI;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		levNum = levelID.charAt(1) - 48;
		BuilderFileAccessController fileAccess = new BuilderFileAccessController();

		switch (levelID.charAt(0)) {
		case 'L':
			deleteLightning(levNum);
			try {
				gui.refresh(fileAccess.getModel().getMenu());
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 'P':
			deletePuzzle(levNum);
			try {
				gui.refresh(fileAccess.getModel().getMenu());
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 'T':
			deleteTheme(levNum);
			try {
				gui.refresh(fileAccess.getModel().getMenu());
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			System.out
					.println("Someone's passing in weird values for the levelID into BuilderDeleteLevelController...");
			break;
		}
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
		BuilderFileAccessController fileAccess = new BuilderFileAccessController();
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
		BuilderFileAccessController fileAccess = new BuilderFileAccessController();
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
		BuilderFileAccessController fileAccess = new BuilderFileAccessController();
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
