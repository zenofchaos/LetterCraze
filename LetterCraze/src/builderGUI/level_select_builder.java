package builderGUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class level_select_builder extends JPanel {

	/**
	 * Create the panel.
	 */
	public level_select_builder() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JLabel lblWhatTypeOf = new JLabel("What Type of Level");
		lblWhatTypeOf.setVerticalAlignment(SwingConstants.TOP);
		lblWhatTypeOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatTypeOf.setBounds(12, 33, 426, 36);
		lblWhatTypeOf.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWhatTypeOf.setForeground(Color.WHITE);
		lblWhatTypeOf.setBackground(Color.DARK_GRAY);
		add(lblWhatTypeOf);
		
		JLabel lblWouldYouLike = new JLabel("Would You Like to Build?");
		lblWouldYouLike.setHorizontalAlignment(SwingConstants.CENTER);
		lblWouldYouLike.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWouldYouLike.setBackground(Color.DARK_GRAY);
		lblWouldYouLike.setForeground(Color.WHITE);
		lblWouldYouLike.setBounds(12, 57, 426, 43);
		add(lblWouldYouLike);
		
		JButton btnPuzzle = new JButton("Puzzle");
		btnPuzzle.setBounds(168, 112, 117, 25);
		add(btnPuzzle);
		
		JButton btnLightning = new JButton("Lightning");
		btnLightning.setBounds(168, 165, 117, 25);
		add(btnLightning);
		
		JButton btnTheme = new JButton("Theme");
		btnTheme.setBounds(168, 216, 117, 25);
		add(btnTheme);

	}
}
