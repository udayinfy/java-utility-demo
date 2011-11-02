package org.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisDemo {
	
	public static void main(String[] args) {

		String resource = "Configuration.xml";
		Reader reader = null;
		SqlSession sqlSession = null;
		SqlSessionFactory sqlMapperFactory = null;
		
		// 1. ��XML�й���SqlSessionFactory
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlMapperFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		while( true ) {
		
			try {
				
				long timeStart = new java.util.Date().getTime();
				
				// 2. ��SqlSessionFactory�л�ȡSqlSession
				sqlSession = sqlMapperFactory.openSession();
				
				// add
				Product product = new Product();
	//			product.setPid(99);
				product.setPcode(1123);
				product.setPname("�ɱȿ�");
				product.setPdate( new java.util.Date() );
				
				sqlSession.insert("ProductMapper.addProduct", product);
				
				sqlSession.commit();
				
				long timeEnd = new java.util.Date().getTime();
				System.out.println( "Time Eclipsed---->" + ( timeEnd - timeStart ) );
				
				// select
	//			Product product = (Product) sqlSession.selectOne("ProductMapper.queryProductById", 1);
	//			System.out.println( "------------>" + product );
				
				// parameter is a list
//				List list = new ArrayList();
//				list.add(41);  list.add(43);
//				
//				List pnameList = sqlSession.selectList("ProductMapper.getSomePnameById", list);
//				
//				System.out.println("-------------------->" + pnameList);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

	
	}
	
}
