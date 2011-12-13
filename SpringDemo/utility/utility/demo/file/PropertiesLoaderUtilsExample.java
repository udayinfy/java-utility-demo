package utility.demo.file;

import java.util.Properties;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * Spring 提供的 PropertiesLoaderUtils 允许您直接通过基于类路径的文件地址加载属性资源。
 * @author zhc
 * @version 2011/12/13
 * 
 */
public class PropertiesLoaderUtilsExample {
	
	public static void main(String[] args) throws Throwable {
		
		// ① jdbc.properties 是位于类路径下的文件
		Properties props = PropertiesLoaderUtils.loadAllProperties("jdbc.properties");
		System.out.println(props.getProperty("jdbc.driverClassName"));
		
	}
}