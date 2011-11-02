package test;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;


public class JtableTest extends JFrame {
	
	private static final long serialVersionUID = 7154711124507349775L;

	public JtableTest() {
		
		AbstractTableModel model = new MyTableModel();
		JTable table = new JTable(model); 
		
		table.setDefaultRenderer(Color.class, new ColorCellRenderer());
		
		JComboBox gradeList = new JComboBox() ;
		gradeList.addItem("��");  gradeList.addItem("��");  
		gradeList.addItem("��");  gradeList.addItem("��");
		table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(gradeList)) ;
		
		this.getContentPane().add( new JScrollPane(table) ) ;
		
		this.setTitle("JTable");
		this.setSize(400, 400);
		this.setLocation(400, 400);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		new JtableTest();
	}
	

}

class MyTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 5218799361014800099L;

	private String[] titles = { "��Ʒ", "���", "�ȼ�", "��ɫ", "����" };
	
	private Object[][] data = { {"AAA", Boolean.TRUE, "��", Color.RED, new ImageIcon("src\\test\\temp.png")}, 
								{"BBB", Boolean.FALSE, "��", Color.YELLOW, new ImageIcon("src\\test\\temp.png")},
								{"CCC", Boolean.FALSE, "��", Color.BLUE, new ImageIcon("src\\test\\temp.png")},
								{"DDD", Boolean.FALSE, "��", Color.ORANGE, new ImageIcon("src\\test\\temp.png")},
								{"EEE", Boolean.TRUE, "��", Color.GREEN, new ImageIcon("src\\test\\temp.png")},
								{"FFF", Boolean.TRUE, "��", Color.PINK, new ImageIcon("src\\test\\temp.png")}};
	
	@Override
	public int getRowCount() {
		return data.length;
	}
	
	@Override
	public int getColumnCount() {
		return titles.length;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return data[0][columnIndex].getClass();
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return titles[columnIndex];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		data[rowIndex][columnIndex] = aValue;
	}
	
	
	
}

class ColorCellRenderer implements TableCellRenderer {
	
	private JPanel panel = new JPanel();
	
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		panel.setBackground((Color) value);
		
		return panel;
	}

}

/*
 * DefaultTableModel AbstractTableModel 
 * Cell Editer 
 * Cell Render
 * Column Sort
 * Row Select Event
 */

