package demo.serviceprovider;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;

import demo.service.DBService;

// Ϊ�˽����ݿ����ʵ������JNDI��Context�У�������Ҫʵ��Referenceable�ӿڣ���ʵ��RetReference������
public class SimpleDBService implements Referenceable, DBService {
	
	private String location = "mydb//local:8421/defaultdb";  // ���ݿ��������֮һ�����ݿ�λ��
	private String state = "start";  // ���ݿ��������֮�������ݿ�״̬

	public Reference getReference() throws NamingException {
		// Reference�Ƕ�������ã�Context�д�ŵ���Reference��Ϊ�˴�Reference�л�ԭ������ʵ����
		// ������Ҫ���RefAddr�������Ǵ�������ʵ���������������ǵ�SimpleDBService�У�location��
		// state����������������
		Reference ref = new Reference(getClass().getName(),
				SimpleDBServiceFactory.class.getName(), null);
		ref.add(new StringRefAddr("location", location));
		ref.add(new StringRefAddr("state", state));
		return ref;
	}

	public void accessDB() {
		if (state.equals("start"))
			System.out.println("we are accessing DB.");
		else
			System.out.println("DB is not start.");
	}

	public String getLocation() {
		return location;
	}

	public String getState() {
		return state;
	}

	public void setProperty(int index, String property) {
		if (index == 0)
			location = property;
		else
			state = property;
	}
}
