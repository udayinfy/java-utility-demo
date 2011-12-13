package utility.demo.file;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

/**
 * FileCopyUtils�����ṩ�����һ��ʽ�ľ�̬�����������ܹ����ļ����ݿ�����һ��Ŀ�� byte[]��String ����һ�������������ļ��С�
 * @author zhc
 * @version 2011/12/13
 */
public class FileCopyUtilsExample {
	
	public static void main(String[] args) throws Throwable {
		
		Resource res = new ClassPathResource("conf/abc.conf");
		
		// �� ���ļ����ݿ�����һ�� byte[] ��
		byte[] fileData = FileCopyUtils.copyToByteArray(res.getFile());
		
		// �� ���ļ����ݿ�����һ�� String ��
		String fileStr = FileCopyUtils.copyToString(new FileReader(res.getFile()));
		
		// �� ���ļ����ݿ�������һ��Ŀ���ļ�
		FileCopyUtils.copy(res.getFile(), new File(res.getFile().getParent() + "/file2.txt"));

		// �� ���ļ����ݿ�����һ���������
		OutputStream os = new ByteArrayOutputStream();
		FileCopyUtils.copy(res.getInputStream(), os);
	}
}