package hibernate.spring.test;

import java.util.Calendar;

import hibernate.spring.context.SpringContext;
import hibernate.spring.dao.IUserDao;
import hibernate.spring.dao.domain.User;
import hibernate.spring.dao.impl.UserDaoImpl;

import org.springframework.context.ApplicationContext;

public class HibernateSpringTest {
	
	public static void main(String[] args) {
		
		SpringContext.initContext();
		ApplicationContext appContext = SpringContext.getAppContext();
		
		IUserDao userDao = (UserDaoImpl)appContext.getBean("userDao");
		
		User user = new User();
		user.setName("User123");
		user.setBirthday(Calendar.getInstance().getTime());
		
		userDao.save(user);
		
		
	}

}
