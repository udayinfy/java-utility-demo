package com.hibernate.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.domain.Department;
import com.hibernate.domain.Employee;
import com.hibernate.util.HibernateUtil;

public class One2ManyTest {
	
	public static void main(String[] args) {
		
//		add();
		
//		query();
		
//		queryAndRemove();
		
		queyrCasadeByHqlAndUpdate();
		
	}
	
	public static void queyrCasadeByHqlAndUpdate(){
		
		Session session = null;
		Transaction tran = null;
		try{
			
			session = HibernateUtil.getSeesion();
			tran = session.beginTransaction();
			
			String hql = "select emps from Department dept join dept.emps emps where dept.id=1 and emps.id=3";
			Query query = session.createQuery(hql);
			
			List<Employee> list = query.list();
			
			for (Iterator<Employee> it = list.iterator(); it.hasNext();) {
				Employee emp = it.next();
				emp.setName("updated" + emp.getName());
				session.update(emp);
			}
			
			System.out.println(list.size());
			
			tran.commit();
		}finally{
			if( session != null )
				session.close();
		}
	}
	
	public static void queryAndRemove(){
		
		int deptId = 1;
		Employee emp = new Employee();
		emp.setId(2);
		
		Session session = null;
		Transaction tran = null;
		try{
			
			session = HibernateUtil.getSeesion();
			tran = session.beginTransaction();
			
			Department dept = (Department) session.get(Department.class, deptId);
			
			Set<Employee> emps = dept.getEmps();
			emps.remove(emp);

			session.update(dept);
			
			tran.commit();
		}finally{
			if( session != null )
				session.close();
		}
	}
	
	/**
	 * 插入级联关系的部门和员工
	 */
	public static void add(){
		Session session = null;
		Transaction tran = null;
		try{
			Department dept = new Department();
			dept.setName("dept");
			
			// 告诉员工是什么部门的
			Employee emp = new Employee();
			emp.setDept(dept);
			emp.setName("emp");
			Employee emp2 = new Employee();
			emp2.setName("emp2");
			emp2.setDept(dept);
			
			// 告诉本门那些员工是部门的
//			Set<Employee> emps = new HashSet<Employee>();
//			emps.add(emp);
//			emps.add(emp2);
//			dept.setEmps(emps);
			
			session = HibernateUtil.getSeesion();
			tran = session.beginTransaction();

			session.save(dept);
			session.save(emp);
			session.save(emp2);
			
			tran.commit();
		}finally{
			if( session != null )
				session.close();
		}
	}
	
	/**
	 * 查询
	 * @param deptId
	 * @return
	 */
	public static Department query(){
		
		int deptId = 1;
		
		Session session = null;
		try{
			
			session = HibernateUtil.getSeesion();
			
			Department dept = (Department) session.get(Department.class, deptId);
			
			System.out.println(dept.getEmps().size());
			
			return dept;
			
		}finally{
			if( session != null )
				session.close();
		}
	}

}
