package junit.test;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import demo.bean.LoggingBean;
import demo.service.PersonService;

public class SpringTest {

	@Test
	public void instanceSpring() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		PersonService personService = (PersonService) ctx.getBean("personService");
		personService.save();
	}

	@Test
	public void testNameAware() {

		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		LoggingBean lb = (LoggingBean) factory.getBean("logging");
		lb.run();

	}
	
}
