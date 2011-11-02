package ui.c.jbutton;

import javax.swing.JFrame ;
import javax.swing.JToggleButton ;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.java.swing.plaf.windows.WindowsLabelUI;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import java.awt.GridLayout ;

/*
 * ������İ�ť
 */
public class JToggleButtonDemo01{
	public static void main(String args[]){
		
		try {
			UIManager.setLookAndFeel(new WindowsLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		JFrame frame = new JFrame("Welcome To MLDN") ;
		JToggleButton but1 = new JToggleButton("��ѡ��",true) ;	 // Ĭ��ѡ��
		JToggleButton but2 = new JToggleButton("δѡ��") ;
		JToggleButton but3 = new JToggleButton("����") ;
		frame.setLayout(new GridLayout(3,1)) ;	// �����Ű���ʽ
		frame.add(but1) ;
		frame.add(but2) ;
		frame.add(but3) ;
		frame.setSize(200,100) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}
};