package ui.a.jframe;

import javax.swing.JFrame ;
import java.awt.Color ;

public class JFrameDemo01{
	public static void main(String args[]){
		JFrame f = new JFrame("��һ��Swing����") ;
		f.setSize(230,80) ;	// ��������Ĵ�С
		f.setBackground(Color.WHITE) ;	// ���������óɰ�ɫ
		f.setLocation(300,200) ;	// �����������ʾλ��
		f.setVisible(true) ;	// ������ɼ�
	}
};