package utility.demo.file;

import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * Spring 定义了一个 org.springframework.core.io.Resource 接口，Resource 接口是为了统一各种类型不同的资源而定义的，Spring 提供了若干 Resource 接口的实现类，这些实现类可以轻松地加载不同类型的底层资源，并提供了获取文件名、URL 地址以及资源内容的操作方法。
 * @author zhc 
 * @version 2011/12/13
 */
public class FileSourceDemo {
	
	public static void main(String[] args) {
		try {
			String filePath1 = "D:/Workspaces/workspace-ee/SpringDemo/utility/conf/abc.conf";
			String filePath2 = "conf/abc.conf";
			
			// 使用系统文件路径方式加载文件
			Resource res1 = new FileSystemResource(filePath1);
			// 使用类路径方式加载文件
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