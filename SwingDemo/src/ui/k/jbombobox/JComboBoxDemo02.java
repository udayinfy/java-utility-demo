package ui.k.jbombobox;

import javax.swing.JFrame ;
import java.awt.Container ;
import java.awt.event.WindowEvent ;
import java.awt.event.WindowAdapter ;
import java.awt.GridLayout ;
import javax.swing.JComboBox ;
import javax.swing.JLabel ;
import javax.swing.JLabel ;
import javax.swing.AbstractListModel ;
import javax.swing.BorderFactory ;
import javax.swing.ComboBoxEditor ;
import javax.swing.ComboBoxModel ;
import java.util.Vector ;

class MyComboBoxModel extends AbstractListModel implements ComboBoxModel{
	private String nations[] = {"�й�","����","����","����","�����","����"} ;
	private String item = null ;
	
	public Object getSelectedItem(){	// �õ�ѡ���ѡ��
		return this.item ;
	}
	public void setSelectedItem(Object anItem){	// ����ѡ��
		this.item = (String)anItem ;
	}
	public int getSize(){
		return this.nations.length ;
	}
	public Object getElementAt(int ind){
		return this.nations[ind] ;
	}
}

class MyComboBox02{
	
	private String defaultMsg = "��ѡ���������ҵ����ơ�" ;
	private JFrame frame = new JFrame("Welcome TO MLDN") ;
	private Container cont = frame.getContentPane() ;	// �õ�����
	private JComboBox jcb1 = null ;
	private JComboBox jcb2 = null ;
	public MyComboBox02(){
		this.frame.setLayout(new GridLayout(2,1)) ;	// �����Ű�
		
		this.jcb1 = new JComboBox(new MyComboBoxModel()) ;	// ʵ���������б��
		this.jcb1.setEditable(true) ;	// ��ʾ���Ա༭

		// Ϊÿһ������������һ���߿�
		this.jcb1.setBorder(BorderFactory.createTitledBorder("��ϲ��ȥ�Ǹ��������Σ�")) ;
		ComboBoxEditor editor = null ;
		editor = this.jcb1.getEditor() ;	/// �õ��༭����
		this.jcb1.configureEditor(editor,defaultMsg) ;// ָ��Ĭ��ֵ
		this.jcb1.setMaximumRowCount(3) ;
		cont.add(this.jcb1) ;
		cont.add(new JLabel("�����б��")) ;
		this.frame.setSize(180,150) ;
		this.frame.setVisible(true) ;
		this.frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;
	}
}

public class JComboBoxDemo02{
	public static void main(String args[]){
		new MyComboBox02() ;
	}
}