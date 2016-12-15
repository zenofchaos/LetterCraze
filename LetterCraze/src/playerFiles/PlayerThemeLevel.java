package playerFiles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerThemeLevel.
 */
public class PlayerThemeLevel extends PlayerLevel {
	
	/** The description. */
	String description;
	
	/** The theme words. */
	LinkedList<String> themeWords;
	
	/** The board preset. */
	PlayerBoard boardPreset;

	/**
	 * Instantiates a new player theme level.
	 *
	 * @param starThresholds the star thresholds
	 * @param bestScore the best score
	 * @param bestStars the best stars
	 * @param isLocked the is locked
	 * @param theme the theme
	 * @param description the description
	 * @param themeWords the theme words
	 * @param boardPreset the board preset
	 */
	public PlayerThemeLevel(int[] starThresholds, int bestScore, int bestStars, boolean isLocked, String theme,
			String description, LinkedList<String> themeWords, PlayerBoard boardPreset) {
		super(starThresholds, bestScore, bestStars, isLocked, theme);
		this.description = description;
		this.themeWords = themeWords;
		this.boardPreset = boardPreset;
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
	public LinkedList<String> getThemeWords() {
		return this.themeWords;
	}

	/**
	 * Gets the board preset.
	 *
	 * @return the board preset
	 */
	public PlayerBoard getBoardPreset() {
		return this.boardPreset;
	}

	/**
	 * Sets the theme words.
	 *
	 * @param themeWords the theme words
	 * @return true, if successful
	 */
	public boolean setThemeWords(LinkedList<String> themeWords) {
		this.themeWords = themeWords;
		return true;
	}

	/**
	 * Sets the board preset.
	 *
	 * @param boardPreset the board preset
	 * @return true, if successful
	 */
	public boolean setBoardPreset(PlayerBoard boardPreset) {
		this.boardPreset = boardPreset;
		return true;
	}

	/* (non-Javadoc)
	 * @see playerFiles.PlayerLevel#initBoard()
	 */
	@Override
	public boolean initBoard() {
		if (this.board != null) {
		} else { // This means the board doesn't exist. go through and make all
					// the squares real quick before continuing.
			PlayerSquare[][] emptyarray = new PlayerSquare[6][6];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					emptyarray[i][j] = new PlayerSquare(i, j);
				}
			}
			PlayerBoard board = new PlayerBoard(emptyarray);
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
	boolean addThemeWord(String word) {
		return themeWords.add(word);
	}

	/**
	 * Removes the theme word.
	 *
	 * @param word the word
	 * @return true, if successful
	 */
	boolean removeThemeWord(String word) {
		return themeWords.remove(word);
	}

	/* (non-Javadoc)
	 * @see playerFiles.PlayerLevel#isValidWord(playerFiles.PlayerWord)
	 */
	@Override
	public boolean isValidWord(PlayerWord w) {
		String toMatch = w.getWord();
		Iterator<String> iterator = themeWords.iterator();

		while (iterator.hasNext()) {
			if (iterator.next().equals(toMatch)) {
				return true;
			}
		}
		return false;
	}

	// Only the number of words matters for lightning levels,
	/* (non-Javadoc)
	 * @see playerFiles.PlayerLevel#wordScore(playerFiles.PlayerWord)
	 */
	// so their point values are all 1
	@Override
	public int wordScore(PlayerWord w) {
		return 1;
	}

	/* (non-Javadoc)
	 * @see playerFiles.PlayerLevel#reset()
	 */
	@Override
	public void reset() {
		this.initBoard();
		this.pointScore = 0;
		this.selectedWord = new PlayerWord();
		this.starCount = 0;
		for(int i = 0; i < this.wordsEntered.size(); i++){
			this.themeWords.add(wordsEntered.get(i).getWord());
		}
		this.wordsEntered = new ArrayList<PlayerWord>();
	}
	
	/* (non-Javadoc)
	 * @see playerFiles.PlayerLevel#submitSelectedWord()
	 */
	@Override
	public boolean submitSelectedWord() {
		System.out.println(selectedWord.getWord());
		if (isValidWord(selectedWord)) {
			wordsEntered.add(selectedWord);
			pointScore += wordScore(selectedWord);
			if (pointScore >= starThresholds[2]){
				starCount = 3;
			}
			else if (pointScore >= starThresholds[1]){
				starCount = 2;
			}
			else if (pointScore >= starThresholds[0]){
				starCount = 1;
			}
			
			boolean wordFound = false;
			int index = 0;
			while (!wordFound && (index < this.themeWords.size())){
				if(selectedWord.getWord().equals(this.themeWords.get(index))){
					wordFound = true;
					this.themeWords.remove(index);
				}
				index++;
			}
			
			if(!wordFound){
				System.out.println("Selected Word not found in Theme Words");
			}
			
			this.board.removeWord(selectedWord);
			this.board.rise();
			
			selectedWord = new PlayerWord();
			return true;
		} else {
			return false;
		}
	}
}
