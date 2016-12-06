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

		String[] levelTypes = new String[3];
		levelTypes[0] = "Puzzle";
		levelTypes[1] = "Lightning";
		levelTypes[2] = "Theme";

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
		
		JPanel lightningInnerPanel = new JPanel();
		lightningInnerPanel.setBackground(Color.LIGHT_GRAY);
		lightningInnerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		lightningScrollPane.setViewportView(lightningInnerPanel);
		
		JPanel puzzleInnerPanel = new JPanel();
		puzzleInnerPanel.setBackground(Color.LIGHT_GRAY);
		puzzleInnerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		puzzleScrollPane.setViewportView(puzzleInnerPanel);

		PlayerMenuIterator menuIterator = theMenu.iterator();
		
		int numLevels = 0;

		for(int lType = 0; lType < levelTypes.length; lType++){
			while(menuIterator.hasNext(levelTypes[lType])){
				numLevels++;
				
				PlayerLevel tempLevel = menuIterator.next(levelTypes[lType]);

				JLabel[] star = new JLabel[3];

				for(int i = 0; i < tempLevel.getBestStars(); i++){
					star[i] = new JLabel(fullStar);
				}

				for (int i = tempLevel.getBestStars(); i < star.length; i++){
					star[i] = new JLabel(emptyStar);
				}

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
								.addComponent(star[0], starSize, starSize, Short.MAX_VALUE)
								.addComponent(star[1], starSize, starSize, Short.MAX_VALUE)
								.addComponent(star[2], starSize, starSize, Short.MAX_VALUE)
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
										.addComponent(star[0], starSize, starSize, starSize)
										.addComponent(star[1], starSize, starSize, starSize)
										.addComponent(star[2], starSize, starSize, starSize))
								.addContainerGap(0, Short.MAX_VALUE))
						);
				thePanel.setLayout(gl_thePanel);
				
				if(levelTypes[lType].equals("Theme")){
					themeInnerPanel.add(thePanel);			
				}
				else if(levelTypes[lType].equals("Puzzle")){
					puzzleInnerPanel.add(thePanel);
				}
				else if(levelTypes[lType].equals("Lightning")){
					lightningInnerPanel.add(thePanel);
				}
			}
		}
		System.out.println("number of Levels: " + numLevels);
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
