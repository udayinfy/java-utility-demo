package ui.l.jmenu;

import java.awt.event.WindowAdapter ;
import java.awt.event.WindowEvent ;
import java.awt.Container ;
import java.io.File ;
import javax.swing.JFrame ;
import javax.swing.ImageIcon ;
import javax.swing.JTextArea ;
import javax.swing.JScrollPane ;
import javax.swing.JMenu ;
import javax.swing.JMenuBar ;

public class JMenuDemo01{
	public static void main(String args[]){
		JFrame frame = new JFrame("Welcome To MLDN") ;
		JTextArea text = new JTextArea() ;
		text.setEditable(true) ;	// 可编辑
		frame.getContentPane().add(new JScrollPane(text)) ;	// 加入滚动条
		JMenu menuFile = new JMenu("文件") ;
		menuFile.setIcon(new ImageIcon("src\\ui\\l\\jmenu\\file.gif")) ;
		JMenuBar menuBar = new JMenuBar() ;
		menuBar.add(menuFile) ;
		frame.setJMenuBar(menuBar) ;	// 菜单是需要通过此方法增加的
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;
		frame.setVisible(true) ;
		frame.setSize(300,100) ;
		frame.setLocation(300,200) ;
	}
}