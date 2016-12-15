package playerFiles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class PlayerThemeLevel extends PlayerLevel {
	String description;
	LinkedList<String> themeWords;
	PlayerBoard boardPreset;

	public PlayerThemeLevel(int[] starThresholds, int bestScore, int bestStars, boolean isLocked, String theme,
			String description, LinkedList<String> themeWords, PlayerBoard boardPreset) {
		super(starThresholds, bestScore, bestStars, isLocked, theme);
		this.description = description;
		this.themeWords = themeWords;
		this.boardPreset = boardPreset;
	}

	public String getDescription() {
		return this.description;
	}

	public LinkedList<String> getThemeWords() {
		return this.themeWords;
	}

	public PlayerBoard getBoardPreset() {
		return this.boardPreset;
	}

	public boolean setThemeWords(LinkedList<String> themeWords) {
		this.themeWords = themeWords;
		return true;
	}

	public boolean setBoardPreset(PlayerBoard boardPreset) {
		this.boardPreset = boardPreset;
		return true;
	}

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

	boolean addThemeWord(String word) {
		return themeWords.add(word);
	}

	boolean removeThemeWord(String word) {
		return themeWords.remove(word);
	}

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
	// so their point values are all 1
	@Override
	public int wordScore(PlayerWord w) {
		return 1;
	}

	@Override
	public void reset() {
		this.initBoard();
		this.pointScore = 0;
		this.selectedWord = new PlayerWord();
		this.starCount = 0;
		this.wordsEntered = new ArrayList<PlayerWord>();
	}
	
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
