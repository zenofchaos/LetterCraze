package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderGUI.BuilderEditorGUI;

public class BuilderSaveController implements ActionListener{
	BuilderEditorGUI editorView;
	
	public BuilderSaveController(BuilderEditorGUI editorView) {
		this.editorView = editorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("save button pressed");
		// code goes here to save the level information
		editorView.closeWindow();
	}

}
