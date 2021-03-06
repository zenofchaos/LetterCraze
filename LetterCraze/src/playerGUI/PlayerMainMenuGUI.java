package playerGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import playerControllers.PlayerMMController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PlayerMainMenuGUI extends JFrame implements IPlayerGUI{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerMainMenuGUI frame = new PlayerMainMenuGUI();
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
	public PlayerMainMenuGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Letter Craze Player");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		
		JButton btnLevels = new JButton("Levels");
		btnLevels.addActionListener(new PlayerMMController(this));
		btnLevels.setFont(new Font("Dialog", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.CENTER)
				.addComponent(lblNewLabel, Alignment.CENTER, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
				.addComponent(btnLevels, Alignment.CENTER, GroupLayout.PREFERRED_SIZE, 0, 200)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnLevels, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(200, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	@Override
	// Opens (set visible) this panel
	public void openWindow(){
		this.setVisible(true);
	}
	
	@Override
	// Hide and dispose of this panel
	public void closeWindow(){
		this.setVisible(false);
		this.dispose();
	}
	
	@Override
	// Hide and dispose of this panel
	public void hideWindow(){
		this.setVisible(false);
	}

	@Override
	public void refresh(Object o) {
		// TODO Auto-generated method stub
		
	}
}
