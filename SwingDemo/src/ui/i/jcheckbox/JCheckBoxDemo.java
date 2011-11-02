package ui.i.jcheckbox;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import javax.swing.border.Border;


public class JCheckBoxDemo {
	
	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	
	JCheckBox jcb1 = new JCheckBox("³µ×Ó");
	JCheckBox jcb2 = new JCheckBox("·¿×Ó");
	JCheckBox jcb3 = new JCheckBox("Æ±×Ó");
	JLabel jl = new JLabel("  ");
	
	JCheckBox jcb4 = new JCheckBox("ÑàÎÑ");
	JCheckBox jcb5 = new JCheckBox("Óã³á");
	JCheckBox jcb6 = new JCheckBox("ÐÜÕÆ");
	JLabel jl2 = new JLabel("  ");
	
	Vector<JCheckBox> v = new Vector<JCheckBox>();
	String chkSelected = "";
	
	Vector<JCheckBox> v2 = new Vector<JCheckBox>();
	String chkSelected2 = "";
	
	public JCheckBoxDemo() {
		
		jf.setTitle("JCheckBoxButton");
		jp.setBorder(BorderFactory.createTitledBorder("ÄãÏ²»¶Ê²Ã´£¿"));
		jp.setLayout(new GridLayout(2,4));
		
		v.add(jcb1);  v.add(jcb2);  v.add(jcb3);
		for( int i=0; i<v.size(); i++){
			v.get(i).addItemListener(  new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					chkSelected = "";
					for( int i=0; i<v.size(); i++ ){
						if( v.get(i).isSelected() ){
							chkSelected += v.get(i).getText() + " ";
						}
					}
					jl.setText(chkSelected);
					
				}
			});
		}
		
		v2.add(jcb4);  v2.add(jcb5);  v2.add(jcb6);
		for( int i=0; i<v2.size(); i++){
			v2.get(i).addItemListener(  new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					chkSelected2 = "";
					for( int i=0; i<v2.size(); i++ ){
						if( v2.get(i).isSelected() ){
							chkSelected2 += v2.get(i).getText() + " ";
						}
					}
					jl2.setText(chkSelected2);
					
				}
			});
		}
		
		
		jf.add(jp);
		jp.add(jl);
		jp.add(jcb1);
		jp.add(jcb2);
		jp.add(jcb3);
		
		jp.add(jl2);
		jp.add(jcb4);
		jp.add(jcb5);
		jp.add(jcb6);
		
		
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setSize(400,300);
		jf.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new JCheckBoxDemo();
	}
	
	

}
