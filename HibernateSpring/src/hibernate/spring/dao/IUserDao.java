package hibernate.spring.dao;

import hibernate.spring.dao.domain.User;


public interface IUserDao {
	
	public void save(User user);
	
	public User query(int id);

}
