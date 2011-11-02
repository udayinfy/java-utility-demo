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
	private Container cont = frame.getContentPane() ;	// 得到容器
	private JComboBox jcb1 = null ;
	private JLabel label = new JLabel("www.MLDNJAVA.cn") ;	// 定义标签
	private String fontSize[] = {"10","12","14","16","18","20","22","24","26","48","72"} ;
	
	public MyComboBox03(){
		this.frame.setLayout(new GridLayout(2,2)) ;	// 定义排版
		this.jcb1 = new JComboBox(fontSize) ;	// 实例化下拉列表框

		this.jcb1.addItemListener(this) ;
		this.jcb1.addActionListener(this) ;

		this.jcb1.setEditable(true) ;	// 表示可以编辑

		// 为每一个下拉框增加一个边框
		this.jcb1.setBorder(BorderFactory.createTitledBorder("你喜欢去那个国家旅游？")) ;
		ComboBoxEditor editor = null ;
		editor = this.jcb1.getEditor() ;	/// 得到编辑对象
		this.jcb1.configureEditor(editor,"12") ;// 指定默认值
		this.jcb1.setMaximumRowCount(3) ;

		this.changeFontSize(12) ;	// 默认值
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
		if(e.getStateChange()==ItemEvent.SELECTED){	// 判断是否是选中
			String itemSize = (String)e.getItem() ;
			try{
				this.changeFontSize(Integer.parseInt(itemSize)) ;
			}catch(Exception e1){
				
			}
		}
	}

	public void actionPerformed(ActionEvent e){
		String item = (String)this.jcb1.getSelectedItem() ;
		int size = 12 ;	// 设置一个默认大小
		try{
			size = Integer.parseInt(item) ;
		}catch(Exception e1){}
		this.changeFontSize(size) ;
		// 判断给定的size是否存在，如果不存在则需要将新的内容设置上去
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



