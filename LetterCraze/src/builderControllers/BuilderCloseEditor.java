package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderGUI.BuilderEditorGUI;
import builderGUI.BuilderNewLevelGUI;

public class BuilderCloseEditor implements ActionListener{
	BuilderEditorGUI editorView;
	
	public BuilderCloseEditor(BuilderEditorGUI editorView) {
		this.editorView = editorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Close menu window
		editorView.closeWindow();
		//Generate the model
		//FileAccessController fileAccess = new FileAccessController(new PlayerMenu());
		//PlayerModel model = fileAccess.getModel();th
		//BuilderEditorGUI selectView = new BuilderEditorGUI();
		//selectView.openWindow();
	}
	
	
}
