package xml.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import xml.hibernate.domain.Student;
import xml.hibernate.domain.Teather;

import common.hibernate.HibernateUtil;

public class Many2ManyTest {
	
	public static void main(String[] args) {
		
		add();
		
//		query(1);
		
	}
	
	/**
	 * 多对多关联插入数据
	 */
	public static void add(){
		Session session = null;
		Transaction tx = null;
		try {
			
			Teather teather1 = new Teather();
			teather1.setName("Teather1");
			Teather teather2 = new Teather();
			teather2.setName("Teather2");
			Set<Teather> thSet = new HashSet<Teather>();
			thSet.add(teather1);
			thSet.add(teather2);
			
			Student student1 = new Student();
			student1.setName("Student1");
			Student student2 = new Student();
			student2.setName("Student2");
			Set<Student> stuSet = new HashSet<Student>();
			stuSet.add(student1);
			stuSet.add(student2);
			
			teather1.setStudents(stuSet);
			teather2.setStudents(stuSet);
			
//			student1.setTeathers(thSet);
//			student2.setTeathers(thSet);
			
			
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			
			session.save(teather1);
			session.save(teather2);
			
			session.save(student1);
			session.save(student2);
			
			tx.commit();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	/**
	 * 多对多关联查询数据
	 * @param id
	 * @return
	 */
	public static Teather query(int id) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			
			Teather teather = (Teather) session.get(Teather.class, id);
			
			System.out.println(teather.getStudents().size());
			
			return null;
		} finally {
			if (session != null)
				session.close();
		}
	}

}
