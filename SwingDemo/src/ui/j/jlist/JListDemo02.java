package ui.j.jlist;

import javax.swing.JFrame ;
import javax.swing.JList ;
import java.util.Vector ;
import javax.swing.BorderFactory ;
import javax.swing.ListSelectionModel ;
import javax.swing.JScrollPane ;
import javax.swing.AbstractListModel ;
import java.awt.Container ;
import java.awt.GridLayout ;
import java.awt.event.WindowAdapter ;
import java.awt.event.WindowEvent ;

class MyListModel02 extends AbstractListModel{
	
	private String nations[] = {"中国","巴西","美国","韩国","意大利","法国"} ;
	
	public Object getElementAt(int index){
		if(index<this.nations.length){
			return this.nations[index] ;
		}else{
			return null ;
		}
	}
	
	public int getSize(){
		return this.nations.length ;
	}
	
}

class MyList02{
	
	private JFrame frame = new JFrame("Welcome To MLDN") ;
	private Container cont = frame.getContentPane() ;	// 得到窗体容器
	private JList list1 = null ;
	
	public MyList02(){
		
		this.frame.setLayout(new GridLayout(1,3)) ;	// 定义排版
		
		this.list1 = new JList(new MyListModel02()) ;

		this.list1.setBorder(BorderFactory.createTitledBorder("你喜欢去那个国家旅游？")) ;

		this.list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION) ;// 多选

		this.cont.add(new JScrollPane(this.list1)) ;

		this.frame.setSize(330,180) ;
		this.frame.setVisible(true) ;

		this.frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent a){
				System.exit(1) ;
			}
		}) ;
	}
	
}

public class JListDemo02{
	public static void main(String args[]){
		new MyList02() ;
	}
}


