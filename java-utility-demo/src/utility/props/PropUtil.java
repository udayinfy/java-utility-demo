package utility.props;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {

	private static final Properties props = new Properties();

	static {
		InputStream in = null;
		try {
			String filePath = PropUtil.class.getResource("/").getFile() + "utility/props/" + "abc.properties";
			in = new BufferedInputStream(new FileInputStream(filePath));
			props.load(in);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
	
	/**
	 * 加载Properties
	 * @param binPath 相对于bin根目录的文件路径
	 * @return
	 */
	public static Properties loadProps(String binPath){
		Properties retProp = new Properties();
		InputStream in = null;
		try {
			String filePath = PropUtil.class.getResource("/").getFile() + binPath;
			in = new BufferedInputStream(new FileInputStream(filePath));
			retProp.load(in);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return retProp;
	}
	
	/**
	 * 根据key获取对应的值
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return props.getProperty(key);
	}
	

	
	
}
