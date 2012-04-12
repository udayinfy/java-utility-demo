package com.hibernate.context;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate工具类
 * @author Admin
 *
 */
public final class HibernateXmlCfgContext {
	private static SessionFactory sessionFactory;

	private HibernateXmlCfgContext(){}
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure();
		sessionFactory = cfg.buildSessionFactory();
	}

	/**
	 * 获取SessoinFactory
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/**
	 * 获取Session
	 * @return
	 */
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	
	public static void main(String[] args) {
		Session session = getSession();
		System.out.println(session);
	}
	
}
