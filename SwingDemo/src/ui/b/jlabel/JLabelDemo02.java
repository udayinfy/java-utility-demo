package ui.b.jlabel;

import java.awt.Dimension ;
import java.awt.Color ;
import java.awt.Font ;
import java.awt.Point ;
import javax.swing.JLabel ;
import javax.swing.JFrame ;

public class JLabelDemo02{
	public static void main(String args[]){
		JFrame frame = new JFrame("Welcome To MLDN") ;
		JLabel lab = new JLabel("MLDN",JLabel.CENTER) ;	// 实例化标签对象
		Font fnt = new Font("Serief",Font.ITALIC + Font.BOLD,28) ;
		lab.setFont(fnt) ;
		frame.add(lab) ;	// 将组件件入到面板之中
		Dimension dim = new Dimension() ;
		frame.setBackground(Color.WHITE) ;//设置窗体的背景颜色
		dim.setSize(200,70) ;
		frame.setSize(dim) ;
		Point point = new Point(300,200) ;	// 设置坐标
		frame.setLocation(point) ;
		frame.setVisible(true) ;
	}
}; 