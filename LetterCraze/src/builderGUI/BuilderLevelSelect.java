package builderGUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class BuilderLevelSelect extends JPanel {

	/**
	 * Create the panel.
	 */
	public BuilderLevelSelect() {
		setBackground(Color.DARK_GRAY);

		JButton btnPuzzle = new JButton("Puzzle");

		JButton btnLightning = new JButton("Lightning");

		JButton btnTheme = new JButton("Theme");

		JLabel lblWhatTypeOf = new JLabel("<html><body>What Type of Level <br> Would You Like to Build?</body></html>");
		lblWhatTypeOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatTypeOf.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWhatTypeOf.setForeground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.CENTER)
				.addComponent(btnPuzzle, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnLightning, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnTheme, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblWhatTypeOf, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap(80, Short.MAX_VALUE)
						.addComponent(lblWhatTypeOf)
						.addGap(30)
						.addComponent(btnPuzzle)
						.addGap(30)
						.addComponent(btnLightning)
						.addGap(30)
						.addComponent(btnTheme)
						.addContainerGap(80, Short.MAX_VALUE))
				);
		setLayout(groupLayout);

	}
	
}
