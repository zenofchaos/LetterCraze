package playerGUI;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import playerControllers.PlayerLvlBackController;
import playerControllers.PlayerOutsideGridController;
import playerControllers.PlayerRefreshController;
import playerControllers.PlayerResetController;
import playerControllers.PlayerSquareController;
import playerControllers.PlayerTimerController;
import playerControllers.PlayerUndoController;
import playerFiles.PlayerLevel;
import playerFiles.PlayerLightningLevel;
import playerFiles.PlayerPuzzleLevel;
import playerFiles.PlayerThemeLevel;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

// TODO: Auto-generated Javadoc
/**
 * An object of the class PlayerLevelGUI represents every graphical component needed to display a level for the user to 
 * play. Every component either provides a view for players to interact with or informs the player of the current 
 * status of the level.
 */
public class PlayerLevelGUI extends JFrame implements IPlayerGUI{

	/** The panel containing all other components. */
	private JPanel contentPane;
	
	/** The level being played. */
	private PlayerLevel l;
	
	/** The string denoting the type and number of the level. */
	String levelIdentifier;
	
	/** The time the user started the level. */
	long initialTime;
	
	/** The timer that determines when the level will end automatically. */
	Timer gameTimer;
	
	/** The timer used to update the time-remaining label automatically. */
	Timer refreshTimer;

	/**
	 * Creates a window and components from a given set of initial level entities.
	 *
	 * @param level the level
	 * @param levelIddentifier the code for the type and the number of the level
	 */
	public PlayerLevelGUI(PlayerLevel level, String identifier) {
		this.l = level;
		this.levelIdentifier = identifier;
		this.initialTime = System.currentTimeMillis();
		initialize();
	}
	
	/**
	 * Gets the level.
	 *
	 * @return The current static level object.
	 */
	public PlayerLevel getLevel() {
		return l;
	}
	
	/**
	 * Gets the identifier.
	 *
	 * @return A string identifying this level.
	 */
	public String getIdentifier(){
		return this.levelIdentifier;
	}
	
	/**
	 * Gets the inital time.
	 *
	 * @return The current number of seconds which have passed since this level started.
	 */
	public long getInitalTime(){
		return this.initialTime;
	}
	
