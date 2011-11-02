package ui.c.jbutton;

import javax.swing.JFrame ;
import javax.swing.JToggleButton ;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.java.swing.plaf.windows.WindowsLabelUI;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import java.awt.GridLayout ;

/*
 * 不弹起的按钮
 */
public class JToggleButtonDemo01{
	public static void main(String args[]){
		
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		JFrame frame = new JFrame("Welcome To MLDN") ;
		JToggleButton but1 = new JToggleButton("已选中",true) ;	 // 默认选中
		JToggleButton but2 = new JToggleButton("未选中") ;
		JToggleButton but3 = new JToggleButton("按我") ;
		frame.setLayout(new GridLayout(3,1)) ;	// 设置排版样式
		frame.add(but1) ;
		frame.add(but2) ;
		frame.add(but3) ;
		frame.setSize(200,100) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}
};