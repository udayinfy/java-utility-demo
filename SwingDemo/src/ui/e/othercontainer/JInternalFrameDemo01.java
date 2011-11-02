package ui.e.othercontainer;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.junit.Test;

public class JInternalFrameDemo01 {

	public static void main(String[] args) {

		JFrame frame = new JFrame("JInternalFrame"); // ʵ�����������
		Container cont = frame.getContentPane();

		JDesktopPane desk = new JDesktopPane(); // ���崰�������

		cont.add(desk, BorderLayout.CENTER); // ������ʾ��ʽ
		cont.add(new JLabel("�ڲ�����"), BorderLayout.SOUTH);

		JInternalFrame jif = null;
		String picPath = "src/ui/e/othercontainer/Koala.jpg";
		Icon icon = new ImageIcon(picPath); // ʵ����Icon����

		for (int i = 0; i < 3; i++) {
			jif = new JInternalFrame("JInternalFrame-" + i, true, true, true, true);
			
			JPanel pan = new JPanel();
			pan.add(new JLabel( icon )); // �����ǩ
			jif.add(pan);
			
			jif.setLocation(35 - i * 10, 35 - i * 10); // ������ʾλ��
			jif.pack();
			jif.setVisible(true);
			
			desk.add(jif);
		}

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.setSize(230, 120);// ��������Զ�������С
		frame.setLocation(300, 200);
		frame.setVisible(true);
	}
	
	public static void main(String args){
		
		JFrame jf = new JFrame();
		
		Icon icon = new ImageIcon("src/ui/e/othercontainer/Koala.jpg");
		JLabel jl = new JLabel( icon );
		
		Container container = jf.getContentPane();
		
		container.add(jl);
		
		jf.setSize(400,300);
		jf.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
		jf.setVisible( true );
		
	}
};
