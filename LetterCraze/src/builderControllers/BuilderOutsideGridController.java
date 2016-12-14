package builderControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import builderGUI.BuilderEditorGUI;

import builderFiles.BuilderLevel;

public class BuilderOutsideGridController implements MouseListener {

	BuilderEditorGUI levelView;
	int row;
	int col;
	
	public BuilderOutsideGridController(BuilderEditorGUI window){
		this.levelView = window;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		//levelView.refresh(l());
	}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	private BuilderLevel l() {
		return levelView.getLevel();
	}
}