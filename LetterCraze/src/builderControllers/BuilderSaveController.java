package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderLevel;
import builderFiles.BuilderLightningLevel;
import builderFiles.BuilderPuzzleLevel;
import builderFiles.BuilderThemeLevel;
import builderGUI.BuilderEditorGUI;

// TODO: Auto-generated Javadoc
/**
 * The Class BuilderSaveController.
 */
public class BuilderSaveController implements ActionListener{
	
	/** The editor view. */
	BuilderEditorGUI editorView;
	
	/** The level. */
	BuilderLevel level;
	
	/** The level identifier. */
	String levelIdentifier;
	
	/** The level num. */
	int levelNum;
	
	/**
	 * Instantiates a new builder save controller.
	 *
	 * @param editorView the editor view
	 * @param levelIdentifier the level identifier
	 */
	public BuilderSaveController(BuilderEditorGUI editorView, String levelIdentifier) {
		this.editorView = editorView;
		this.level = editorView.getLevel();
		this.levelIdentifier = levelIdentifier;
		char levelNumChar = levelIdentifier.charAt(1);
		int levelNum = (int) levelNumChar - 48;
		this.levelNum = levelNum;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("save button pressed");
		save();
		
	}
	
	/**
	 * Save.
	 *
	 * @return true, if successful
	 */
	boolean save(){
		BuilderFileAccessController fileAccessController = new BuilderFileAccessController();
		if (level instanceof BuilderPuzzleLevel){
			try {
				fileAccessController.savePuzzle(levelNum,(BuilderPuzzleLevel) level);
				editorView.refresh(level);
				return true;
			} catch (Exception e1) {
				e1.printStackTrace();
				return false;
			}
			
		}
		else if(level instanceof BuilderThemeLevel){
			try {
				fileAccessController.saveTheme(levelNum,(BuilderThemeLevel) level);
				editorView.refresh(level);
				return true;
			} catch (Exception e1) {
				e1.printStackTrace();
				return false;
			}
			
		}
		else if(level instanceof BuilderLightningLevel){
			try {
				fileAccessController.saveLightning(levelNum,(BuilderLightningLevel) level);
				editorView.refresh(level);
				return true;
			} catch (Exception e1) {
				e1.printStackTrace();
				return false;
			}
		}
		else{
			System.out.println("Invalid level type sent to BuilderSaveController");
			return false;
		}
		
	}

}
