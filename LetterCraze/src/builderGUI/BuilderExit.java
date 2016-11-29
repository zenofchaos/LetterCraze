package builderGUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuilderExit extends JPanel {

	/**
	 * Create the panel.
	 */
	public BuilderExit() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JLabel lblWouldYouLike = new JLabel("Would you like to save and exit?");
		lblWouldYouLike.setHorizontalAlignment(SwingConstants.CENTER);
		lblWouldYouLike.setBounds(12, 38, 426, 24);
		lblWouldYouLike.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWouldYouLike.setForeground(Color.WHITE);
		add(lblWouldYouLike);
		
		JButton btnSaveAndExit = new JButton("Save and Exit");
		btnSaveAndExit.setBounds(117, 101, 200, 25);
		add(btnSaveAndExit);
		
		JButton btnExitWithoutSaving = new JButton("Exit without Saving");
		btnExitWithoutSaving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExitWithoutSaving.setBounds(117, 155, 200, 25);
		add(btnExitWithoutSaving);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(117, 210, 200, 25);
		add(btnCancel);

	}

}
