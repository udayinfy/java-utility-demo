package ui.i.jcheckbox;

import java.awt.Container ;
import java.awt.GridLayout ;
import java.awt.event.WindowAdapter ;
import java.awt.event.WindowEvent ;
import javax.swing.JFrame ;
import javax.swing.JPanel ;
import javax.swing.JCheckBox ;
import javax.swing.BorderFactory ;

class MyCheckBox01{
	
	private JFrame frame = new JFrame("Welcome To MLDN") ;	// 定义窗体
	private Container cont = frame.getContentPane() ;	// 得到窗体容器
	private JCheckBox jcb1 = new JCheckBox("MLDN") ;	// 定义一个复选框
	private JCheckBox jcb2 = new JCheckBox("MLDNJAVA") ;	// 定义一个复选框
	private JCheckBox jcb3 = new JCheckBox("智囊团") ;	// 定义一个复选框
	private JPanel pan = new JPanel() ;
	
	public MyCheckBox01(){
		pan.setBorder(BorderFactory.createTitledBorder("请选择最喜爱的网站")) ;
		pan.setLayout(new GridLayout(1,3)) ;	// 设置组件的排版 
		pan.add(this.jcb1) ;	// 增加组件
		pan.add(this.jcb2) ;	// 增加组件
		pan.add(this.jcb3) ;	// 增加组件
		cont.add(pan) ;	// 将面板加入到容器之中
		this.frame.setSize(330,80) ;
		this.frame.setVisible(true) ;	// 设置可显示
		this.frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent arg){
				System.exit(1) ;
			}
		}) ;
	}

}

public class JCheckBoxDemo01{
	public static void main(String args[]){
		new MyCheckBox01() ;
	}
}