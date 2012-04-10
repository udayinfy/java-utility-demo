package hibernate.spring.test;

import hibernate.spring.context.SpringContext;
import hibernate.spring.dao.IUserDao;
import hibernate.spring.dao.domain.User;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;

public class HibernateSpringTest {
	
	public static void main(String[] args) {
		
		SpringContext.initContext();
		ApplicationContext appContext = SpringContext.getAppContext();
		
		IUserDao userDao = (IUserDao) appContext.getBean("userDao");
		
		User user = new User();
		user.setName("User123");
		user.setBirthday(Calendar.getInstance().getTime());
		
		userDao.save(user);
		
		
	}

}
