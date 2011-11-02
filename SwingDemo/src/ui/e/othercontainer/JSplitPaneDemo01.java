package ui.e.othercontainer;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.Container;
import javax.swing.JSplitPane;

public class JSplitPaneDemo01 {

	public static void main(String args[]) {
		JFrame frame = new JFrame("JSplitPane"); // ʵ�����������
		Container cont = frame.getContentPane();
		JPanel pan = new JPanel(); // ׼������һ�����

		JSplitPane lfsplit = null; // ���ҷָ�
		JSplitPane tpsplit = null; // ���·ָ�

		lfsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				new JLabel("���ǩ"), new JLabel("�ұ�ǩ"));
		lfsplit.setDividerSize(3); // �������ҷָ����ķָ��ߴ�С

		tpsplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, lfsplit,
				new JLabel("�±�ǩ"));
		tpsplit.setDividerSize(10); // �������ҷָ����ķָ��ߴ�С

		tpsplit.setOneTouchExpandable(true);
		cont.add(tpsplit);


		frame.pack();// ��������Զ�������С
		frame.setLocation(300, 200);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
};