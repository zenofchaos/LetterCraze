package builderGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import builderControllers.BuilderOpenLevelSelectController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class BuilderMainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuilderMainMenu frame = new BuilderMainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuilderMainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLetterCrazeBuilder = new JLabel("Letter Craze Builder");
		lblLetterCrazeBuilder.setFont(new Font("Dialog", Font.BOLD, 20));
		lblLetterCrazeBuilder.setHorizontalAlignment(SwingConstants.CENTER);
		lblLetterCrazeBuilder.setForeground(Color.WHITE);
		lblLetterCrazeBuilder.setBounds(12, 12, 426, 93);
		contentPane.add(lblLetterCrazeBuilder);
		
		JButton btnLevels = new JButton("Levels");
		btnLevels.addActionListener(new BuilderOpenLevelSelectController(this));
		btnLevels.setFont(new Font("Dialog", Font.BOLD, 15));
		btnLevels.setBounds(167, 117, 117, 25);
		contentPane.add(btnLevels);
	}
	
	// Opens (set visible) this panel
	public void open(){
		this.setVisible(true);
	}
	
	// Hide and dispose of this panel
	public void close(){
		this.setVisible(false);
		this.dispose();
	}

}
