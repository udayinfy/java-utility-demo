package com.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.domain.Department;
import com.hibernate.domain.Employee;
import com.hibernate.util.HibernateUtil;

public class One2ManyTest {
	
	public static void main(String[] args) {
		
//		add();
		
		query(8);
		
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
	public static Department query(int deptId){
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
