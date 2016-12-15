package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderLevel;
import builderFiles.BuilderLightningLevel;
import builderFiles.BuilderPuzzleLevel;
import builderFiles.BuilderThemeLevel;
import builderGUI.BuilderEditorGUI;

public class BuilderSaveController implements ActionListener{
	BuilderEditorGUI editorView;
	BuilderLevel level;
	String levelIdentifier;
	int levelNum;
	
	public BuilderSaveController(BuilderEditorGUI editorView, String levelIdentifier) {
		this.editorView = editorView;
		this.level = editorView.getLevel();
		this.levelIdentifier = levelIdentifier;
		char levelNumChar = levelIdentifier.charAt(1);
		int levelNum = (int) levelNumChar - 48;
		this.levelNum = levelNum;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("save button pressed");
		// TODO: NEED TO SOMEHOW HAVE THE WHOLE MENU HERE TO MAKE THE FILE ACCESS CONTROLLER
		//TODO: ALSO NEED SOME WAY TO GET THE NUMBER THE LEVEL IS FROM THE MENU, MAYBE WE SHOULD ADD THAT TO 
		//THE STORED INFO IN EACH LEVEL? SO EACH LEVEL KNOWS IT'S T1 OR P4 FOR EXAMPLE?
		BuilderFileAccessController fileAccessController = new BuilderFileAccessController();
		if (level instanceof BuilderPuzzleLevel){
			try {
				fileAccessController.savePuzzle(levelNum,(BuilderPuzzleLevel) level);
				editorView.refresh(level);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		else if(level instanceof BuilderThemeLevel){
			try {
				fileAccessController.saveTheme(levelNum,(BuilderThemeLevel) level);
				editorView.refresh(level);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		else if(level instanceof BuilderLightningLevel){
			try {
				fileAccessController.saveLightning(levelNum,(BuilderLightningLevel) level);
				editorView.refresh(level);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else{
			System.out.println("Invalid level type sent to BuilderSaveController");
		}

		
		
		
		editorView.refresh(level);
	}

}
