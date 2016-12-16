package builderFiles;

import java.util.LinkedList;

import playerFiles.PlayerBoard;
import playerFiles.PlayerSquare;

/**
 * The Class BuilderThemeLevel is a theme level for the builder.
 */
public class BuilderThemeLevel extends BuilderLevel{

	/** The description. */
	String description;
	
	/** The theme words. */
	LinkedList<String> themeWords;
	
	/** The board preset. */
	BuilderBoard boardPreset;
	
	/**
	 * Instantiates a new builder theme level.
	 *
	 * @param starThresholds the star thresholds
	 * @param theme the theme
	 * @param description the description
	 * @param themeWords the theme words
	 * @param boardPreset the board preset
	 */
	public BuilderThemeLevel(int[] starThresholds, String theme, String description, LinkedList<String> themeWords, BuilderBoard boardPreset) {
		super(starThresholds, theme);
		this.themeWords = themeWords;
		this.boardPreset = boardPreset;
		this.description = description;
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Gets the theme words.
	 *
	 * @return the theme words
	 */
	public LinkedList<String> getThemeWords(){
		return this.themeWords;
	}
	
	/**
	 * Gets the board preset.
	 *
	 * @return the board preset
	 */
	public BuilderBoard getBoardPreset(){
		return this.boardPreset;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the description
	 * @return true, if successful
	 */
	public boolean setDescription(String description){
		this.description = description;
		return true;
		
	}
	
	/**
	 * Sets the theme words.
	 *
	 * @param themeWords the theme words
	 * @return true, if successful
	 */
	public boolean setThemeWords(LinkedList<String> themeWords){
		this.themeWords = themeWords;
		return true;
	}
	
	/**
	 * Sets the board preset.
	 *
	 * @param boardPreset the board preset
	 * @return true, if successful
	 */
	boolean setBoardPreset(BuilderBoard boardPreset){
		this.boardPreset = boardPreset;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see builderFiles.BuilderLevel#initBoard()
	 */
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
	
	/**
	 * Adds the theme word.
	 *
	 * @param word the word
	 * @return true, if successful
	 */
	public boolean addThemeWord(String word){
		return themeWords.add(word);
	}
}
