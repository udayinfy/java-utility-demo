package org.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisCacheDemo {
	
	public void getEmp(){
		
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			Emp2 emp = (Emp2) sqlSession.selectOne("Emp2Mapper.getOneEmpById", 1);
			System.out.println("emp.getTel()--------------------->" + emp.getTel());
			
			sqlSession.update("Emp2Mapper.updateOneEmpById", 1);
			sqlSession.commit();
			
			Emp2 emp2 = (Emp2) sqlSession.selectOne("Emp2Mapper.getOneEmpById", 1);
			System.out.println("emp2.getTel()--------------------->" + emp2.getTel());
			
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			if( sqlSession!=null )
				sqlSession.close();
		}
		
	}
	
	public void getEmp2(){
		
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			Emp2 emp = (Emp2) sqlSession.selectOne("Emp2Mapper.getOneEmpById", 1);
			System.out.println("emp.getTel()--------------------->" + emp.getTel());
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			if( sqlSession!=null )
				sqlSession.close();
		}
		
	}
	
	public void addEmp(){
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			
			Emp2 emp = new Emp2();
			emp.setEmail("email@email.com");
			emp.setEname("ename");
			emp.setTel("11111111111");
			
			sqlSession.insert("Emp2Mapper.addEmp",emp);
			sqlSession.commit();
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			if( sqlSession!=null )
				sqlSession.close();
		}
	}
	
	@Test
	public void test(){
//		getEmp();
//		addEmp();
		getEmp2();
		getEmp2();
		
	}
	
}
