package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderGUI.BuilderEditorGUI;

//TODO: not sure it's really an action listener, how do we want the enter functionality to work here?

public class BuilderEnterWordListController implements ActionListener {
	BuilderEditorGUI builderEditorView;
	
	public BuilderEnterWordListController(BuilderEditorGUI builderEditorView){
		this.builderEditorView = builderEditorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String wordList = e.getActionCommand();
		System.out.println(wordList);
		
	}

}
