package anno.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import anno.hibernate.domain.Student;
import anno.hibernate.domain.Teather;

import common.hibernate.HibernateUtil;
import common.hibernate.UUIDUtil;

public class Many2ManyTest {
	
	public static void main(String[] args) {
		
		add2();
		
	}
	
	/**
	 * 多对多关联插入数据
	 */
	public static void add(){
		
		Session session = null;
		Transaction tx = null;
		try {
			
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			
			Student stu1 = new Student();
			stu1.setId(UUIDUtil.generateUUID());
			stu1.setName("Student1");
			
			Student stu2 = new Student();
			stu2.setId(UUIDUtil.generateUUID());
			stu2.setName("Student2");
			
			Set<Student> students = new HashSet<Student>();
			students.add(stu1);
			students.add(stu2);
			
			Teather teather = new Teather();
			teather.setId(UUIDUtil.generateUUID());
			teather.setName("Teather1");
			teather.setStudents(students);
			
			session.save(teather);
			
			tx.commit();
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public static void add2(){

		Session session = null;
		Transaction tx = null;
		try {
			
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			
			Student stu1 = (Student) session.get(Student.class, 155915806);
			stu1.setName("new name");
			Student stu2 = (Student) session.get(Student.class, 1694623429);
			
			Set<Student> students = new HashSet<Student>();
			students.add(stu1);
			students.add(stu2);
			
			Teather teather = (Teather) session.get(Teather.class, 141846886);
			
			session.save(teather);
			
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
			
			
			
			return null;
		} finally {
			if (session != null)
				session.close();
		}
	}

}
