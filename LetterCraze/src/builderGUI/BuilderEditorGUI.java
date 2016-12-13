package builderGUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import builderControllers.BuilderAddTitle;
import builderControllers.BuilderCloseEditorController;
import builderControllers.BuilderSquareController;
import builderFiles.BuilderLevel;
import builderFiles.BuilderLightningLevel;
import builderFiles.BuilderPuzzleLevel;
import builderFiles.BuilderThemeLevel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BuilderEditorGUI extends JFrame implements IBuilderGUI {

	private JPanel contentPane;
	private static BuilderLevel l;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuilderEditorGUI frame = new BuilderEditorGUI(l);
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
	public BuilderEditorGUI(BuilderLevel level) {
		BuilderEditorGUI.l = level;
		initialize();
	}

	/**
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
		int w = (int)getBounds().getWidth();
		int h = (int)getBounds().getHeight();
		
		JLabel titleLabel = new JLabel("Level Title:");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		titleLabel.setBounds(0, 55, 190, 30);
		contentPane.add(titleLabel);
		
		JTextField titleTextField = new JTextField(properTitle());
		titleTextField.addActionListener(new BuilderAddTitle(this));
		titleTextField.setHorizontalAlignment(SwingConstants.LEFT);
		titleTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
		titleTextField.setBounds(200, 60, h / 2, 24);
		contentPane.add(titleTextField);
		
		JLabel subtitleLabel = new JLabel(properSubtitleType()); // holds moves left (puzzle), time left (lightning), or theme description (theme)
		subtitleLabel.setForeground(Color.WHITE);
		subtitleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		subtitleLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		subtitleLabel.setBounds(0, 85, 190, 30);
		contentPane.add(subtitleLabel);
		
		JTextField subtitleTextField = new JTextField(properSubtitle());
		subtitleTextField.setHorizontalAlignment(SwingConstants.LEFT);
		subtitleTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
		subtitleTextField.setBounds(200, 90, properSubtitleWidth(h), 24);
		contentPane.add(subtitleTextField);
		
		JTextField[][] letterTextFields = new JTextField[6][6];
		JPanel[][] squarePanels = new JPanel[6][6];
		for (int i = 0; i < 6; i++) { // i is the row number
			for (int j = 0; j < 6; j++) { // j is the column number
				squarePanels[i][j] = new JPanel();
				squarePanels[i][j].addMouseListener(new BuilderSquareController(this, i, j));
				if (l.getBoard().getSquareArray()[i][j].getActive()) {
					squarePanels[i][j].setBackground(Color.WHITE);
				} else {
					squarePanels[i][j].setBackground(Color.DARK_GRAY);
				}
				squarePanels[i][j].setBounds(w / 2 + h * (j - 3) / 12, h * (i + 3) / 12, h / 12, h / 12);
				squarePanels[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1, false));
				if (l instanceof BuilderThemeLevel) {
					letterTextFields[i][j] = new JTextField(properLetter(i, j));
					letterTextFields[i][j].setHorizontalAlignment(SwingConstants.CENTER);
					letterTextFields[i][j].setFont(new Font("Dialog", Font.BOLD, 20));
					letterTextFields[i][j].setBounds(0, 0, h / 12, 30);
					squarePanels[i][j].add(letterTextFields[i][j]);
				}
				contentPane.add(squarePanels[i][j]);
			}
		}
		
		if (l instanceof BuilderThemeLevel) {
			String wordsToFind = "";
			for (int i = 0; i < ((BuilderThemeLevel)l).getThemeWords().size(); i++) {
				wordsToFind += ((BuilderThemeLevel)l).getThemeWords().get(i) + "\n";
			}
			JTextArea wordsToFindTextPane = new JTextArea(wordsToFind);
			wordsToFindTextPane.setForeground(Color.WHITE);
			wordsToFindTextPane.setFont(new Font("Dialog", Font.PLAIN, 14));
			wordsToFindTextPane.setBounds(0, 0, w - 500, 20 * ((BuilderThemeLevel)l).getThemeWords().size());
			JScrollPane wordsToFindScrollPane = new JScrollPane(wordsToFindTextPane);
			wordsToFindScrollPane.setForeground(Color.WHITE);
			wordsToFindScrollPane.setBackground(Color.DARK_GRAY);
			wordsToFindScrollPane.setBounds(20, 120, w - 500, h / 2);
			contentPane.add(wordsToFindScrollPane);
		}
		
		JProgressBar scoreProgressBar = new JProgressBar();
		scoreProgressBar.setForeground(Color.YELLOW);
		scoreProgressBar.setBackground(Color.BLACK);
		scoreProgressBar.setBorder(BorderFactory.createEmptyBorder());
		scoreProgressBar.setOrientation(SwingConstants.VERTICAL);
		scoreProgressBar.setBounds(w - 120, 30, 50, h - 90);
		contentPane.add(scoreProgressBar);
		
		final int starSize = 20;
		ImageIcon fullStar = new ImageIcon("./images/fullStar.png");
		JLabel[] starIconLabels = new JLabel[3];
		JLabel[] starLineLabels = new JLabel[3];
		JTextField[] starThresholdTextFields = new JTextField[3];
		for (int i = 0; i < 3; i++) {
			starIconLabels[i] = new JLabel(fullStar);
			contentPane.add(starIconLabels[i]);
			starLineLabels[i] = new JLabel("----------");
			starLineLabels[i].setForeground(Color.WHITE);
			starLineLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
			starLineLabels[i].setFont(new Font("Dialog", Font.PLAIN, 20));
			starLineLabels[i].setBounds(w - 95, (h - 60) - 20 - (h - 120) * (i + 1) / 3, 50, 20);
			contentPane.add(starLineLabels[i]);
			starThresholdTextFields[i] = new JTextField("" + l.getStarThresholds()[i]);
			starThresholdTextFields[i].setHorizontalAlignment(SwingConstants.LEFT);
			starThresholdTextFields[i].setFont(new Font("Dialog", Font.PLAIN, 20));
			starThresholdTextFields[i].setBounds(w - 60, (h - 60) - 20 - (h - 120) * (i + 1) / 3, 60, 20);
			contentPane.add(starThresholdTextFields[i]);
		}
		
		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("Dialog", Font.BOLD, 15));
		saveButton.setBounds(w / 2 - 110, h - 100, 100, 40);
		contentPane.add(saveButton);
		
		JButton previewButton = new JButton("Preview");
		previewButton.setFont(new Font("Dialog", Font.BOLD, 15));
		previewButton.setBounds(w / 2 + 10, h - 100, 100, 40);
		contentPane.add(previewButton);
		
		JButton backButton = new JButton("Back to Menu");
		backButton.addActionListener(new BuilderCloseEditorController(this));
		backButton.setFont(new Font("Dialog", Font.BOLD, 15));
		backButton.setBounds(20, 20, 150, 25);
		contentPane.add(backButton);
	}
	
	private String properTitle() {
		try {
			return l.getTitle();
		} catch (NullPointerException e) {
			return "";
		}
	}

	private String properSubtitleType() {
		if (l instanceof BuilderPuzzleLevel) {
			return "Word Limit:";
		} else if (l instanceof BuilderLightningLevel) {
			return "Time Limit:";
		} else if (l instanceof BuilderThemeLevel) {
			return "Description:";
		} else {
			return "";
		}
	}
	
	private String properSubtitle() {
		try {
			if (l instanceof BuilderPuzzleLevel) {
				return "" + ((BuilderPuzzleLevel)l).getWordLimit();
			} else if (l instanceof BuilderLightningLevel) {
				return "" + ((BuilderLightningLevel)l).getMaxTime();
			} else if (l instanceof BuilderThemeLevel) {
				return ((BuilderThemeLevel)l).getDescription();
			} else {
				return "";
			}
		} catch (NullPointerException e) {
			return "";
		}
	}
	
	private int properSubtitleWidth(int h) {
		if (l instanceof BuilderPuzzleLevel) {
			return 40;
		} else if (l instanceof BuilderLightningLevel) {
			return 40;
		} else if (l instanceof BuilderThemeLevel) {
			return h / 2;
		} else {
			return h / 2;
		}
	}
	
	private String properLetter(int i, int j) {
		try {
			return l.getBoard().getSquareArray()[i][j].getLetter().getLetter();
		} catch (NullPointerException e) {
			return "   ";
		}
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
		l = (BuilderLevel)level;
		initialize();
	}
}