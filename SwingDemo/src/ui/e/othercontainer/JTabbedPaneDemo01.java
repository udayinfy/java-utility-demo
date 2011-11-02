package ui.e.othercontainer;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

public class JTabbedPaneDemo01 {
	
	public static void main(String args[]){
		
		try {
			UIManager.setLookAndFeel( new WindowsLookAndFeel() ) ;
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		
		JFrame frame = new JFrame("JTabbedPane") ; // 实例化窗体对象
		Container cont = frame.getContentPane() ;
		
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP) ;// 设置标签在顶部显示
		JPanel pan1 = new JPanel() ;
		JPanel pan2 = new JPanel() ;
		JButton but = new JButton("按钮") ;
		JLabel lab = new JLabel("标签") ;
		pan1.add(but) ;
		pan2.add(lab) ;
		
		String picPath = "src/ui/e/othercontainer/Koala.jpg" ;
		tab.addTab("图片选项",new ImageIcon(picPath),pan1,"图象") ;
		tab.addTab("文字选项",pan2) ;	
		cont.add(tab) ;
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		frame.setSize(400,300) ;// 根据组件自动调整大小
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
		
		
	}
	
};