package ui.g.event;

import java.awt.event.WindowAdapter ;
import java.awt.event.MouseMotionListener ;
import java.awt.event.WindowEvent ;
import java.awt.event.MouseEvent ;
import java.awt.Color ;
import javax.swing.JFrame ;
import java.awt.event.ActionListener ;
import java.awt.event.WindowEvent ;
import java.awt.event.ActionEvent ;
import java.awt.Color ;
import java.awt.GridLayout ;
import java.awt.Font ;
import javax.swing.JFrame ;
import javax.swing.JButton ;
import javax.swing.JLabel ;
import javax.swing.JTextArea ;
import javax.swing.JPasswordField ;
import javax.swing.JScrollPane ;
import javax.swing.JPanel ;

class MyMouseMotionHandle01 extends JFrame{
	public MyMouseMotionHandle01(){
		super.setTitle("Welcome To MLDN") ;
		super.addMouseMotionListener(new MouseMotionListener(){
			public void mouseDragged(MouseEvent e){
				System.out.println("鼠标拖拽到：X = " + e.getX() + "，Y = " + e.getY()) ;
			}
			public void mouseMoved(MouseEvent e){
				System.out.println("鼠标移动到窗体。") ;
			}
		}) ;
		super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	// 加入事件
		super.setSize(310,210) ;
		super.setVisible(true) ;
	}
};


public class MyMouseMotionEventDemo01{
	public static void main(String args[]){
		new MyMouseMotionHandle01() ;
	}
};