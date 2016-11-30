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
import javax.swing.JButton;

public class PlayerLevel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerLevel frame = new PlayerLevel();
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
	public PlayerLevel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 36));
		titleLabel.setBounds(contentPane.getWidth() / 2, 20, contentPane.getWidth(), 36);
		contentPane.add(titleLabel);
		
		JLabel subtitleLabel = new JLabel("Subtitle text here"); // holds moves left (puzzle), time left (lightning), or theme description (theme)
		subtitleLabel.setForeground(Color.WHITE);
		subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		subtitleLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		subtitleLabel.setBounds(240, 80, 426, 59);
		contentPane.add(subtitleLabel);
		
		JLabel scoreLabel = new JLabel("Score: 0");
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		scoreLabel.setBounds(215, 130, 426, 59);
		contentPane.add(scoreLabel);
		
		JPanel[][] letterPanels = new JPanel[6][6];
		JLabel[][] letterLabels = new JLabel[6][6];
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				letterLabels[i][j] = new JLabel();
				letterLabels[i][j].setForeground(Color.WHITE);
				letterLabels[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				letterLabels[i][j].setFont(new Font("Dialog", Font.BOLD, 20));
				letterLabels[i][j].setBounds(12, 28, 426, 59);
				letterPanels[i][j] = new JPanel();
				letterPanels[i][j].add(letterLabels[i][j]);
				contentPane.add(letterPanels[i][j]);
			}
		}
		
		JScrollPane wordsFoundScrollPane = new JScrollPane();
		wordsFoundScrollPane.setBounds(12, 28, 36, 48);
		contentPane.add(wordsFoundScrollPane);
		
		JProgressBar scoreProgressBar = new JProgressBar();
		scoreProgressBar.setBounds(12, 28, 36, 48);
		contentPane.add(scoreProgressBar);
		
		JLabel starLabel1 = new JLabel("10");
		starLabel1.setForeground(Color.WHITE);
		starLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		starLabel1.setFont(new Font("Dialog", Font.BOLD, 20));
		starLabel1.setBounds(12, 28, 426, 59);
		contentPane.add(starLabel1);
		
		JLabel starLabel2 = new JLabel("20");
		starLabel2.setForeground(Color.WHITE);
		starLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		starLabel2.setFont(new Font("Dialog", Font.BOLD, 20));
		starLabel2.setBounds(12, 28, 426, 59);
		contentPane.add(starLabel2);
		
		JLabel starLabel3 = new JLabel("30");
		starLabel3.setForeground(Color.WHITE);
		starLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		starLabel3.setFont(new Font("Dialog", Font.BOLD, 20));
		starLabel3.setBounds(12, 28, 426, 59);
		contentPane.add(starLabel3);
		
		JButton undoButton = new JButton("Undo");
		undoButton.setFont(new Font("Dialog", Font.BOLD, 15));
		undoButton.setBounds(164, 116, 117, 25);
		contentPane.add(undoButton);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Dialog", Font.BOLD, 15));
		resetButton.setBounds(164, 116, 117, 25);
		contentPane.add(resetButton);
		
		JButton backButton = new JButton("Back to Menu");
		backButton.setFont(new Font("Dialog", Font.BOLD, 15));
		backButton.setBounds(164, 116, 117, 25);
		contentPane.add(backButton);
	}
	
	//Opens (sets visible) this window
	public void open(){
		this.setVisible(true);
	}
	
	//Hides and disposes of this window
	public void close(){
		this.setVisible(false);
		this.dispose();
	}
}
