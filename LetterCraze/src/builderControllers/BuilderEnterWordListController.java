package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;

import builderFiles.BuilderThemeLevel;
import builderGUI.BuilderEditorGUI;

//TODO: not sure it's really an action listener, how do we want the enter functionality to work here?

public class BuilderEnterWordListController implements ActionListener {
	BuilderEditorGUI builderEditorView;
	String textField;
	BuilderThemeLevel level;
	
	public BuilderEnterWordListController(BuilderEditorGUI builderEditorView, String textField){
		this.builderEditorView = builderEditorView;
		this.textField = textField;
		this.level = (BuilderThemeLevel) builderEditorView.getLevel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String eol = System.getProperty("line.separator");
		String lines[] = textField.split(eol);
		System.out.println(textField);
		LinkedList<String> linesList = new LinkedList<String>();
		for(int i=0; i < lines.length; i++){
			linesList.add(lines[i]);
			System.out.println(lines[i]);
		}
		level.setThemeWords(linesList);
		builderEditorView.refresh(level);
		
	}

}
