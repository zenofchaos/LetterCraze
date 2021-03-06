package builderGUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import builderControllers.BuilderAddLetterController;
import builderControllers.BuilderAddStarThreshold;
import builderControllers.BuilderAddTitle;
import builderControllers.BuilderCloseEditorController;
import builderControllers.BuilderOutsideGridController;
import builderControllers.BuilderPreviewController;
import builderControllers.BuilderRemoveWordController;
import builderControllers.BuilderSaveController;
import builderControllers.BuilderSquareController;
import builderControllers.BuilderAddWordController;
import builderControllers.BuilderTypeSpecificInfoController;
import builderFiles.BuilderLevel;
import builderFiles.BuilderLightningLevel;
import builderFiles.BuilderPuzzleLevel;
import builderFiles.BuilderThemeLevel;
import playerFiles.PlayerLevel;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * An object of the class BuilderEditorGUI represents every graphical component needed to display an interface with 
 * which the user can create a custom level or change an existing level.
 */
public class BuilderEditorGUI extends JFrame implements IBuilderGUI {

	/** The panel containing all other components. */
	private JPanel contentPane;
	
	/** The level being edited. */
	private static BuilderLevel l;
	
	/** The string denoting the type and number of the level. */
	private static String levelIdentifier;

	/**
	 * Launch the editor.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuilderEditorGUI frame = new BuilderEditorGUI(l, levelIdentifier);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates a window and components from a given set of initial level entities.
	 *
	 * @param level the level
	 * @param levelIddentifier the code for the type and the number of the level
	 */
	public BuilderEditorGUI(BuilderLevel level, String levelIdentifier) {
		BuilderEditorGUI.l = level;
		BuilderEditorGUI.levelIdentifier = levelIdentifier;
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
		contentPane.addMouseListener(new BuilderOutsideGridController(this));
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JLabel titleLabel = new JLabel("Level Title:");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		titleLabel.setFont(new Font("Dialog", Font.BOLD, h * 1/30));
		titleLabel.setBounds(0, h * 11/96, w * 19/64, h * 1/16);
		contentPane.add(titleLabel);
		
		JTextField titleTextField = new JTextField(properTitle());
		titleTextField.addActionListener(new BuilderAddTitle(this));
		titleTextField.setHorizontalAlignment(SwingConstants.LEFT);
		titleTextField.setFont(new Font("Dialog", Font.PLAIN, h * 1/30));
		titleTextField.setBounds(w * 5/16 + borderSize, h * 1/8, h * 1/2 - borderSize, h * 1/20);
		contentPane.add(titleTextField);
		
		JLabel subtitleLabel = new JLabel(properSubtitleType()); // holds moves left (puzzle), time left (lightning), or theme description (theme)
		subtitleLabel.setForeground(Color.WHITE);
		subtitleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		subtitleLabel.setFont(new Font("Dialog", Font.BOLD, h * 1/30));
		subtitleLabel.setBounds(0, h * 17/96, w * 19/64, h * 1/16);
		contentPane.add(subtitleLabel);
		
		JTextField subtitleTextField = new JTextField(properSubtitle());
		subtitleTextField.addActionListener(new BuilderTypeSpecificInfoController(this));
		subtitleTextField.setHorizontalAlignment(SwingConstants.LEFT);
		subtitleTextField.setFont(new Font("Dialog", Font.PLAIN, h * 1/30));
		subtitleTextField.setBounds(w * 5/16 + borderSize, h * 3/16, properSubtitleWidth(w, h, borderSize), h * 1/20);
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
					squarePanels[i][j].setBackground(Color.GRAY);
				}
				squarePanels[i][j].setBounds(w * 1/2 + h * (j - 3) * 1/12 + borderSize, h * (i + 3) * 1/12 + borderSize, h * 1/12 - borderSize, h * 1/12 - borderSize);
				if (l instanceof BuilderThemeLevel) {
					letterTextFields[i][j] = new JTextField(properLetter(i, j));
					letterTextFields[i][j].setForeground(Color.BLACK);
					letterTextFields[i][j].setHorizontalAlignment(SwingConstants.CENTER);
					letterTextFields[i][j].setFont(new Font("Dialog", Font.BOLD, h * 1/24));
					letterTextFields[i][j].setBounds(0, 0, h * 1/12, h * 1/16);
					letterTextFields[i][j].addActionListener(new BuilderAddLetterController(this, i, j));
					squarePanels[i][j].add(letterTextFields[i][j]);
				}
				contentPane.add(squarePanels[i][j]);
			}
		}
		
		if (l instanceof BuilderThemeLevel) {
			JPanel wordsToFindPanel = new JPanel();
			wordsToFindPanel.setLayout(new GridLayout(0, 1));
			wordsToFindPanel.setAlignmentX(SwingConstants.LEFT);
			wordsToFindPanel.setBounds(0, 0, w * 15/64, ((BuilderThemeLevel)l).getThemeWords().size() * h * 7/240);
			JLabel[] wordsToFindLabels = new JLabel[((BuilderThemeLevel)l).getThemeWords().size()];
			for (int i = 0; i < ((BuilderThemeLevel)l).getThemeWords().size(); i++) {
				wordsToFindLabels[i] = new JLabel(((BuilderThemeLevel)l).getThemeWords().get(i).toUpperCase());
				wordsToFindLabels[i].setBackground(Color.WHITE);
				wordsToFindLabels[i].setForeground(Color.BLACK);
				wordsToFindLabels[i].setFont(new Font("Dialog", Font.PLAIN, h * 7/240));
				wordsToFindLabels[i].addMouseListener(new BuilderRemoveWordController(this, i));
				wordsToFindPanel.add(wordsToFindLabels[i]);
			}
			JScrollPane wordsToFindScrollPane = new JScrollPane(wordsToFindPanel);
			wordsToFindScrollPane.getVerticalScrollBar().setValue(placeToScroll);
			wordsToFindScrollPane.setForeground(Color.WHITE);
			wordsToFindScrollPane.setBackground(Color.DARK_GRAY);
			wordsToFindScrollPane.setBounds(w * 1/32, h * 1/4, w * 15/64, h * 1/2);
			contentPane.add(wordsToFindScrollPane);
			
			JTextField wordsToFindTextField = new JTextField();
			wordsToFindTextField.addActionListener(new BuilderAddWordController(this));
			wordsToFindTextField.setFont(new Font("Dialog", Font.PLAIN, h * 7/240));
			wordsToFindTextField.setBounds(w * 1/32, h * 19/24, w * 15/64, h * 1/20);
			contentPane.add(wordsToFindTextField);
		}
		
		JProgressBar scoreProgressBar = new JProgressBar();
		scoreProgressBar.setForeground(Color.YELLOW);
		scoreProgressBar.setBackground(Color.BLACK);
		scoreProgressBar.setOrientation(SwingConstants.VERTICAL);
		scoreProgressBar.setBounds(w * 13/16, h * 1/16, w * 5/64, h * 13/16);
		contentPane.add(scoreProgressBar);
		
		final int starSize = h * 1/24;
		BufferedImage fullStarOriginal = null;
		try {
			fullStarOriginal = ImageIO.read(new File("./images/fullStar.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image fullStarResized = fullStarOriginal.getScaledInstance(starSize, starSize, Image.SCALE_SMOOTH);
		ImageIcon fullStar = new ImageIcon(fullStarResized);
		JLabel[] starIconLabels = new JLabel[3];
		JTextField[] starThresholdTextFields = new JTextField[3];
		for (int i = 0; i < 3; i++) {
			starIconLabels[i] = new JLabel(fullStar);
			starIconLabels[i].setHorizontalAlignment(SwingConstants.LEFT);
			starIconLabels[i].setBounds(w * 49/64, h * 5/6 - (h * 3/4) * (i + 1) / 3, starSize, starSize);
			contentPane.add(starIconLabels[i]);
			starThresholdTextFields[i] = new JTextField("" + l.getStarThresholds()[i]);
			starThresholdTextFields[i].setHorizontalAlignment(SwingConstants.LEFT);
			starThresholdTextFields[i].setFont(new Font("Dialog", Font.PLAIN, h * 1/24));
			starThresholdTextFields[i].setBounds(w * 29/32, h * 5/6 - (h * 3/4) * (i + 1) / 3, w * 3/32, h * 1/24);
			starThresholdTextFields[i].addActionListener(new BuilderAddStarThreshold(this, i));
			contentPane.add(starThresholdTextFields[i]);
		}
		
		JButton saveButton = new JButton("Save Level");
		saveButton.addActionListener(new BuilderSaveController(this, levelIdentifier));
		saveButton.setFont(new Font("Dialog", Font.BOLD, h * 1/32));
		saveButton.setBounds(w * 21/64, h * 19/24, w * 5/32, h * 1/12);
		contentPane.add(saveButton);
		
		JButton previewButton = new JButton("Preview");
		previewButton.addActionListener(new BuilderPreviewController(this));
		previewButton.setFont(new Font("Dialog", Font.BOLD, h * 1/32));
		previewButton.setBounds(w * 33/64, h * 19/24, w * 5/32, h * 1/12);
		contentPane.add(previewButton);
		
		JButton backButton = new JButton("Back to Menu");
		backButton.addActionListener(new BuilderCloseEditorController(this));
		backButton.setFont(new Font("Dialog", Font.BOLD, h * 1/32));
		backButton.setBounds(w * 1/32, h * 1/24, w * 15/64, h * 5/96);
		contentPane.add(backButton);
	}
	
	/**
	 * Determines the title to display at the top of the screen.
	 * 
	 * @return the title to display
	 */
	private String properTitle() {
		try {
			return l.getTitle();
		} catch (NullPointerException e) {
			return "";
		}
	}

	/**
	 * Determines what text label to display in the line under the title.
	 * 
	 * @return the string to display
	 */
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
	
	/**
	 * Determines what the line below the title should be labeled based on the level type.
	 *
	 * @return the string to display
	 */
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
	
	/**
	 * Determines how large to draw the bar in which to type information below the title.
	 * 
	 * @param w window width
	 * @param h window height
	 * @param borderSize spacing between squares in the board
	 * @return the x-dimension of the bar
	 */
	private int properSubtitleWidth(int w, int h, int borderSize) {
		if (l instanceof BuilderPuzzleLevel) {
			return w * 1/16;
		} else if (l instanceof BuilderLightningLevel) {
			return w * 1/16;
		} else if (l instanceof BuilderThemeLevel) {
			return h * 1/2 - borderSize;
		} else {
			return h * 1/2 - borderSize;
		}
	}
	
	/**
	 * Determines what letter to display inside a given square's text field.
	 * 
	 * @param i the board row
	 * @param j the board column
	 * @return the string to display
	 */
	private String properLetter(int i, int j) {
		try {
			return l.getBoard().getSquareArray()[i][j].getLetter().getLetter();
		} catch (NullPointerException e) {
			return "   ";
		}
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
		l = (BuilderLevel)level;
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
		l = (BuilderLevel)level;
		contentPane.removeAll();
		showComponents(placeToScroll);
		contentPane.repaint();
		contentPane.validate();
	}
}