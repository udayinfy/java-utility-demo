package hibernate.spring.test;

import hibernate.spring.context.SpringContext;
import hibernate.spring.dao.domain.User;
import hibernate.spring.service.IUserService;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;

public class ServiceTest {
	
	public static void main(String[] args) {
		
		SpringContext.initContext();
		ApplicationContext appContext = SpringContext.getAppContext();
		
		IUserService userService = (IUserService) appContext.getBean("userService");
		
		User user = new User();
		user.setName("User12345678");
		user.setBirthday(Calendar.getInstance().getTime());
		
		userService.addUser(user);
			
		
		
	}

}
