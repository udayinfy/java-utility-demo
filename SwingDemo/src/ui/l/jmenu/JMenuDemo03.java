package ui.l.jmenu;

import java.awt.event.WindowAdapter ;
import java.awt.event.WindowEvent ;
import java.awt.event.ActionListener ;
import java.awt.event.ActionEvent ;
import java.awt.Container ;
import java.io.File ;
import javax.swing.JFrame ;
import javax.swing.ImageIcon ;
import javax.swing.JTextArea ;
import javax.swing.JScrollPane ;
import javax.swing.JMenu ;
import javax.swing.KeyStroke ;
import javax.swing.JMenuBar ;
import javax.swing.JMenuItem ;

public class JMenuDemo03{
	public static void main(String args[]){
		JFrame frame = new JFrame("Welcome To MLDN") ;
		final JTextArea text = new JTextArea() ;
		text.setEditable(true) ;	// 可编辑
		frame.getContentPane().add(new JScrollPane(text)) ;	// 加入滚动条
		JMenu menuFile = new JMenu("文件") ;
		menuFile.setIcon(new ImageIcon("src\\ui\\l\\jmenu\\file.gif")) ;
		JMenuBar menuBar = new JMenuBar() ;
		menuBar.add(menuFile) ;

		JMenuItem newItem = new JMenuItem("新建",new ImageIcon("src\\ui\\l\\jmenu\\new.gif")) ;
		JMenuItem openItem = new JMenuItem("打开",new ImageIcon("src\\ui\\l\\jmenu\\open.gif")) ;
		JMenuItem closeItem = new JMenuItem("关闭",new ImageIcon("src\\ui\\l\\jmenu\\close.gif")) ;
		JMenuItem exitItem = new JMenuItem("退出",new ImageIcon("src\\ui\\l\\jmenu\\exit.gif")) ;

		// 此时定义完了四个菜单的选项，定义完成之后，增加快捷键
		newItem.setMnemonic('N') ;
		openItem.setMnemonic('O') ;
		closeItem.setMnemonic('C') ;
		exitItem.setMnemonic('E') ;

		newItem.setAccelerator(KeyStroke.getKeyStroke('N',java.awt.Event.CTRL_MASK)) ;
		openItem.setAccelerator(KeyStroke.getKeyStroke('O',java.awt.Event.CTRL_MASK)) ;
		closeItem.setAccelerator(KeyStroke.getKeyStroke('C',java.awt.Event.ALT_MASK)) ;
		exitItem.setAccelerator(KeyStroke.getKeyStroke('E',java.awt.Event.ALT_MASK)) ;

		newItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text.append("=== 选择了“新建”菜单项\n") ;
			}
		}) ;

		openItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text.append("=== 选择了“打开”菜单项\n") ;
			}
		}) ;

		closeItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text.append("=== 选择了“关闭”菜单项\n") ;
			}
		}) ;

		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				text.append("=== 选择了“退出”菜单项\n") ;
			}
		}) ;

		menuFile.add(newItem) ;
		menuFile.add(openItem) ;
		menuFile.add(closeItem) ;
		menuFile.add(exitItem) ;

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