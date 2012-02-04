package org.mybatis.dao.factory;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {
	
	private static String resource = "configuration.xml";
	private static SqlSessionFactory sqlMapperFactory = null;
	
	static {
		
		try {
			// ��XML�й���SqlSessionFactory
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapperFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static SqlSession getSqlSession() {
		
		// ��SqlSessionFactory�л�ȡSqlSession
		SqlSession sqlSession = sqlMapperFactory.openSession();
		
		return sqlSession;
		
	}

}
