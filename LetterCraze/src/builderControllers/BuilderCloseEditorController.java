package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderGUI.BuilderEditorGUI;
import builderGUI.BuilderSelectLevelGUI;

public class BuilderCloseEditorController implements ActionListener{
	BuilderEditorGUI editorView;
	
	public BuilderCloseEditorController(BuilderEditorGUI editorView) {
		this.editorView = editorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		editorView.closeWindow();
	}
	
	
}
