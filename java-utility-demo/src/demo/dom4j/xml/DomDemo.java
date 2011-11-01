package demo.dom4j.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DomDemo {

	public static void main(String[] args) {

		DomDemo dd = new DomDemo();
		String fileName = "employees.xml";
		String fileDir = System.getProperty("user.dir") + File.separator
				+ "src";
		dd.createXml(fileDir + File.separator + fileName);
		System.out.println("createXml OK!!");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dd.parserXml(fileDir + File.separator + fileName);
		System.out.println("parserXml OK!!");
	}

	public void createXml(String fileName) {
		Document document = DocumentHelper.createDocument();
		Element employees = document.addElement("employees");
		Element employee = employees.addElement("employee");
		Element name = employee.addElement("name");
		name.setText("tom");
		Element gender = employee.addElement("gender");
		gender.setText("male");
		Element age = employee.addElement("age");
		age.setText("30");

		try {
			Writer fileWriter = new FileWriter(fileName);
			XMLWriter xmlWriter = new XMLWriter(fileWriter);
			xmlWriter.write(document);
			xmlWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}

	}

	public void parserXml(String fileName) {
		File inputXml = new File(fileName);
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(inputXml);
			Element employes = document.getRootElement();
			for (Iterator i = employes.elementIterator(); i.hasNext();) {
				Element employee = (Element) i.next();
				for (Iterator j = employee.elementIterator(); j.hasNext();) {
					Element node = (Element) j.next();
					System.out.println(node.getName() + ":" + node.getText());
				}

			}

		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {

		}

	}

}
