package playerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import playerFiles.PlayerBoard;
import playerFiles.PlayerLevel;
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
		
		//add the extracted word back to the board
		PlayerBoard theBoard = this.level.getBoard();
		this.level.setBoard(theBoard.addWord(toUndo));
	}
}
