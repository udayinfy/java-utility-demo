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
		
		
		JFrame frame = new JFrame("JTabbedPane") ; // ʵ�����������
		Container cont = frame.getContentPane() ;
		
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP) ;// ���ñ�ǩ�ڶ�����ʾ
		JPanel pan1 = new JPanel() ;
		JPanel pan2 = new JPanel() ;
		JButton but = new JButton("��ť") ;
		JLabel lab = new JLabel("��ǩ") ;
		pan1.add(but) ;
		pan2.add(lab) ;
		
		String picPath = "src/ui/e/othercontainer/Koala.jpg" ;
		tab.addTab("ͼƬѡ��",new ImageIcon(picPath),pan1,"ͼ��") ;
		tab.addTab("����ѡ��",pan2) ;	
		cont.add(tab) ;
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		frame.setSize(400,300) ;// ��������Զ�������С
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
		
		
	}
	
};