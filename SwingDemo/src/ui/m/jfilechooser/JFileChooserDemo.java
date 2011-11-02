package ui.m.jfilechooser;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;


public class JFileChooserDemo {

	JFrame jf = new JFrame("�ļ�ѡ����");
	Point pt = new Point(400,300);
	Dimension dim = new Dimension(400,300);
	JPanel jp = new JPanel();
	
	JButton btnOpenFile = new JButton("���ļ�");
	JButton btnSaveFile = new JButton("�����ļ�");
	JLabel  jl = new JLabel();
	JTextArea jta = new JTextArea();
	
	public JFileChooserDemo(){
		
		jl.setText("û�д��κ��ļ�") ;
		
		btnOpenFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int result = 0;
				File file = null;
				
				JFileChooser fileChooser = new JFileChooser() ;
				fileChooser.setApproveButtonText("ȷ��") ;
				fileChooser.setDialogTitle("���ļ�") ;
				
				result = fileChooser.showOpenDialog(jf.getContentPane()) ;
				
				if( result == JFileChooser.APPROVE_OPTION ){
					file = fileChooser.getSelectedFile() ;
					jl.setText("�򿪵��ļ�����Ϊ��" + file.getName()) ;
				}else if( result == JFileChooser.CANCEL_OPTION ){
					jl.setText("û��ѡ���κ��ļ�") ;
				}else{
					jl.setText("�������ִ���") ;
				}
				
				// �����ļ�
				if(file!=null){
					try{
						Scanner scan = new Scanner(new FileInputStream(file)) ;
						scan.useDelimiter("\n") ;
						while(scan.hasNext()){
							jta.append(scan.next()) ;
							jta.append("\n") ;
						}
						scan.close() ;
					}catch(Exception e){
						
					}
				}
				
			}
		});
		
		btnSaveFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int result = 0;
				File file = null;
				
				JFileChooser fileChooser = new JFileChooser() ;
				fileChooser.setApproveButtonText("ȷ��") ;
				fileChooser.setDialogTitle("�����ļ�") ;
				
				result = fileChooser.showSaveDialog(jf.getContentPane()) ;	
				
				if(result==JFileChooser.APPROVE_OPTION){	
					file = fileChooser.getSelectedFile() ;	
					jl.setText("ѡ��Ĵ洢�ļ�����Ϊ��" + file.getName()) ;
				}else if(result==JFileChooser.CANCEL_OPTION){
					jl.setText("û��ѡ���κ��ļ�") ;
				}else{
					jl.setText("�������ִ���") ;
				}
				
				if(file!=null){
					try{
						PrintStream out = new PrintStream(new FileOutputStream(file)) ;
						out.print(jta.getText()) ;
						out.close() ;
					}catch(Exception e1){
						
					}
				}
			}
		});
		
		jf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
			
		});
		
		
		
		jp.add(btnOpenFile);
		jp.add(btnSaveFile);
		jf.add(jp);
		
		jf.getContentPane().add(jl,BorderLayout.NORTH);
		jf.getContentPane().add(new JScrollPane(jta),BorderLayout.CENTER);
		jf.getContentPane().add(jp,BorderLayout.SOUTH);
		
		jf.setLocation(pt);
		jf.setSize(dim);
		jf.setVisible(true);
		
		
	}
	

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		new JFileChooserDemo();
		
	}

}
