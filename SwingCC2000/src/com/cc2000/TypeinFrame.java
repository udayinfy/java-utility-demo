package com.cc2000;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 * CC2000¼�빦��ʵ��
 * 
 * @author zhc
 * 
 */
public class TypeinFrame extends JFrame {
	private static final long serialVersionUID = 6202097400548423168L;

	/**
	 * ����ѧ����Ϣ  {@link Student}
	 */
	private Vector<Student> stuVector;
	/**
	 * ����UI��JTree
	 */
	private JTree tree;
	/**
	 * ����UI��JTable
	 */
	private JTable table;

	public TypeinFrame(Vector<Student> stuVector) {

		this.stuVector = stuVector;

		JPanel rootPanel = new JPanel();
		rootPanel.setLayout(new BorderLayout());

		rootPanel.add(makeTreePanel(), BorderLayout.WEST);
		rootPanel.add(makeTablePanel(), BorderLayout.CENTER);

		this.getContentPane().add(rootPanel);

		this.setTitle("CC2000��Ϣ¼��");
		this.setSize(new Dimension(600, 400));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Make Tree Panel
	 * 
	 * @return
	 */
	protected JScrollPane makeTreePanel() {

		DefaultTreeModel model = this.makeTreeModel();
	    
		tree = new JTree();
		tree.setModel(model);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setRootVisible(true);
		
		TreeWillExpandListener treeWillExpandListener = new TreeWillExpandListener() {
			public void treeWillCollapse(TreeExpansionEvent treeExpansionEvent)
					throws ExpandVetoException {
				TreePath path = treeExpansionEvent.getPath();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
						.getLastPathComponent();
				if( node.isRoot() ) return;
				
				((DefaultTableModel)table.getModel()).getDataVector().removeAllElements(); 
				table.addNotify();
			}

			public void treeWillExpand(TreeExpansionEvent treeExpansionEvent)
					throws ExpandVetoException {
				TreePath path = treeExpansionEvent.getPath();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) path
						.getLastPathComponent();
				if( node.isRoot() ) return;
				
				((DefaultTableModel)table.getModel()).getDataVector().removeAllElements(); 
				
				for( int i=0; i<node.getChildCount(); i++ ){
					DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) node.getChildAt(i);
					Student student = (Student) childNode.getUserObject();
					((DefaultTableModel) table.getModel()).insertRow(i, student.getStuInfo());
				}
				table.addNotify();
				

			}
		};
		tree.addTreeWillExpandListener(treeWillExpandListener);
		JScrollPane jsp = new JScrollPane(tree);

		jsp.setPreferredSize(new Dimension(150, 400));

