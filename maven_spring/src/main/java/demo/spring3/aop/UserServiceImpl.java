package demo.spring3.aop;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	public void getUserByUid(String uid) {

		System.out.println("getUserById");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateUserByUid(String uid) {

		System.out.println("updateUserByUid");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
