package com.hibernate.test;

import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.domain.User;
import com.hibernate.util.HibernateUtil;

public class UserTest {
	
	public static void main(String[] args){
		
		User user = new User();
		user.setName("���»�");
		user.setBirthday(new Date());
		//111˲ʱ״̬����
		
		addUser(user);

		//222�ѹ�״̬����
		User user2 = getUser(user.getId());
		System.out.println(user2.getName());
		
	}
	
	
	/**
	 *  hibernate������׼ģ��
	 * @param user
	 */
	public static void addUser(User user){
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateUtil.getSeesion();
			tran = session.beginTransaction();
			
			session.save(user);
//			session.persist(user);
			//333�־�״̬����
			
			tran.commit();
		}catch(HibernateException he){
			if( tran !=null )
				tran.rollback();
			throw he;
		}finally{
			if( session != null )
				session.close();
		}
	}
	
	public static User getUser(int id){
		Session session = null;
		User user = null;
		try{
			session = HibernateUtil.getSeesion();
//			user = (User) session.get(User.class, id);
			
			
			// ������
			user = (User) session.load(User.class, id);
			System.out.println(user.getClass());
			Hibernate.initialize(user);
			
			
			return user;
		}finally{
			if( session != null )
				session.close();
		}
		
		
	}

}
