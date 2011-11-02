package ui.d.layout;

import java.awt.BorderLayout ;
import javax.swing.JFrame ;
import javax.swing.JButton ;

public class BorderLayoutDemo01{
	public static void main(String args[]){
		
		JFrame frame = new JFrame("BorderLayout") ; 
		frame.setLayout(new BorderLayout(3,3)) ;
		
		frame.add(new JButton("����EAST��"),BorderLayout.EAST) ;
		frame.add(new JButton("����WEST��"),BorderLayout.WEST) ;
		frame.add(new JButton("�ϣ�SOUTH��"),BorderLayout.SOUTH) ;
		frame.add(new JButton("����NORTH��"),BorderLayout.NORTH) ;
		frame.add(new JButton("�У�CENTER��"),BorderLayout.CENTER) ;
		
		frame.setSize(400,300) ;
		frame.setVisible(true) ;
	}
};