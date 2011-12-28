package demo.xml;

import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LogDemo {
	
	private static Logger logger = Logger.getLogger(LogDemo.class);
	
	public static void main(String[] args) {
		
		URL url = LogDemo.class.getResource("/log4j.xml");
		
		DOMConfigurator.configure(url);
		
		logger.debug("this is dubug message.");
		logger.debug("this is dubug message.");
		logger.debug("this is dubug message.");
		
		
		
		
	}

}
