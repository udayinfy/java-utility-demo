package demo.regex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {

	
	/**
	 * 把文件读入字符串
	 * @param fileUrl
	 * @return
	 */
	public static String readToBuffer(String fileUrl) {

		StringBuffer buffer = new StringBuffer();
		String line = "";
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileUrl)));
			line = reader.readLine();
			while (line != null) {
				buffer.append(line);
				buffer.append(System.getProperty("line.separator"));
				line = reader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return buffer.toString();
	}


}
