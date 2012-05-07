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
 * ��ѯ����
 * @author Admin
 *
 */
public class UserQueryTest {
	
	public static void main(String[] args) {
		
		String name = "�»�";
		
		List<User> list = criteriaQuery(name);
		
		for (Iterator<User> it = list.iterator(); it.hasNext();) {
			User user = it.next();
			System.out.println(user.getId());
		}
		
		
	}
	
	public static void getUser(int id){
		Session session = null;
		User user = null;
		try{
			session = HibernateXmlCfgContext.getSession();
//			user = (User) session.get(User.class, id);
			
			
			// ������
			user = (User) session.load(User.class, id);
			System.out.println(user.getClass());
			Hibernate.initialize(user);
			
			
		}finally{
			if( session != null )
				session.close();
		}
		
		
	}
	
	/**
	 * hql sql ��ѯ��ʽ
	 * @param name
	 */
	public static List<User> query(String name){
		Session session = null;
		try{
			
			session = HibernateXmlCfgContext.getSession();
			
//			String hql = "from User as user where user.name=?";
			String hql = "from User as user where user.name=:name"; // �������棿��������ά��
			
			Query query = session.createQuery(hql);
//			session.createSQLQuery("");
			
//			query.setParameter(0, name);
			query.setParameter("name", name);
			
			List<User> list = query.list();
//			query.uniqueResult();  //����ȷ����ѯ���Ľ��ֻ��һ��
			
//			hibernate ��ҳ
//			query.setFirstResult(0);
//			query.setMaxResults(10);
			
			return list;
		}finally{
			if( session != null )
				session.close();
		}
	}
	
	/**
	 * Criteria ��ѯ��ʽ
	 * @param name
	 * @return
	 */
	public static List<User> criteriaQuery(String name){
		Session session = null;
		try{
			
			session = HibernateXmlCfgContext.getSession();
			
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("name", name));
			criteria.add(Restrictions.lt("birthday", new Date())); // ���Լ��϶��Լ������

//			hibernate ��ҳ
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
