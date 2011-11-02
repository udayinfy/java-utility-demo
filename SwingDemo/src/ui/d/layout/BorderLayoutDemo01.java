package ui.d.layout;

import java.awt.BorderLayout ;
import javax.swing.JFrame ;
import javax.swing.JButton ;

public class BorderLayoutDemo01{
	public static void main(String args[]){
		
		JFrame frame = new JFrame("BorderLayout") ; 
		frame.setLayout(new BorderLayout(3,3)) ;
		
		frame.add(new JButton("东（EAST）"),BorderLayout.EAST) ;
		frame.add(new JButton("西（WEST）"),BorderLayout.WEST) ;
		frame.add(new JButton("南（SOUTH）"),BorderLayout.SOUTH) ;
		frame.add(new JButton("北（NORTH）"),BorderLayout.NORTH) ;
		frame.add(new JButton("中（CENTER）"),BorderLayout.CENTER) ;
		
		frame.setSize(400,300) ;
		frame.setVisible(true) ;
	}
};