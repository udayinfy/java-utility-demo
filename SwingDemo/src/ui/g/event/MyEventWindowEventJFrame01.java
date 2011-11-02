package ui.g.event;

import java.awt.event.WindowListener ;
import java.awt.event.WindowEvent ;
import java.awt.Color ;
import javax.swing.JFrame ;

class MyWindowEventHandle01 implements WindowListener{
	public void windowActivated(WindowEvent e){
		System.out.println("windowActivated --> ���ڱ�ѡ��") ;
	}
	public void windowClosed(WindowEvent e){
		System.out.println("windowClosed --> ���ڱ��ر�") ;
	}
	public void windowClosing(WindowEvent e){
		System.out.println("windowClosing --> ���ڹر�") ;
		System.exit(1) ;
	}
	public void windowDeactivated(WindowEvent e){
		System.out.println("windowDeactivated --> ȡ������ѡ��") ;
	}
	public void windowDeiconified(WindowEvent e){
		System.out.println("windowDeiconified --> ���ڴ���С���ָ�") ;
	}
	public void windowIconified(WindowEvent e){
		System.out.println("windowIconified --> ������С��") ;
	}
	public void windowOpened(WindowEvent e){
		System.out.println("windowOpened --> ���ڱ���") ;
	}
};

public class MyEventWindowEventJFrame01{
	public static void main(String args[]){
		JFrame frame = new JFrame("Welcome To MLDN") ; 
		frame.addWindowListener(new MyWindowEventHandle01()) ;	// �����¼�
		frame.setSize(300,150) ;
		frame.setBackground(Color.WHITE) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}
};