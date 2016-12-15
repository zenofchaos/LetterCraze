package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderLevel;
import builderGUI.BuilderEditorGUI;

//TODO: actually add the title to the level object that also needs to be passed to the controller

public class BuilderAddTitle implements ActionListener {
	BuilderEditorGUI builderEditorView;
	BuilderLevel level;
	
	public BuilderAddTitle(BuilderEditorGUI builderEditorView){
		this.builderEditorView = builderEditorView;
		this.level = builderEditorView.getLevel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	String title = e.getActionCommand();
	title.trim();
	addTitle(title);
	}
	
	void addTitle(String title){
		level.setTitle(title);
		builderEditorView.refresh(level);
		
	}

	
}
