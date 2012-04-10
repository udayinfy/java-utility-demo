package hibernate.spring.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import hibernate.spring.dao.IUserDao;
import hibernate.spring.dao.domain.User;

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
