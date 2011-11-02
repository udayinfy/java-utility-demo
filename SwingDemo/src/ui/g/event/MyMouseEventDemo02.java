package ui.g.event;

import java.awt.event.WindowAdapter ;
import java.awt.event.MouseAdapter ;
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

class MyMouseHandle02 extends JFrame{
	
	private JTextArea text = new JTextArea() ;
	
	public MyMouseHandle02(){
		super.setTitle("Welcome To MLDN") ;
		JScrollPane scr = new JScrollPane(text) ;
		scr.setBounds(5,5,300,200) ;
		super.add(scr) ;
		text.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int c = e.getButton() ;
				String mouseInfo = null ;
				if(c==MouseEvent.BUTTON1){
					mouseInfo = "���" ;
				}
				if(c==MouseEvent.BUTTON3){
					mouseInfo = "�Ҽ�" ;
				}
				if(c==MouseEvent.BUTTON2){
					mouseInfo = "����" ;
				}
				text.append("��굥����" + mouseInfo + "\n") ;
			}
		}) ;
		super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	// �����¼�
		super.setSize(310,210) ;
		super.setVisible(true) ;
	}
};


public class MyMouseEventDemo02{
	public static void main(String args[]){
		new MyMouseHandle02() ;
	}
};


