package demo.spring3.aop;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	public User getUserByUid(long uid) {

		System.out.println("getUserById");

		User user = new User();
		user.setUid(1L);
		user.setName("aname");
		
		return user;

	}

	public void updateUserByUid(long uid) {

		System.out.println("updateUserByUid");

	}

}
