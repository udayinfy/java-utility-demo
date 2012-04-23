package demo.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class DBLogger {
	
	private static Logger dbLogger = org.apache.log4j.Logger.getLogger("db");
	
	static{
		InputStream inputStream = DBLogger.class.getResourceAsStream("/log4j-db.properties");
		Properties prop = new Properties();
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PropertyConfigurator.configure(prop);
	}
	
	public static void error(String msg, Throwable t){
		dbLogger.error(t.toString(), t);
	}
	
	public static void error(String msg){
		dbLogger.error(msg);
	}
	
}
