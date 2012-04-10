package spatial.hibernate.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {


	public static String getBinPath() {
		String fileUrl = FileUtil.class.getResource("/").getFile();
		return fileUrl;
	}

	public static String readToBuffer(String fileUrl, String encode) {

		StringBuilder buffer = new StringBuilder();
		String line = "";
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileUrl), encode));
			line = reader.readLine();
			while (line != null) {
				buffer.append(line);
				buffer.append("\n");
				line = reader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String content = buffer.toString();
		return content.substring(0, content.length()-2);
	}
}
