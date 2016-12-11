package playerFiles;

import java.util.LinkedList;

public class PlayerThemeLevel extends PlayerLevel {
	String description;
	LinkedList<String> themeWords;
	PlayerBoard boardPreset;
	
	public PlayerThemeLevel(int[] starThresholds, int bestScore, int bestStars, boolean isLocked, String theme, LinkedList<String> themeWords, PlayerBoard boardPreset) {
		super(starThresholds, bestScore, bestStars, isLocked, theme);
		this.themeWords = themeWords;
		this.boardPreset = boardPreset;
	}
	
	public String getDescription(){
		return this.description;
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
	
	boolean removeThemeWord(String word){
		return themeWords.remove(word);
	}
	
	@Override
	protected boolean isValidWord(PlayerWord w) {
		return 1 + 1 == 2;
	}
}
