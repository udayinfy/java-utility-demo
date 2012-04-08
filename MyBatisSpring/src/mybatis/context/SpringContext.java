package mybatis.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {

	private static ApplicationContext appContext = null;

	public static void initContext() {
		appContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	}

	public static ApplicationContext getAppContext() {
		return appContext;
	}

	

}
