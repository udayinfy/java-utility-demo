package ui.a.jframe;

import javax.swing.JFrame ;
import java.awt.Color ;
import java.awt.Dimension ;
import java.awt.Point ;

public class JFrameDemo02{
	public static void main(String args[]){
		JFrame f = new JFrame("第一个Swing窗体") ;
		Dimension d = new Dimension() ;
		d.setSize(230,80) ;
		f.setSize(d) ;	// 设置组件的大小
		f.setBackground(Color.WHITE) ;	// 将背景设置成白色
		Point p = new Point(300,200) ;	// 指定组件的显示位置
		f.setLocation(p) ;	// 设置组件的显示位置
		f.setVisible(true) ;	// 让组件可见
	}
};