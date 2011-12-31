package demo.props;

import org.apache.log4j.Logger;

public class LogDemo {
	
//	private static Logger logger = Logger.getLogger(LogDemo.class);
	private static Logger logger = Logger.getLogger("D");
	
	public static void main(String[] args) {
		logger.error("this is error message.");
		logger.debug("this is debug message.");
	}

}
