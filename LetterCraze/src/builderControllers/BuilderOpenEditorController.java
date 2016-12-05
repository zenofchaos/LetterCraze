package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderMenu;
import builderGUI.BuilderEditorGUI;
import builderGUI.BuilderMainMenuGUI;
import builderGUI.BuilderNewLevelGUI;

public class BuilderOpenEditorController implements ActionListener{

	BuilderNewLevelGUI editorView;
	
	public BuilderOpenEditorController(BuilderNewLevelGUI editorView) {
		this.editorView = editorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Close menu window
		//editorView.closeWindow();
		//Generate the model
		//FileAccessController fileAccess = new FileAccessController(new PlayerMenu());
		//PlayerModel model = fileAccess.getModel();th
		BuilderEditorGUI selectView = new BuilderEditorGUI();
		selectView.openWindow();
	}
}
