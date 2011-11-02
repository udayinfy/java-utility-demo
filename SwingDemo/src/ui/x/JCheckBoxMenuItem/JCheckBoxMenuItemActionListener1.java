package ui.x.JCheckBoxMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Listening to JCheckBoxMenuItem Events with an ActionListener
 * @author Admin
 *
 */

public class JCheckBoxMenuItemActionListener1 {

	public static void main(final String args[]) {
		JFrame frame = new JFrame("MenuSample Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();

		// File Menu, F - Mnemonic
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);

		// File->New, N - Mnemonic
		JMenuItem newMenuItem = new JMenuItem("New", KeyEvent.VK_N);
		fileMenu.add(newMenuItem);

		JCheckBoxMenuItem caseMenuItem = new JCheckBoxMenuItem("Case Sensitive");
		caseMenuItem.setMnemonic(KeyEvent.VK_C);
		fileMenu.add(caseMenuItem);

		ActionListener aListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton aButton = (AbstractButton) event.getSource();
				boolean selected = aButton.getModel().isSelected();
				String newLabel;
				Icon newIcon;
				if (selected) {
					newLabel = "A";
				} else {
					newLabel = "B";
				}
				aButton.setText(newLabel);
			}
		};

		caseMenuItem.addActionListener(aListener);
		
		frame.setJMenuBar(menuBar);
		frame.setSize(350, 250);
		frame.setVisible(true);
	}
}