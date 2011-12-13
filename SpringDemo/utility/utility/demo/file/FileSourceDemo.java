package utility.demo.file;

import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * Spring ������һ�� org.springframework.core.io.Resource �ӿڣ�Resource �ӿ���Ϊ��ͳһ�������Ͳ�ͬ����Դ������ģ�Spring �ṩ������ Resource �ӿڵ�ʵ���࣬��Щʵ����������ɵؼ��ز�ͬ���͵ĵײ���Դ�����ṩ�˻�ȡ�ļ�����URL ��ַ�Լ���Դ���ݵĲ���������
 * @author zhc 
 * @version 2011/12/13
 */
public class FileSourceDemo {
	
	public static void main(String[] args) {
		try {
			String filePath1 = "D:/Workspaces/workspace-ee/SpringDemo/utility/conf/abc.conf";
			String filePath2 = "conf/abc.conf";
			
			// ʹ��ϵͳ�ļ�·����ʽ�����ļ�
			Resource res1 = new FileSystemResource(filePath1);
			// ʹ����·����ʽ�����ļ�
			Resource res2 = new ClassPathResource(filePath2);
			
			InputStream inputStream1 = res1.getInputStream();
			InputStream inputStream2 = res2.getInputStream();
			
			System.out.println("res1:" + res1.getFilename());
			System.out.println("res2:" + res2.getFilename());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}