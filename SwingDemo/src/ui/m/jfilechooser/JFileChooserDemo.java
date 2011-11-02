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

	JFrame jf = new JFrame("文件选择器");
	Point pt = new Point(400,300);
	Dimension dim = new Dimension(400,300);
	JPanel jp = new JPanel();
	
	JButton btnOpenFile = new JButton("打开文件");
	JButton btnSaveFile = new JButton("保存文件");
	JLabel  jl = new JLabel();
	JTextArea jta = new JTextArea();
	
	public JFileChooserDemo(){
		
		jl.setText("没有打开任何文件") ;
		
		btnOpenFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int result = 0;
				File file = null;
				
				JFileChooser fileChooser = new JFileChooser() ;
				fileChooser.setApproveButtonText("确定") ;
				fileChooser.setDialogTitle("打开文件") ;
				
				result = fileChooser.showOpenDialog(jf.getContentPane()) ;
				
				if( result == JFileChooser.APPROVE_OPTION ){
					file = fileChooser.getSelectedFile() ;
					jl.setText("打开的文件名称为：" + file.getName()) ;
				}else if( result == JFileChooser.CANCEL_OPTION ){
					jl.setText("没有选择任何文件") ;
				}else{
					jl.setText("操作出现错误") ;
				}
				
				// 操作文件
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
				fileChooser.setApproveButtonText("确定") ;
				fileChooser.setDialogTitle("保存文件") ;
				
				result = fileChooser.showSaveDialog(jf.getContentPane()) ;	
				
				if(result==JFileChooser.APPROVE_OPTION){	
					file = fileChooser.getSelectedFile() ;	
					jl.setText("选择的存储文件名称为：" + file.getName()) ;
				}else if(result==JFileChooser.CANCEL_OPTION){
					jl.setText("没有选择任何文件") ;
				}else{
					jl.setText("操作出现错误") ;
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
