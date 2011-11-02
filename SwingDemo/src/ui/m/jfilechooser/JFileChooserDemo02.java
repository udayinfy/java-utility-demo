package ui.m.jfilechooser;

import java.io.File ;
import java.io.FileInputStream ;
import java.io.FileOutputStream ;
import java.io.PrintStream ;
import java.util.Scanner ;
import java.awt.BorderLayout ;
import java.awt.event.WindowAdapter ;
import java.awt.event.WindowEvent ;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import javax.swing.JFrame  ;
import javax.swing.JTextArea ;
import javax.swing.JLabel ;
import javax.swing.JButton ;
import javax.swing.JPanel ;
import javax.swing.JFileChooser ;
import javax.swing.JScrollPane ;
import javax.swing.UIManager;

class Note implements ActionListener{
	
	private JTextArea area = new JTextArea(8,10) ;	// 定义文本区
	private JFrame frame = new JFrame("Welcome To MLDN") ;
	private JButton open = new JButton("打开文件") ;
	private JButton save = new JButton("保存文件") ;
	private JLabel label = new JLabel("现在没有打开的文件") ;
	private JPanel butPan = new JPanel() ;
	
	public Note(){
		this.butPan.add(open) ;	// 在面板中加入按钮
		this.butPan.add(save) ;	// 在面板中加入按钮
		
		this.frame.setLayout(new BorderLayout(3,3)) ;
		this.frame.add(this.label,BorderLayout.NORTH) ;
		this.frame.add(this.butPan,BorderLayout.SOUTH) ;
		this.frame.add(new JScrollPane(this.area),BorderLayout.CENTER) ;
		
		this.frame.setSize(330,180) ;
		this.frame.setVisible(true) ;
		
		this.frame.addWindowListener(
			new WindowAdapter()	{
				public void windowClosing(WindowEvent e){
					System.exit(1) ;
				}
			}
		) ;
		
		this.open.addActionListener(this) ;
		this.save.addActionListener(this) ;
	}
	
	public void actionPerformed(ActionEvent e){
		File file = null ;	// 接收文件
		int result = 0 ;	// 接收操作状态
		JFileChooser fileChooser = new JFileChooser() ;	// 文件选择框
		if(e.getSource()==this.open){	// 表示执行的是打开操作
			this.area.setText("") ;	// 打开将文字区域的内容清空
			fileChooser.setApproveButtonText("确定") ;
			fileChooser.setDialogTitle("打开文件") ;
			result = fileChooser.showOpenDialog(this.frame) ;
			if(result==JFileChooser.APPROVE_OPTION){	// 选择的是确定按钮
				file = fileChooser.getSelectedFile() ;	// 得到选择的文件
				this.label.setText("打开的文件名称为：" + file.getName()) ;
			}else if(result==JFileChooser.CANCEL_OPTION){
				this.label.setText("没有选择任何文件") ;
			}else{
				this.label.setText("操作出现错误") ;
			}
			if(file!=null){
				try{
					Scanner scan = new Scanner(new FileInputStream(file)) ;
					scan.useDelimiter("\n") ;
					while(scan.hasNext()){
						this.area.append(scan.next()) ;
						this.area.append("\n") ;
					}
					scan.close() ;
				}catch(Exception e1){}
			}
		}
		if(e.getSource()==this.save){	// 判断是否是保存操作
			result = fileChooser.showSaveDialog(this.frame) ;	// 显示保存框
			if(result==JFileChooser.APPROVE_OPTION){	// 选择的是确定按钮
				file = fileChooser.getSelectedFile() ;	// 得到选择的文件
				this.label.setText("选择的存储文件名称为：" + file.getName()) ;
			}else if(result==JFileChooser.CANCEL_OPTION){
				this.label.setText("没有选择任何文件") ;
			}else{
				this.label.setText("操作出现错误") ;
			}
			if(file!=null){
				try{
					PrintStream out = new PrintStream(new FileOutputStream(file)) ;
					out.print(this.area.getText()) ;
					out.close() ;
				}catch(Exception e1){}
			}
		}
	}
}

public class JFileChooserDemo02{
	
	public static void main(String args[]){
		new Note() ;
	}
}