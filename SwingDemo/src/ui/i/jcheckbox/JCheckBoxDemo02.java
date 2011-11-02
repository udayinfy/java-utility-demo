package ui.i.jcheckbox;

import java.io.File ;
import java.awt.Container ;
import java.awt.GridLayout ;
import java.awt.event.WindowAdapter ;
import java.awt.event.WindowEvent ;
import java.awt.event.ItemListener ;
import java.awt.event.ItemEvent ;
import javax.swing.JFrame ;
import javax.swing.ImageIcon ;
import javax.swing.JPanel ;
import javax.swing.JCheckBox ;
import javax.swing.BorderFactory ;

class MyItemListener implements ItemListener{
	private String right = "src\\ui\\i\\jcheckbox\\right.png" ;
	private String wrong = "src\\ui\\i\\jcheckbox\\wrong.gif" ;
	public void itemStateChanged(ItemEvent e){
		// 不管如何操作，则肯定由JCheckBox产生事件
		JCheckBox jcb = (JCheckBox)e.getItem() ;	// 得到产生的事件
		if(jcb.isSelected()){	// 如果被选中了，则显示正确的图片
			jcb.setIcon(new ImageIcon(right)) ;
		}else{
			jcb.setIcon(new ImageIcon(wrong)) ;
		}
	}
}
class MyCheckBox02{
	
	private String wrong = "d:" + File.separator + "wrong.gif" ;
	private JFrame frame = new JFrame("Welcome To MLDN") ;	// 定义窗体
	private Container cont = frame.getContentPane() ;	// 得到窗体容器
	private JCheckBox jcb1 = new JCheckBox("MLDN",new ImageIcon(wrong)) ;	// 定义一个复选框
	private JCheckBox jcb2 = new JCheckBox("MLDNJAVA",new ImageIcon(wrong)) ;	// 定义一个复选框
	private JCheckBox jcb3 = new JCheckBox("智囊团",new ImageIcon(wrong)) ;	// 定义一个复选框
	private JPanel pan = new JPanel() ;
	public MyCheckBox02(){
		pan.setBorder(BorderFactory.createTitledBorder("请选择最喜爱的网站")) ;
		pan.setLayout(new GridLayout(1,3)) ;	// 设置组件的排版 
		pan.add(this.jcb1) ;	// 增加组件
		pan.add(this.jcb2) ;	// 增加组件
		pan.add(this.jcb3) ;	// 增加组件

		jcb1.addItemListener(new MyItemListener()) ;
		jcb2.addItemListener(new MyItemListener()) ;
		jcb3.addItemListener(new MyItemListener()) ;

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

public class JCheckBoxDemo02{
	public static void main(String args[]){
		new MyCheckBox02() ;
	}
}