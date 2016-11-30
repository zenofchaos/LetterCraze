package playerGUI;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Font;

public class PlayerSplashGUI {

	private JFrame frame;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {


				PlayerSplashGUI window = new PlayerSplashGUI();
				PlayerMainMenuGUI menuWindow = new PlayerMainMenuGUI();
				window.initialize();
				window.frame.setUndecorated(true);
				window.frame.setVisible(true);

				ActionListener closer = new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						menuWindow.openWindow();
						window.frame.setVisible(false);
						window.frame.dispose();
					}

				};

				Timer timer = new Timer(5000, closer);
				timer.setRepeats(false);
				timer.start();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerSplashGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);

		JLabel lblWelcomeToLettercraze = new JLabel("Welcome to LetterCraze!");
		lblWelcomeToLettercraze.setForeground(Color.WHITE);
		lblWelcomeToLettercraze.setFont(new Font("Dialog", Font.BOLD, 24));

		JLabel lblYttriumGroup = new JLabel("Yttrium Group");
		lblYttriumGroup.setForeground(Color.WHITE);
		lblYttriumGroup.setFont(new Font("Dialog", Font.BOLD, 18));

		JLabel lblLindaBakerCraig = new JLabel("Linda Baker, Craig Bursey, Karen Orton, Kevin Ouellette, Charles Sinkler");
		lblLindaBakerCraig.setForeground(Color.WHITE);
		lblLindaBakerCraig.setFont(new Font("Dialog", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.CENTER)
				.addGap(25, 30, Short.MAX_VALUE)
				.addComponent(lblWelcomeToLettercraze)
				.addComponent(lblLindaBakerCraig)
				.addComponent(lblYttriumGroup)
				.addGap(25, 30, Short.MAX_VALUE)
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap(140, Short.MAX_VALUE)
						.addComponent(lblWelcomeToLettercraze)
						.addGap(80)
						.addComponent(lblYttriumGroup)
						.addGap(60)
						.addComponent(lblLindaBakerCraig)
						.addContainerGap(140, Short.MAX_VALUE))
				);
		frame.getContentPane().setLayout(groupLayout);
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
