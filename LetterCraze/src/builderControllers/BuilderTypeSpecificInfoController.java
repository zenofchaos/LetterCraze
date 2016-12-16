package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderLevel;
import builderFiles.BuilderLightningLevel;
import builderFiles.BuilderPuzzleLevel;
import builderFiles.BuilderThemeLevel;
import builderGUI.BuilderEditorGUI;


/**
 * The Class BuilderTypeSpecificInfoController edits word limit, time limit, 
 * or theme description based on level type.
 */
public class BuilderTypeSpecificInfoController implements ActionListener {
	
	/** The builder editor view. */
	BuilderEditorGUI builderEditorView;
	
	/**
	 * Instantiates a new builder type specific info controller.
	 *
	 * @param builderEditorView the builder editor view
	 */
	public BuilderTypeSpecificInfoController(BuilderEditorGUI builderEditorView){
		this.builderEditorView = builderEditorView;
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		input.trim();
		if(typeSpecificInfo(input)){
			return;
		}
		else{
			System.out.println("Builder Type Specific Controller Failed");
		}

	}
	
	/**
	 * Checks if is valid number, every character is 0-9.
	 *
	 * @param value the value
	 * @return true, if is valid number
	 */
	boolean isValidNumber(String value){
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
	
	/**
	 * Type specific info actually sets the info based on if it is a valid type
	 * for the type of level and refreshes the gui.
	 *
	 * @param input the input
	 * @return true, if successful
	 */
	boolean typeSpecificInfo(String input){
		if (builderEditorView.getLevel() instanceof BuilderPuzzleLevel){
			BuilderPuzzleLevel level = (BuilderPuzzleLevel) builderEditorView.getLevel();
			if(isValidNumber(input)){
				int maxMoves = Integer.parseInt(input);
				level.setWordLimit(maxMoves);
				builderEditorView.refresh(level);
				return true;
			}
			else{
				System.out.println("max number of moves not a valid input");
				builderEditorView.refresh(level);
				return false;
			}
		}
		else if(builderEditorView.getLevel() instanceof BuilderThemeLevel){
			BuilderThemeLevel level = (BuilderThemeLevel) builderEditorView.getLevel();
			level.setDescription(input);
			builderEditorView.refresh(level);
			return true;
			
		}
		else if(builderEditorView.getLevel() instanceof BuilderLightningLevel){
			BuilderLightningLevel level = (BuilderLightningLevel) builderEditorView.getLevel();
			if(isValidNumber(input)){
				int maxTime = Integer.parseInt(input);
				level.setMaxTime(maxTime);
				builderEditorView.refresh(level);
				return true;
			}
			else{
				System.out.println("max time of moves not a valid input");
				builderEditorView.refresh(level);
				return false;
				
			}
		}
		else{
			System.out.println("Invalid level type sent to BuilderOpenNewEditorController");
			return false;
		}
	}

}
