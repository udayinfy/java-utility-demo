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
		JFrame frame = new JFrame("JSplitPane"); // 实例化窗体对象
		Container cont = frame.getContentPane();
		JPanel pan = new JPanel(); // 准备好了一个面板

		JSplitPane lfsplit = null; // 左右分割
		JSplitPane tpsplit = null; // 上下分割

		lfsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				new JLabel("左标签"), new JLabel("右标签"));
		lfsplit.setDividerSize(3); // 设置左右分割条的分割线大小

		tpsplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, lfsplit,
				new JLabel("下标签"));
		tpsplit.setDividerSize(10); // 设置左右分割条的分割线大小

		tpsplit.setOneTouchExpandable(true);
		cont.add(tpsplit);


		frame.pack();// 根据组件自动调整大小
		frame.setLocation(300, 200);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
};