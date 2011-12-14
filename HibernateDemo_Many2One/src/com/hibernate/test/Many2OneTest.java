package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.domain.Department;
import com.hibernate.domain.Employee;
import com.hibernate.util.HibernateUtil;

public class Many2OneTest {
	
	public static void main(String[] args) {
		
		add();
		
		query(1);
		
	}
	
	/**
	 * 插入级联关系的部门和员工
	 */
	public static void add(){
		Session session = null;
		Transaction tran = null;
		try{
			
			Department depart = new Department();
			depart.setName("depatName");
			
			Employee employee = new Employee();
			employee.setName("employeeName");
			employee.setDepart(depart);
			
			session = HibernateUtil.getSeesion();
			tran = session.beginTransaction();

			session.save(depart);
			session.save(employee);
			
			tran.commit();
		}finally{
			if( session != null )
				session.close();
		}
	}
	
	/**
	 * 查询
	 * @param empId
	 * @return
	 */
	public static Employee query(int empId){
		Session session = null;
		try{
			
			session = HibernateUtil.getSeesion();
			
			Employee emp = (Employee) session.get(Employee.class, empId);
			
			System.out.println(emp.getDepart().getName());
			
			return emp;
			
		}finally{
			if( session != null )
				session.close();
		}
	}

}
