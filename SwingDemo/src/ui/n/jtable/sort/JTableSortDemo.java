package ui.n.jtable.sort;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableSortDemo{
	
	public static void main(String args[]){
		
		JFrame frame = new JFrame("JTable Sort") ;
		String[] titles = {"����","����","�Ա�","��ѧ�ɼ�","Ӣ��ɼ�","�ܷ�","�Ƿ񼰸�"} ;
		
		Object [][] userInfo = {
			{"���˻�",30,"��",89,97,186,true} ,
			{"�",23,"Ů",90,93,183,false} 
		} ;	// ��������
		
		JTable table = new JTable(userInfo,titles) ;	// �������
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