package hibernate.spring.test;

import hibernate.spring.context.SpringContext;
import hibernate.spring.dao.IUserDao;
import hibernate.spring.dao.domain.User;

import java.sql.SQLException;
import java.util.Calendar;

import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

public class DaoTest {
	
	public static void main(String[] args) {
		
		SpringContext.initContext();
		ApplicationContext appContext = SpringContext.getAppContext();
		
		IUserDao userDao = (IUserDao) appContext.getBean("userDao");
		
		User user = new User();
		user.setName("User000");
		user.setBirthday(Calendar.getInstance().getTime());
		
//		try{
			userDao.save(user);
//		}catch(DataAccessException dae){
//			dae.printStackTrace();  
//		}
		
//		User user = userDao.query(5);
//		User user2 = userDao.query(5);
//		System.out.println(user.getName());
		
		
	}

}
