package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderLetter;
import builderFiles.BuilderLevel;
import builderGUI.BuilderEditorGUI;


/**
 * The Class BuilderAddLetterController is the controller that adds a letter to a desired square for the theme builder.
 */
public class BuilderAddLetterController implements ActionListener {
	
	/** The builder editor view. */
	BuilderEditorGUI builderEditorView;
	
	/** The col. */
	int row, col;
	
	/** The level. */
	BuilderLevel level;

	/**
	 * Instantiates a new builder add letter controller.
	 *
	 * @param builderEditorView the builder editor view
	 * @param row the row
	 * @param col the col
	 */
	public BuilderAddLetterController(BuilderEditorGUI builderEditorView, int row, int col){
		this.builderEditorView = builderEditorView;
		this.row = row; 
		this.col = col;
		this.level = builderEditorView.getLevel();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		input = input.trim();
		if(addLetter(input)){
			return;
		}
		else{
			System.out.println("Builder add letter controller failed");
		}


	}

	/**
	 * Checks if is valid letter, must by one letter capital or lowercase or a qu in any capital/lowercase arrangement.
	 *
	 * @param input the input
	 * @return true, if is valid letter
	 */
	boolean isValidLetter(String input){
		if((input.length() == 1)){
			if ((input.charAt(0) >= 'A') && (input.charAt(0) <= 'Z') || (input.charAt(0) >= 'a') && (input.charAt(0) <= 'z')){
				return true;
			}
		}
		else if ((input.length() == 2)){
			if((input.equals("QU")) || (input.equals("Qu")) || (input.equals("qU")) || (input.equals("qu"))){
				return true;
			}
			else{
				return false;
			}
		}
		else if ((input.length() == 0)){
			return true;
		}
		
		else{
			return false;
		}
		return false;
	}
	
	/**
	 * Adds the letter.
	 *
	 * @param input the input
	 * @return true, if successful
	 */
	boolean addLetter(String input){
		System.out.println(input);
		if(isValidLetter(input)){
			if(input.length() == 0){
				level.getBoard().getSquare(row, col).setLetter(null);
				builderEditorView.refresh(level);
				return true;
			}
			else if((input.charAt(0) == 'Q')|| (input.charAt(0) == 'q')){
				BuilderLetter letter  = new BuilderLetter("qu");
				level.getBoard().getSquare(row, col).setLetter(letter);
				builderEditorView.refresh(level);
				return true;
			}
			else{
				BuilderLetter letter  = new BuilderLetter(input);
				level.getBoard().getSquare(row, col).setLetter(letter);
				builderEditorView.refresh(level);
				return true;
			}
		}
		else{
			System.out.println("invalid Letter entered");
			builderEditorView.refresh(level);
			return false;
		}
	}

}
