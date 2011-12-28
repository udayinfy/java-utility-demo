package log4j.props;

import org.apache.log4j.Logger;

public class LogDemo {
	
	private static Logger logger = Logger.getLogger(LogDemo.class);
	
	public static void main(String[] args) {
		logger.error("this is error message.");
		logger.debug("this is debug message.");
	}

}
