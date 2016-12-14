package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderGUI.BuilderEditorGUI;

//TODO: actually add the title to the level object that also needs to be passed to the controller

public class BuilderAddTitle implements ActionListener {
	BuilderEditorGUI builderEditorView;
	
	public BuilderAddTitle(BuilderEditorGUI builderEditorView){
		this.builderEditorView = builderEditorView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	String title = e.getActionCommand();
	title.trim();
	System.out.println(title);
	}

	
}
