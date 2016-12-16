package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderGUI.BuilderEditorGUI;
import builderGUI.BuilderPreviewGUI;

// TODO: Auto-generated Javadoc
/**
 * The Class BuilderPreviewController.
 */
public class BuilderPreviewController implements ActionListener {
	
	/** The builder view. */
	BuilderEditorGUI builderView;
	
	/**
	 * Instantiates a new builder preview controller.
	 *
	 * @param builderView the builder view
	 */
	public BuilderPreviewController(BuilderEditorGUI builderView){
		this.builderView = builderView;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//builderView.closeWindow();
		BuilderPreviewGUI window = new BuilderPreviewGUI(builderView.getLevel());
		window.getLevel().initBoard();
		window.openWindow();

	}

}
