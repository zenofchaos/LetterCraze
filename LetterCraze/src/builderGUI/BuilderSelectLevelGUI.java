package builderGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import builderControllers.BuilderCloseLevelMenuController;
import builderControllers.BuilderOpenExistingEditorController;
import builderControllers.BuilderOpenNewEditorController;
import builderFiles.BuilderLevel;
import builderFiles.BuilderMenu;
import builderFiles.BuilderMenuIterator;
import playerControllers.PlayerLSController;

public class BuilderSelectLevelGUI implements IBuilderGUI{

	JPanel[] panelsPuzzle;
	JPanel[] panelsTheme;
	JPanel[] panelsLightning;

	final int lvlWidth = 100;
	final int lvlHeight = 100;

	BuilderMenu theMenu;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuilderSelectLevelGUI window = new BuilderSelectLevelGUI(new BuilderMenu());
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
	public BuilderSelectLevelGUI(BuilderMenu menu) {
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
		frame.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		btnBack.addActionListener(new BuilderCloseLevelMenuController(this));
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
		themeScrollPane.setViewportView(themeInnerPanel);
		
		JPanel lightningInnerPanel = new JPanel();
		lightningInnerPanel.setBackground(Color.LIGHT_GRAY);
		lightningScrollPane.setViewportView(lightningInnerPanel);
		
		JPanel puzzleInnerPanel = new JPanel();
		puzzleInnerPanel.setBackground(Color.LIGHT_GRAY);
		puzzleScrollPane.setViewportView(puzzleInnerPanel);
		
		
		ImageIcon plusSign = new ImageIcon("./images/plusSign.png");
		
		for(int j = 0; j < levelTypes.length; j++){
			JPanel newLevel = new JPanel();
			newLevel.setBackground(Color.gray);
			
			JLabel add = new JLabel(plusSign);
			
			GroupLayout gl_newLevel = new GroupLayout(newLevel);
			gl_newLevel.setHorizontalGroup(
					gl_newLevel.createSequentialGroup()
					.addGap(30)
					.addComponent(add, 80, 80, Short.MAX_VALUE)
					.addGap(30));
			
			gl_newLevel.setVerticalGroup(
					gl_newLevel.createSequentialGroup()
					.addGap(30)
					.addComponent(add, 80, 80, Short.MAX_VALUE)
					.addGap(30));
			
			if(levelTypes[j].equals("Puzzle")){
				puzzleInnerPanel.add(newLevel);
				newLevel.addMouseListener(new BuilderOpenNewEditorController(this, "P"));
			}
			else if(levelTypes[j].equals("Lightning")){
				lightningInnerPanel.add(newLevel);
				newLevel.addMouseListener(new BuilderOpenNewEditorController(this, "L"));
			}
			else if(levelTypes[j].equals("Theme")){
				themeInnerPanel.add(newLevel);
				newLevel.addMouseListener(new BuilderOpenNewEditorController(this, "T"));
			}
		}
		
		BuilderMenuIterator menuIterator = theMenu.iterator();

		for(int lType = 0; lType < levelTypes.length; lType++){
			int numLevels = 0;
			while(menuIterator.hasNext(levelTypes[lType])){
				numLevels++;
				
				BuilderLevel tempLevel = menuIterator.next(levelTypes[lType]);

				JPanel thePanel = new JPanel();
				String type = levelTypes[lType];
				String levelLabel = "";
				switch(type){
					case "Puzzle":
						levelLabel = "P";
						levelLabel+= numLevels;
						break;
					case "Lightning":
						levelLabel = "L";
						levelLabel+= numLevels;
						break;
					case "Theme":
						levelLabel = "T";
						levelLabel+= numLevels;
						break;
					default:
						System.out.println("switch statement error in Player Select Level GUI for determining level type");
				}
				thePanel.addMouseListener(new BuilderOpenExistingEditorController(this, levelLabel));
				thePanel.setBackground(Color.gray);

				JLabel label = new JLabel(tempLevel.getTitle());
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setToolTipText(tempLevel.getTitle());
				label.setFont(new Font("Dialog", Font.BOLD, 12));
				label.setForeground(Color.WHITE);
				
				JButton btnDelete = new JButton();
				btnDelete.setText("Delete");
				btnDelete.setFont(new Font("Dialog", Font.BOLD, 12));
				
				GroupLayout gl_thePanel = new GroupLayout(thePanel);
				gl_thePanel.setHorizontalGroup(
						gl_thePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_thePanel.createSequentialGroup()
								.addContainerGap(5, Short.MAX_VALUE)
								.addComponent(label, 90, 90, Short.MAX_VALUE)
								.addContainerGap(5, Short.MAX_VALUE))
						.addGroup(gl_thePanel.createSequentialGroup()
								.addContainerGap(5, Short.MAX_VALUE)
								.addComponent(btnDelete)
								.addContainerGap(5, Short.MAX_VALUE))
						);
				gl_thePanel.setVerticalGroup(
						gl_thePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_thePanel.createSequentialGroup()
								.addContainerGap(5, Short.MAX_VALUE)
								.addComponent(label, 20, 20, 20)
								.addGap(35)
								.addComponent(btnDelete)
								.addContainerGap(20, Short.MAX_VALUE))
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
		
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}

	
	// Opens (set visible) this frame
	public void openWindow(){
		this.frame.setVisible(true);
	}

	// Hides and disposes of this frame
	public void closeWindow(){
		this.frame.setVisible(false);
		this.frame.dispose();
	}

	// Hides this frame from view
	public void hideWindow(){
		this.frame.setVisible(false);
	}

	@Override
	public void refresh(Object o) {
		// TODO Auto-generated method stub
		
	}

	public BuilderMenu getMenu() {
		return this.theMenu;
	}
}
