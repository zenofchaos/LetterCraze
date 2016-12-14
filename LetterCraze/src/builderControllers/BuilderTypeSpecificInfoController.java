package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderLevel;
import builderFiles.BuilderLightningLevel;
import builderFiles.BuilderPuzzleLevel;
import builderFiles.BuilderThemeLevel;
import builderGUI.BuilderEditorGUI;

public class BuilderTypeSpecificInfoController implements ActionListener {
	BuilderEditorGUI builderEditorView;
	String type;
	BuilderLevel level;
	
	public BuilderTypeSpecificInfoController(BuilderEditorGUI builderEditorView, String type){
		this.builderEditorView = builderEditorView;
		this.type = type;
		this.level = builderEditorView.getLevel();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		input.trim();
		if(this.type == "P"){
			System.out.println("puzzle specific input");
			System.out.println(input);
			if(isValidNumber(input)){
				int maxMoves = Integer.parseInt(input);
				// store max moves in level info
				// refresh screen
			}
			else{
				System.out.println("max number of moves not a valid input");
				// refresh screen
			}
		}
		else if(this.type == "T"){
			System.out.println("theme specific input");
			System.out.println(input);
			// save description somewhere
		}
		else if(this.type == "L"){
			System.out.println("Lightning specific input");
			System.out.println(input);
			if(isValidNumber(input)){
				int maxTime = Integer.parseInt(input);
				// store max moves in level info
				// refresh screen
			}
			else{
				System.out.println("max time of moves not a valid input");
				// refresh screen
			}
		}
		else{
			System.out.println("Invalid type sent to BuilderOpenNewEditorController");
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
