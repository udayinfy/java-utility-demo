package utility.demo.file;

import java.io.File;
import org.springframework.util.ResourceUtils;

/**
 * Spring 提供了一个 ResourceUtils 工具类，它支持“classpath:”和“file:”的地址前缀，它能够从指定的地址加载文件资源。
 * @author zhc
 * @version 2011/12/13
 *
 */
public class ResourceUtilsExample {
	
	public static void main(String[] args) throws Throwable {
		
		File clsFile = ResourceUtils.getFile("classpath:conf/abc.conf");
		System.out.println(clsFile.isFile());

		String filePath = "file:D:/Workspaces/workspace-ee/SpringDemo/utility/conf/abc.conf";
		File httpFile = ResourceUtils.getFile(filePath);
		System.out.println(httpFile.isFile());
	}
	
}