package utility.props;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropUtil {
	
	private static final Properties props = new Properties();
	private static final String profilePath = PropUtil.class.getResource("/").getFile() + "redirect.properties";
	private static final String comment = "";

	static {
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(profilePath));
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
	 * 
	 * @param binPath
	 *            相对于bin根目录的文件路径
	 * @return
	 */
	public static Properties loadProperties(String binPath) {
		Properties retProp = new Properties();
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(profilePath));
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
	 * 写入一对properties信息，如果该键已经存在，更新该键的值； 如果该键不存在，则插件一对键值。
	 * 
	 * @param keyname
	 *            键名
	 * @param keyvalue
	 *            键值
	 */
	public static void writeProperty(String key, String value) {
		try {
			OutputStream fos = new FileOutputStream(profilePath);
			props.setProperty(key, value);
			props.store(fos, comment);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新properties文件的键值对，如果该键已经存在，更新该键的值； 如果该键不存在，则插件一对键值。
	 * 
	 * @param key
	 *            键名
	 * @param keyvalue
	 *            键值
	 */
	public void updateProperty(String key, String value) {
		try {
			props.load(new FileInputStream(profilePath));
			OutputStream fos = new FileOutputStream(profilePath);
			props.setProperty(key, value);
			props.store(fos, comment);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除properties文件的键值对， 如果键不存在，不任何做操作
	 * 
	 * @param key
	 *            键名
	 * @param keyvalue
	 *            键值
	 */
	public static void removeProperty(String key) {
		try {
			props.load(new FileInputStream(profilePath));
			OutputStream fos = new FileOutputStream(profilePath);
			props.remove(key);
			props.store(fos, comment);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 打印Properties列表
	 */
	public static String printProperties(String splitStr) {
		StringBuffer buffer = new StringBuffer();
		Set<Object> keySet = props.keySet();
		for (Iterator it = keySet.iterator(); it.hasNext();) {
			String key = (String) it.next();
			String keyValue = key + "=" + props.getProperty(key);
			System.out.println(keyValue);
			buffer.append(keyValue + splitStr);
		}
		
		return buffer.toString();
		
	}
	
	/**
	 * 打印Properties列表
	 */
	public static String printProperties(Properties props, String splitStr) {
		StringBuffer buffer = new StringBuffer();
		Set<Object> keySet = props.keySet();
		for (Iterator it = keySet.iterator(); it.hasNext();) {
			String key = (String) it.next();
			String keyValue = key + "=" + props.getProperty(key);
			System.out.println(keyValue);
			buffer.append(keyValue + splitStr);
		}
		
		return buffer.toString();
		
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

	public static Properties getProperties() {
		return props;
	}

}
