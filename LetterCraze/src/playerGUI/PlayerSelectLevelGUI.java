package playerGUI;

import java.awt.EventQueue;
import playerControllers.PlayerSelectLevelController;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import playerFiles.PlayerLevel;
import playerFiles.PlayerMenu;
import playerFiles.PlayerMenuIterator;

import javax.swing.JButton;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class PlayerSelectLevelGUI implements IPlayerGUI{

	JPanel[] panelsPuzzle;
	JPanel[] panelsTheme;
	JPanel[] panelsLightning;

	final int lvlWidth = 80;
	final int lvlHeight = 80;
	final int starSize = 20;

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
		this.panelsPuzzle = new JPanel[theMenu.numLevel("Puzzle")];
		this.panelsTheme = new JPanel[theMenu.numLevel("Theme")];
		this.panelsLightning = new JPanel[theMenu.numLevel("Lightning")];
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon fullStar = new ImageIcon("./images/fullStar.png");
		ImageIcon emptyStar = new ImageIcon("./images/emptyStar.png");
		JLabel fullLabelStar1 = new JLabel(fullStar);
		JLabel fullLabelStar2 = new JLabel(fullStar);
		JLabel fullLabelStar3 = new JLabel(emptyStar);

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

		//JPanel t1 = new JPanel();
		//t1.setBackground(Color.gray);

		System.out.print(System.getProperty("user.dir"));

		/*JLabel t1Label = new JLabel("The Theme of this Level is Colors");
		t1Label.setHorizontalAlignment(SwingConstants.CENTER);
		t1Label.setToolTipText("The Theme of this Level is Colors");
		t1Label.setFont(new Font("Dialog", Font.BOLD, 10));
		t1Label.setForeground(Color.WHITE);

		JLabel lblHighScore = new JLabel("<html><center>High Score: <br> 159 </center></html>");
		lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighScore.setForeground(Color.WHITE);
		lblHighScore.setFont(new Font("Dialog", Font.BOLD, 10));

		GroupLayout gl_t1 = new GroupLayout(t1);
		gl_t1.setHorizontalGroup(
				gl_t1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_t1.createSequentialGroup()
						.addContainerGap(10, Short.MAX_VALUE)
						.addComponent(fullLabelStar1, starSize, starSize, Short.MAX_VALUE)
						.addComponent(fullLabelStar2, starSize, starSize, Short.MAX_VALUE)
						.addComponent(fullLabelStar3, starSize, starSize, Short.MAX_VALUE)
						.addContainerGap(10, Short.MAX_VALUE))
				.addGroup(gl_t1.createSequentialGroup()
						.addContainerGap(5, Short.MAX_VALUE)
						.addComponent(t1Label, 70, 70, Short.MAX_VALUE)
						.addContainerGap(5, Short.MAX_VALUE))
				.addGroup(gl_t1.createSequentialGroup()
						.addContainerGap(5, Short.MAX_VALUE)
						.addComponent(lblHighScore, 70, 70, Short.MAX_VALUE)
						.addContainerGap(5, Short.MAX_VALUE))
				);
		gl_t1.setVerticalGroup(
				gl_t1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_t1.createSequentialGroup()
						.addContainerGap(5, Short.MAX_VALUE)
						.addComponent(t1Label, 10, 10, 10)
						.addContainerGap(5, Short.MAX_VALUE)
						.addComponent(lblHighScore, 20, 20, 20)
						.addContainerGap(20, Short.MAX_VALUE)
						.addGroup(gl_t1.createParallelGroup(Alignment.LEADING)
								.addComponent(fullLabelStar1, starSize, starSize, starSize)
								.addComponent(fullLabelStar2, starSize, starSize, starSize)
								.addComponent(fullLabelStar3, starSize, starSize, starSize))
						.addContainerGap(0, Short.MAX_VALUE))
				);
		t1.setLayout(gl_t1);*/
		
		themeInnerPanel.setLayout(new GridLayout(1, 0, 5, 0));
		
		PlayerMenuIterator menuIterator = theMenu.iterator();
		while(menuIterator.hasNext("Lightning")){
			PlayerLevel tempLevel = menuIterator.next("Lightning");
			
			JPanel thePanel = new JPanel();
			thePanel.setBackground(Color.gray);
			
			JLabel label = new JLabel(tempLevel.getTitle());
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setToolTipText(tempLevel.getTitle());
			label.setFont(new Font("Dialog", Font.BOLD, 10));
			label.setForeground(Color.WHITE);

			JLabel lblHighScore = new JLabel("<html><center>High Score: <br>" + tempLevel.getBestScore() + "</center></html>");
			lblHighScore.setHorizontalAlignment(SwingConstants.CENTER);
			lblHighScore.setForeground(Color.WHITE);
			lblHighScore.setFont(new Font("Dialog", Font.BOLD, 10));

			GroupLayout gl_thePanel = new GroupLayout(thePanel);
			gl_thePanel.setHorizontalGroup(
					gl_thePanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_thePanel.createSequentialGroup()
							.addContainerGap(10, Short.MAX_VALUE)
							.addComponent(fullLabelStar1, starSize, starSize, Short.MAX_VALUE)
							.addComponent(fullLabelStar2, starSize, starSize, Short.MAX_VALUE)
							.addComponent(fullLabelStar3, starSize, starSize, Short.MAX_VALUE)
							.addContainerGap(10, Short.MAX_VALUE))
					.addGroup(gl_thePanel.createSequentialGroup()
							.addContainerGap(5, Short.MAX_VALUE)
							.addComponent(label, 70, 70, Short.MAX_VALUE)
							.addContainerGap(5, Short.MAX_VALUE))
					.addGroup(gl_thePanel.createSequentialGroup()
							.addContainerGap(5, Short.MAX_VALUE)
							.addComponent(lblHighScore, 70, 70, Short.MAX_VALUE)
							.addContainerGap(5, Short.MAX_VALUE))
					);
			gl_thePanel.setVerticalGroup(
					gl_thePanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_thePanel.createSequentialGroup()
							.addContainerGap(5, Short.MAX_VALUE)
							.addComponent(label, 10, 10, 10)
							.addContainerGap(5, Short.MAX_VALUE)
							.addComponent(lblHighScore, 20, 20, 20)
							.addContainerGap(20, Short.MAX_VALUE)
							.addGroup(gl_thePanel.createParallelGroup(Alignment.LEADING)
									.addComponent(fullLabelStar1, starSize, starSize, starSize)
									.addComponent(fullLabelStar2, starSize, starSize, starSize)
									.addComponent(fullLabelStar3, starSize, starSize, starSize))
							.addContainerGap(0, Short.MAX_VALUE))
					);
			thePanel.setLayout(gl_thePanel);
			themeInnerPanel.add(thePanel);
			
		}
		
		

		JPanel lightningInnerPanel = new JPanel();
		lightningInnerPanel.setBackground(Color.LIGHT_GRAY);
		lightningInnerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		lightningScrollPane.setViewportView(lightningInnerPanel);

		JButton btnLightning1 = new JButton("1");
		btnLightning1.addActionListener(new PlayerSelectLevelController(this,"L1"));
		lightningInnerPanel.setLayout(new GridLayout(1, 0, 5, 0));
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

		/*for(int pLevel = 1; pLevel <= btnPuzzle.length; pLevel++){	
			btnPuzzle[pLevel] = new JButton("Puzzle" + pLevel);
			btnPuzzle[pLevel].addActionListener(new PlayerSelectLevelController(this,"P" + pLevel));
			puzzleInnerPanel.add(btnPuzzle[pLevel]);
		}*/
		/*
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
		 */
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}

	@Override
	// Opens (set visible) this frame
	public void openWindow(){
		this.frame.setVisible(true);
	}

	@Override
	// Hides and disposes of this frame
	public void closeWindow(){
		this.frame.setVisible(false);
		this.frame.dispose();
	}

	@Override
	// Hides this frame from view
	public void hideWindow(){
		this.frame.setVisible(false);
	}
}
