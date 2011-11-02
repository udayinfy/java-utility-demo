package ui.c.jbutton;

import javax.swing.JFrame ;
import javax.swing.JButton ;
import java.awt.Font ;

public class JButtonDemo01{
	public static void main(String args[]){
		JFrame frame = new JFrame("Welcome To MLDN") ;	// 实例化窗体对象
		JButton but = new JButton("按我") ;	 
		Font fnt = new Font("Serief",Font.BOLD,28);
		but.setFont(fnt) ;
		frame.add(but) ;
		frame.setSize(200,70) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}
};