package ui.d.layout;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class CardLayoutDemo01 {
	public static void main(String args[]) {
		JFrame frame = new JFrame("CardLayout");
		CardLayout card = new CardLayout();
		frame.setLayout(card);

		Container con = frame.getContentPane();
		con.add(new JLabel("标签-A", JLabel.CENTER), "first");
		con.add(new JLabel("标签-B", JLabel.CENTER), "second");
		con.add(new JLabel("标签-C", JLabel.CENTER), "thrid");
		con.add(new JLabel("标签-D", JLabel.CENTER), "fourth");
		con.add(new JLabel("标签-E", JLabel.CENTER), "fifth");

		frame.setSize(400, 300);
		frame.setVisible(true);

		card.show(con, "thrid");
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
			card.next(con);
		}

	}
};