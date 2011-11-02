package ui.h.jradiobutton;

import java.io.File ;
import java.awt.Container ;
import java.awt.GridLayout ;
import java.awt.event.WindowAdapter ;
import java.awt.event.ItemListener ;
import java.awt.event.ItemEvent  ;
import java.awt.event.WindowEvent ;
import javax.swing.JFrame ;
import javax.swing.JPanel ;
import javax.swing.JRadioButton ;
import javax.swing.ButtonGroup ;
import javax.swing.BorderFactory ;
import javax.swing.ImageIcon ;

class MyRadio03 implements ItemListener{
	
	private String right = "src\\ui\\h\\jradiobutton\\right.png" ;
	private String wrong = "src\\ui\\h\\jradiobutton\\wrong.gif" ;
	private JFrame frame = new JFrame("Welcome TO MLDN") ;
	private Container cont = frame.getContentPane() ;
	private JRadioButton jrb1 = new JRadioButton("男",new ImageIcon(right),true) ;
	private JRadioButton jrb2 = new JRadioButton("女",new ImageIcon(wrong),false) ;
	private JPanel pan = new JPanel() ;
	
	public MyRadio03(){
		
		pan.setBorder(BorderFactory.createTitledBorder("选择性别")) ;	// 设置一个边框的显示条
		pan.setLayout(new GridLayout(1,3)) ;
		pan.add(this.jrb1) ;
		pan.add(this.jrb2) ;
		
		ButtonGroup group = new ButtonGroup() ;
		group.add(this.jrb1) ;
		group.add(this.jrb2) ;
		
		jrb1.addItemListener(this) ;
		jrb2.addItemListener(this) ;

		cont.add(pan) ;
		
		this.frame.setSize(300,80) ;
		this.frame.setVisible(true) ;
		
		this.frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent obj){
				System.exit(1) ;
			}
		}) ;
	}
	
	public void itemStateChanged(ItemEvent e){
		if(e.getSource()==jrb1){
			jrb1.setIcon(new ImageIcon(right)) ;
			jrb2.setIcon(new ImageIcon(wrong)) ;
		}else{
			jrb1.setIcon(new ImageIcon(wrong)) ;
			jrb2.setIcon(new ImageIcon(right)) ;
		
		}
	}
};

public class JRadioButtonDemo03{
	public static void main(String args[]){
		new MyRadio03() ;
	}
};



