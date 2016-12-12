package playerGUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import playerControllers.PlayerLvlBackController;
import playerControllers.PlayerOutsideGridController;
import playerControllers.PlayerSquareController;
import playerFiles.PlayerLevel;
import playerFiles.PlayerLightningLevel;
import playerFiles.PlayerPuzzleLevel;
import playerFiles.PlayerThemeLevel;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PlayerLevelGUI extends JFrame implements IPlayerGUI{

	private JPanel contentPane;
	private static PlayerLevel l;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerLevelGUI frame = new PlayerLevelGUI(l);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerLevelGUI(PlayerLevel level) {
		PlayerLevelGUI.l = level;
		initialize();
	}
	
	/**
	 * @return current static level object
	 */
	public PlayerLevel getLevel() {
		return l;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 640, 480);
		contentPane = new JPanel();
		//contentPane.addMouseListener(new PlayerOutsideGridController(this));
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int w = (int)getBounds().getWidth();
		int h = (int)getBounds().getHeight();
		
		JLabel titleLabel = new JLabel(l.getTitle());
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		titleLabel.setBounds(0, 20, w, 40);
		contentPane.add(titleLabel);
		
		JLabel subtitleLabel = new JLabel(properSubtitle()); // holds moves left (puzzle), time left (lightning), or theme description (theme)
		subtitleLabel.setForeground(Color.WHITE);
		subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		subtitleLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		subtitleLabel.setBounds(0, 60, w, 30);
		contentPane.add(subtitleLabel);
		
		JLabel scoreLabel = new JLabel("Score: " + l.getPointScore());
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		scoreLabel.setBounds(0, 80, w, 30);
		contentPane.add(scoreLabel);
		
		JLabel[][] letterLabels = new JLabel[6][6];
		JPanel[][] squarePanels = new JPanel[6][6];
		for (int i = 0; i < 6; i++) { // i is the row number
			for (int j = 0; j < 6; j++) { // j is the column number
				squarePanels[i][j] = new JPanel();
				squarePanels[i][j].addMouseListener(new PlayerSquareController(this, i, j));
				if (l.getBoard().getSquares()[i][j].isActive()) {
					if (l.squareIsSelected(l.getBoard().getSquares()[i][j])) {
						squarePanels[i][j].setBackground(Color.YELLOW);
					} else {
						squarePanels[i][j].setBackground(Color.WHITE);
					}
				} else {
					squarePanels[i][j].setBackground(Color.DARK_GRAY);
				}
				final int borderSize = 6;
				squarePanels[i][j].setBounds(w / 2 + h * (j - 3) / 12 + borderSize, h * (i + 3) / 12 + borderSize, h / 12 - borderSize, h / 12 - borderSize);
				letterLabels[i][j] = new JLabel("<html><b>" + l.getBoard().getSquares()[i][j].getLetter().getLetter() + "</b>" + properLetterPoints(i, j) + "</html>");
				letterLabels[i][j].setForeground(Color.BLACK);
				letterLabels[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				letterLabels[i][j].setFont(new Font("Dialog", Font.PLAIN, properLetterSize(i, j)));
				letterLabels[i][j].setBounds(0, 0, 80, 80);
				squarePanels[i][j].add(letterLabels[i][j]);
				contentPane.add(squarePanels[i][j]);
			}
		}
		
		String wordsFound = "";
		for (int i = 0; i < l.getWordsEntered().size(); i++) {
			wordsFound += l.getWordsEntered().get(i).getWord() + properWordPoints(i) + "\n";
		}
		JLabel wordsFoundLabel = new JLabel(wordsFound);
		wordsFoundLabel.setForeground(Color.WHITE);
		wordsFoundLabel.setHorizontalAlignment(SwingConstants.LEFT);
		wordsFoundLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		wordsFoundLabel.setBounds(0, 0, w - 500, 20 * l.getWordsEntered().size());
		JScrollPane wordsFoundScrollPane = new JScrollPane(wordsFoundLabel);
		wordsFoundScrollPane.setForeground(Color.WHITE);
		wordsFoundScrollPane.setBackground(Color.DARK_GRAY);
		wordsFoundScrollPane.setBounds(20, 120, w - 500, h / 2);
		contentPane.add(wordsFoundScrollPane);
		
		JProgressBar scoreProgressBar = new JProgressBar(0, l.getStarThresholds()[2]);
		scoreProgressBar.setValue(l.getPointScore());
		scoreProgressBar.setForeground(Color.YELLOW);
		scoreProgressBar.setBackground(Color.BLACK);
		scoreProgressBar.setBorder(BorderFactory.createEmptyBorder());
		scoreProgressBar.setOrientation(SwingConstants.VERTICAL);
		scoreProgressBar.setBounds(w - 120, 30, 50, h - 90);
		contentPane.add(scoreProgressBar);
		
		final int starSize = 20;
		ImageIcon fullStar = new ImageIcon("./images/fullStar.png");
		ImageIcon emptyStar = new ImageIcon("./images/emptyStar.png");
		JLabel[] starIconLabels = new JLabel[3];
		JLabel[] starLineLabels = new JLabel[3];
		JLabel[] starThresholdLabels = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			if (l.getStarCount() >= i) {
				starIconLabels[i] = new JLabel(fullStar);
			} else {
				starIconLabels[i] = new JLabel(emptyStar);
			}
			starIconLabels[i].setHorizontalAlignment(SwingConstants.LEFT);
			starIconLabels[i].setBounds(w - 110, (h - 60) - 20 - (h - 120) * l.getStarThresholds()[i] / l.getStarThresholds()[2], starSize, starSize);
			contentPane.add(starIconLabels[i]);
			starLineLabels[i] = new JLabel("----------");
			starLineLabels[i].setForeground(Color.WHITE);
			starLineLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			starLineLabels[i].setFont(new Font("Dialog", Font.PLAIN, 20));
			starLineLabels[i].setBounds(w - 95, (h - 60) - 20 - (h - 120) * l.getStarThresholds()[i] / l.getStarThresholds()[2], 50, 20);
			contentPane.add(starLineLabels[i]);
			starThresholdLabels[i] = new JLabel("" + l.getStarThresholds()[i]);
			starThresholdLabels[i].setForeground(Color.WHITE);
			starThresholdLabels[i].setHorizontalAlignment(SwingConstants.LEFT);
			starThresholdLabels[i].setFont(new Font("Dialog", Font.PLAIN, 20));
			starThresholdLabels[i].setBounds(w - 60, (h - 60) - 20 - (h - 120) * l.getStarThresholds()[i] / l.getStarThresholds()[2], 60, 20);
			contentPane.add(starThresholdLabels[i]);
		}
		if (!(l instanceof PlayerLightningLevel)) {
			JButton undoButton = new JButton("Undo");
			undoButton.setFont(new Font("Dialog", Font.BOLD, 15));
			undoButton.setBounds(w / 2 - 110, h - 100, 100, 40);
			contentPane.add(undoButton);
		}
		
		JButton resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Dialog", Font.BOLD, 15));
		resetButton.setBounds(properResetX(w), h - 100, 100, 40);
		contentPane.add(resetButton);
		
		JButton backButton = new JButton("Back to Menu");
		backButton.setFont(new Font("Dialog", Font.BOLD, 15));
		backButton.setBounds(20, 20, 150, 25);
		contentPane.add(backButton);
		backButton.addActionListener(new PlayerLvlBackController(this));
	}
	
	private String properSubtitle() {
		if (l instanceof PlayerPuzzleLevel) {
			return "Words Left: " + ((PlayerPuzzleLevel)l).getWordLimit();
		} else if (l instanceof PlayerLightningLevel) {
			return "Time Left: " + ((PlayerLightningLevel)l).getMaxTime();
		} else if (l instanceof PlayerThemeLevel) {
			return ((PlayerThemeLevel)l).getDescription();
		} else return "";
	}
	
	private int properLetterSize(int i, int j) {
		if ((l.getBoard().getSquares()[i][j].getLetter().getLetter() == "Qu") && (l instanceof PlayerPuzzleLevel)) {
			return 16;
		} else {
			return 20;
		}
	}
	
	private String properLetterPoints(int i, int j) {
		String spaceIfNotQu;
		if (l.getBoard().getSquares()[i][j].getLetter().getLetter() == "Qu") {
			spaceIfNotQu = "";
		} else {
			spaceIfNotQu = " ";
		}
		if (l instanceof PlayerPuzzleLevel) {
			return spaceIfNotQu + makeSubscript(l.getBoard().getSquares()[i][j].getLetter().getPoints());
		} else if (l instanceof PlayerLightningLevel) {
			return "";
		} else if (l instanceof PlayerThemeLevel) {
			return "";
		} else return spaceIfNotQu + makeSubscript(l.getBoard().getSquares()[i][j].getLetter().getPoints());
	}
	
	private String properWordPoints(int i) {
		if (l instanceof PlayerPuzzleLevel) {
			return "\t\t\t" + l.getWordsEntered().get(i).getPointVal();
		} else if (l instanceof PlayerLightningLevel) {
			return "";
		} else if (l instanceof PlayerThemeLevel) {
			return "";
		} else return "\t\t\t" + l.getWordsEntered().get(i).getPointVal();
	}
	
	private int properResetX(int w) {
		if (l instanceof PlayerPuzzleLevel) {
			return w / 2 + 10;
		} else if (l instanceof PlayerLightningLevel) {
			return w / 2 - 50;
		} else if (l instanceof PlayerThemeLevel) {
			return w / 2 + 10;
		} else return w / 2 + 10;
	}
	
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

	@Override
	public void openWindow() {
		this.setVisible(true);
	}

	@Override
	public void closeWindow() {
		this.setVisible(false);
		this.dispose();
	}

	@Override
	public void hideWindow() {
		this.setVisible(false);
	}
	
	@Override
	public void refresh(Object level) {
		l = (PlayerLevel)level;
		initialize();
	}
}