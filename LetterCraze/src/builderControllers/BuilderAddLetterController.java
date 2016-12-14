package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderLevel;
import builderGUI.BuilderEditorGUI;

//TODO: add some way to know which square the letter is in!! then add the letter to that square

public class BuilderAddLetterController implements ActionListener {
	BuilderEditorGUI builderEditorView;
	int row, col;
	BuilderLevel level;
	
	public BuilderAddLetterController(BuilderEditorGUI builderEditorView, int col, int row){
		this.builderEditorView = builderEditorView;
		this.row = row; 
		this.col = col;
		this.level = builderEditorView.getLevel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String letter = e.getActionCommand();
		letter = letter.trim();
		System.out.println(letter);
		
		
	}

}
