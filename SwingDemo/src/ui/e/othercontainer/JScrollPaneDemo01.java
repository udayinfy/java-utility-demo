package ui.e.othercontainer;

import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class JScrollPaneDemo01 {

	public static void main(String args[]) {

		JFrame frame = new JFrame("JScrollPane"); // ʵ�����������
		Container cont = frame.getContentPane();

		String picPath = "src/ui/e/othercontainer/Koala.jpg";
		Icon icon = new ImageIcon(picPath); // ʵ����Icon����

		JPanel pan = new JPanel();
		JLabel lab = new JLabel(icon);
		pan.add(lab);

		JScrollPane scr1 = null;
		// ���ô�ֱ��ˮƽ�Ĺ�����һֱ��ʾ
		scr1 = new JScrollPane(pan, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		cont.add(scr1);

		
		frame.setSize(400, 300);// ��������Զ�������С
		frame.setLocation(400, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
};