package swing.jtree;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class SimpleTreeTest extends JFrame {
	private static final long serialVersionUID = -5186381927001818719L;

	public static void main(String[] args) {
		SimpleTreeTest stt = new SimpleTreeTest();
		stt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stt.setSize(250, 250);
		stt.setVisible(true);
	}

	public SimpleTreeTest() {
		
		Object[] genealogy = { "A", "B", "C", "D", "E", "F" };
		java.util.Vector<String> vector = new java.util.Vector<String>() {
			private static final long serialVersionUID = 1L;
			public String toString() {
				return "DD";
			}
		};
		vector.addElement("1");
		vector.addElement("2");
		vector.addElement("3");
		vector.addElement("4");
		genealogy[0] = vector;
		JTree tree = new JTree(genealogy);
		tree.setRootVisible(true);
		
		JScrollPane jsp = new JScrollPane(tree);
		getContentPane().add(jsp);
	}

}