package ui.a.jframe;

import javax.swing.JFrame ;
import java.awt.Color ;

public class JFrameDemo01{
	public static void main(String args[]){
		JFrame f = new JFrame("第一个Swing窗体") ;
		f.setSize(230,80) ;	// 设置组件的大小
		f.setBackground(Color.WHITE) ;	// 将背景设置成白色
		f.setLocation(300,200) ;	// 设置组件的显示位置
		f.setVisible(true) ;	// 让组件可见
	}
};