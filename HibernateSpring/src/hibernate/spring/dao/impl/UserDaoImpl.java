package hibernate.spring.dao.impl;

import hibernate.spring.dao.IUserDao;
import hibernate.spring.dao.domain.User;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements IUserDao{

	@Override
	public void save(User user) {
		
		getHibernateTemplate().save(user);
		
		user.setName("editedName");
		getHibernateTemplate().update(user);
		
		
	}

	@Override
	public User query(int id) {
		
		User user = getHibernateTemplate().get(User.class, id);
		
		return user;
	}

}
