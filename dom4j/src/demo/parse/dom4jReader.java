package demo.parse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Attribute;
import java.util.List;
import java.util.Iterator;
import org.dom4j.io.XMLWriter;
import java.io.*;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class dom4jReader {
	
	public void modifyDocument(File inputXml) {
		try {
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(inputXml);
			
			List list = document.selectNodes("//article/@level");
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				Attribute attribute = (Attribute) iter.next();
				if (attribute.getValue().equals("Intermediate"))
					attribute.setValue("Introductory");
			}
			
			list = document.selectNodes("//article/@date");
			iter = list.iterator();
			while (iter.hasNext()) {
				Attribute attribute = (Attribute) iter.next();
				if (attribute.getValue().equals("December-2001"))
					attribute.setValue("October-2002");
			}
			
			list = document.selectNodes("//article");
			iter = list.iterator();
			while (iter.hasNext()) {
				Element element = (Element) iter.next();
				Iterator iterator = element.elementIterator("title");
				while (iterator.hasNext()) {
					Element titleElement = (Element) iterator.next();
					if (titleElement.getText().equals(
							"Java configuration with XML Schema"))
						titleElement
								.setText("Create flexible and extensible XML schema");
				}
			}
			
			list = document.selectNodes("//article/author");
			iter = list.iterator();
			while (iter.hasNext()) {
				Element element = (Element) iter.next();
				Iterator iterator = element.elementIterator("firstname");
				while (iterator.hasNext()) {
					Element firstNameElement = (Element) iterator.next();
					if (firstNameElement.getText().equals("Marcello"))
						firstNameElement.setText("Ayesha");
				}
			}
			
			list = document.selectNodes("//article/author");
			iter = list.iterator();
			while (iter.hasNext()) {
				Element element = (Element) iter.next();
				Iterator iterator = element.elementIterator("lastname");
				while (iterator.hasNext()) {
					Element lastNameElement = (Element) iterator.next();
					if (lastNameElement.getText().equals("Vitaletti"))
						lastNameElement.setText("Malik");
				}
			}
			
			XMLWriter output = new XMLWriter( new FileWriter( new File(
					System.getProperty("user.dir") + File.separator + "src"
							+ File.separator + "catalog.xml") ));
			output.write(document);
			output.close();
		} catch (DocumentException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] argv) {
		dom4jReader dom4jParser = new dom4jReader();
		dom4jParser.modifyDocument(new File( System.getProperty("user.dir")
				+ File.separator + "src" + File.separator + "catalog.xml" ));
		System.out.println("ok");
	}
}



