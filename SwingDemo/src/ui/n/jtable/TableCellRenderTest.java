package ui.n.jtable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class TableCellRenderTest {
	public static void main(String[] args) {
		JFrame frame = new TableCellRenderFrame();
		frame.setVisible(true);
	}
}

/*
 * the planet table model specifies the values, rendering and editing properties
 * for the planet data
 */

class PlanetTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;

	public static final int NAME_COLUMN = 0;

	public static final int MOON_COLUMN = 2;

	public static final int GASEOUS_COLUMN = 3;

	public static final int COLOR_COLUMN = 4;
	
	private String[] columnNames = { "Planet", "Radius", "Moons", "Gaseous",
			"Color", "Image" };
	
	private Object[][] cells = {
			{ "Mercury", new Double(2440), new Integer(0), Boolean.FALSE,
					Color.YELLOW, new ImageIcon("src\\ui\\n\\jtable\\temp.png") },
			{ "Venus", new Double(6052), new Integer(0), Boolean.FALSE,
					Color.yellow, new ImageIcon("src\\ui\\n\\jtable\\temp.png") },
			{ "Earth", new Double(6378), new Integer(1), Boolean.FALSE,
					Color.blue, new ImageIcon("src\\ui\\n\\jtable\\temp.png") },
			{ "Mars", new Double(3397), new Integer(2), Boolean.FALSE,
					Color.red, new ImageIcon("src\\ui\\n\\jtable\\temp.png") },
			{ "Jupiter", new Double(71492), new Integer(16), Boolean.TRUE,
					Color.orange, new ImageIcon("src\\ui\\n\\jtable\\temp.png") },
			{ "Saturn", new Double(60268), new Integer(18), Boolean.TRUE,
					Color.orange, new ImageIcon("src\\ui\\n\\jtable\\temp.png") },
			{ "Uranus", new Double(25559), new Integer(17), Boolean.TRUE,
					Color.blue, new ImageIcon("src\\ui\\n\\jtable\\temp.png") },
			{ "Neptune", new Double(24766), new Integer(8), Boolean.TRUE,
					Color.blue, new ImageIcon("src\\ui\\n\\jtable\\temp.png") },
			{ "Pluto", new Double(1137), new Integer(1), Boolean.FALSE,
					Color.black, new ImageIcon("src\\ui\\n\\jtable\\temp.png") } };

	
	public int getColumnCount() {
		return cells[0].length;
	}

	public int getRowCount() {
		return cells.length;
	}
	
	public String getColumnName(int c) {
		return columnNames[c];
	}

	public Class<? extends Object> getColumnClass(int c) {
		return cells[0][c].getClass();
	}
	
	public Object getValueAt(int r, int c) {
		return cells[r][c];
	}

	public void setValueAt(Object obj, int r, int c) {
		cells[r][c] = obj;
	}

	public boolean isCellEditable(int r, int c) {
		return c == NAME_COLUMN || c == MOON_COLUMN || c == GASEOUS_COLUMN
				|| c == COLOR_COLUMN;
	}

}

class TableCellRenderFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public TableCellRenderFrame() {
		setTitle("TableCellRenderTest");
		setSize(600, 400);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		TableModel model = new PlanetTableModel();
		JTable table = new JTable(model);

		// set up renderers and editors
		table.setDefaultRenderer(Color.class, new ColorTableCellRenderer());
		table.setDefaultEditor(Color.class, new ColorTableCellEditor());

		JComboBox moonCombo = new JComboBox();
		for (int i = 0; i <= 20; i++)
			moonCombo.addItem(new Integer(i));
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn moonColumn = columnModel
				.getColumn(PlanetTableModel.MOON_COLUMN);
		moonColumn.setCellEditor(new DefaultCellEditor(moonCombo));

		// show table
		table.setRowHeight(100);
		Container contentPane = getContentPane();
		contentPane.add(new JScrollPane(table), "Center");
	}
}

class ColorTableCellRenderer implements TableCellRenderer {
	
	/*
	 * the following panel is returned for all cells, with the background color
	 * set to the Color value of the cell
	 */
	private JPanel panel = new JPanel();
	
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		panel.setBackground((Color) value);
		
		return panel;
	}

}

class ColorTableCellEditor extends ColorTableCellRenderer implements
		TableCellEditor {

	private JColorChooser colorChooser;

	private JDialog colorDialog;

	private EventListenerList listenerList = new EventListenerList();

	private ChangeEvent event = new ChangeEvent(this);

	ColorTableCellEditor() { // prepare color dialog

		colorChooser = new JColorChooser();
		colorDialog = JColorChooser.createDialog(null, "Planet Color", false,
				colorChooser, new ActionListener() // OK button listener
				{
					public void actionPerformed(ActionEvent event) {
						fireEditingStopped();
					}
				}, new ActionListener() // Cancel button listener
				{
					public void actionPerformed(ActionEvent event) {
						fireEditingCanceled();
					}
				});
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) { /*
														 * this is where we get
														 * the current Color
														 * value We store it in
														 * the dialog in case
														 * the user starts
														 * editing
														 */
		colorChooser.setColor((Color) value);
		return getTableCellRendererComponent(table, value, isSelected, true,
				row, column);
	}

	public boolean isCellEditable(EventObject anEvent) {
		return true;
	}

	public boolean shouldSelectCell(EventObject anEvent) { // start editing
		colorDialog.setVisible(true);

		// tell caller it is ok to select this cell
		return true;
	}

	public void cancelCellEditing() { // editing is canceled--hide dialog
		colorDialog.setVisible(false);
	}

	public boolean stopCellEditing() { // editing is complete--hide dialog
		colorDialog.setVisible(false);

		// tell caller is is ok to use color value
		return true;
	}

	public Object getCellEditorValue() {
		return colorChooser.getColor();
	}

	public void addCellEditorListener(CellEditorListener l) {
		listenerList.add(CellEditorListener.class, l);
	}

	public void removeCellEditorListener(CellEditorListener l) {
		listenerList.remove(CellEditorListener.class, l);
	}

	protected void fireEditingStopped() {
		Object[] listeners = listenerList.getListenerList();
		for (int i = listeners.length - 2; i >= 0; i -= 2)
			((CellEditorListener) listeners[i + 1]).editingStopped(event);
	}

	protected void fireEditingCanceled() {
		Object[] listeners = listenerList.getListenerList();
		for (int i = listeners.length - 2; i >= 0; i -= 2)
			((CellEditorListener) listeners[i + 1]).editingCanceled(event);
	}

}
