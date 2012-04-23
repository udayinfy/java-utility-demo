package demo.database;

import java.io.FileNotFoundException;

public class LogTest {
	
	public static void main(String[] args) {

		try {
			throw new FileNotFoundException("aaaaaaaaaaaaaaaaaaaaaa");
		} catch (FileNotFoundException e) {
			DBLogger.error(e.getMessage(), e);
		}
		
	}

}
