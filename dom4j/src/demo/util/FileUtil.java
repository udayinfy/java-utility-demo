package demo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileUtil {

	public static void main(String[] args) {
		try {

		} catch (Exception ex) {
			Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	/**
	 * 把图片的二进制读入byte数组
	 * 
	 * @return
	 * @throws IOException
	 */
	public static byte[] readImage(String imagePath) throws IOException {
		byte[] retValue = null;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(new File(imagePath));
			retValue = new byte[fileInputStream.available()];
			fileInputStream.read(retValue);
		} finally {
			fileInputStream.close();
		}
		return retValue;
	}

	/**
	 * 本地目录,不存在创建
	 */
	public static void mkDir(String dir) {
		File file = new File(dir);
		if (!file.isDirectory()) {
			file.mkdir();
		}
	}

	/**
	 * 得到项目的bin目录
	 * 
	 * @return
	 */
	public static String getBinPath() {
		String fileUrl = FileUtil.class.getResource("/").getFile();
		return fileUrl;
	}

	/**
	 * 指定编码把文件读入字符串
	 * 
	 * @param file
	 * @param encode
	 * @return
	 */
	public static String readToBuffer(File file, String encode) {

		StringBuilder buffer = new StringBuilder();
		String line = "";
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encode));
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
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return buffer.toString();
	}

	/**
	 * 指定编码把文件读入字符串
	 * 
	 * @param fileUrl
	 * @param encode
	 * @return
	 */
	public static String readToBuffer(String fileUrl, String encode) {

		StringBuilder buffer = new StringBuilder();
		String line = "";
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileUrl), encode));
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
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return buffer.toString();
	}
}
