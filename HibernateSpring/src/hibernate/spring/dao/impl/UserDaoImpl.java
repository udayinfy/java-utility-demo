package hibernate.spring.dao.impl;

import hibernate.spring.dao.IUserDao;
import hibernate.spring.dao.domain.User;

import java.sql.SQLException;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {

	@Override
	@CacheEvict(value = "userCache", allEntries = true)
	public void save(User user) {
		
		try{
			getHibernateTemplate().save(user);
		}catch(DataAccessException dae){
			// TODO 捕获不到的异常
			SQLException sqle = (SQLException) dae.getCause();  
			System.out.println("Error code: " + sqle.getErrorCode());  
			System.out.println("SQL state: " + sqle.getSQLState());  
		}
	}

	@Override
	@Cacheable("userCache")
	public User query(int id) {

		User user = getHibernateTemplate().get(User.class, id);

		return user;
	}

}
