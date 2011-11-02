package ui.g.event;

import java.awt.event.WindowListener ;
import java.awt.event.WindowEvent ;
import java.awt.Color ;
import javax.swing.JFrame ;

class MyWindowEventHandle01 implements WindowListener{
	public void windowActivated(WindowEvent e){
		System.out.println("windowActivated --> 窗口被选中") ;
	}
	public void windowClosed(WindowEvent e){
		System.out.println("windowClosed --> 窗口被关闭") ;
	}
	public void windowClosing(WindowEvent e){
		System.out.println("windowClosing --> 窗口关闭") ;
		System.exit(1) ;
	}
	public void windowDeactivated(WindowEvent e){
		System.out.println("windowDeactivated --> 取消窗口选中") ;
	}
	public void windowDeiconified(WindowEvent e){
		System.out.println("windowDeiconified --> 窗口从最小化恢复") ;
	}
	public void windowIconified(WindowEvent e){
		System.out.println("windowIconified --> 窗口最小化") ;
	}
	public void windowOpened(WindowEvent e){
		System.out.println("windowOpened --> 窗口被打开") ;
	}
};

public class MyEventWindowEventJFrame01{
	public static void main(String args[]){
		JFrame frame = new JFrame("Welcome To MLDN") ; 
		frame.addWindowListener(new MyWindowEventHandle01()) ;	// 加入事件
		frame.setSize(300,150) ;
		frame.setBackground(Color.WHITE) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}
};