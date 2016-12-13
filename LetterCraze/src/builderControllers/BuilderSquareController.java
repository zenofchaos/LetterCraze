package builderControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import builderFiles.BuilderLevel;
import builderFiles.BuilderSquare;
import builderGUI.BuilderEditorGUI;

public class BuilderSquareController implements MouseListener {

	BuilderEditorGUI levelView;
	int row;
	int col;
	
	public BuilderSquareController(BuilderEditorGUI window, int i, int j){
		this.levelView = window;
		this.row = i;
		this.col = j;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e) && ((e.getModifiers() == MouseEvent.BUTTON1_MASK))) {
			toggle();
			levelView.refresh(l());
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			toggle();
			levelView.refresh(l());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	private BuilderLevel l() {
		return levelView.getLevel();
	}
	
	private BuilderSquare thisSquare() {
		return l().getBoard().getSquareArray()[row][col];
	}
	
	private void toggle() {
		thisSquare().setActive(!(thisSquare().getActive()));
	}
	
}