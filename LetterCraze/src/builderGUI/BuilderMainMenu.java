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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblLetterCrazeBuilder = new JLabel("Letter Craze Builder");
		lblLetterCrazeBuilder.setFont(new Font("Dialog", Font.BOLD, 20));
		lblLetterCrazeBuilder.setHorizontalAlignment(SwingConstants.CENTER);
		lblLetterCrazeBuilder.setForeground(Color.WHITE);

		JButton btnLevels = new JButton("Levels");
		btnLevels.addActionListener(new BuilderOpenLevelSelectController(this));
		btnLevels.setFont(new Font("Dialog", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.CENTER)
				.addGap(0, 0, Short.MAX_VALUE)
				.addComponent(lblLetterCrazeBuilder, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(160)
				.addComponent(btnLevels, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(0, 0, Short.MAX_VALUE)
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap(60, Short.MAX_VALUE)
						.addComponent(lblLetterCrazeBuilder, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGap(20)
						.addComponent(btnLevels, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(120, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
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
