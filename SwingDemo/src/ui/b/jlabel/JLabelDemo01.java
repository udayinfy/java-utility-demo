package ui.b.jlabel;

import java.awt.Dimension ;
import java.awt.Color ;
import java.awt.Point ;
import javax.swing.JLabel ;
import javax.swing.JFrame ;

public class JLabelDemo01{
	public static void main(String args[]){
		JFrame frame = new JFrame("Welcome To MLDN") ;
		JLabel lab = new JLabel("MLDN",JLabel.CENTER) ;	// ʵ������ǩ����
		frame.add(lab) ;	// ��������뵽���֮��
		Dimension dim = new Dimension() ;
		frame.setBackground(Color.WHITE) ;//���ô���ı�����ɫ
		dim.setSize(200,70) ;
		frame.setSize(dim) ;
		Point point = new Point(300,200) ;	// ��������
		frame.setLocation(point) ;
		frame.setVisible(true) ;
	}
}; 