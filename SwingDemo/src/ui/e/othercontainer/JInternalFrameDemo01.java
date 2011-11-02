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

		JFrame frame = new JFrame("JInternalFrame"); // 实例化窗体对象
		Container cont = frame.getContentPane();

		JDesktopPane desk = new JDesktopPane(); // 定义窗体的容器

		cont.add(desk, BorderLayout.CENTER); // 设置显示样式
		cont.add(new JLabel("内部窗体"), BorderLayout.SOUTH);

		JInternalFrame jif = null;
		String picPath = "src/ui/e/othercontainer/Koala.jpg";
		Icon icon = new ImageIcon(picPath); // 实例化Icon对象

		for (int i = 0; i < 3; i++) {
			jif = new JInternalFrame("JInternalFrame-" + i, true, true, true, true);
			
			JPanel pan = new JPanel();
			pan.add(new JLabel( icon )); // 加入标签
			jif.add(pan);
			
			jif.setLocation(35 - i * 10, 35 - i * 10); // 设置显示位置
			jif.pack();
			jif.setVisible(true);
			
			desk.add(jif);
		}

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.setSize(230, 120);// 根据组件自动调整大小
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
