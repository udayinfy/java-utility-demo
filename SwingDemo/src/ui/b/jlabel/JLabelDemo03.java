package ui.b.jlabel;

import java.awt.Dimension ;
import java.awt.Color ;
import java.awt.Font ;
import java.awt.Point ;
import java.io.File ;
import java.io.FileInputStream ;
import java.io.InputStream ;
import javax.swing.JLabel ;
import javax.swing.JFrame ;
import javax.swing.Icon ;
import javax.swing.ImageIcon ;

public class JLabelDemo03{
	public static void main(String args[]){
		JFrame frame = new JFrame("Welcome To MLDN") ;

		String picPath = "d:" + File.separator + "mldn.gif" ;
		File file = new File(picPath) ;	// 实例化File类的对象
		InputStream input = null ;
		byte b[] = new byte[(int)file.length()] ;
		try{
			input = new FileInputStream(file) ;
			input.read(b) ;
			input.close() ;
		}catch(Exception e){
			e.printStackTrace() ;
		}
		Icon icon = new ImageIcon(b) ;
		JLabel lab = new JLabel("MLDN",icon,JLabel.CENTER) ;	// 实例化标签对象
		Font fnt = new Font("Serief",Font.ITALIC + Font.BOLD,28) ;
		lab.setFont(fnt) ;
		lab.setForeground(Color.RED) ;
		lab.setBackground(Color.YELLOW) ;//设置窗体的背景颜色
		frame.add(lab) ;	// 将组件件入到面板之中
		Dimension dim = new Dimension() ;
		frame.setBackground(Color.WHITE) ;//设置窗体的背景颜色
		dim.setSize(300,160) ;
		frame.setSize(dim) ;
		Point point = new Point(300,200) ;	// 设置坐标
		frame.setLocation(point) ;
		frame.setVisible(true) ;
	}
}; 