package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import builderFiles.BuilderLetter;
import builderFiles.BuilderThemeLevel;
import builderGUI.BuilderEditorGUI;

public class BuilderAddWordController implements ActionListener {
	BuilderEditorGUI editorView;
	BuilderThemeLevel level;

	public BuilderAddWordController(BuilderEditorGUI editorView){
		this.editorView = editorView;
		this.level = (BuilderThemeLevel) editorView.getLevel();
	}

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
