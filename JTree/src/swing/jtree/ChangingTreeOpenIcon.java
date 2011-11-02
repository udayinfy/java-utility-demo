package swing.jtree;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;

class TreeNodeVector4<E> extends Vector<E> {
	private static final long serialVersionUID = -5414615972725084676L;
	
	String name;

	TreeNodeVector4(String name) {
		this.name = name;
	}

	TreeNodeVector4(String name, E elements[]) {
		this.name = name;
		for (int i = 0, n = elements.length; i < n; i++) {
			add(elements[i]);
		}
	}

	public String toString() {
		return "[" + name + "]";
	}
}

public class ChangingTreeOpenIcon {
	
	public static void main(final String args[]) {
		UIManager.put("Tree.openIcon", new ImageIcon("img//yourFile.gif"));

		JFrame frame = new JFrame("JTreeSample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Vector<String> v1 = new TreeNodeVector4<String>("Two", new String[] {
				"Mercury", "Venus", "Mars" });
		Vector<Object> v2 = new TreeNodeVector4<Object>("Three");
		v2.add(System.getProperties());
		v2.add(v1);
		Object rootNodes[] = { v1, v2 };
		Vector<Object> rootVector = new TreeNodeVector4<Object>("Root",
				rootNodes);
		JTree tree = new JTree(rootVector);
		frame.add(new JScrollPane(tree), BorderLayout.CENTER);

		frame.setSize(300, 300);
		frame.setVisible(true);

	}
}