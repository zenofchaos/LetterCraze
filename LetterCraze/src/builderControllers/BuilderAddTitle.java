package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderLevel;
import builderGUI.BuilderEditorGUI;

// TODO: Auto-generated Javadoc
//TODO: actually add the title to the level object that also needs to be passed to the controller

/**
 * The Class BuilderAddTitle.
 */
public class BuilderAddTitle implements ActionListener {
	
	/** The builder editor view. */
	BuilderEditorGUI builderEditorView;
	
	/** The level. */
	BuilderLevel level;
	
	/**
	 * Instantiates a new builder add title.
	 *
	 * @param builderEditorView the builder editor view
	 */
	public BuilderAddTitle(BuilderEditorGUI builderEditorView){
		this.builderEditorView = builderEditorView;
		this.level = builderEditorView.getLevel();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	String title = e.getActionCommand();
	title.trim();
	addTitle(title);
	}
	
	/**
	 * Adds the title.
	 *
	 * @param title the title
	 */
	void addTitle(String title){
		level.setTitle(title);
		builderEditorView.refresh(level);
		
	}

	
}
