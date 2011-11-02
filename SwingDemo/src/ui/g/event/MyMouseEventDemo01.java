package ui.g.event;

import java.awt.event.WindowAdapter ;
import java.awt.event.MouseListener ;
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

class MyMouseHandle01 extends JFrame implements MouseListener{
	private JTextArea text = new JTextArea() ;
	public MyMouseHandle01(){
		super.setTitle("Welcome To MLDN") ;
		JScrollPane scr = new JScrollPane(text) ;
		scr.setBounds(5,5,300,200) ;
		super.add(scr) ;
		text.addMouseListener(this) ;
		super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	// �����¼�
		super.setSize(310,210) ;
		super.setVisible(true) ;
	}
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

	public void mouseEntered(MouseEvent e){
		text.append("�����������\n") ;
	}
	public void mouseExited(MouseEvent e){
		text.append("����뿪�����\n") ;
	}
	public void mousePressed(MouseEvent e){
		text.append("��갴�¡�\n") ;
	}
	public void mouseReleased(MouseEvent e){
		text.append("����ɿ���\n") ;
	}
	
};


public class MyMouseEventDemo01{
	public static void main(String args[]){
		new MyMouseHandle01() ;
	}
};