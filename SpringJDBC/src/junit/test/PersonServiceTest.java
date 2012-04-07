package junit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.spring.bean.Person;
import demo.spring.service.PersonService;

public class PersonServiceTest {
	private static PersonService personService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
			personService = (PersonService) cxt.getBean("personService");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void save() {
		for (int i = 0; i < 5; i++)
			personService.save(new Person("Person" + i));
	}

	@Test
	public void getPerson() {
		Person person = personService.getPerson(1);
		System.out.println(person.getName());
	}

	@Test
	public void update() {
		Person person = personService.getPerson(1);
		person.setName("xxx");
		personService.update(person);
	}

	@Test
	public void delete() {
		personService.delete(1);
	}

	@Test
	public void getBeans() {
		for (Person person : personService.getPersons()) {
			System.out.println(person.getName());
		}
	}
}
