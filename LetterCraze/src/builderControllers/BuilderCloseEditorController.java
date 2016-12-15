package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderMenu;
import builderGUI.BuilderEditorGUI;
import builderGUI.BuilderSelectLevelGUI;

// TODO: Auto-generated Javadoc
/**
 * The Class BuilderCloseEditorController.
 */
public class BuilderCloseEditorController implements ActionListener{
	
	/** The editor view. */
	BuilderEditorGUI editorView;
	
	/**
	 * Instantiates a new builder close editor controller.
	 *
	 * @param editorView the editor view
	 */
	public BuilderCloseEditorController(BuilderEditorGUI editorView) {
		this.editorView = editorView;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
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
