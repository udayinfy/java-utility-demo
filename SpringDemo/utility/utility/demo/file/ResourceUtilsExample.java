package utility.demo.file;

import java.io.File;
import org.springframework.util.ResourceUtils;

/**
 * Spring �ṩ��һ�� ResourceUtils �����࣬��֧�֡�classpath:���͡�file:���ĵ�ַǰ׺�����ܹ���ָ���ĵ�ַ�����ļ���Դ��
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