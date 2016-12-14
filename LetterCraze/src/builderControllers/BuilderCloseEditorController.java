package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderMenu;
import builderGUI.BuilderEditorGUI;
import builderGUI.BuilderSelectLevelGUI;

public class BuilderCloseEditorController implements ActionListener{
	BuilderEditorGUI editorView;
	
	public BuilderCloseEditorController(BuilderEditorGUI editorView) {
		this.editorView = editorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BuilderFileAccessController access = new BuilderFileAccessController();
		BuilderMenu menu = new BuilderMenu();
		try {
			menu = access.getModel().getMenu();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		BuilderSelectLevelGUI window = new BuilderSelectLevelGUI(menu);
		window.openWindow();
		editorView.closeWindow();
		
	}
	
	
}
