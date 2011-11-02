package ui.x.JCheckBoxMenuItem;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Listening to JCheckBoxMenuItem with an ItemListener
 * @author Admin
 *
 */
public class JCheckBoxMenuItemActionListener2 {

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

		ItemListener iListener = new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				Icon girlIcon = new ImageIcon("src/ui/x/jCheckBoxMenuItem/girl-r.jpg");
				Icon boyIcon = new ImageIcon("src/ui/x/jCheckBoxMenuItem/boy-r.jpg");
				AbstractButton aButton = (AbstractButton) event.getSource();
				int state = event.getStateChange();
				String newLabel;
				Icon newIcon;
				if (state == ItemEvent.SELECTED) {
					newLabel = "Girl";
					newIcon = girlIcon;
				} else {
					newLabel = "Boy";
					newIcon = boyIcon;
				}
				aButton.setText(newLabel);
				aButton.setIcon(newIcon);
			}
		};

		caseMenuItem.addItemListener(iListener);
		
		frame.setJMenuBar(menuBar);
		frame.setSize(350, 250);
		frame.setVisible(true);
	}
}