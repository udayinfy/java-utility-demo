package demo.serviceprovider;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;

import demo.service.DBService;

// 为了将数据库服务实例加入JNDI的Context中，我们需要实现Referenceable接口，并实现RetReference方法。
public class SimpleDBService implements Referenceable, DBService {
	
	private String location = "mydb//local:8421/defaultdb";  // 数据库服务属性之一：数据库位置
	private String state = "start";  // 数据库服务属性之二：数据库状态

	public Reference getReference() throws NamingException {
		// Reference是对象的引用，Context中存放的是Reference，为了从Reference中还原出对象实例，
		// 我们需要添加RefAddr，它们是创建对象实例的线索。在我们的SimpleDBService中，location和
		// state是这样两个线索。
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
