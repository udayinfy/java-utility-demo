package ui.f.textcompenent;

import java.awt.GridLayout ;
import javax.swing.JFrame ;
import javax.swing.JTextArea ;
import javax.swing.JLabel ;

public class JTextAreaDemo01{
	public static void main(String args[]){
		JFrame frame = new JFrame("Welcome To MLDN") ;
		JTextArea jta = new JTextArea(3,10) ;	// 设置大小
		JLabel lab = new JLabel("多行文本域：") ;
		lab.setBounds(10,10,120,20) ; 
		jta.setBounds(130,10,150,100) ; 
		frame.setLayout(null) ;	// 取消布局管理器
		frame.add(lab) ;
		frame.add(jta) ;
		frame.setSize(300,150) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}
};