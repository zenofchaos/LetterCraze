package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderLevel;
import builderFiles.BuilderLightningLevel;
import builderFiles.BuilderPuzzleLevel;
import builderFiles.BuilderThemeLevel;
import builderGUI.BuilderEditorGUI;

//TODO:WEIRD CASTING STUFF GOING ON WITH LEVEL TYPES HERE, NOT SURE THIS IS GOOD.... MIGHT WANT TO MAKE THREE DIFFERENT CONTROLLERS

public class BuilderTypeSpecificInfoController implements ActionListener {
	BuilderEditorGUI builderEditorView;
	
	public BuilderTypeSpecificInfoController(BuilderEditorGUI builderEditorView){
		this.builderEditorView = builderEditorView;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		input.trim();
		if (builderEditorView.getLevel() instanceof BuilderPuzzleLevel){
			BuilderPuzzleLevel level = (BuilderPuzzleLevel) builderEditorView.getLevel();
			if(isValidNumber(input)){
				int maxMoves = Integer.parseInt(input);
				level.setWordLimit(maxMoves);
				builderEditorView.refresh(level);
			}
			else{
				System.out.println("max number of moves not a valid input");
				builderEditorView.refresh(level);
			}
		}
		else if(builderEditorView.getLevel() instanceof BuilderThemeLevel){
			BuilderThemeLevel level = (BuilderThemeLevel) builderEditorView.getLevel();
			level.setDescription(input);
			builderEditorView.refresh(level);
			
		}
		else if(builderEditorView.getLevel() instanceof BuilderLightningLevel){
			BuilderLightningLevel level = (BuilderLightningLevel) builderEditorView.getLevel();
			if(isValidNumber(input)){
				int maxTime = Integer.parseInt(input);
				level.setMaxTime(maxTime);
				builderEditorView.refresh(level);
			}
			else{
				System.out.println("max time of moves not a valid input");
				builderEditorView.refresh(level);
				
			}
		}
		else{
			System.out.println("Invalid level type sent to BuilderOpenNewEditorController");
		}

	}
	
	private boolean isValidNumber(String value){
		boolean validNum = false;
		for(int i = 0; i < value.length(); i++){
			if ((value.charAt(i) >= '0') && (value.charAt(i) <= '9')){
				validNum = true;
			}
			else{
				return false;
			}
		}
		return validNum;
	}

}
