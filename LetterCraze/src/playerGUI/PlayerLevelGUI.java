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

/**
 * _____
 * @author Craig Bursey
 */
public class PlayerLevelGUI extends JFrame implements IPlayerGUI{

	/**_*/
	private JPanel contentPane;
	/**_*/
	private static PlayerLevel l;
	/**_*/
	String levelIdentifier;
	/**_*/
	long initialTime;
	/**_*/
	Timer gameTimer;
	/**_*/
	Timer refreshTimer;

	/**
	 * ___
	 */
	public PlayerLevelGUI(PlayerLevel level, String identifier) {
		PlayerLevelGUI.l = level;
		this.levelIdentifier = identifier;
		this.initialTime = System.currentTimeMillis();
		initialize();
	}
	
	/**
	 * @return The current static level object.
	 */
	public PlayerLevel getLevel() {
		return l;
	}
	/**
	 * @return A string identifying this level.
	 */
	public String getIdentifier(){
		return this.levelIdentifier;
	}
	
	/**
	 * @return The current number of seconds which have passed since this level started.
	 */
	public long getInitalTime(){
		return this.initialTime;
	}
	
	/**
	 * _____
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
	 * ______
	 * @param placeToScroll
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
				letterLabels[i][j] = new JLabel("<html><b>" + l.getBoard().getSquareArray()[i][j].getLetter().getLetter() + "</b>" + properLetterPoints(i, j) + "</html>");
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
	 * _____
	 * @return
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
	 * ____
	 * @param h
	 * @return
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
	 * _____
	 * @param i
	 * @param j
	 * @param h
	 * @return
	 */
	private int properLetterSize(int i, int j, int h) {
		if ((l.getBoard().getSquareArray()[i][j].getLetter().getLetter() == "Qu") && (l instanceof PlayerPuzzleLevel)) {
			return h * 1/30;
		} else {
			return h * 1/24;
		}
	}
	
	/**
	 * ______
	 * @param i
	 * @param j
	 * @return
	 */
	private String properLetterPoints(int i, int j) {
		String spaceIfNotQu;
		if (l.getBoard().getSquareArray()[i][j].getLetter().getLetter() == "Qu") {
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
	 * ____
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
	 * _____
	 * @param w
	 * @return
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
	 * _______
	 * @param n
	 * @return
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
	 * _____
	 * @return
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

	/**
	 * _
	 */
	@Override
	public void openWindow() {
		this.setVisible(true);
	}

	/**
	 * ___
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

	/**
	 * _
	 */
	@Override
	public void hideWindow() {
		this.setVisible(false);
	}
	
	/**
	 * __
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
	 * ______
	 * @param level
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