package demo.schema.javase;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XSDCheck {

	public static void main(String[] args) throws SAXException, IOException {

		// 1. Lookup a factory for the W3C XML Schema language
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		// 2. Compile the schema.
		// Here the schema is loaded from a java.io.File, but you could use
		// a java.net.URL or a javax.xml.transform.Source instead.
		String xsdUrl = System.getProperty("user.dir") + "\\src\\demo\\schema\\javase\\app.xsd";
		File schemaLocation = new File(xsdUrl);
		Schema schema = factory.newSchema(schemaLocation);

		// 3. Get a validator from the schema.
		Validator validator = schema.newValidator();
//		validator.setErrorHandler(errorHandler)

		// 4. Parse the document you want to check.
		String xmlUrl = System.getProperty("user.dir") + "\\src\\demo\\schema\\javase\\app.xml";
		Source source = new StreamSource(xmlUrl);

		// 5. Check the document
		try {
			validator.validate(source);
			System.out.println(xmlUrl + " is valid.");
		} catch (SAXException ex) {
			System.out.println(xmlUrl + " is not valid because ");
			System.out.println(ex.getMessage());
		}

	}

}