package builderFiles;

import java.util.LinkedList;

public class BuilderThemeLevel extends BuilderLevel{

	String description;
	LinkedList<String> themeWords;
	BuilderBoard boardPreset;
	
	public BuilderThemeLevel(int[] starThresholds, String theme, LinkedList<String> themeWords, BuilderBoard boardPreset) {
		super(starThresholds, theme);
		this.themeWords = themeWords;
		this.boardPreset = boardPreset;
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
	
	boolean setThemeWords(LinkedList<String> themeWords){
		this.themeWords = themeWords;
		return true;
	}
	
	boolean setBoardPreset(BuilderBoard boardPreset){
		this.boardPreset = boardPreset;
		return true;
	}
	
	@Override
	public boolean initBoard(){
		this.board = this.boardPreset;
		return true;
	}
	
	public boolean addThemeWord(String word){
		return themeWords.add(word);
	}
}
