package builderGUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import builderControllers.BuilderPreviewBackController;
import builderFiles.BuilderLevel;
import builderFiles.BuilderLightningLevel;
import builderFiles.BuilderPuzzleLevel;
import builderFiles.BuilderThemeLevel;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

// TODO: Auto-generated Javadoc
/**
 * An object of the class BuilderPreviewGUI represents every graphical component needed to display what a built level 
 * would look like in the player application. Essentially, it is a PlayerLevelGUI, minus the ActionListeners and 
 * MouseListeners that constitute a playable level.
 */
public class BuilderPreviewGUI extends JFrame implements IBuilderGUI {

	/** The panel containing all other components. */
	private JPanel contentPane;
	
	/** The level being previewed. */
	private static BuilderLevel l;

	/**
	 * Creates a window and components from a given set of initial level entities.
	 *
	 * @param level the level
	 */
	public BuilderPreviewGUI(BuilderLevel level) {
		BuilderPreviewGUI.l = level;
		initialize();
	}
	
	/**
	 * Gets the level.
	 *
	 * @return current static level object
	 */
	public BuilderLevel getLevel() {
		return l;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		showComponents();
	}
	
	/**
	 * Show components.
	 */
	private void showComponents() {
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
		
		JLabel scoreLabel = new JLabel("Score: 0");
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
				if (l.getBoard().getSquareArray()[i][j].getActive()) {
					if (false) {
						squarePanels[i][j].setBackground(Color.YELLOW);
					} else {
						squarePanels[i][j].setBackground(Color.WHITE);
					}
				} else {
					squarePanels[i][j].setBackground(Color.DARK_GRAY);
				}
				squarePanels[i][j].setBounds(w * 1/2 + h * (j - 3) * 1/12 + borderSize, h * (i + 3) * 1/12 + borderSize, h * 1/12 - borderSize, h * 1/12 - borderSize);
				try{
					letterLabels[i][j] = new JLabel("<html><b>" + l.getBoard().getSquareArray()[i][j].getLetter().getLetter() + "</b>" + properLetterPoints(i, j) + "</html>");
				}
				catch (Exception e){
					letterLabels[i][j] = new JLabel("<html><b>" + " " + "</b>" + properLetterPoints(i, j) + "</html>");
				}
				letterLabels[i][j].setForeground(Color.BLACK);
				letterLabels[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				letterLabels[i][j].setFont(new Font("Dialog", Font.PLAIN, properLetterSize(i, j, h)));
				letterLabels[i][j].setBounds(0, 0, h * 1/6, h * 1/6);
				squarePanels[i][j].add(letterLabels[i][j]);
				contentPane.add(squarePanels[i][j]);
			}
		}
		
