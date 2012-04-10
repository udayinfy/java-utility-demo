package hibernate.spring.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest {
	
	public static void main(String[] args) {
		read();
	}
	
	public static void read(){
		String filePath = "C:\\abc.txt";
		File file = new File(filePath);
		
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			System.out.println(fileInputStream);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("这是一个运行时异常。");
		}
		
	}

}
