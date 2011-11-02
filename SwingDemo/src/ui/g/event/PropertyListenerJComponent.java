package ui.g.event;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;

class ActionChangedListener implements PropertyChangeListener {

	private JButton button;

	public ActionChangedListener(JButton button) {
		this.button = button;
	}

	public void propertyChange(PropertyChangeEvent e) {
		String propertyName = e.getPropertyName();
		System.out.println(propertyName);
		if (e.getPropertyName().equals(Action.NAME)) {
			String text = (String) e.getNewValue();
			button.setText(text);
			button.repaint();
		} else if (propertyName.equals("enabled")) {
			Boolean enabledState = (Boolean) e.getNewValue();
			button.setEnabled(enabledState.booleanValue());
			button.repaint();
		} else if (e.getPropertyName().equals(Action.SMALL_ICON)) {
			Icon icon = (Icon) e.getNewValue();
			button.setIcon(icon);
			button.invalidate();
			button.repaint();
		}
	}
}

public class PropertyListenerJComponent {

	public static void main(String[] a) {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton bn = new JButton();

		bn.addPropertyChangeListener(new ActionChangedListener(bn));

		frame.add(bn);
		bn.setEnabled(false);

		frame.setSize(300, 300);
		frame.setVisible(true);

		frame.add(bn);
	}

}