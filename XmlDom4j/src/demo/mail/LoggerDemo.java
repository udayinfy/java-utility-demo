package demo.mail;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerDemo {

	public static void main(String[] args) {
		Properties props = new Properties();
		try {
			InputStream istream = LoggerDemo.class.getResourceAsStream("/demo/mail/log4j.properties");
			props.load(istream);
			istream.close();
			PropertyConfigurator.configure(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Logger logger = Logger.getLogger("mail");
		logger.error("ddddddddddddddddddd");
		
	}
}
