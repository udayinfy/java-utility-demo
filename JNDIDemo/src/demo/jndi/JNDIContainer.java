package demo.jndi;

import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import demo.service.DBService;
import demo.service.LogService;

public class JNDIContainer {

	private Context ctx = null;

	public void init() throws Exception {
		// ��ʼ��JNDI�ṩ�ߡ�
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.fscontext.RefFSContextFactory");
		env.put(Context.PROVIDER_URL, "file:/c:/sample"); // fscontext�ĳ�ʼĿ¼��������Ҫ��c:\�´���sampleĿ¼��
		ctx = new InitialContext(env);
		loadServices();
	}

	// �������ļ�JNDIContainer.properties�ж�ȡDBService��LogServiceʵ�֣��󶨵�Context�С�
	private void loadServices() throws Exception {
		InputStream in = getClass().getResourceAsStream(
				"JNDIContainer.properties");
		Properties props = new Properties();
		props.load(in);

		// inject dbservice
		String s = props.getProperty("DBServiceClass");
		Object obj = Class.forName(s).newInstance();
		if (obj instanceof DBService) {
			DBService db = (DBService) obj;
			String[] ss = props.getProperty("DBServiceProperty").split(";");
			for (int i = 0; i < ss.length; i++)
				db.setProperty(i, ss[i]);
			ctx.rebind(props.getProperty("DBServiceName"), db);
		}

		// inject logservice
		s = props.getProperty("LogServiceClass");
		obj = Class.forName(s).newInstance();
		if (obj instanceof LogService) {
			LogService log = (LogService) obj;
			ctx.rebind(props.getProperty("LogServiceName"), log);
		}
	}

	public void close() throws NamingException {
		ctx.close();
	}

	public Context getContext() {
		return ctx;
	}
}