	/**
	 * Initializes the contents of the frame.
	 */
	private void initialize() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 640, 480);
		contentPane = new JPanel();
		contentPane.addMouseListener(new PlayerOutsideGridController(this));
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		if(l instanceof PlayerLightningLevel){
			gameTimer = new Timer(((PlayerLightningLevel)l).getMaxTime()*1000,new PlayerTimerController(this));
			gameTimer.setRepeats(false);
			gameTimer.start();
		}
		
		if(l instanceof PlayerLightningLevel){
			PlayerRefreshController rc = new PlayerRefreshController(this);
			refreshTimer = new Timer(250,rc);
			refreshTimer.start();
		}
		
		showComponents(0);
	}
	
	/**
	 * Instantiates Swing components each representing an interactive level element. Instantiates different sets of 
	 * components depending on which level subclass the static level belongs to.
	 * 
	 * @param placeToScroll the number of pixels downward the scroll pane must be scrolled, counting from the top of 
	 * the contained panel.
	 */
	private void showComponents(int placeToScroll) {
		int w = (int)getBounds().getWidth();
		int h = (int)getBounds().getHeight();
		int borderSize = h * 1/80;
		
		JLabel titleLabel = new JLabel(l.getTitle());
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Dialog", Font.BOLD, h * 1/16));
		titleLabel.setBounds(0, h * 1/24, w, h * 1/12);
		contentPane.add(titleLabel);
		
		JLabel subtitleLabel = new JLabel(properSubtitle()); // holds moves left (puzzle), time left (lightning), or theme description (theme)
		subtitleLabel.setForeground(Color.WHITE);
		subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		subtitleLabel.setFont(new Font("Dialog", Font.BOLD, properSubtitleSize(h)));
		subtitleLabel.setBounds(0, h * 1/8, w, h * 1/16);
		contentPane.add(subtitleLabel);
		
		JLabel scoreLabel = new JLabel("Score: " + l.getPointScore());
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Dialog", Font.BOLD, h * 1/24));
		scoreLabel.setBounds(0, h * 1/6, w, h * 1/16);
		contentPane.add(scoreLabel);
		
		JLabel[][] letterLabels = new JLabel[6][6];
		JPanel[][] squarePanels = new JPanel[6][6];
		for (int i = 0; i < 6; i++) { // i is the row number
			for (int j = 0; j < 6; j++) { // j is the column number
				squarePanels[i][j] = new JPanel();
				squarePanels[i][j].addMouseListener(new PlayerSquareController(this, i, j));
				if (l.getBoard().getSquareArray()[i][j].getActive()) {
					if (l.squareIsSelected(l.getBoard().getSquareArray()[i][j])) {
						squarePanels[i][j].setBackground(Color.YELLOW);
					} else {
						squarePanels[i][j].setBackground(Color.WHITE);
					}
				} else {
					squarePanels[i][j].setBackground(Color.DARK_GRAY);
				}
				squarePanels[i][j].setBounds(w * 1/2 + h * (j - 3) * 1/12 + borderSize, h * (i + 3) * 1/12 + borderSize, h * 1/12 - borderSize, h * 1/12 - borderSize);
				try {
					letterLabels[i][j] = new JLabel("<html><b>" + l.getBoard().getSquareArray()[i][j].getLetter().getLetter() + "</b>" + properLetterPoints(i, j) + "</html>");
				}
				catch (NullPointerException e) {
					letterLabels[i][j] = new JLabel();
				}
				letterLabels[i][j].setForeground(Color.BLACK);
				letterLabels[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				letterLabels[i][j].setFont(new Font("Dialog", Font.PLAIN, properLetterSize(i, j, h)));
				letterLabels[i][j].setBounds(0, 0, h * 1/6, h * 1/6);
				squarePanels[i][j].add(letterLabels[i][j]);
				contentPane.add(squarePanels[i][j]);
			}
		}
		
		String wordsFound = "<html>";
		for (int i = 0; i < l.getWordsEntered().size(); i++) {
			wordsFound += l.getWordsEntered().get(i).getWord().toUpperCase() + properWordPoints(i) + "<br>";
		}
		wordsFound += "</html>";
		JLabel wordsFoundLabel = new JLabel(wordsFound);
		wordsFoundLabel.setBackground(Color.WHITE);
		wordsFoundLabel.setForeground(Color.BLACK);
		wordsFoundLabel.setHorizontalAlignment(SwingConstants.LEFT);
		wordsFoundLabel.setVerticalAlignment(SwingConstants.TOP);
		wordsFoundLabel.setFont(new Font("Dialog", Font.PLAIN, h * 7/240));
		wordsFoundLabel.setBounds(0, 0, w * 15/64, l.getWordsEntered().size() * h * 7/240);
		JScrollPane wordsFoundScrollPane = new JScrollPane(wordsFoundLabel);
		wordsFoundScrollPane.getVerticalScrollBar().setValue(placeToScroll);
		wordsFoundScrollPane.setForeground(Color.WHITE);
		wordsFoundScrollPane.setBackground(Color.DARK_GRAY);
		wordsFoundScrollPane.setBounds(w * 1/32, h * 1/4, w * 15/64, h * 1/2);
		contentPane.add(wordsFoundScrollPane);
		
		String selectedWord = l.getSelectedWord().getWord().toUpperCase();
		JLabel selectedWordLabel = new JLabel(selectedWord);
		selectedWordLabel.setForeground(Color.YELLOW);
		selectedWordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectedWordLabel.setFont(new Font("Dialog", Font.BOLD, h * 1/24));
		selectedWordLabel.setBounds(w * 1/32, h * 19/24, w * 15/64, h * 1/16);
		contentPane.add(selectedWordLabel);
		
		if ((l instanceof PlayerPuzzleLevel) && (l.getSelectedWord().getPointVal() > 0)) {
			int selectedWordScore = l.getSelectedWord().getPointVal();
			JLabel selectedWordScoreLabel = new JLabel("" + selectedWordScore);
			selectedWordScoreLabel.setForeground(Color.YELLOW);
			selectedWordScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
			selectedWordScoreLabel.setFont(new Font("Dialog", Font.BOLD, h * 1/24));
			selectedWordScoreLabel.setBounds(w * 1/32, h * 27/32, w * 15/64, h * 1/16);
			contentPane.add(selectedWordScoreLabel);
		}
		
		JProgressBar scoreProgressBar = new JProgressBar(0, l.getStarThresholds()[2]);
		scoreProgressBar.setValue(l.getPointScore());
		scoreProgressBar.setForeground(Color.YELLOW);
		scoreProgressBar.setBackground(Color.BLACK);
		scoreProgressBar.setOrientation(SwingConstants.VERTICAL);
		scoreProgressBar.setBounds(w * 13/16, h * 1/16, w * 5/64, h * 13/16);
		contentPane.add(scoreProgressBar);
		
		final int starSize = h * 1/24;
		BufferedImage fullStarOriginal = null;
		BufferedImage emptyStarOriginal = null;
		try {
			fullStarOriginal = ImageIO.read(new File("./images/fullStar.png"));
			emptyStarOriginal = ImageIO.read(new File("./images/emptyStar.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image fullStarResized = fullStarOriginal.getScaledInstance(starSize, starSize, Image.SCALE_SMOOTH);
		Image emptyStarResized = emptyStarOriginal.getScaledInstance(starSize, starSize, Image.SCALE_SMOOTH);
		ImageIcon fullStar = new ImageIcon(fullStarResized);
		ImageIcon emptyStar = new ImageIcon(emptyStarResized);
		JLabel[] starIconLabels = new JLabel[3];
		JLabel[] starThresholdLabels = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			if (l.getStarCount() > i) {
				starIconLabels[i] = new JLabel("", fullStar, JLabel.CENTER);
			} else {
				starIconLabels[i] = new JLabel("", emptyStar, JLabel.CENTER);
			}
			starIconLabels[i].setHorizontalAlignment(SwingConstants.LEFT);
			starIconLabels[i].setBounds(w * 49/64, h * 5/6 - (h * 3/4) * l.getStarThresholds()[i] / l.getStarThresholds()[2], starSize, starSize);
			contentPane.add(starIconLabels[i]);
			starThresholdLabels[i] = new JLabel("" + l.getStarThresholds()[i]);
			if (l.getStarCount() > i) {
				starThresholdLabels[i].setForeground(Color.YELLOW);
			} else {
				starThresholdLabels[i].setForeground(Color.WHITE);
			}
			starThresholdLabels[i].setHorizontalAlignment(SwingConstants.LEFT);
			starThresholdLabels[i].setFont(new Font("Dialog", Font.PLAIN, h * 1/24));
			starThresholdLabels[i].setBounds(w * 29/32, h * 5/6 - (h * 3/4) * l.getStarThresholds()[i] / l.getStarThresholds()[2], w * 3/32, h * 1/24);
			contentPane.add(starThresholdLabels[i]);
		}
		
		if (!(l instanceof PlayerLightningLevel)) {
			JButton undoButton = new JButton("Undo");
			undoButton.setFont(new Font("Dialog", Font.BOLD, h * 1/32));
			undoButton.setBounds(w * 21/64, h * 19/24, w * 5/32, h * 1/12);
			contentPane.add(undoButton);
			undoButton.addActionListener(new PlayerUndoController(this));
		}
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new PlayerResetController(this));
		resetButton.setFont(new Font("Dialog", Font.BOLD, h * 1/32));
		resetButton.setBounds(properResetX(w), h * 19/24, w * 5/32, h * 1/12);
		contentPane.add(resetButton);
		
		JButton backButton = new JButton("Back to Menu");
		backButton.addActionListener(new PlayerLvlBackController(this));
		backButton.setFont(new Font("Dialog", Font.BOLD, h * 1/32));
		backButton.setBounds(w * 1/32, h * 1/24, w * 15/64, h * 5/96);
		contentPane.add(backButton);
	}
	
	/**
	 * Determines what the line below the title should be labeled based on the level type.
	 *
	 * @return the string to display
	 */
	private String properSubtitle() {
		if (l instanceof PlayerPuzzleLevel) {
			int wordsEntered = ((PlayerPuzzleLevel)l).getWordsEntered().size();
			int wordLimit = ((PlayerPuzzleLevel)l).getWordLimit();
			return "Words Left: " + (wordLimit - wordsEntered);
		} else if (l instanceof PlayerLightningLevel) {
			int maxTime = ((PlayerLightningLevel)l).getMaxTime();
			return "Time Left: " + (maxTime - (System.currentTimeMillis() - this.initialTime)/1000);
		} else if (l instanceof PlayerThemeLevel) {
			return ((PlayerThemeLevel)l).getDescription();
		} else return "";
	}
	
	/**
	 * Determines how large to display the subtitle.
	 *
	 * @param h the window height
	 * @return the font size
	 */
	private int properSubtitleSize(int h) {
		if (l instanceof PlayerPuzzleLevel) {
			return h * 1/24;
		} else if (l instanceof PlayerLightningLevel) {
			return h * 1/24;
		} else if (l instanceof PlayerThemeLevel) {
			return h * 7/240;
		} else return h * 1/24;
	}
	
	/**
	 * Determines how large to display the letter in a given square so that the text fits.
	 *
	 * @param i the board row
	 * @param j the board column
	 * @param h the window height
	 * @return the font size
	 */
	private int properLetterSize(int i, int j, int h) {
		try {
			if ((l.getBoard().getSquareArray()[i][j].getLetter().getLetter() == "QU") && (l instanceof PlayerPuzzleLevel)) {
				return h * 1/32;
			} else {
				return h * 1/24;
			}
		} catch (NullPointerException e) {
			return h * 1/24;
		}
	}
	
	/**
	 * Determines what point value to display for a given letter, if any.
	 *
	 * @param i the board row
	 * @param j the board column
	 * @return the string comprised of a subscript point value, or a blank string
	 */
	private String properLetterPoints(int i, int j) {
		String spaceIfNotQu;
		if (l.getBoard().getSquareArray()[i][j].getLetter().getLetter() == "QU") {
			spaceIfNotQu = "";
		} else {
			spaceIfNotQu = " ";
		}
		if (l instanceof PlayerPuzzleLevel) {
			return spaceIfNotQu + makeSubscript(l.getBoard().getSquareArray()[i][j].getLetter().getPoints());
		} else if (l instanceof PlayerLightningLevel) {
			return "";
		} else if (l instanceof PlayerThemeLevel) {
			return "";
		} else return spaceIfNotQu + makeSubscript(l.getBoard().getSquareArray()[i][j].getLetter().getPoints());
	}
	
	/**
	 * Determines what point value to display for a given submitted word, if any.
	 *
	 * @param i the number of words submitted before the word in question
	 * @return the string comprised of a point value, or a blank string
	 */
	private String properWordPoints(int i) {
		if (l instanceof PlayerPuzzleLevel) {
			return " (" + l.getWordsEntered().get(i).getPointVal() + ")";
		} else if (l instanceof PlayerLightningLevel) {
			return "";
		} else if (l instanceof PlayerThemeLevel) {
			return "";
		} else return " (" + l.getWordsEntered().get(i).getPointVal() + ")";
	}
	
	/**
	 * Determines the drawing location of the reset button.
	 *
	 * @param w the window width
	 * @return the x-coordinate of the top-left corner of the reset button
	 */
	private int properResetX(int w) {
		if (l instanceof PlayerPuzzleLevel) {
			return w * 33/64;
		} else if (l instanceof PlayerLightningLevel) {
			return w * 27/64;
		} else if (l instanceof PlayerThemeLevel) {
			return w * 33/64;
		} else return w * 33/64;
	}
	
	/**
	 * Converts the given number into a subscript.
	 *
	 * @param n the number to turn into a subscript
	 * @return the string comprised of the number as a subscript
	 */
	private String makeSubscript(int n) {
		String regulars = "" + n;
		String subscripts = "";
		for (int i = 0; i < regulars.length(); i++) {
			switch (regulars.charAt(i)) {
				case '0': subscripts += '\u2080';
				break;
				case '1': subscripts += '\u2081';
				break;
				case '2': subscripts += '\u2082';
				break;
				case '3': subscripts += '\u2083';
				break;
				case '4': subscripts += '\u2084';
				break;
				case '5': subscripts += '\u2085';
				break;
				case '6': subscripts += '\u2086';
				break;
				case '7': subscripts += '\u2087';
				break;
				case '8': subscripts += '\u2088';
				break;
				case '9': subscripts += '\u2089';
				break;
				default: subscripts += '\u2093';
			break;
			}
		}
		return subscripts;
	}
	
	/**
	 * Gets the scroll pane.
	 *
	 * @return the scroll pane component, or a blank pane if not found
	 */
	private JScrollPane getScrollPane() {
		Component[] components = contentPane.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (components[i] instanceof JScrollPane) {
				return (JScrollPane)components[i];
			}
		}
		return new JScrollPane();
	}

	/* (non-Javadoc)
	 * @see builderGUI.IBuilderGUI#openWindow()
	 */
	@Override
	public void openWindow() {
		this.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see builderGUI.IBuilderGUI#closeWindow()
	 */
	@Override
	public void closeWindow() {
		if(l instanceof PlayerLightningLevel){
			refreshTimer.stop();
			gameTimer.stop();
		}
		this.setVisible(false);
		this.dispose();
	}

	/* (non-Javadoc)
	 * @see builderGUI.IBuilderGUI#hideWindow()
	 */
	@Override
	public void hideWindow() {
		this.setVisible(false);
	}
	
	/* (non-Javadoc)
	 * @see builderGUI.IBuilderGUI#refresh(java.lang.Object)
	 */
	@Override
	public void refresh(Object level) {
		int placeToScroll = getScrollPane().getVerticalScrollBar().getValue();
		l = (PlayerLevel)level;
		contentPane.removeAll();
		showComponents(placeToScroll);
		contentPane.repaint();
		contentPane.validate();
	}
	
	/**
	 * Refreshes the display as normal and then moves the scroll bar of the scoll pane to a specified position.
	 *
	 * @param level the level
	 */
	public void refreshAndScroll(Object level) {
		int placeToScroll = 2 * getScrollPane().getVerticalScrollBar().getMaximum();
		l = (PlayerLevel)level;
		contentPane.removeAll();
		showComponents(placeToScroll);
		contentPane.repaint();
		contentPane.validate();
	}
}