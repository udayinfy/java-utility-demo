package com.hibernate.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.hibernate.context.HibernateXmlCfgContext;
import com.hibernate.domain.User;

/**
 * 查询测试
 * @author Admin
 *
 */
public class UserQueryTest {
	
	public static void main(String[] args) {
		
		String name = "德华";
		
		List<User> list = criteriaQuery(name);
		
		for (Iterator<User> it = list.iterator(); it.hasNext();) {
			User user = it.next();
			System.out.println(user.getId());
		}
		
		
	}
	
	/**
	 * get load方式
	 * @param id
	 */
	public static void getUser(int id){
		Session session = null;
		User user = null;
		try{
			session = HibernateXmlCfgContext.getSession();
//			user = (User) session.get(User.class, id);
			
			
			// 懒加载
			user = (User) session.load(User.class, id);
			System.out.println(user.getClass());
			Hibernate.initialize(user);
			
			
		}finally{
			if( session != null )
				session.close();
		}
		
		
	}
	
	/**
	 * hql sql 查询方式
	 * @param name
	 */
	public static List<User> query(String name){
		Session session = null;
		try{
			
			session = HibernateXmlCfgContext.getSession();
			
//			String hql = "from User as user where user.name=?";
			String hql = "from User as user where user.name=:name"; // 别名代替？，更容易维护
			
			Query query = session.createQuery(hql);
//			session.createSQLQuery("");
			
//			query.setParameter(0, name);
			query.setParameter("name", name);
			
			List<User> list = query.list();
//			query.uniqueResult();  //可以确定查询到的结果只有一个
			
//			hibernate 分页
//			query.setFirstResult(0);
//			query.setMaxResults(10);
			
			return list;
		}finally{
			if( session != null )
				session.close();
		}
	}
	
	/**
	 * Criteria 查询方式
	 * @param name
	 * @return
	 */
	public static List<User> criteriaQuery(String name){
		Session session = null;
		try{
			
			session = HibernateXmlCfgContext.getSession();
			
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("name", name));
			criteria.add(Restrictions.lt("birthday", new Date())); // 可以加上多个约束条件

//			hibernate 分页
			criteria.setFirstResult(0);
			criteria.setMaxResults(10);
			
			List<User> list = criteria.list();
			
			
			return list;
		}finally{
			if( session != null )
				session.close();
		}
		
	}

}
