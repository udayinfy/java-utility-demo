package hibernate.spring.dao.impl;

import hibernate.spring.dao.IUserDao;
import hibernate.spring.dao.domain.User;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements IUserDao {

	@Override
	@CacheEvict(value = "userCache", allEntries = true)
	public void save(User user) {

		getHibernateTemplate().save(user);

	}

	@Override
	@Cacheable("userCache")
	public User query(int id) {

		User user = getHibernateTemplate().get(User.class, id);

		return user;
	}

}
