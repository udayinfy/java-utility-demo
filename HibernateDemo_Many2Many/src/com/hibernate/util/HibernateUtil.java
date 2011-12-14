package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate������
 * @author Admin
 *
 */
public final class HibernateUtil {
	private static SessionFactory sessionFactory;

	private HibernateUtil(){}
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure();
		sessionFactory = cfg.buildSessionFactory();
	}

	/**
	 * ��ȡSessoinFactory
	 * @return
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/**
	 * ��ȡSession
	 * @return
	 */
	public static Session getSession(){
		return sessionFactory.openSession();
	}
	
	
	public static void main(String[] args) {
//		getSeesion();
		System.out.println("aaaaaaaaaaaaaaa");
	}
	
}
