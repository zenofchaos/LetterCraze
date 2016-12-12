package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderMenu;
import builderFiles.BuilderModel;
import builderGUI.BuilderEditorGUI;
import builderGUI.BuilderMainMenuGUI;
import builderGUI.BuilderSelectLevelGUI;

public class BuilderOpenEditorController implements ActionListener{

	BuilderSelectLevelGUI editorView;
	
	public BuilderOpenEditorController(BuilderSelectLevelGUI editorView) {
		this.editorView = editorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Close menu window
		//editorView.closeWindow();
		//Generate the model
		//BuilderFileAccessController fileAccess = new BuilderFileAccessController(new BuilderMenu());
		//BuilderModel model = fileAccess.getModel();
		//BuilderEditorGUI selectView = new BuilderEditorGUI(model);
		//selectView.openWindow();
	}
}
