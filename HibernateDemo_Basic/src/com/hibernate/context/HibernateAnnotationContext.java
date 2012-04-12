package com.hibernate.context;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * hibernate������
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
		Session session = getSession();
		System.out.println(session);
	}
	
}
