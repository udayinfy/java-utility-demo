package demo.schema;

import java.io.File;
import java.io.StringReader;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.util.XMLErrorHandler;
import org.xml.sax.SAXException;

import demo.util.FileUtil;

public class ValidateDemo {

	public static void main(String[] args) {
		String xmlPath = FileUtil.getBinPath() + "\\xml\\validatexml.xml";
		String xml = FileUtil.readToBuffer(xmlPath, "utf-8");
		String schemaPath = FileUtil.getBinPath() + "\\schema\\ecsync.xsd";
		String schema = FileUtil.readToBuffer(schemaPath, "utf-8");

		try {
			SAXReader reader = new SAXReader();
			reader.setValidation(true);
			reader.setFeature("http://xml.org/sax/features/validation", true);
			reader.setFeature("http://apache.org/xml/features/validation/schema", true);
			// specify the schema to use
			reader.setProperty("http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation", schema);
			XMLErrorHandler errorHandler = new XMLErrorHandler();
			// add error handler which turns any errors into XML
			reader.setErrorHandler(errorHandler);
			// parse the document
			Document document = reader.read(new StringReader(xml));
			boolean hasError = errorHandler.getErrors().hasContent();
			System.out.println(hasError);
		} catch (SAXException sax) {

		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}

}
