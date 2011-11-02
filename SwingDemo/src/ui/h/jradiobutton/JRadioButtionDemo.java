package ui.h.jradiobutton;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;


public class JRadioButtionDemo {
	
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	
	JRadioButton jrb1 = new JRadioButton("����");
	JRadioButton jrb2 = new JRadioButton("����");
	JRadioButton jrb3 = new JRadioButton("Ʊ��");
	JLabel jl = new JLabel("    ");
	ButtonGroup bg = new ButtonGroup();
	
	JRadioButton jrb4 = new JRadioButton("����");
	JRadioButton jrb5 = new JRadioButton("���");
	JRadioButton jrb6 = new JRadioButton("����");
	JLabel jl2 = new JLabel("    ");
	ButtonGroup bg2 = new ButtonGroup();
	
	
	public JRadioButtionDemo() {
		
		jp.setBorder(BorderFactory.createTitledBorder("��ϲ��ʲô��"));
		jp.setLayout(new GridLayout(2,4));
		
		bg.add(jrb1);
		bg.add(jrb2);
		bg.add(jrb3);
		
		bg2.add(jrb4);
		bg2.add(jrb5);
		bg2.add(jrb6);
		
		jf.add(jp);
		jp.add(jl);
		jp.add(jrb1);
		jp.add(jrb2);
		jp.add(jrb3);
		
		jp.add(jl2);
		jp.add(jrb4);
		jp.add(jrb5);
		jp.add(jrb6);
		
		jrb1.addItemListener(   new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if( e.getSource() == jrb1 ){
					jl.setText("����");
				}
				
			}
		});
		jrb2.addItemListener(   new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if( e.getSource() == jrb2 ){
					jl.setText("����");
				}
				
			}
		});
		jrb3.addItemListener(   new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if( e.getSource() == jrb3 ){
					jl.setText("Ʊ��");
				}
			}
		});
		
		jrb4.addItemListener(   new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if( e.getSource() == jrb4 ){
					jl2.setText("����");
				}
				
			}
		});
		jrb5.addItemListener(   new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if( e.getSource() == jrb5 ){
					jl2.setText("���");
				}
				
			}
		});
		jrb6.addItemListener(   new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if( e.getSource() == jrb6 ){
					jl2.setText("����");
				}
			}
		});
		
		jf.addWindowListener(   new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
		jf.setSize(400,300);
		jf.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new JRadioButtionDemo();
	}
	
	

}
