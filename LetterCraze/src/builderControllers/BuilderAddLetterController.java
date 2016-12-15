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
			if((input.charAt(0) == 'Q')|| (input.charAt(0) == 'q')){
				BuilderLetter letter  = new BuilderLetter("qu");
				level.getBoard().getSquare(row, col).setLetter(letter);
				builderEditorView.refresh(level);
			}
			else{
				BuilderLetter letter  = new BuilderLetter(input);
				level.getBoard().getSquare(row, col).setLetter(letter);
				builderEditorView.refresh(level);
			}
		}
		else{
			System.out.println("invalid Letter entered");
			builderEditorView.refresh(level);
		}


	}

	private boolean isValidLetter(String input){
		if((input.length() == 1)){
			if ((input.charAt(0) >= 'A') && (input.charAt(0) <= 'Z') || (input.charAt(0) >= 'a') && (input.charAt(0) <= 'z')){
				System.out.println("HERE");
				return true;
			}
		}
		else if ((input.length() == 2)){
			if((input.equals("QU")) || (input.equals("Qu")) || (input.equals("qU")) || (input.equals("qu"))){
				System.out.println("HERE1");
				return true;
			}
			else{
				System.out.println("HERE2");
				return false;
			}
		}
		else{
			System.out.println("HERE3");
			return false;
		}
		return false;
	}

}
