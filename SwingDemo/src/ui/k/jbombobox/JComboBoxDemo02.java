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
	private String nations[] = {"中国","巴西","美国","韩国","意大利","法国"} ;
	private String item = null ;
	
	public Object getSelectedItem(){	// 得到选择的选项
		return this.item ;
	}
	public void setSelectedItem(Object anItem){	// 设置选项
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
	
	private String defaultMsg = "请选择或输入国家的名称。" ;
	private JFrame frame = new JFrame("Welcome TO MLDN") ;
	private Container cont = frame.getContentPane() ;	// 得到容器
	private JComboBox jcb1 = null ;
	private JComboBox jcb2 = null ;
	public MyComboBox02(){
		this.frame.setLayout(new GridLayout(2,1)) ;	// 定义排版
		
		this.jcb1 = new JComboBox(new MyComboBoxModel()) ;	// 实例化下拉列表框
		this.jcb1.setEditable(true) ;	// 表示可以编辑

		// 为每一个下拉框增加一个边框
		this.jcb1.setBorder(BorderFactory.createTitledBorder("你喜欢去那个国家旅游？")) ;
		ComboBoxEditor editor = null ;
		editor = this.jcb1.getEditor() ;	/// 得到编辑对象
		this.jcb1.configureEditor(editor,defaultMsg) ;// 指定默认值
		this.jcb1.setMaximumRowCount(3) ;
		cont.add(this.jcb1) ;
		cont.add(new JLabel("下拉列表框")) ;
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