package com.hibernate.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.context.HibernateXmlCfgContext;

/**
 * 更通用的写法
 * @author Admin
 *
 */
public class UserTest2 {
	
	
	public static void main(String[] args) {
		
		
		
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
