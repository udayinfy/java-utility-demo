package ui.d.layout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AbsoluteLayoutDemo01{
	
	public static void main(String args[]){
		
		JFrame frame = new JFrame("AbsoluteLayout") ; 
		frame.setLayout(null) ;
		
		JLabel title = new JLabel("Title") ;
		JButton enter = new JButton("Enter") ;
		JButton help = new JButton("Help") ;
		
		frame.setSize(280,123) ;
		title.setBounds(45,5,150,20) ;
		enter.setBounds(10,30,80,20) ;
		help.setBounds(100,30,80,20) ;
		
		frame.add(title) ;
		frame.add(enter) ;
		frame.add(help) ;
		
		frame.setVisible(true) ;
		
	}
};