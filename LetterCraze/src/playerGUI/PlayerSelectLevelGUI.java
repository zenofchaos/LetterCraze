package playerGUI;

import java.awt.EventQueue;
import playerControllers.PlayerSelectLevelController;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import playerControllers.PlayerSelectLevelController;
import playerFiles.PlayerMenu;

import javax.swing.JButton;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Dimension;

public class PlayerSelectLevelGUI {

	PlayerMenu theMenu;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerSelectLevelGUI window = new PlayerSelectLevelGUI(new PlayerMenu());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayerSelectLevelGUI(PlayerMenu menu) {
		this.theMenu = menu;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
				);

		JScrollPane puzzleScrollPane = new JScrollPane();

		JScrollPane lightningScrollPane = new JScrollPane();

		JScrollPane themeScrollPane = new JScrollPane();

		JLabel lblPuzzleLevels = new JLabel("Puzzle Levels");

		JLabel lblLightningLevels = new JLabel("Lightning Levels");

		JLabel lblThemeLevels = new JLabel("Theme Levels");

		JButton btnBack = new JButton("Back");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(20)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnBack)
								.addComponent(lblPuzzleLevels)
								.addComponent(lblLightningLevels)
								.addComponent(lblThemeLevels)
								.addComponent(themeScrollPane, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
								.addComponent(lightningScrollPane, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
								.addComponent(puzzleScrollPane, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
						.addGap(20))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnBack)
						.addGap(5)
						.addComponent(lblPuzzleLevels)
						.addGap(20)
						.addComponent(puzzleScrollPane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addGap(20)
						.addComponent(lblLightningLevels)
						.addGap(20)
						.addComponent(lightningScrollPane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addGap(20)
						.addComponent(lblThemeLevels)
						.addGap(20)
						.addComponent(themeScrollPane, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addGap(20))
				);
		
		JPanel themeInnerPanel = new JPanel();
		themeInnerPanel.setBackground(Color.LIGHT_GRAY);
		themeInnerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		themeScrollPane.setViewportView(themeInnerPanel);
		themeInnerPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JButton btnTheme1 = new JButton("1");
		btnTheme1.addActionListener(new PlayerSelectLevelController(this,"T1"));
		themeInnerPanel.add(btnTheme1);
		
		JButton btnTheme2 = new JButton("2");
		btnTheme2.addActionListener(new PlayerSelectLevelController(this,"T2"));
		themeInnerPanel.add(btnTheme2);
		
		JButton btnTheme3 = new JButton("3");
		btnTheme3.addActionListener(new PlayerSelectLevelController(this,"T3"));
		themeInnerPanel.add(btnTheme3);
		
		JButton btnTheme4 = new JButton("4");
		btnTheme4.addActionListener(new PlayerSelectLevelController(this,"T4"));
		themeInnerPanel.add(btnTheme4);
		
		JButton btnTheme5 = new JButton("5");
		btnTheme5.addActionListener(new PlayerSelectLevelController(this,"T5"));
		themeInnerPanel.add(btnTheme5);
		
		JPanel lightningInnerPanel = new JPanel();
		lightningInnerPanel.setBackground(Color.LIGHT_GRAY);
		lightningInnerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		lightningScrollPane.setViewportView(lightningInnerPanel);
		lightningInnerPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JButton btnLightning1 = new JButton("1");
		btnLightning1.addActionListener(new PlayerSelectLevelController(this,"L1"));
		lightningInnerPanel.add(btnLightning1);
		
		JButton btnLightning2 = new JButton("2");
		btnLightning2.addActionListener(new PlayerSelectLevelController(this,"L2"));
		lightningInnerPanel.add(btnLightning2);
		
		JButton btnLightning3 = new JButton("3");
		btnLightning3.addActionListener(new PlayerSelectLevelController(this,"L3"));
		lightningInnerPanel.add(btnLightning3);
		
		JButton btnLightning4 = new JButton("4");
		btnLightning4.addActionListener(new PlayerSelectLevelController(this,"L4"));
		lightningInnerPanel.add(btnLightning4);
		
		JButton btnLightning5 = new JButton("5");
		btnLightning5.addActionListener(new PlayerSelectLevelController(this,"L5"));
		lightningInnerPanel.add(btnLightning5);
		
		JPanel puzzleInnerPanel = new JPanel();
		puzzleInnerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		puzzleInnerPanel.setBackground(Color.LIGHT_GRAY);
		puzzleScrollPane.setViewportView(puzzleInnerPanel);
		puzzleInnerPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JButton btnPuzzle1 = new JButton("1");
		btnPuzzle1.addActionListener(new PlayerSelectLevelController(this,"P1"));
		puzzleInnerPanel.add(btnPuzzle1);
		
		JButton btnPuzzle2 = new JButton("2");
		btnPuzzle2.addActionListener(new PlayerSelectLevelController(this,"P2"));
		puzzleInnerPanel.add(btnPuzzle2);
		
		JButton btnPuzzle3 = new JButton("3");
		btnPuzzle3.addActionListener(new PlayerSelectLevelController(this,"P3"));
		puzzleInnerPanel.add(btnPuzzle3);
		
		JButton btnPuzzle4 = new JButton("4");
		btnPuzzle4.addActionListener(new PlayerSelectLevelController(this,"P4"));
		puzzleInnerPanel.add(btnPuzzle4);
		
		JButton btnPuzzle5 = new JButton("5");
		btnPuzzle5.addActionListener(new PlayerSelectLevelController(this,"P5"));
		puzzleInnerPanel.add(btnPuzzle5);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	// Opens (set visible) this frame
		public void open(){
			this.frame.setVisible(true);
		}
		
		// Hides and disposes of this frame
		public void close(){
			this.frame.setVisible(false);
			this.frame.dispose();
		}
}
