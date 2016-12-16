package builderControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.SwingUtilities;

import builderFiles.BuilderThemeLevel;
import builderGUI.BuilderEditorGUI;

/**
 * The Class BuilderRemoveWordController removes a word from the word list in the theme builder.
 */
public class BuilderRemoveWordController implements MouseListener {
	
	/** The editor view. */
	BuilderEditorGUI editorView;
	
	/** The index. */
	int index;
	
	/** The level. */
	BuilderThemeLevel level;
	
	/**
	 * Instantiates a new builder remove word controller.
	 *
	 * @param editorView the editor view
	 * @param index the index
	 */
	public BuilderRemoveWordController(BuilderEditorGUI editorView, int index){
		this.editorView = editorView;
		this.index = index;
		this.level = (BuilderThemeLevel) editorView.getLevel();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if(SwingUtilities.isRightMouseButton(e)){
			LinkedList<String> list = level.getThemeWords();
			list.remove(index);
			level.setThemeWords(list);
			editorView.refresh(level);
		}

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
