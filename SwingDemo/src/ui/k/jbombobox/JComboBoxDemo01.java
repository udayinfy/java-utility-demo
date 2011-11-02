package ui.k.jbombobox;

import javax.swing.JFrame ;
import java.awt.Container ;
import java.awt.event.WindowEvent ;
import java.awt.event.WindowAdapter ;
import java.awt.GridLayout ;
import javax.swing.JComboBox ;
import javax.swing.JLabel ;
import javax.swing.BorderFactory ;
import java.util.Vector ;

class MyComboBox01{
	
	private JFrame frame = new JFrame("Welcome TO MLDN") ;
	private Container cont = frame.getContentPane() ;	// �õ�����
	private JComboBox jcb1 = null ;
	private JComboBox jcb2 = null ;
	
	public MyComboBox01(){
		
		this.frame.setLayout(new GridLayout(2,2)) ;	// �����Ű�
		
		String nations[] = {"�й�","����","����","����","�����","����"} ;
		Vector<String> v = new Vector<String>() ;
		v.add("MLDN") ;	// ��������
		v.add("MLDNJAVA") ;	// ��������
		v.add("������") ;	// ��������
		this.jcb1 = new JComboBox(nations) ;	// ʵ���������б��
		this.jcb2 = new JComboBox(v) ;	// ʵ���������б��

		// Ϊÿһ������������һ���߿�
		this.jcb1.setBorder(BorderFactory.createTitledBorder("��ϲ��ȥ�Ǹ��������Σ�")) ;
		this.jcb2.setBorder(BorderFactory.createTitledBorder("��ϲ������վ��")) ;
		
		cont.add(this.jcb1) ;
		cont.add(this.jcb2) ;
		cont.add(new JLabel("�����б��")) ;
		
		
		this.frame.setSize(300,150) ;
		this.frame.setVisible(true) ;
		
		this.frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;
	}
}

public class JComboBoxDemo01{
	public static void main(String args[]){
		new MyComboBox01() ;
	}
}



