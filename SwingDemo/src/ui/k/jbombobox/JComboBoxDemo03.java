package ui.k.jbombobox;

import javax.swing.JFrame ;
import java.awt.Container ;
import java.awt.Font ;
import java.awt.event.WindowEvent ;
import java.awt.event.ActionListener ;
import java.awt.event.ItemListener ;
import java.awt.event.ItemEvent ;
import java.awt.event.ActionEvent ;
import java.awt.event.WindowAdapter ;
import java.awt.GridLayout ;
import javax.swing.JComboBox ;
import javax.swing.JLabel ;
import javax.swing.ComboBoxEditor ;
import javax.swing.BorderFactory ;
import java.util.Vector ;

class MyComboBox03 implements ItemListener,ActionListener{
	private JFrame frame = new JFrame("Welcome TO MLDN") ;
	private Container cont = frame.getContentPane() ;	// �õ�����
	private JComboBox jcb1 = null ;
	private JLabel label = new JLabel("www.MLDNJAVA.cn") ;	// �����ǩ
	private String fontSize[] = {"10","12","14","16","18","20","22","24","26","48","72"} ;
	
	public MyComboBox03(){
		this.frame.setLayout(new GridLayout(2,2)) ;	// �����Ű�
		this.jcb1 = new JComboBox(fontSize) ;	// ʵ���������б��

		this.jcb1.addItemListener(this) ;
		this.jcb1.addActionListener(this) ;

		this.jcb1.setEditable(true) ;	// ��ʾ���Ա༭

		// Ϊÿһ������������һ���߿�
		this.jcb1.setBorder(BorderFactory.createTitledBorder("��ϲ��ȥ�Ǹ��������Σ�")) ;
		ComboBoxEditor editor = null ;
		editor = this.jcb1.getEditor() ;	/// �õ��༭����
		this.jcb1.configureEditor(editor,"12") ;// ָ��Ĭ��ֵ
		this.jcb1.setMaximumRowCount(3) ;

		this.changeFontSize(12) ;	// Ĭ��ֵ
		cont.add(this.jcb1) ;

		cont.add(label) ;
		this.frame.setSize(300,150) ;
		this.frame.setVisible(true) ;
		this.frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;
	}
	public void itemStateChanged(ItemEvent e){
		if(e.getStateChange()==ItemEvent.SELECTED){	// �ж��Ƿ���ѡ��
			String itemSize = (String)e.getItem() ;
			try{
				this.changeFontSize(Integer.parseInt(itemSize)) ;
			}catch(Exception e1){
				
			}
		}
	}

	public void actionPerformed(ActionEvent e){
		String item = (String)this.jcb1.getSelectedItem() ;
		int size = 12 ;	// ����һ��Ĭ�ϴ�С
		try{
			size = Integer.parseInt(item) ;
		}catch(Exception e1){}
		this.changeFontSize(size) ;
		// �жϸ�����size�Ƿ���ڣ��������������Ҫ���µ�����������ȥ
		if(!this.isExists(item))
		{
			this.jcb1.addItem(jcb1.getSelectedItem()) ;
		}
	}
	public boolean isExists(String item){
		boolean flag = false ;
		for(int i=0;i<this.jcb1.getItemCount();i++){
			if(item.equals(this.jcb1.getItemAt(i))){
				flag = true ;
			}
		}
		return flag ;
	}
	public void changeFontSize(int size){
		System.out.println("*************" + size) ;
		Font fnt = new Font("Serief",Font.BOLD,size) ;
		this.label.setFont(fnt) ;
	}

}

public class JComboBoxDemo03{
	public static void main(String args[]){
		new MyComboBox03() ;
	}
}	



