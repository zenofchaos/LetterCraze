package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderGUI.BuilderPreviewGUI;

public class BuilderPreviewBackController implements ActionListener {
	BuilderPreviewGUI gui;
	
	public BuilderPreviewBackController(BuilderPreviewGUI gui){
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gui.closeWindow();

	}

}
