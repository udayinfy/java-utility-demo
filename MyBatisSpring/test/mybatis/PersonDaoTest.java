package mybatis;

import java.util.Calendar;

import mybatis.context.SpringContext;
import mybatis.dao.IPersonDao;
import mybatis.dao.bean.Person;
import mybatis.dao.impl.PersonDaoImpl;

import org.springframework.context.ApplicationContext;

public class PersonDaoTest {

	public static void main(String[] args) {

		SpringContext.initContext();
		ApplicationContext appContext = SpringContext.getAppContext();
		
		Person person = new Person();
		person.setPname("person1");
		person.setAge(29);
		person.setBirthday(Calendar.getInstance().getTime());

		IPersonDao personDao = (IPersonDao) appContext.getBean("personDao");

//		personDao.addPerson(person);

		Person p = personDao.queryPersonById("1");
		System.out.println(p.getPname());

	}

}
