package ui.f.textcompenent;

import java.awt.GridLayout ;
import javax.swing.JFrame ;
import javax.swing.JTextArea ;
import javax.swing.JScrollPane ;
import javax.swing.JLabel ;

public class JTextAreaDemo02{
	public static void main(String args[]){
		JFrame frame = new JFrame("Welcome To MLDN") ;
		JTextArea jta = new JTextArea(3,10) ;	// ���ô�С
		JLabel lab = new JLabel("�����ı���") ;
		JScrollPane scr = new JScrollPane(jta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS ) ;
		frame.setLayout(new GridLayout(2,1)) ;	// ȡ�����ֹ�����
		frame.add(lab) ;
		frame.add(scr) ;
		frame.setSize(300,150) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}
};