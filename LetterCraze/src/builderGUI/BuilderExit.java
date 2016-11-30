package builderGUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class BuilderExit extends JPanel {

	/**
	 * Create the panel.
	 */
	public BuilderExit() {
		setBackground(Color.DARK_GRAY);

		JLabel lblWouldYouLike = new JLabel("Would you like to save and exit?");
		lblWouldYouLike.setHorizontalAlignment(SwingConstants.CENTER);
		lblWouldYouLike.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWouldYouLike.setForeground(Color.WHITE);

		JButton btnSaveAndExit = new JButton("Save and Exit");

		JButton btnExitWithoutSaving = new JButton("Exit without Saving");
		btnExitWithoutSaving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnCancel = new JButton("Cancel");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.CENTER)
				.addComponent(lblWouldYouLike, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnSaveAndExit, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnExitWithoutSaving, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap(40, Short.MAX_VALUE)
						.addComponent(lblWouldYouLike)
						.addGap(40)
						.addComponent(btnSaveAndExit)
						.addGap(30)
						.addComponent(btnExitWithoutSaving)
						.addGap(30)
						.addComponent(btnCancel)
						.addContainerGap(40, Short.MAX_VALUE))
				);
		setLayout(groupLayout);

	}

}
