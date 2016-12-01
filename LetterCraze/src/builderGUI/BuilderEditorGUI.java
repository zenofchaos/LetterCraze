package builderGUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class BuilderEditorGUI extends JFrame implements IBuilderGUI{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuilderEditorGUI frame = new BuilderEditorGUI();
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
	public BuilderEditorGUI() {
		initialize();
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
		
		JTextField titleTextField = new JTextField("Your title here");
		titleTextField.setHorizontalAlignment(SwingConstants.LEFT);
		titleTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
		titleTextField.setBounds(200, 60, h / 2, 24);
		contentPane.add(titleTextField);
		
		JLabel subtitleLabel = new JLabel("Other Info:"); // holds moves left (puzzle), time left (lightning), or theme description (theme)
		subtitleLabel.setForeground(Color.WHITE);
		subtitleLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		subtitleLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		subtitleLabel.setBounds(0, 85, 190, 30);
		contentPane.add(subtitleLabel);
		
		JTextField subtitleTextField = new JTextField("Words/time/description here");
		subtitleTextField.setHorizontalAlignment(SwingConstants.LEFT);
		subtitleTextField.setFont(new Font("Dialog", Font.PLAIN, 16));
		subtitleTextField.setBounds(200, 90, h / 2, 24);
		contentPane.add(subtitleTextField);
		
		JPanel[][] letterPanels = new JPanel[6][6];
		JTextField[][] letterTextFields = new JTextField[6][6];
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				letterTextFields[i][j] = new JTextField("   ");
				letterTextFields[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				letterTextFields[i][j].setFont(new Font("Dialog", Font.BOLD, 20));
				letterTextFields[i][j].setBounds(0, 0, h / 12, 30);
				letterPanels[i][j] = new JPanel();
				letterPanels[i][j].setBounds(w / 2 + h * (i - 3) / 12, h * (j + 3) / 12, h / 12, h / 12);
				letterPanels[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1, false));
				letterPanels[i][j].add(letterTextFields[i][j]);
				contentPane.add(letterPanels[i][j]);
			}
		}
		
		JTextPane wordstoFindTextPane = new JTextPane();
		wordstoFindTextPane.setBounds(20, 120, w - 500, h / 2);
		contentPane.add(wordstoFindTextPane);
		
		JProgressBar scoreProgressBar = new JProgressBar(0, 30);
		scoreProgressBar.setForeground(Color.YELLOW);
		scoreProgressBar.setBackground(Color.BLACK);
		scoreProgressBar.setBorder(BorderFactory.createEmptyBorder());
		scoreProgressBar.setOrientation(SwingConstants.VERTICAL);
		scoreProgressBar.setBounds(w - 120, 30, 50, h - 90);
		contentPane.add(scoreProgressBar);
		
		JTextField starTextField3 = new JTextField();
		starTextField3.setHorizontalAlignment(SwingConstants.LEFT);
		starTextField3.setFont(new Font("Dialog", Font.PLAIN, 20));
		starTextField3.setBounds(w - 60, 60 - 20, 60, 20);
		contentPane.add(starTextField3);
		
		JTextField starTextField2 = new JTextField();
		starTextField2.setHorizontalAlignment(SwingConstants.LEFT);
		starTextField2.setFont(new Font("Dialog", Font.PLAIN, 20));
		starTextField2.setBounds(w - 60, h / 2 - 20, 60, 20);
		contentPane.add(starTextField2);
		
		JTextField starTextField1 = new JTextField();
		starTextField1.setForeground(Color.BLACK);
		starTextField1.setHorizontalAlignment(SwingConstants.LEFT);
		starTextField1.setFont(new Font("Dialog", Font.PLAIN, 20));
		starTextField1.setBounds(w - 60, h - 60 - 20, 60, 20);
		contentPane.add(starTextField1);
		
		JButton saveButton = new JButton("Save");
		saveButton.setFont(new Font("Dialog", Font.BOLD, 15));
		saveButton.setBounds(w / 2 - 110, h - 100, 100, 40);
		contentPane.add(saveButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Dialog", Font.BOLD, 15));
		clearButton.setBounds(w / 2 + 10, h - 100, 100, 40);
		contentPane.add(clearButton);
		
		JButton backButton = new JButton("Back to Menu");
		backButton.setFont(new Font("Dialog", Font.BOLD, 15));
		backButton.setBounds(20, 20, 150, 25);
		contentPane.add(backButton);
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