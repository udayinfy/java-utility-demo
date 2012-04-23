package com.hibernate.test;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.context.HibernateXmlCfgContext;
import com.hibernate.domain.User;

/**
 * 更通用的写法
 * @author Admin
 *
 */
public class UserTest {
	
	
	public static void main(String[] args) {
		
		
		updateUser();
		
		
	}
	
	public static void addUser(){
		
		User user = new User();
		user.setName("刘德华");
		user.setBirthday(new Date());
		//111瞬时状态对象
		
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateXmlCfgContext.getSession();
			tran = session.beginTransaction();
			
			session.save(user);
//			session.persist(user);
			//222持久状态对象
			
			tran.commit();
		}catch(HibernateException he){
			if( tran !=null )
				tran.rollback();
			throw he;
		}finally{
			if( session != null )
				session.close();
		}

		//333脱管状态对象
		System.out.println(user.getName());
	}
	
	public static void getUser(){
		int id  = 118;
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
	
	public static void updateUser(){
		
		User user = new User();
		user.setId(1);
		user.setName("Name123");
		user.setBirthday(Calendar.getInstance().getTime());
		
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateXmlCfgContext.getSession();
			tran = session.beginTransaction();
			
//			User user = (User) session.get(User.class, 1);
//			user.setName("UpdatedName");                         
//			user.setBirthday(Calendar.getInstance().getTime());  
			
			session.update(user);
			tran.commit();
		}finally{
			if( session != null )
				session.close();
		}
		
	}
	
	/**
	 * hibernate操作标准模板
	 * @param entity
	 */
	public static void add(Object entity){
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateXmlCfgContext.getSession();
			tran = session.beginTransaction();
			
			session.save(entity);
//			session.persist(user);
			//333持久状态对象
			
			tran.commit();
		}/*catch(HibernateException he){ // 1 有异常要抛出去处理。2 不处理异常可以抛出去，简化代码
			if( tran !=null )
				tran.rollback();
			throw he;
		}*/finally{
			if( session != null )
				session.close();
		}
	}
	
	/**
	 * hibernate操作标准模板
	 * @param entity
	 */
	public static void update(Object entity){
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateXmlCfgContext.getSession();
			tran = session.beginTransaction();
			
			session.update(entity);
//			session.persist(user);
			//333持久状态对象
			
			tran.commit();
		}/*catch(HibernateException he){  // 1 有异常要抛出去处理。2 不处理异常可以抛出去，简化代码
			if( tran !=null )
				tran.rollback();
			throw he;
		}*/finally{
			if( session != null )
				session.close();
		}
	}
	
	/**
	 * hibernate操作标准模板
	 * @param entity
	 */
	public static void delete(Object entity){
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateXmlCfgContext.getSession();
			tran = session.beginTransaction();
			
			session.delete(entity);
//			session.persist(user);
			//333持久状态对象
			
			tran.commit();
		}/*catch(HibernateException he){  // 1 有异常要抛出去处理。2 不处理异常可以抛出去，简化代码
			if( tran !=null )
				tran.rollback();
			throw he;
		}*/finally{
			if( session != null )
				session.close();
		}
	}
	
	/**
	 *  hibernate操作标准模板
	 * @param clazz
	 * @param id
	 * @return
	 */
	public static Object get(Class clazz, Serializable id){
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateXmlCfgContext.getSession();
			
			Object obj = session.get(clazz, id);
			//333持久状态对象
			return obj;
		}/*catch(HibernateException he){  // 1 有异常要抛出去处理。2 不处理异常可以抛出去，简化代码
			if( tran !=null )
				tran.rollback();
			throw he;
		}*/finally{
			if( session != null )
				session.close();
		}
	}
	
	
}
