package utility.demo.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

/**
 * FileCopyUtils，它提供了许多一步式的静态操作方法，能够将文件内容拷贝到一个目标 byte[]、String 甚至一个输出流或输出文件中。
 * @author zhc
 * @version 2011/12/13
 */
public class FileCopyUtilsExample {
	
	public static void main(String[] args) throws Throwable {
		
		Resource res = new ClassPathResource("conf/abc.conf");
		
		// ① 将文件内容拷贝到一个 byte[] 中
		byte[] fileData = FileCopyUtils.copyToByteArray(res.getFile());
		
		// ② 将文件内容拷贝到一个 String 中
		String fileStr = FileCopyUtils.copyToString(new FileReader(res.getFile()));
		
		// ③ 将文件内容拷贝到另一个目标文件
		FileCopyUtils.copy(res.getFile(), new File(res.getFile().getParent() + "/file2.txt"));

		// ④ 将文件内容拷贝到一个输出流中
		OutputStream os = new ByteArrayOutputStream();
		FileCopyUtils.copy(res.getInputStream(), os);
	}
}