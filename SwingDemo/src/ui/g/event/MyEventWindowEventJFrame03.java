package ui.g.event;

import java.awt.event.WindowAdapter ;
import java.awt.event.WindowEvent ;
import java.awt.Color ;
import javax.swing.JFrame ;

public class MyEventWindowEventJFrame03{
	public static void main(String args[]){
		JFrame frame = new JFrame("Welcome To MLDN") ; 
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.out.println("windowClosing --> ���ڹر�") ;
				System.exit(1) ;
			}
		}) ;	// �����¼�
		frame.setSize(300,150) ;
		frame.setBackground(Color.WHITE) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}
};