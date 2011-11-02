package ui.d.layout;

import java.awt.GridLayout ;
import javax.swing.JFrame ;
import javax.swing.JButton ;

public class GridLayoutDemo01{
	
	public static void main(String args[]){
		
		JFrame frame = new JFrame("GridLayout") ; 
		frame.setLayout(new GridLayout(3,5,3,3)) ;
		
		JButton but = null ;
		for(int i=0;i<13;i++){
			but = new JButton("°´Å¥-"+ i) ;
			frame.add(but) ;
		}
		
		frame.pack() ;
		frame.setVisible(true) ;
	}
};