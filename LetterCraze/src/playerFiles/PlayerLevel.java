package playerFiles;

import java.util.*;

/**
 * The Class PlayerLevel.
 */
public abstract class PlayerLevel {
	
	/** The title. */
	String title;
	
	/** The point score. */
	int pointScore;
	
	/** The star count. */
	int starCount;
	
	/** The words entered. */
	ArrayList<PlayerWord> wordsEntered;
	
	/** The star thresholds. */
	int[] starThresholds;
	
	/** The best score. */
	int bestScore;
	
	/** The best stars. */
	int bestStars;
	
	/** The board. */
	PlayerBoard board;
	
	/** The selected word. */
	PlayerWord selectedWord;
	
	/** The is locked. */
	boolean isLocked;
	
	/**
	 * Instantiates a new player level.
	 *
	 * @param starThresholds the star thresholds
	 * @param bestScore the best score
	 * @param bestStars the best stars
	 * @param isLocked the is locked
	 * @param title the title
	 */
	PlayerLevel(int[] starThresholds, int bestScore, int bestStars, boolean isLocked, String title){
		if(!(starThresholds.length == 3)){
			System.err.println ("incorrect number passed to create PlayerLevel");
		}
		else{
			this.starThresholds = starThresholds;
			this.bestScore = bestScore;
			this.bestStars = bestStars;
			this.isLocked = isLocked;
			this.title = title;
			this.pointScore = 0;
			this.starCount = 0;
			this.wordsEntered = new ArrayList<PlayerWord>();
			this.selectedWord = new PlayerWord();			
		}
	}
	
	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle(){
		return this.title;
	}
	
	/**
	 * Gets the point score.
	 *
	 * @return the point score
	 */
	public int getPointScore(){
		return this.pointScore;
	}
	
	/**
	 * Gets the star count.
	 *
	 * @return the star count
	 */
	public int getStarCount(){
		return this.starCount;
	}
	
	/**
	 * Gets the words entered.
	 *
	 * @return the words entered
	 */
	public ArrayList<PlayerWord> getWordsEntered(){
		return this.wordsEntered;
	}
	
	/**
	 * Gets the star thresholds.
	 *
	 * @return the star thresholds
	 */
	public int[] getStarThresholds(){
		return this.starThresholds;
	}
	
	/**
	 * Gets the best score.
	 *
	 * @return the best score
	 */
	public int getBestScore(){
		return this.bestScore;
	}
	
	/**
	 * Gets the best stars.
	 *
	 * @return the best stars
	 */
	public int getBestStars(){
		return this.bestStars;
	}
	
	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	public PlayerBoard getBoard(){
		return this.board;
	}
	
	/**
	 * Gets the selected word.
	 *
	 * @return the selected word
	 */
	public PlayerWord getSelectedWord() {
		return this.selectedWord;
	}
	
	/**
	 * Gets the checks if is locked.
	 *
	 * @return the checks if is locked
	 */
	public boolean getIsLocked(){
		return this.isLocked;
	}
	
	/**
	 * Sets the title.
	 *
	 * @param title the title
	 * @return true, if successful
	 */
	public boolean setTitle(String title){
		this.title = title;
		return true;
	}
	
	/**
	 * Sets the point score.
	 *
	 * @param pointScore the point score
	 * @return true, if successful
	 */
	public boolean setPointScore(int pointScore){
		this.pointScore = pointScore;
		return true;
	}
	
	/**
	 * Sets the star count.
	 *
	 * @param starCount the star count
	 * @return true, if successful
	 */
	public boolean setStarCount(int starCount){
		this.starCount = starCount;
		return true;
	}
	
	/**
	 * Sets the words entered.
	 *
	 * @param wordsEntered the words entered
	 * @return true, if successful
	 */
	public boolean setWordsEntered(ArrayList<PlayerWord> wordsEntered){
		this.wordsEntered = wordsEntered;
		return true;
	}
	
	/**
	 * Sets the star thresholds.
	 *
	 * @param starThresholds the star thresholds
	 * @return true, if successful
	 */
	public boolean setStarThresholds(int[] starThresholds){
		if (starThresholds.length == 3){
			this.starThresholds = starThresholds;
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Sets the best score.
	 *
	 * @param bestScore the best score
	 * @return true, if successful
	 */
	public boolean setBestScore(int bestScore){
		this.bestScore = bestScore;
		return true;
	}
	
	/**
	 * Sets the best stars.
	 *
	 * @param bestStars the best stars
	 * @return true, if successful
	 */
	public boolean setBestStars(int bestStars){
		this.bestStars = bestStars;
		return true;
	}
	
	/**
	 * Sets the board.
	 *
	 * @param board the board
	 * @return true, if successful
	 */
	public boolean setBoard(PlayerBoard board){
		this.board = board;
		return true;
	}
	
	/**
	 * Sets the selected word.
	 *
	 * @param selectedWord the selected word
	 * @return true, if successful
	 */
	public boolean setSelectedWord(PlayerWord selectedWord){
		this.selectedWord = selectedWord;
		return true;
	}
	
	/**
	 * Sets the is locked.
	 *
	 * @param isLocked the is locked
	 * @return true, if successful
	 */
	public boolean setIsLocked(boolean isLocked){
		this.isLocked = isLocked;
		return true;
	}
	
	/**
	 * Inits the board with a given board if theme or with random letters otherwise.
	 *
	 * @return true, if successful
	 */
	public boolean initBoard(){
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

		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				this.board.getSquareArray()[row][col].setLetter(new PlayerLetter());
			}
		}
		return true;
	}

	/**
	 * Submit selected word.
	 *
	 * @return true, if successful
	 */
	abstract public boolean submitSelectedWord();

	/**
	 * Checks if is valid word.
	 *
	 * @param w the w
	 * @return true, if is valid word
	 */
	abstract public boolean isValidWord(PlayerWord w);
	
	/**
	 * Word score.
	 *
	 * @param w the PlayerWord
	 * @return the score of the word
	 */
	abstract public int wordScore(PlayerWord w);
	
	/**
	 * Square is selected.
	 *
	 * @param s the PlayerSquare
	 * @return true, if successful
	 */
	public boolean squareIsSelected(PlayerSquare s) {
		try{
			return selectedWord.contains(s);
		}
		catch (NullPointerException e){
			return false;
		}
	}
	
	/**
	 * Reset.
	 */
	abstract public void reset();
}
