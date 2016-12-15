package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderGUI.BuilderPreviewGUI;

// TODO: Auto-generated Javadoc
/**
 * The Class BuilderPreviewBackController.
 */
public class BuilderPreviewBackController implements ActionListener {
	
	/** The gui. */
	BuilderPreviewGUI gui;
	
	/**
	 * Instantiates a new builder preview back controller.
	 *
	 * @param gui the gui
	 */
	public BuilderPreviewBackController(BuilderPreviewGUI gui){
		this.gui = gui;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		gui.closeWindow();

	}

}
