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

		JFrame frame = new JFrame("JScrollPane"); // 实例化窗体对象
		Container cont = frame.getContentPane();

		String picPath = "src/ui/e/othercontainer/Koala.jpg";
		Icon icon = new ImageIcon(picPath); // 实例化Icon对象

		JPanel pan = new JPanel();
		JLabel lab = new JLabel(icon);
		pan.add(lab);

		JScrollPane scr1 = null;
		// 设置垂直和水平的滚动条一直显示
		scr1 = new JScrollPane(pan, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		cont.add(scr1);

		
		frame.setSize(400, 300);// 根据组件自动调整大小
		frame.setLocation(400, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
};