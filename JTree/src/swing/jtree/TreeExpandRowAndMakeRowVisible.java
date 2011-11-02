package swing.jtree;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

class TreeNodeVector2<E> extends Vector<E> {
	String name;

	TreeNodeVector2(String name) {
		this.name = name;
	}

	TreeNodeVector2(String name, E elements[]) {
		this.name = name;
		for (int i = 0, n = elements.length; i < n; i++) {
			add(elements[i]);
		}
	}

	public String toString() {
		return "[" + name + "]";
	}
}

public class TreeExpandRowAndMakeRowVisible {
	public static void main(final String args[]) {
		JFrame frame = new JFrame("JTreeSample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Vector<String> v1 = new TreeNodeVector2<String>("Two", new String[] {
				"Mercury", "Venus", "Mars" });
		Vector<Object> v2 = new TreeNodeVector2<Object>("Three");
		v2.add(System.getProperties());
		v2.add(v1);
		Object rootNodes[] = { v1, v2 };
		Vector<Object> rootVector = new TreeNodeVector2<Object>("Root",
				rootNodes);
		JTree tree = new JTree(rootVector);
		frame.add(new JScrollPane(tree), BorderLayout.CENTER);

		tree.expandRow(1);
		tree.scrollRowToVisible(2);

		tree.revalidate();

		frame.setSize(300, 300);
		frame.setVisible(true);

	}
}