		String wordsFound = "";
		JLabel wordsFoundLabel = new JLabel(wordsFound);
		wordsFoundLabel.setForeground(Color.WHITE);
		wordsFoundLabel.setHorizontalAlignment(SwingConstants.LEFT);
		wordsFoundLabel.setFont(new Font("Dialog", Font.PLAIN, h * 7/240));
		wordsFoundLabel.setBounds(0, 0, w * 15/64, 0 * h * 7/240);
		JScrollPane wordsFoundScrollPane = new JScrollPane(wordsFoundLabel);
		wordsFoundScrollPane.getVerticalScrollBar().setValue(wordsFoundScrollPane.getVerticalScrollBar().getMaximum());
		wordsFoundScrollPane.setForeground(Color.WHITE);
		wordsFoundScrollPane.setBackground(Color.DARK_GRAY);
		wordsFoundScrollPane.setBounds(w * 1/32, h * 1/4, w * 15/64, h * 1/2);
		contentPane.add(wordsFoundScrollPane);
		
		
		JProgressBar scoreProgressBar = new JProgressBar(0, l.getStarThresholds()[2]);
		scoreProgressBar.setValue(0);
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
			if (0 > i) {
				starIconLabels[i] = new JLabel("", fullStar, JLabel.CENTER);
			} else {
				starIconLabels[i] = new JLabel("", emptyStar, JLabel.CENTER);
			}
			starIconLabels[i].setHorizontalAlignment(SwingConstants.LEFT);
			starIconLabels[i].setBounds(w * 49/64, h * 5/6 - (h * 3/4) * l.getStarThresholds()[i] / l.getStarThresholds()[2], starSize, starSize);
			contentPane.add(starIconLabels[i]);
			starThresholdLabels[i] = new JLabel("" + l.getStarThresholds()[i]);
			if (0 > i) {
				starThresholdLabels[i].setForeground(Color.YELLOW);
			} else {
				starThresholdLabels[i].setForeground(Color.WHITE);
			}
			starThresholdLabels[i].setHorizontalAlignment(SwingConstants.LEFT);
			starThresholdLabels[i].setFont(new Font("Dialog", Font.PLAIN, h * 1/24));
			starThresholdLabels[i].setBounds(w * 29/32, h * 5/6 - (h * 3/4) * l.getStarThresholds()[i] / l.getStarThresholds()[2], w * 3/32, h * 1/24);
			contentPane.add(starThresholdLabels[i]);
		}
		
		if (!(l instanceof BuilderLightningLevel)) {
			JButton undoButton = new JButton("Undo");
			undoButton.setFont(new Font("Dialog", Font.BOLD, h * 1/32));
			undoButton.setBounds(w * 21/64, h * 19/24, w * 5/32, h * 1/12);
			contentPane.add(undoButton);
		}
		
		JButton resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Dialog", Font.BOLD, h * 1/32));
		resetButton.setBounds(properResetX(w), h * 19/24, w * 5/32, h * 1/12);
		contentPane.add(resetButton);
		
		JButton backButton = new JButton("Back to Editor");
		backButton.addActionListener(new BuilderPreviewBackController(this));
		backButton.setFont(new Font("Dialog", Font.BOLD, h * 1/32));
		backButton.setBounds(w * 1/32, h * 1/24, w * 15/64, h * 5/96);
		contentPane.add(backButton);
	}
	
	/**
	 * Proper subtitle.
	 *
	 * @return the string
	 */
	private String properSubtitle() {
		if (l instanceof BuilderPuzzleLevel) {
			return "Words Left: " + ((BuilderPuzzleLevel)l).getWordLimit();
		} else if (l instanceof BuilderLightningLevel) {
			return "Time Left: " + ((BuilderLightningLevel)l).getMaxTime();
		} else if (l instanceof BuilderThemeLevel) {
			return ((BuilderThemeLevel)l).getDescription();
		} else return "";
	}
	
	/**
	 * Proper subtitle size.
	 *
	 * @param h the h
	 * @return the int
	 */
	private int properSubtitleSize(int h) {
		if (l instanceof BuilderPuzzleLevel) {
			return h * 1/24;
		} else if (l instanceof BuilderLightningLevel) {
			return h * 1/24;
		} else if (l instanceof BuilderThemeLevel) {
			return h * 7/240;
		} else return h * 1/24;
	}
	
	/**
	 * Proper letter size.
	 *
	 * @param i the i
	 * @param j the j
	 * @param h the h
	 * @return the int
	 */
	private int properLetterSize(int i, int j, int h) {
		try{
			if ((l.getBoard().getSquareArray()[i][j].getLetter().getLetter() == "Qu") && (l instanceof BuilderPuzzleLevel)) {
				return h * 1/30;
			} else {
				return h * 1/24;
			}
		}
		catch(Exception e){
			return h * 1/24;
		}
	}
	
	/**
	 * Proper letter points.
	 *
	 * @param i the i
	 * @param j the j
	 * @return the string
	 */
	private String properLetterPoints(int i, int j) {
		String spaceIfNotQu;
		try{
			if (l.getBoard().getSquareArray()[i][j].getLetter().getLetter() == "Qu") {
				spaceIfNotQu = "";
			} else {
				spaceIfNotQu = " ";
			}
		}
		catch(Exception e){
			spaceIfNotQu = " ";
		}
		if (l instanceof BuilderPuzzleLevel) {
			try{
				return spaceIfNotQu + makeSubscript(l.getBoard().getSquareArray()[i][j].getLetter().getPoints());
			}
			catch(Exception e){
				return spaceIfNotQu + " ";
			}
		} else if (l instanceof BuilderLightningLevel) {
			return "";
		} else if (l instanceof BuilderThemeLevel) {
			return "";
		} else return spaceIfNotQu + makeSubscript(l.getBoard().getSquareArray()[i][j].getLetter().getPoints());
	}
	
	/**
	 * Proper reset X.
	 *
	 * @param w the w
	 * @return the int
	 */
	private int properResetX(int w) {
		if (l instanceof BuilderPuzzleLevel) {
			return w * 33/64;
		} else if (l instanceof BuilderLightningLevel) {
			return w * 27/64;
		} else if (l instanceof BuilderThemeLevel) {
			return w * 33/64;
		} else return w * 33/64;
	}
	
	/**
	 * Make subscript.
	 *
	 * @param n the n
	 * @return the string
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
		l = (BuilderLevel)level;
		contentPane.removeAll();
		showComponents();
		contentPane.repaint();
		contentPane.validate();
	}
}