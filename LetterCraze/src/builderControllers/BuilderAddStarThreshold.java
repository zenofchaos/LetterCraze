package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderLevel;
import builderGUI.BuilderEditorGUI;

public class BuilderAddStarThreshold implements ActionListener {
	BuilderEditorGUI builderEditorView;
	//BuilderLevel level;
	int starNum;
	
	public BuilderAddStarThreshold(BuilderEditorGUI builderEditorView, int starNum){
		this.builderEditorView = builderEditorView;
		//this.level = builderEditorView.l();
		this.starNum = starNum;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	String threshold = e.getActionCommand();
	//TODO: add way to determine if input can be converted to int or not, check for invalid input
	int starThreshold = Integer.parseInt(threshold);
	System.out.println(starThreshold);
	}
	
}
