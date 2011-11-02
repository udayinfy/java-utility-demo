package ui.g.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PropertyChangeListenerDemo {

	public static void main(String args[]) {

		Runnable runner = new Runnable() {
			public void run() {
				JFrame frame = new JFrame("Button Sample");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				final JButton button1 = new JButton("Select Me");
				final JButton button2 = new JButton("No Select Me");
				final Random random = new Random();
				// Define ActionListener
				ActionListener actionListener = new ActionListener() {
					public void actionPerformed(ActionEvent actionEvent) {
						JButton button = (JButton) actionEvent.getSource();
						int red = random.nextInt(255);
						int green = random.nextInt(255);
						int blue = random.nextInt(255);
						button.setBackground(new Color(red, green, blue));
					}
				};
				// Define PropertyChangeListener
				PropertyChangeListener propertyChangeListener = new PropertyChangeListener() {
					public void propertyChange(
							PropertyChangeEvent propertyChangeEvent) {
						String property = propertyChangeEvent.getPropertyName();
						System.out.println( "---->" + propertyChangeEvent.getPropertyName() );
						if ("background".equals(property)) {
							button2.setBackground((Color) propertyChangeEvent
									.getNewValue());
						}
					}
				};
				button1.addActionListener(actionListener);
				button1.addPropertyChangeListener(propertyChangeListener);
				button2.addActionListener(actionListener);
				frame.add(button1, BorderLayout.NORTH);
				frame.add(button2, BorderLayout.SOUTH);
				frame.setSize(300, 100);
				frame.setVisible(true);
			}
		};

		EventQueue.invokeLater(runner);

	}
}