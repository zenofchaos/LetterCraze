package builderControllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import builderFiles.BuilderThemeLevel;
import builderGUI.BuilderEditorGUI;

public class BuilderAddWordController implements KeyListener {
	BuilderEditorGUI editorView;
	BuilderThemeLevel level;
	
	public BuilderAddWordController(BuilderEditorGUI editorView){
		this.editorView = editorView;
		this.level = (BuilderThemeLevel) editorView.getLevel();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			String eol = System.getProperty("line.separator");
			System.out.println("HERE");
			System.out.println(editorView.getTextArea().getText());
			String lines[] = editorView.getTextArea().getText().split(eol);
			LinkedList<String> linesList = new LinkedList<String>();
			for(int i=0; i < lines.length; i++){
				linesList.add(lines[i]);
				System.out.println(lines[i]);
			}
			level.setThemeWords(linesList);
			editorView.refresh(level);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
