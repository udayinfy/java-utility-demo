package ui.b.jlabel;

import java.awt.Dimension ;
import java.awt.Color ;
import java.awt.Font ;
import java.awt.Point ;
import java.io.File ;
import javax.swing.JLabel ;
import javax.swing.JFrame ;
import javax.swing.Icon ;
import javax.swing.ImageIcon ;

public class JLabelDemo04{
	public static void main(String args[]){
		JFrame frame = new JFrame("Welcome To MLDN") ;

		String picPath = "d:" + File.separator + "mldn.gif" ;

		Icon icon = new ImageIcon(picPath) ;
		JLabel lab = new JLabel("MLDN",icon,JLabel.CENTER) ;	// ʵ������ǩ����
		Font fnt = new Font("Serief",Font.ITALIC + Font.BOLD,28) ;
		lab.setFont(fnt) ;
		lab.setForeground(Color.RED) ;
		lab.setBackground(Color.YELLOW) ;//���ô���ı�����ɫ
		frame.add(lab) ;	// ��������뵽���֮��
		Dimension dim = new Dimension() ;
		frame.setBackground(Color.WHITE) ;//���ô���ı�����ɫ
		dim.setSize(300,160) ;
		frame.setSize(dim) ;
		Point point = new Point(300,200) ;	// ��������
		frame.setLocation(point) ;
		frame.setVisible(true) ;
	}
}; 