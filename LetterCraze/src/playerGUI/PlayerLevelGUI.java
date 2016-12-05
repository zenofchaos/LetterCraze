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

import playerControllers.PlayerBackBtnController;
import playerFiles.PlayerLevel;
import playerFiles.PlayerLightningLevel;
import playerFiles.PlayerPuzzleLevel;
import playerFiles.PlayerThemeLevel;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class PlayerLevelGUI extends JFrame implements IPlayerGUI{

	private JPanel contentPane;
	private static PlayerLevel level;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerLevelGUI frame = new PlayerLevelGUI(level);
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
	public PlayerLevelGUI(PlayerLevel l) {
		PlayerLevelGUI.level = l;
		initialize();
	}

	/**
	 * A shortcut for getting the level to be displayed.
	 */
	private PlayerLevel l() {
		return PlayerLevelGUI.level;
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
		
		JLabel titleLabel = new JLabel(l().getTitle());
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
		
		JLabel scoreLabel = new JLabel("Score: " + l().getPointScore());
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		scoreLabel.setBounds(0, 80, w, 30);
		contentPane.add(scoreLabel);
		
		JPanel[][] letterPanels = new JPanel[6][6];
		JLabel[][] letterLabels = new JLabel[6][6];
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				letterLabels[i][j] = new JLabel(l().getBoard().getSquares()[i][j].getLetter().getLetter());
				letterLabels[i][j].setForeground(Color.BLACK);
				letterLabels[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				letterLabels[i][j].setFont(new Font("Dialog", Font.BOLD, 20));
				letterLabels[i][j].setBounds(0, 0, 80, 80);
				letterPanels[i][j] = new JPanel();
				letterPanels[i][j].setBounds(w / 2 + h * (i - 3) / 12, h * (j + 3) / 12, h / 12, h / 12);
				letterPanels[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1, false));
				letterPanels[i][j].add(letterLabels[i][j]);
				contentPane.add(letterPanels[i][j]);
			}
		}
		
		JScrollPane wordsFoundScrollPane = new JScrollPane();
		wordsFoundScrollPane.setForeground(Color.WHITE);
		wordsFoundScrollPane.setBackground(Color.DARK_GRAY);
		wordsFoundScrollPane.setBounds(20, 120, w - 500, h / 2);
		contentPane.add(wordsFoundScrollPane);
		
		JProgressBar scoreProgressBar = new JProgressBar(0, l().getStarThresholds()[3]);
		scoreProgressBar.setForeground(Color.YELLOW);
		scoreProgressBar.setBackground(Color.BLACK);
		scoreProgressBar.setBorder(BorderFactory.createEmptyBorder());
		scoreProgressBar.setOrientation(SwingConstants.VERTICAL);
		scoreProgressBar.setBounds(w - 120, 30, 50, h - 90);
		contentPane.add(scoreProgressBar);
		
		JLabel starLabel3 = new JLabel("" + l().getStarThresholds()[3]);
		starLabel3.setForeground(Color.WHITE);
		starLabel3.setHorizontalAlignment(SwingConstants.LEFT);
		starLabel3.setFont(new Font("Dialog", Font.PLAIN, 20));
		starLabel3.setBounds(w - 60, 60 - 20, 60, 20);
		contentPane.add(starLabel3);
		
		JLabel starLabel2 = new JLabel("" + l().getStarThresholds()[2]);
		starLabel2.setForeground(Color.WHITE);
		starLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		starLabel2.setFont(new Font("Dialog", Font.PLAIN, 20));
		starLabel2.setBounds(w - 60, h / 2 - 20, 60, 20);
		contentPane.add(starLabel2);
		
		JLabel starLabel1 = new JLabel("" + l().getStarThresholds()[1]);
		starLabel1.setForeground(Color.WHITE);
		starLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		starLabel1.setFont(new Font("Dialog", Font.PLAIN, 20));
		starLabel1.setBounds(w - 60, h - 60 - 20, 60, 20);
		contentPane.add(starLabel1);
		
		JButton undoButton = new JButton("Undo");
		undoButton.setFont(new Font("Dialog", Font.BOLD, 15));
		undoButton.setBounds(w / 2 - 110, h - 100, 100, 40);
		contentPane.add(undoButton);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Dialog", Font.BOLD, 15));
		resetButton.setBounds(w / 2 + 10, h - 100, 100, 40);
		contentPane.add(resetButton);
		
		JButton backButton = new JButton("Back to Menu");
		backButton.setFont(new Font("Dialog", Font.BOLD, 15));
		backButton.setBounds(20, 20, 150, 25);
		contentPane.add(backButton);
		backButton.addActionListener(new PlayerBackBtnController(this));
	}
	
	private String properSubtitle() {
		if (l() instanceof PlayerPuzzleLevel) {
			return "Words Left: " + ((PlayerPuzzleLevel)l()).getWordLimit();
		} else if (l() instanceof PlayerLightningLevel) {
			return "Time Left: " + ((PlayerLightningLevel)l()).getMaxTime();
		} else if (l() instanceof PlayerThemeLevel) {
			return ((PlayerThemeLevel)l()).getDescription();
		} else return "";
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
}