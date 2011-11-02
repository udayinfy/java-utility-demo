package demo.serviceprovider;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;

import demo.service.LogService;

public class SimpleLogService implements Referenceable, LogService {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// SimpleLogServiceû���κ����ԣ�ͨ��SimpleLogService��������������SimpleLogServiceʵ������һ���ģ�
	// ��������������RefAddr�ˡ�
	public Reference getReference() throws NamingException {
		return new Reference(getClass().getName(),
				SimpleLogServiceFactory.class.getName(), null);
	}

	public void log(String message) {
		String date = sdf.format(new Date());
		System.out.println(date + ":" + message);
	}
}
