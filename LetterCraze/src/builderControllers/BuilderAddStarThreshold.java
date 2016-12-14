package builderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builderFiles.BuilderLevel;
import builderGUI.BuilderEditorGUI;

//TODO: add the threshold to the level passed in, and actually pass in the level

public class BuilderAddStarThreshold implements ActionListener {
	BuilderEditorGUI builderEditorView;
	BuilderLevel level;
	int starNum;
	
	public BuilderAddStarThreshold(BuilderEditorGUI builderEditorView, int starNum){
		this.builderEditorView = builderEditorView;
		this.level = builderEditorView.getLevel();
		this.starNum = starNum;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String threshold = e.getActionCommand();
		threshold = threshold.trim();
		boolean validNum = false;
		for(int i = 0; i < threshold.length(); i++){
			if ((threshold.charAt(i) >= '0') && (threshold.charAt(i) <= '9')){
				validNum = true;
			}
			else{
				validNum = false;
				break;
			}
		}
		if (validNum){
			int starThreshold = Integer.parseInt(threshold);
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
