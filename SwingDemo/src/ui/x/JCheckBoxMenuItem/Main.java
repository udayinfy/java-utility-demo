package ui.x.JCheckBoxMenuItem;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * Check if a JCheckBoxMenuItem is selected in its item change listener
 * @author Admin
 *
 */
public class Main extends JFrame {
	JCheckBoxMenuItem check = new JCheckBoxMenuItem("Check");

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("Checkable");
		bar.add(menu);
		menu.add(check);

		check.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				System.out.println("Checked? " + check.isSelected());
			}
		});

		setJMenuBar(bar);
		getContentPane().add(new JLabel("A placeholder"));

		pack();
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String arg[]) {
		new Main();
	}
}