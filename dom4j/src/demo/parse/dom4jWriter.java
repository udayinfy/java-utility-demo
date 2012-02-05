package demo.parse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;
import java.io.*;

public class dom4jWriter {
	
	public void generateDocument() {
		
		Document document = DocumentHelper.createDocument();
		
		Element catalogElement = document.addElement("catalog");
		catalogElement.addComment("An XML Catalog");
//		catalogElement.addProcessingInstruction("target", "text");
		
		Element journalElement = catalogElement.addElement("journal");
		journalElement.addAttribute("title", "XML Zone");
		journalElement.addAttribute("publisher", "IBM developerWorks");
		Element articleElement = journalElement.addElement("article");
		
		articleElement.addAttribute("level", "Intermediate");
		articleElement.addAttribute("date", "December-2001");
		Element titleElement = articleElement.addElement("title");
		titleElement.setText("Java configuration with XML Schema");
		Element authorElement = articleElement.addElement("author");
		
		Element firstNameElement = authorElement.addElement("firstname");
		firstNameElement.setText("Marcello");
		Element lastNameElement = authorElement.addElement("lastname");
		lastNameElement.setText("Vitaletti");
		
		try {
			XMLWriter output = new XMLWriter(new FileWriter(new File(
					System.getProperty("user.dir") + File.separator + "src"
							+ File.separator + "catalog.xml")));
			output.write(document);
			output.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] argv) {
		dom4jWriter dom4j = new dom4jWriter();
		dom4j.generateDocument();
		System.out.println("ok");
	}
}



