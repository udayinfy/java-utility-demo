package ui.i.jcheckbox;

import java.io.File ;
import java.awt.Container ;
import java.awt.GridLayout ;
import java.awt.event.WindowAdapter ;
import java.awt.event.WindowEvent ;
import java.awt.event.ItemListener ;
import java.awt.event.ItemEvent ;
import javax.swing.JFrame ;
import javax.swing.ImageIcon ;
import javax.swing.JPanel ;
import javax.swing.JCheckBox ;
import javax.swing.BorderFactory ;

class MyItemListener implements ItemListener{
	private String right = "src\\ui\\i\\jcheckbox\\right.png" ;
	private String wrong = "src\\ui\\i\\jcheckbox\\wrong.gif" ;
	public void itemStateChanged(ItemEvent e){
		// ������β�������϶���JCheckBox�����¼�
		JCheckBox jcb = (JCheckBox)e.getItem() ;	// �õ��������¼�
		if(jcb.isSelected()){	// �����ѡ���ˣ�����ʾ��ȷ��ͼƬ
			jcb.setIcon(new ImageIcon(right)) ;
		}else{
			jcb.setIcon(new ImageIcon(wrong)) ;
		}
	}
}
class MyCheckBox02{
	
	private String wrong = "d:" + File.separator + "wrong.gif" ;
	private JFrame frame = new JFrame("Welcome To MLDN") ;	// ���崰��
	private Container cont = frame.getContentPane() ;	// �õ���������
	private JCheckBox jcb1 = new JCheckBox("MLDN",new ImageIcon(wrong)) ;	// ����һ����ѡ��
	private JCheckBox jcb2 = new JCheckBox("MLDNJAVA",new ImageIcon(wrong)) ;	// ����һ����ѡ��
	private JCheckBox jcb3 = new JCheckBox("������",new ImageIcon(wrong)) ;	// ����һ����ѡ��
	private JPanel pan = new JPanel() ;
	public MyCheckBox02(){
		pan.setBorder(BorderFactory.createTitledBorder("��ѡ����ϲ������վ")) ;
		pan.setLayout(new GridLayout(1,3)) ;	// ����������Ű� 
		pan.add(this.jcb1) ;	// �������
		pan.add(this.jcb2) ;	// �������
		pan.add(this.jcb3) ;	// �������

		jcb1.addItemListener(new MyItemListener()) ;
		jcb2.addItemListener(new MyItemListener()) ;
		jcb3.addItemListener(new MyItemListener()) ;

		cont.add(pan) ;	// �������뵽����֮��
		this.frame.setSize(330,80) ;
		this.frame.setVisible(true) ;	// ���ÿ���ʾ
		this.frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent arg){
				System.exit(1) ;
			}
		}) ;
	}
	
}

public class JCheckBoxDemo02{
	public static void main(String args[]){
		new MyCheckBox02() ;
	}
}