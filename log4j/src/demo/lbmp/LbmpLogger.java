package demo.lbmp;

import org.apache.log4j.Logger;

public class LbmpLogger {
	
	public static void main(String[] args) {
		LbmpLogger.debug("aaaaaaaaaaa");
	}
	
	private static Logger debugLogger = Logger.getLogger("lbmpdebug");
	private static Logger infoLogger = Logger.getLogger("lbmpinfo");
	private static Logger warnLogger = Logger.getLogger("lbmpwarn");
	private static Logger errorLogger = Logger.getLogger("lbmperror");
	
	public static void debug(String message){
		debugLogger.debug(message);
	}
	
	public static void debug(String message, Throwable t){
		debugLogger.debug(message, t);
	}
	
	public static void info(String message){
		infoLogger.info(message);
	}
	
	public static void info(String message, Throwable t){
		infoLogger.info(message, t);
	}
	
	public static void warn(String message){
		warnLogger.warn(message);
	}
	
	public static void warn(String message, Throwable t){
		warnLogger.warn(message, t);
	}
	
	public static void error(String message){
		errorLogger.error(message);
	}
	
	public static void error(String message, Throwable t){
		errorLogger.error(message, t);
	}
	

}
