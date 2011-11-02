package swing.jtree;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class DefaultMutableTreeNodeDemo {
	
	public static void main(String args[]) {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
		DefaultMutableTreeNode mercury = new DefaultMutableTreeNode("Mercury");
		root.insert(mercury, 0);
		DefaultMutableTreeNode venus = new DefaultMutableTreeNode("Venus");
		root.insert(venus, 1);
		DefaultMutableTreeNode mars = new DefaultMutableTreeNode("Mars");
		root.insert(mars, 2);
		
		DefaultMutableTreeNode other = new DefaultMutableTreeNode("Other");
		mars.insert(other, 0);
		
		JTree tree = new JTree(root);

		JScrollPane scrollPane = new JScrollPane(tree);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.setSize(300, 150);
		frame.setVisible(true);
		
	}
	
}