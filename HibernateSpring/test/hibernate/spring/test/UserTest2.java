package hibernate.spring.test;

import hibernate.spring.context.HibernateContext;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * ��ͨ�õ�д��
 * @author Admin
 *
 */
public class UserTest2 {
	
	
	public static void main(String[] args) {
		
		
		
	}
	
	
	/**
	 * hibernate������׼ģ��
	 * @param entity
	 */
	public static void add(Object entity){
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateContext.getSession();
			tran = session.beginTransaction();
			
			session.save(entity);
//			session.persist(user);
			//333�־�״̬����
			
			tran.commit();
		}/*catch(HibernateException he){ // 1 ���쳣Ҫ�׳�ȥ����2 �������쳣�����׳�ȥ���򻯴���
			if( tran !=null )
				tran.rollback();
			throw he;
		}*/finally{
			if( session != null )
				session.close();
		}
	}
	
	/**
	 * hibernate������׼ģ��
	 * @param entity
	 */
	public static void update(Object entity){
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateContext.getSession();
			tran = session.beginTransaction();
			
			session.update(entity);
//			session.persist(user);
			//333�־�״̬����
			
			tran.commit();
		}/*catch(HibernateException he){  // 1 ���쳣Ҫ�׳�ȥ����2 �������쳣�����׳�ȥ���򻯴���
			if( tran !=null )
				tran.rollback();
			throw he;
		}*/finally{
			if( session != null )
				session.close();
		}
	}
	
	/**
	 * hibernate������׼ģ��
	 * @param entity
	 */
	public static void delete(Object entity){
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateContext.getSession();
			tran = session.beginTransaction();
			
			session.delete(entity);
//			session.persist(user);
			//333�־�״̬����
			
			tran.commit();
		}/*catch(HibernateException he){  // 1 ���쳣Ҫ�׳�ȥ����2 �������쳣�����׳�ȥ���򻯴���
			if( tran !=null )
				tran.rollback();
			throw he;
		}*/finally{
			if( session != null )
				session.close();
		}
	}
	
	/**
	 *  hibernate������׼ģ��
	 * @param clazz
	 * @param id
	 * @return
	 */
	public static Object get(Class clazz, Serializable id){
		Session session = null;
		Transaction tran = null;
		try{
			session = HibernateContext.getSession();
			
			Object obj = session.get(clazz, id);
			//333�־�״̬����
			return obj;
		}/*catch(HibernateException he){  // 1 ���쳣Ҫ�׳�ȥ����2 �������쳣�����׳�ȥ���򻯴���
			if( tran !=null )
				tran.rollback();
			throw he;
		}*/finally{
			if( session != null )
				session.close();
		}
	}
	
	
}
