package ui.c.jbutton;

import javax.swing.JFrame ;
import javax.swing.JButton ;
import java.awt.Font ;

public class JButtonDemo01{
	public static void main(String args[]){
		JFrame frame = new JFrame("Welcome To MLDN") ;	// ʵ�����������
		JButton but = new JButton("����") ;	 
		Font fnt = new Font("Serief",Font.BOLD,28);
		but.setFont(fnt) ;
		frame.add(but) ;
		frame.setSize(200,70) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}
};