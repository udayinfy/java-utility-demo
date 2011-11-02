package ui.z.jcolorchooser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JColorChooserDemo {
	
	JFrame jf = new JFrame("JColorChooserDemo");
	Point pt = new Point(400,300);
	Dimension dim = new Dimension(400,300);
	JPanel jp = new JPanel();
	
	JButton btnColor = new JButton("颜色选择器");
	
	public JColorChooserDemo(){
		
		btnColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color c = JColorChooser.showDialog(btnColor, "选择你需要的颜色", Color.BLACK);
				if (c != null) {
					System.out.println(c.toString());
				}
			}
		});
		
		jf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
			
		});
		
		jp.setBorder(BorderFactory.createTitledBorder("颜色选择器"));
		jp.add(btnColor);
		jf.add(jp);
		
		jf.setLocation(pt);
		jf.setSize(dim);
		jf.setVisible(true);
		
		
	}
	

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		new JColorChooserDemo();
		
	}
	

}



