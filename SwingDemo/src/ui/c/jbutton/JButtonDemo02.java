package ui.c.jbutton;

import javax.swing.JFrame ;
import javax.swing.JButton ;
import javax.swing.Icon ;
import javax.swing.ImageIcon ;
import java.io.File ;
import java.awt.Font ;

public class JButtonDemo02{
	public static void main(String args[]){
		JFrame frame = new JFrame("Welcome To MLDN") ;	// ʵ�����������
		String picPath = "d:" + File.separator + "mldn.gif" ;
		Icon icon = new ImageIcon(picPath) ;
		JButton but = new JButton(icon) ;	 
		frame.add(but) ;
		frame.setSize(300,160) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}
};