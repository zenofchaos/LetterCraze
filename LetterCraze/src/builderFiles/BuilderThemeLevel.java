package builderFiles;

import java.util.LinkedList;

import playerFiles.PlayerBoard;
import playerFiles.PlayerSquare;

public class BuilderThemeLevel extends BuilderLevel{

	String description;
	LinkedList<String> themeWords;
	BuilderBoard boardPreset;
	
	public BuilderThemeLevel(int[] starThresholds, String theme, String description, LinkedList<String> themeWords, BuilderBoard boardPreset) {
		super(starThresholds, theme);
		this.themeWords = themeWords;
		this.boardPreset = boardPreset;
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public LinkedList<String> getThemeWords(){
		return this.themeWords;
	}
	
	public BuilderBoard getBoardPreset(){
		return this.boardPreset;
	}
	
	public boolean setDescription(String description){
		this.description = description;
		return true;
		
	}
	public boolean setThemeWords(LinkedList<String> themeWords){
		this.themeWords = themeWords;
		return true;
	}
	
	boolean setBoardPreset(BuilderBoard boardPreset){
		this.boardPreset = boardPreset;
		return true;
	}
	
	@Override
	public boolean initBoard(){
		if (this.board != null) {
		} else { // This means the board doesn't exist. go through and make all
					// the squares real quick before continuing.
			BuilderSquare[][] emptyarray = new BuilderSquare[6][6];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					emptyarray[i][j] = new BuilderSquare(i, j);
				}
			}
			BuilderBoard board = new BuilderBoard(emptyarray);
			this.setBoard(board);
		}

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				this.board.getSquareArray()[i][j].setLetter(this.boardPreset.getSquareArray()[i][j].getLetter());
				this.board.getSquareArray()[i][j].setActive(this.boardPreset.getSquareArray()[i][j].getActive());
			}
		}
		this.board.replace();
		return true;
	}
	
	public boolean addThemeWord(String word){
		return themeWords.add(word);
	}
}
