package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderLetter;
import builderFiles.BuilderLevel;
import builderGUI.BuilderEditorGUI;

//TODO: add some way to know which square the letter is in!! then add the letter to that square

public class BuilderAddLetterController implements ActionListener {
	BuilderEditorGUI builderEditorView;
	int row, col;
	BuilderLevel level;
	
	public BuilderAddLetterController(BuilderEditorGUI builderEditorView, int row, int col){
		this.builderEditorView = builderEditorView;
		this.row = row; 
		this.col = col;
		this.level = builderEditorView.getLevel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		input = input.trim();
		System.out.println(input);
		if(isValidLetter(input)){
			BuilderLetter letter  = new BuilderLetter(input);
			level.getBoard().getSquare(row, col).setLetter(letter);
			builderEditorView.refresh(level);
		}
		else{
			System.out.println("invalid Letter entered");
			builderEditorView.refresh(level);
		}
		
		
	}
	
	private boolean isValidLetter(String input){
		boolean validLetter = false;
		for(int i = 0; i < input.length(); i++){
			if ((input.charAt(i) >= 'A') && (input.charAt(i) <= 'Z') || (input.charAt(i) >= 'a') && (input.charAt(i) <= 'z')){
				validLetter = true;
			}
			else{
				return false;
			}
		}
		return validLetter;
	}

}
