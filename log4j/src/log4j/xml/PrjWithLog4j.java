package log4j.xml;

import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class PrjWithLog4j {
	
	private static Logger logger = Logger.getLogger(PrjWithLog4j.class);
	
	public static void main(String[] args) {
		
		URL url = PrjWithLog4j.class.getResource("/log4j.xml");
		
		DOMConfigurator.configure(url);
		
		logger.debug("this is dubug message.");
		logger.debug("this is dubug message.");
		logger.debug("this is dubug message.");
		
		
		
		
	}

}
