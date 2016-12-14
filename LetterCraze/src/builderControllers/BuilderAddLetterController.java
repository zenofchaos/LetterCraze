package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderGUI.BuilderEditorGUI;

//TODO: add some way to know which square the letter is in!! then add the letter to that square

public class BuilderAddLetterController implements ActionListener {
	BuilderEditorGUI builderEditorView;
	
	public BuilderAddLetterController(BuilderEditorGUI builderEditorView){
		this.builderEditorView = builderEditorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String letter = e.getActionCommand();
		letter = letter.trim();
		
	}

}
