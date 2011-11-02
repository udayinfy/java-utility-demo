package ui.d.layout;

import java.awt.FlowLayout ;
import javax.swing.JFrame ;
import javax.swing.JButton ;

public class FlowLayoutDemo01{
	
	public static void main(String args[]){
		
		JFrame frame = new JFrame("FlowLayout") ; 
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,3,3)) ;
		
		JButton but = null ;
		for(int i=0;i<9;i++){
			but = new JButton("°´Å¥-"+ i) ;
			frame.add(but) ;
		}
		
		frame.setSize(400,300) ;
		frame.setVisible(true) ;
		
	}
};