package ui.a.jframe;

import javax.swing.JFrame ;
import java.awt.Color ;
import java.awt.Dimension ;
import java.awt.Point ;

public class JFrameDemo02{
	public static void main(String args[]){
		JFrame f = new JFrame("��һ��Swing����") ;
		Dimension d = new Dimension() ;
		d.setSize(230,80) ;
		f.setSize(d) ;	// ��������Ĵ�С
		f.setBackground(Color.WHITE) ;	// ���������óɰ�ɫ
		Point p = new Point(300,200) ;	// ָ���������ʾλ��
		f.setLocation(p) ;	// �����������ʾλ��
		f.setVisible(true) ;	// ������ɼ�
	}
};