package org.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	private static String resource = "Configuration.xml";
	private static SqlSessionFactory sqlSessionFactory = null;

	static {
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSqlSession() {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		return sqlSession;
	}

}
