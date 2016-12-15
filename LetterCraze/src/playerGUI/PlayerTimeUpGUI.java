package playerGUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import playerControllers.PlayerExitTimeUpController;
import playerFiles.PlayerLevel;

public class PlayerTimeUpGUI extends JFrame implements IPlayerGUI{

	PlayerLevel level;
	String identifier;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PlayerTimeUpGUI(PlayerLevel l, String i) {
		this.level = l;
		this.identifier = i;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Time has run out!");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));

		JButton btnOK = new JButton("Ok");
		btnOK.addActionListener(new PlayerExitTimeUpController(this));
		btnOK.setFont(new Font("Dialog", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.CENTER)
				.addComponent(lblNewLabel, Alignment.CENTER, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
				.addComponent(btnOK, Alignment.CENTER, GroupLayout.PREFERRED_SIZE, 0, 200)
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap(40, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addGap(40)
						.addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(200, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
	}
	
	public PlayerLevel getLevel(){
		return this.level;
	}
	
	public String getIdentifier(){
		return this.identifier;
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
