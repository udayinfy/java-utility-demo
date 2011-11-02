package ui.n.jtable.sort;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableSortDemo{
	
	public static void main(String args[]){
		
		JFrame frame = new JFrame("JTable Sort") ;
		String[] titles = {"姓名","年龄","性别","数学成绩","英语成绩","总分","是否及格"} ;
		
		Object [][] userInfo = {
			{"李兴华",30,"男",89,97,186,true} ,
			{"李康",23,"女",90,93,183,false} 
		} ;	// 定义数据
		
		JTable table = new JTable(userInfo,titles) ;	// 建立表格
		JScrollPane scr = new JScrollPane(table) ;
		
		
		SortManager sortManager = new SortManager(table);
		
		frame.add(scr) ;
		frame.setSize(370,90) ;
		frame.setVisible(true) ;
		
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		});
		
	}
	
}