		return jsp;
	}

	/**
	 * Make Table Panel
	 * 
	 * @return
	 */
	protected JPanel makeTablePanel() {
		JPanel retPanel = new JPanel();
		retPanel.setLayout(new BorderLayout());

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton addButton = new JButton("���");
		JButton delButton = new JButton("ɾ��");
		JButton exitButton = new JButton("�ر�");
		buttonPanel.add(addButton);
		buttonPanel.add(delButton);
		buttonPanel.add(exitButton);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ѧ��");
		model.addColumn("����"); model.addColumn("�꼶");
		model.addColumn("ƽ���ɼ�"); model.addColumn("���˼��");
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		TableColumn profileColumn = table.getColumnModel().getColumn(4);
		profileColumn.setPreferredWidth(150);
		profileColumn.setMaxWidth(150);
		profileColumn.setMinWidth(150);
		JScrollPane tablePane = new JScrollPane(table);

		retPanel.add(buttonPanel, BorderLayout.NORTH);
		retPanel.add(tablePane, BorderLayout.CENTER);

		// add event
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddDialog addDialog = new AddDialog();
				addDialog.setVisible(true);
			}
		});
		// del event
		delButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int flag = JOptionPane.showConfirmDialog(TypeinFrame.this, 
						"ȷ��ɾ��ѡ������","ȷ����Ϣ",JOptionPane.OK_CANCEL_OPTION);
				if( flag!=0 ){
					return;
				}
				
				TreePath treePath = tree.getSelectionPath();
				
				// ��stuVector��ɾ������
				int row = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Vector dataVector = model.getDataVector();
				if( dataVector.size()==0 ||row<0 || dataVector.size()<=row )
					return;
				Vector<String> vector = (Vector<String>) dataVector.get(row);
				String id = vector.get(0);
				for( int i=0; i<stuVector.size(); i++ ){
					if( id.equals(stuVector.get(i).getId()) ){
						stuVector.remove(i);
						break;
					}
				}
				
				
				// ����tree,table
				((DefaultTableModel)table.getModel()).getDataVector().removeAllElements(); 
				table.addNotify();
				DefaultTreeModel newModel = makeTreeModel();
				tree.setModel(newModel);
				tree.updateUI();
				
				expandAll(tree, treePath, true);
			}
		});
		// exit event
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		return retPanel;
	}

	/**
	 * ����tree��node���
	 * @param rootVector
	 */
	protected DefaultTreeModel makeTreeModel() {
		
		MutableTreeNode root = new DefaultMutableTreeNode("ѧ����Ϣ");
		MutableTreeNode node0 = new DefaultMutableTreeNode("һ�꼶");
		MutableTreeNode node1 = new DefaultMutableTreeNode("���꼶");
		MutableTreeNode node2 = new DefaultMutableTreeNode("���꼶");
		MutableTreeNode node3 = new DefaultMutableTreeNode("���꼶");
		MutableTreeNode node4 = new DefaultMutableTreeNode("���꼶");
		MutableTreeNode node5 = new DefaultMutableTreeNode("���꼶");
		
		int i0 =0, i1=0, i2=0, i3=0, i4=0, i5=0;
		

		for (int i = 0; i < this.stuVector.size(); i++) {
			String grade = this.stuVector.get(i).getGrade();
			if( grade.equals("һ�꼶") )
				node0.insert(new DefaultMutableTreeNode(stuVector.get(i)), i0++);
			if( grade.equals("���꼶") )
				node1.insert(new DefaultMutableTreeNode(stuVector.get(i)), i1++);
			if( grade.equals("���꼶") )
				node2.insert(new DefaultMutableTreeNode(stuVector.get(i)), i2++);
			if( grade.equals("���꼶") )
				node3.insert(new DefaultMutableTreeNode(stuVector.get(i)), i3++);
			if( grade.equals("���꼶") )
				node4.insert(new DefaultMutableTreeNode(stuVector.get(i)), i4++);
			if( grade.equals("���꼶") )
				node5.insert(new DefaultMutableTreeNode(stuVector.get(i)), i5++);
		}
		
		root.insert(node0, 0);
		root.insert(node1, 1);
		root.insert(node2, 2);
		root.insert(node3, 3);
		root.insert(node4, 4);
		root.insert(node5, 5);
		
		DefaultTreeModel model = new DefaultTreeModel(root);
		return model;
	}
	
	protected void expandAll(JTree tree, TreePath treePath, boolean expand) {
		TreeNode root = (TreeNode) tree.getModel().getRoot();

		expandAll(tree, new TreePath(root), treePath, expand);
	}

	protected void expandAll(JTree tree, TreePath parent, TreePath treePath, boolean expand) {
		// Traverse children
		TreeNode node = (TreeNode) parent.getLastPathComponent();
		if (node.getChildCount() >= 0) {
			for (Enumeration e = node.children(); e.hasMoreElements();) {
				TreeNode n = (TreeNode) e.nextElement();
				TreePath path = parent.pathByAddingChild(n);
				if( path==null || treePath==null ){
					continue;
				}
				if( !path.toString().equals(treePath.toString()) ){
					continue;
				}
				expandAll(tree, path, treePath, expand);
			}
		}

		if (expand) {
			tree.expandPath(parent);
		} else {
			tree.collapsePath(parent);
		}
	}
	
	/**
	 * ����ѧ����ϢDialog
	 * @author zhc
	 *
	 */
	class AddDialog extends JDialog {
		private static final long serialVersionUID = -7333581500442612851L;

		public AddDialog() {
			
			this.setModal(true);

			JLabel idLabel = new JLabel("ѧ��");
			final JTextField idTextField = new JTextField( (int)(Math.random() * 10000) + "" );
			idTextField.setEditable(false);
			
			JLabel nameLable = new JLabel("����");
			final JTextField nameTextField = new JTextField();

			JLabel gradeLabel = new JLabel("�꼶");
			Vector<String> gradeVector = new Vector<String>();
			gradeVector.add("һ�꼶");
			gradeVector.add("���꼶");
			gradeVector.add("���꼶");
			gradeVector.add("���꼶");
			gradeVector.add("���꼶");
			gradeVector.add("���꼶");
			final JComboBox gradeComboBox = new JComboBox(gradeVector);

			JLabel avgScoreLabel = new JLabel("ƽ���ɼ�");
			final JTextField avgScoreTextField = new JTextField();
			avgScoreTextField.setDocument(new NumberDocument());

			JLabel profileLable = new JLabel("���˼��");
			final JTextArea profileTextaArea = new JTextArea();

			JButton confirmButton = new JButton("ȷ��");
			JButton cancelButton = new JButton("ȡ��");

			JPanel rootPanel = new JPanel(new GridLayout(6, 2));
			rootPanel.add(idLabel);
			rootPanel.add(idTextField);
			rootPanel.add(nameLable);
			rootPanel.add(nameTextField);
			rootPanel.add(gradeLabel);
			rootPanel.add(gradeComboBox);
			rootPanel.add(avgScoreLabel);
			rootPanel.add(avgScoreTextField);
			rootPanel.add(profileLable);
			rootPanel.add(new JScrollPane(profileTextaArea));
			rootPanel.add(confirmButton);
			rootPanel.add(cancelButton);

			this.getContentPane().add(rootPanel);

			this.setSize(400, 300);
			this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			confirmButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String nameValue = nameTextField.getText();
					String gradeValue = gradeComboBox.getSelectedItem().toString();
					String avgScoreValue = avgScoreTextField.getText();
					String profileValue = profileTextaArea.getText();
					
					if( nameValue==null || "".equals(nameValue) ){
						JOptionPane.showMessageDialog(TypeinFrame.this, "���ֲ���Ϊ�գ�");
						return;
					}
					if( avgScoreValue==null || "".equals(avgScoreValue) ){
						JOptionPane.showMessageDialog(TypeinFrame.this, "ƽ����������Ϊ�գ�");
						return;
					}
					if( profileValue==null || "".equals(profileValue) ){
						JOptionPane.showMessageDialog(TypeinFrame.this, "���˼�鲻��Ϊ�գ�");
						return;
					}
					
					Student student = new Student();
					student.setId(idTextField.getText());
					student.setName(nameValue);
					student.setGrade(gradeValue);
					student.setAvgScore(avgScoreValue);
					student.setProfile(profileValue);
					
					stuVector.add(student);
					
					
					// ����tree,table
					DefaultTreeModel newModel = makeTreeModel();
					TreePath treePath = tree.getSelectionPath();
					tree.setModel(newModel);
					tree.updateUI();
					
					
					
					expandAll(tree, treePath, true);
					
					dispose();
				}
			});
			
			cancelButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});

		}

		/**
		 * ֻ���������ֵ�PlainDocument
		 * @author zhc
		 */
		class NumberDocument extends PlainDocument {
			private static final long serialVersionUID = 4551283481443071472L;

			public void insertString(int offs, String str, AttributeSet a)
					throws BadLocationException {
				char[] source = str.toCharArray();
				char[] result = new char[source.length];
				int j = 0;
				for (int i = 0; i < result.length; i++) {  // ��������ִ������ж�
					if (Character.isDigit(source[i]))  // ����
						result[j++] = source[i];
					else {  // ������
						Toolkit.getDefaultToolkit().beep();
					}
				}
				super.insertString(offs, new String(result, 0, j), a);
			}
		}

	}
	

}
