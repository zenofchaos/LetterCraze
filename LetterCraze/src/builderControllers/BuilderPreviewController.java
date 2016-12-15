package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderGUI.BuilderEditorGUI;
import builderGUI.BuilderPreviewGUI;

public class BuilderPreviewController implements ActionListener {
	BuilderEditorGUI builderView;
	
	public BuilderPreviewController(BuilderEditorGUI builderView){
		this.builderView = builderView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//builderView.closeWindow();
		BuilderPreviewGUI window = new BuilderPreviewGUI(builderView.getLevel());
		window.getLevel().initBoard();
		window.openWindow();

	}

}
