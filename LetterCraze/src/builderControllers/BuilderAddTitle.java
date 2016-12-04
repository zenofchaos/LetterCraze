package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderGUI.BuilderEditorGUI;

public class BuilderAddTitle implements ActionListener {
	BuilderEditorGUI builderEditorView;
	
	public BuilderAddTitle(BuilderEditorGUI builderEditorView){
		this.builderEditorView = builderEditorView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	String title = e.getActionCommand();
	System.out.println(title);
	}
	
}
