package hibernate.spring.context;

import javax.security.auth.login.AppConfigurationEntry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {
	
	private static ApplicationContext appContext = null;
	
	public static void initContext(){
		appContext = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	}

	public static ApplicationContext getAppContext() {
		return appContext;
	}
	
	

}
