package ui.h.jradiobutton;

import java.awt.Container ;
import java.awt.GridLayout ;
import java.awt.event.WindowAdapter ;
import java.awt.event.WindowEvent ;
import javax.swing.JFrame ;
import javax.swing.JPanel ;
import javax.swing.JRadioButton ;
import javax.swing.ButtonGroup ;
import javax.swing.BorderFactory ;

class MyRadio02{
	
	private JFrame frame = new JFrame("Welcome TO MLDN") ;
	private Container cont = frame.getContentPane() ;
	private JRadioButton jrb1 = new JRadioButton("MLDN") ;
	private JRadioButton jrb2 = new JRadioButton("MLDNJAVA") ;
	private JRadioButton jrb3 = new JRadioButton("智囊团") ;
	private JPanel pan = new JPanel() ;
	
	public MyRadio02(){
		
		pan.setBorder(BorderFactory.createTitledBorder("请选择最喜爱的网站")) ;	// 设置一个边框的显示条
		pan.setLayout(new GridLayout(1,3)) ;
		pan.add(this.jrb1) ;
		pan.add(this.jrb2) ;
		pan.add(this.jrb3) ;
		
		ButtonGroup group = new ButtonGroup() ;
		group.add(this.jrb1) ;
		group.add(this.jrb2) ;
		group.add(this.jrb3) ;
		
		cont.add(pan) ;
		
		this.frame.setSize(300,80) ;
		this.frame.setVisible(true) ;
		this.frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent obj){
				System.exit(1) ;
			}
		}) ;
	}
};
public class JRadioButtonDemo02{
	public static void main(String args[]){
		new MyRadio02() ;
	}
};