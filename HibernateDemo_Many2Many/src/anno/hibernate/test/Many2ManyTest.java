package anno.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import xml.hibernate.domain.Teather;

import common.hibernate.HibernateUtil;

public class Many2ManyTest {
	
	public static void main(String[] args) {
		
		add();
		
	}
	
	/**
	 * ��Զ������������
	 */
	public static void add(){
		Session session = null;
		Transaction tx = null;
		try {
			
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			
			
			
			tx.commit();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	/**
	 * ��Զ������ѯ����
	 * @param id
	 * @return
	 */
	public static Teather query(int id) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			
			
			
			return null;
		} finally {
			if (session != null)
				session.close();
		}
	}

}
