package ui.j.jlist;

import javax.swing.JFrame ;
import javax.swing.JList ;
import java.util.Vector ;
import javax.swing.BorderFactory ;
import javax.swing.ListSelectionModel ;
import javax.swing.JScrollPane ;
import java.awt.Container ;
import java.awt.GridLayout ;
import java.awt.event.WindowAdapter ;
import java.awt.event.WindowEvent ;

class MyList01{
	
	private JFrame frame = new JFrame("Welcome To MLDN") ;
	private Container cont = frame.getContentPane() ;	// 得到窗体容器
	private JList list1 = null ;
	private JList list2 = null ;
	
	public MyList01(){
		
		this.frame.setLayout(new GridLayout(1,3)) ;	// 定义排版
		
		String nations[] = {"中国","巴西","美国","韩国","意大利","法国"} ;
		Vector<String> v = new Vector<String>() ;
		v.add("MLDN") ;
		v.add("MLDNJAVA") ;
		v.add("智囊团") ;
		
		this.list1 = new JList(nations) ;
		this.list2 = new JList(v) ;

		this.list1.setBorder(BorderFactory.createTitledBorder("你喜欢去那个国家旅游？")) ;
		this.list2.setBorder(BorderFactory.createTitledBorder("你喜欢网站？")) ;

		this.list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION) ;// 多选
		this.list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION) ;// 单选

		this.cont.add(new JScrollPane(this.list1)) ;
		this.cont.add(this.list2) ;

		this.frame.setSize(330,180) ;
		this.frame.setVisible(true) ;

		this.frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent a){
				System.exit(1) ;
			}
		}) ;
	}

}

public class JListDemo01{
	public static void main(String args[]){
		new MyList01() ;
	}
}



