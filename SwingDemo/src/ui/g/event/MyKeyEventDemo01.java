package ui.g.event;

import java.awt.event.WindowAdapter ;
import java.awt.event.KeyListener ;
import java.awt.event.WindowEvent ;
import java.awt.event.KeyEvent ;
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

class MyKeyHandle01 extends JFrame implements KeyListener{
	private JTextArea text = new JTextArea() ;
	public MyKeyHandle01(){
		super.setTitle("Welcome To MLDN") ;
		JScrollPane scr = new JScrollPane(text) ;
		scr.setBounds(5,5,300,200) ;
		super.add(scr) ;
		text.addKeyListener(this) ;
		super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	// �����¼�
		super.setSize(310,210) ;
		super.setVisible(true) ;
	}
	public void keyPressed(KeyEvent e){
		text.append("���̡�" + KeyEvent.getKeyText(e.getKeyCode())+ "��������\n") ;
	}

	public void keyReleased(KeyEvent e){
		text.append("���̡�" + KeyEvent.getKeyText(e.getKeyCode())+ "�����ɿ�\n") ;
	}

	public void keyTyped(KeyEvent e){
		text.append("����������ǣ�" + e.getKeyChar() + "\n") ;
	} 
};


public class MyKeyEventDemo01{
	public static void main(String args[]){
		new MyKeyHandle01() ;
	}
};