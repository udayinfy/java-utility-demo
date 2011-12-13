package utility.demo.file;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

/**
 * 当您使用 Resource 实现类加载文件资源时，它默认采用操作系统的编码格式。如果文件资源采用了特殊的编码格式（如 UTF-8），则在读取资源内容时必须事先通过 EncodedResource 指定编码格式，否则将会产生中文乱码的问题。
 * @author zhc
 * @version 2011/12/13
 *
 */
public class EncodedResourceExample {
	
	public static void main(String[] args) throws Throwable {
		
		Resource res = new ClassPathResource("conf/abc.conf");
		
		// ① 指定文件资源对应的编码格式（UTF-8）
		EncodedResource encRes = new EncodedResource(res, "UTF-8");
		
		// ② 这样才能正确读取文件的内容，而不会出现乱码
		String content = FileCopyUtils.copyToString(encRes.getReader());
		
		System.out.println(content);
		
	}
}