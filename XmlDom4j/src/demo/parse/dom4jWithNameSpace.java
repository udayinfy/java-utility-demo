package demo.parse;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class dom4jWithNameSpace {

	public static void main(String[] args) {
		String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "gis.xml";
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(new File(filePath));
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		nsTest(document);
		
		
	}

	public static void nsTest(Document document) {

		Element rootElement = document.getRootElement();
		Node node = rootElement.selectSingleNode("//gml:featureMember");

		Map map = new HashMap();
        map.put("esri","http://www.esri.com/esri");
        
        List nodes = node.selectNodes("*");
        for (Iterator it = nodes.iterator(); it.hasNext();) {
			Node subNode = (Node) it.next();
			
			
		}
		

	}

}
