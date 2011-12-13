package utility.demo.file;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

/**
 * ����ʹ�� Resource ʵ��������ļ���Դʱ����Ĭ�ϲ��ò���ϵͳ�ı����ʽ������ļ���Դ����������ı����ʽ���� UTF-8�������ڶ�ȡ��Դ����ʱ��������ͨ�� EncodedResource ָ�������ʽ�����򽫻����������������⡣
 * @author zhc
 * @version 2011/12/13
 *
 */
public class EncodedResourceExample {
	
	public static void main(String[] args) throws Throwable {
		
		Resource res = new ClassPathResource("conf/abc.conf");
		
		// �� ָ���ļ���Դ��Ӧ�ı����ʽ��UTF-8��
		EncodedResource encRes = new EncodedResource(res, "UTF-8");
		
		// �� ����������ȷ��ȡ�ļ������ݣ��������������
		String content = FileCopyUtils.copyToString(encRes.getReader());
		
		System.out.println(content);
		
	}
}