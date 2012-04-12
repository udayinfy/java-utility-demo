package com.hibernate.context;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * hibernate工具类
 * @author Admin
 *
 */
public final class HibernateAnnotationContext {
	private static SessionFactory sessionFactory;

	private HibernateAnnotationContext(){}
	
	static {
		AnnotationConfiguration annotationCfg = new AnnotationConfiguration();
		annotationCfg.configure();
		sessionFactory = annotationCfg.buildSessionFactory();
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
