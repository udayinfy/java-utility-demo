package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.service.PersonService;

public class SpringTest {

	@Test
	public void instanceSpring() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		PersonService personService = (PersonService) ctx.getBean("personService");
		personService.save();
	}
}
