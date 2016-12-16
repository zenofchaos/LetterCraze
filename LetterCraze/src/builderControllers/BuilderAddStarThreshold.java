package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderLevel;
import builderGUI.BuilderEditorGUI;

// TODO: Auto-generated Javadoc
//TODO: add the threshold to the level passed in, and actually pass in the level

/**
 * The Class BuilderAddStarThreshold.
 */
public class BuilderAddStarThreshold implements ActionListener {
	
	/** The builder editor view. */
	BuilderEditorGUI builderEditorView;
	
	/** The level. */
	BuilderLevel level;
	
	/** The star num. */
	int starNum;
	
	/**
	 * Instantiates a new builder add star threshold.
	 *
	 * @param builderEditorView the builder editor view
	 * @param starNum the star num
	 */
	public BuilderAddStarThreshold(BuilderEditorGUI builderEditorView, int starNum){
		this.builderEditorView = builderEditorView;
		this.level = builderEditorView.getLevel();
		this.starNum = starNum;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String threshold = e.getActionCommand();
		threshold = threshold.trim();
		setStar(threshold);
	}
	
	public void setStar(String input){
		boolean validNum = false;
		for(int i = 0; i < input.length(); i++){
			if ((input.charAt(i) >= '0') && (input.charAt(i) <= '9')){
				validNum = true;
			}
			else{
				validNum = false;
				break;
			}
		}
		if (validNum){
			int starThreshold = Integer.parseInt(input);
			System.out.println(starThreshold);
			int[] thresholds = level.getStarThresholds();
			thresholds[starNum] = starThreshold;
			level.setStarThresholds(thresholds);
			builderEditorView.refresh(level);
			
		}
		else{ 
			builderEditorView.refresh(level);
			System.out.println("star Threshold value entered not a valid number");
		}
	}
}
