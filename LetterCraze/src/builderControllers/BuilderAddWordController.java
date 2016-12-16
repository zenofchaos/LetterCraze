package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import builderFiles.BuilderLetter;
import builderFiles.BuilderThemeLevel;
import builderGUI.BuilderEditorGUI;

/**
 * The Class BuilderAddWordController adds a word to the wordlist for the theme editor.
 */
public class BuilderAddWordController implements ActionListener {
	
	/** The editor view. */
	BuilderEditorGUI editorView;
	
	/** The level. */
	BuilderThemeLevel level;

	/**
	 * Instantiates a new builder add word controller.
	 *
	 * @param editorView the editor view
	 */
	public BuilderAddWordController(BuilderEditorGUI editorView){
		this.editorView = editorView;
		this.level = (BuilderThemeLevel) editorView.getLevel();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		input = input.trim();
		if(isValidInput(input)){
			level.addThemeWord(input);
			editorView.refresh(level);
		}
		else{
			System.out.println("invalid Letter entered");
			editorView.refresh(level);
		}
	}

	/**
	 * Checks if is valid input, must be all a-z characters.
	 *
	 * @param input the input
	 * @return true, if is valid input
	 */
	private boolean isValidInput(String input){
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
