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
	private Container cont = frame.getContentPane() ;	// 得到容器
	private JComboBox jcb1 = null ;
	private JComboBox jcb2 = null ;
	
	public MyComboBox01(){
		
		this.frame.setLayout(new GridLayout(2,2)) ;	// 定义排版
		
		String nations[] = {"中国","巴西","美国","韩国","意大利","法国"} ;
		Vector<String> v = new Vector<String>() ;
		v.add("MLDN") ;	// 增加内容
		v.add("MLDNJAVA") ;	// 增加内容
		v.add("智囊团") ;	// 增加内容
		this.jcb1 = new JComboBox(nations) ;	// 实例化下拉列表框
		this.jcb2 = new JComboBox(v) ;	// 实例化下拉列表框

		// 为每一个下拉框增加一个边框
		this.jcb1.setBorder(BorderFactory.createTitledBorder("你喜欢去那个国家旅游？")) ;
		this.jcb2.setBorder(BorderFactory.createTitledBorder("你喜欢的网站？")) ;
		
		cont.add(this.jcb1) ;
		cont.add(this.jcb2) ;
		cont.add(new JLabel("下拉列表框")) ;
		
		
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



