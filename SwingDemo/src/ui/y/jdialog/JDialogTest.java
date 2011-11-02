package ui.y.jdialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class JDialogTest {

	JFrame jf = new JFrame("JFrame");
	JPanel jp = new JPanel();
	JTextField jtf = new JTextField(20);
	JButton jb = new JButton("Validate");

	JDialog jd;
	JLabel jl = new JLabel();

	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	public JDialogTest() {
		
		jp.add(jtf);
		jp.add(jb);
		jf.add(jp);
		
		jf.setSize(400, 300);
		jf.setLocation(300, 200);
		jf.setVisible(true);
		jf.setLocation((d.width - jf.getSize().width) / 2,
				(d.height - jf.getSize().height) / 2);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		jd = new JDialog(jf, "JDialog", true);
		jd.setLayout(new BorderLayout());
		jd.add(jl, BorderLayout.CENTER);
		jd.setSize(200, 100);
		
		jd.setLocation((d.width - jd.getSize().width) / 2,
				(d.height - jd.getSize().height) / 2);
		
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String text = jtf.getText();
				
				if (text == null || "".equals(text.trim())) {
					jl.setText("数据不能为空");
				} else if (text.trim().length() != 6) {
					jl.setText("数据应为6位");
				} else {
					jl.setText("数据符合数据校验！！");
				}
				
				jd.setVisible(true);
				jd.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
				
			}
		});
		
	}
	
	public static void main(String[] args) {
		new JDialogTest();
	}

}
