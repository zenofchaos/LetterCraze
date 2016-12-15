package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import playerFiles.PlayerBoard;
import playerFiles.PlayerLevel;
import playerFiles.PlayerThemeLevel;
import playerFiles.PlayerWord;
import playerGUI.PlayerLevelGUI;

public class PlayerUndoController implements ActionListener{

	PlayerLevelGUI levelView;
	PlayerLevel level;
	
	public PlayerUndoController(PlayerLevelGUI window){
		this.levelView = window;
		this.level = levelView.getLevel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		undoSubmission();
		
		this.levelView.refresh(this.level);
	}

	private void undoSubmission(){
		//extract the last word submitted
		ArrayList<PlayerWord> wordsEntered = this.level.getWordsEntered();
		
		if(wordsEntered.size() == 0){
			return;
		}
		
		PlayerWord toUndo = wordsEntered.remove(wordsEntered.size() - 1);
		//update the level to reflect this extraction
		this.level.setWordsEntered(wordsEntered);
		
		if(this.level instanceof PlayerThemeLevel){
			LinkedList<String> themeWords = ((PlayerThemeLevel)this.level).getThemeWords();
			themeWords.add(toUndo.getWord());
			((PlayerThemeLevel)this.level).setThemeWords(themeWords);
		}
		
		//add the extracted word back to the board
		PlayerBoard theBoard = this.level.getBoard();
		this.level.setBoard(theBoard.addWord(toUndo));
		
		this.level.setPointScore(this.level.getPointScore() - this.level.wordScore(toUndo));
		if (this.level.getPointScore() >= this.level.getStarThresholds()[2]){
			this.level.setStarCount(3);
		}
		else if (this.level.getPointScore() >= this.level.getStarThresholds()[1]){
			this.level.setStarCount(2);
		}
		else if (this.level.getPointScore() >= this.level.getStarThresholds()[0]){
			this.level.setStarCount(1);
		}
		else{
			this.level.setStarCount(0);
		}
	}
}
