package utility.demo.file;

import java.util.Locale;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.LocalizedResourceHelper;

/**
 * ���ػ��ļ���Դ��һ��ͨ�����ػ���ʶ�����������������ļ���Spring �ṩ�� LocalizedResourceHelper ����ͨ���ļ���Դ�����ͱ��ػ�ʵ���ȡƥ��ı��ػ��ļ���Դ���� Resource ���󷵻ء�
 * @author zhc
 * @version 2011/12/13
 *
 */
public class LocaleResourceTest {
	
	public static void main(String[] args) {
		
		LocalizedResourceHelper lrHalper = new LocalizedResourceHelper();
		
		// �� ��ȡ��Ӧ�����ı��ػ��ļ���Դ
		Resource msg_us = lrHalper.findLocalizedResource("i18n/message", ".properties", Locale.US);
		// �� ��ȡ��Ӧ�й���½�ı��ػ��ļ���Դ
		Resource msg_cn = lrHalper.findLocalizedResource("i18n/message", ".properties", Locale.CHINA);
		
		System.out.println("fileName(us):" + msg_us.getFilename());
		System.out.println("fileName(cn):" + msg_cn.getFilename());
	}
}