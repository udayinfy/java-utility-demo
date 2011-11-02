package ui.d.layout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class EmptyBorder extends JFrame {

	public EmptyBorder() {
		
		JPanel simplePanel = new JPanel(new GridLayout(7, 1, 5, 5));
		
		simplePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel label = new JLabel("Lable", JLabel.CENTER);
		label.setForeground(Color.red.darker());

		simplePanel.add(label);
		
		add(simplePanel);
	}

	public static void main(String[] argv) {
		
		EmptyBorder borderFactoryDemo = new EmptyBorder();

		borderFactoryDemo.pack();

		borderFactoryDemo.setVisible(true);
		
		borderFactoryDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}