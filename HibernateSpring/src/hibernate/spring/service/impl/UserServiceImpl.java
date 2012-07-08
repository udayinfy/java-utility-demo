package hibernate.spring.service.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hibernate.spring.dao.IUserDao;
import hibernate.spring.dao.domain.User;
import hibernate.spring.service.IUserService;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = RuntimeException.class)
	public void addUser(User user) {

		userDao.save(user);

		// try {
		otherBiz(user);
		// } catch (RuntimeException e) {
		// e.printStackTrace();
		// }
		// throw new
		// RuntimeException("The Excepiton is throwed out from User Service.");

	}

	public void otherBiz(User user) {
		
		user.setName("ModifidName");
		
//		throw new RuntimeException("The Excepiton is throwed out from User Service.");
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

}
