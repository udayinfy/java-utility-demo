package utility.demo.file;

import java.util.Properties;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * Spring �ṩ�� PropertiesLoaderUtils ������ֱ��ͨ��������·�����ļ���ַ����������Դ��
 * @author zhc
 * @version 2011/12/13
 * 
 */
public class PropertiesLoaderUtilsExample {
	
	public static void main(String[] args) throws Throwable {
		
		// �� jdbc.properties ��λ����·���µ��ļ�
		Properties props = PropertiesLoaderUtils.loadAllProperties("jdbc.properties");
		System.out.println(props.getProperty("jdbc.driverClassName"));
		
	}
}