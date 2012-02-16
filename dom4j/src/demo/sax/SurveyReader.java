package demo.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SurveyReader extends DefaultHandler {

	public SurveyReader() {
	}
	
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("startDocument...");
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("endDocument...");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		System.out.println("startElement...");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		System.out.println("endElement...");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		System.out.println("characters...");
	}

	public void error(SAXParseException e) {
		System.out.println("Error parsing the file: " + e.getMessage());
	}

	public void warning(SAXParseException e) {
		System.out.println("Problem parsing the file: " + e.getMessage());
	}

	public void fatalError(SAXParseException e) {
		System.out.println("Error parsing the file: " + e.getMessage());
		System.out.println("Cannot continue.");
		System.exit(1);
	}

	public static void main(String args[]) {
		XMLReader xmlReader = null;
		try {
			SAXParserFactory spfactory = SAXParserFactory.newInstance();
			spfactory.setValidating(false); // 设置验证选项,如果您的XML文件是有效文档的话,就不用验证.这将提高处理速度
			SAXParser saxParser = spfactory.newSAXParser();
			xmlReader = saxParser.getXMLReader();

			xmlReader.setContentHandler(new SurveyReader());
			xmlReader.setErrorHandler(new SurveyReader());

			InputSource source = new InputSource("\\src\\demo\\sax\\note.xml");
			xmlReader.parse(source);
			
		} catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}
	}
}