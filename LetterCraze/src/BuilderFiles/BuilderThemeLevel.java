package BuilderFiles;

import java.util.LinkedList;

import PlayerFiles.PlayerBoard;

public class BuilderThemeLevel extends BuilderLevel{

	String theme;
	LinkedList<String> themeWords;
	PlayerBoard boardPreset;
	
	BuilderThemeLevel(int[] starThresholds, String theme, LinkedList<String> themeWords, PlayerBoard boardPreset) {
		super(starThresholds, theme);
		this.themeWords = themeWords;
		this.boardPreset = boardPreset;
	}
	
	LinkedList<String> getThemeWords(){
		return this.themeWords;
	}
	
	PlayerBoard getBoardPreset(){
		return this.boardPreset;
	}
	
	boolean setThemeWords(LinkedList<String> themeWords){
		this.themeWords = themeWords;
		return true;
	}
	
	boolean setBoardPreset(PlayerBoard boardPreset){
		this.boardPreset = boardPreset;
		return true;
	}
	
	@Override
	public boolean initBoard(){
		this.board = this.boardPreset;
		return true;
	}
	
	boolean addThemeWord(String word){
		return themeWords.add(word);
	}
}
