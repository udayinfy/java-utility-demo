package swing.jtree;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

class TreeNodeVector3<E> extends Vector<E> {
	private static final long serialVersionUID = -8873321914273299227L;
	
	String name;

	TreeNodeVector3(String name) {
		this.name = name;
	}

	TreeNodeVector3(String name, E elements[]) {
		this.name = name;
		for (int i = 0, n = elements.length; i < n; i++) {
			add(elements[i]);
		}
	}

	public String toString() {
		return "[" + name + "]";
	}
}

public class ChangingTreeLineStyle {
	
	public static void main(final String args[]) {
		
		JFrame frame = new JFrame("JTreeSample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Vector<String> v1 = new TreeNodeVector3<String>("Two", new String[] {
				"Mercury", "Venus", "Mars" });
		Vector<Object> v2 = new TreeNodeVector3<Object>("Three");
		v2.add(System.getProperties());
		v2.add(v1);
		Object rootNodes[] = { v1, v2 };
		Vector<Object> rootVector = new TreeNodeVector3<Object>("Root",	rootNodes);
		JTree tree = new JTree(rootVector);
		
		tree.putClientProperty("JTree.lineStyle", "None");

		frame.add(new JScrollPane(tree), BorderLayout.CENTER);

		frame.setSize(300, 300);
		frame.setVisible(true);

	}
	
}