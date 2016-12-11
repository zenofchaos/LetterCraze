package builderControllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import builderGUI.BuilderEditorGUI;

//TODO: add some way to get which panel was clicked on 

public class BuilderActivateSquareController implements MouseListener{
	BuilderEditorGUI builderEditorView;
	
	public BuilderActivateSquareController(BuilderEditorGUI builderEditorView){
		this.builderEditorView = builderEditorView;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//use the panel identifier to get the square clicked
		// toggle the activity info for that square
		//refresh the view
		
		
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
