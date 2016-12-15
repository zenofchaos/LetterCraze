package builderControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.SwingUtilities;

import builderFiles.BuilderThemeLevel;
import builderGUI.BuilderEditorGUI;

public class BuilderRemoveWordController implements MouseListener {
	BuilderEditorGUI editorView;
	int index;
	BuilderThemeLevel level;
	
	public BuilderRemoveWordController(BuilderEditorGUI editorView, int index){
		this.editorView = editorView;
		this.index = index;
		this.level = (BuilderThemeLevel) editorView.getLevel();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(SwingUtilities.isRightMouseButton(e)){
			LinkedList<String> list = level.getThemeWords();
			list.remove(index);
			level.setThemeWords(list);
			editorView.refresh(level);
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
