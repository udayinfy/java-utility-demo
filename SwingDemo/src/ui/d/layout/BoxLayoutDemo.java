package ui.d.layout;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoxLayoutDemo {

	public static void main(String[] a) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		LayoutManager layout = new BoxLayout(panel, BoxLayout.X_AXIS);
		panel.setLayout(layout);

		panel.add(new JLabel("a"));
		panel.add(new JLabel("b"));
		panel.add(new JLabel("c"));
		panel.add(new JLabel("d"));
		panel.add(new JLabel("e"));
		panel.add(new JLabel("f"));

		frame.add(panel);

		frame.setSize(300, 200);
		frame.setVisible(true);
	}

}