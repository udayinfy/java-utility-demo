package demo.jndi;

import javax.naming.Context;

import demo.service.DBService;
import demo.service.LogService;

public class JNDIClient {

	public static void main(String[] args) {
		try {
			JNDIContainer container = new JNDIContainer();
			container.init();

			// JNDI�ͻ���ʹ�ñ�׼JNDI�ӿڷ�����������
			Context ctx = container.getContext();
			DBService db = (DBService) ctx.lookup("DBService");
			System.out.println("db location is:" + db.getLocation()
					+ ",state is:" + db.getState());
			db.accessDB();

			LogService ls = (LogService) ctx.lookup("LogService");
			ls.log("this is a log message.");

			container.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
