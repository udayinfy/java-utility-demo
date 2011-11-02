package org.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisClobTest {
	
	public static void main(String[] args) {

		String resource = "Configuration.xml";
		Reader reader = null;
		SqlSession sqlSession = null;
		SqlSessionFactory sqlMapperFactory = null;
		try {
			// 1. 从XML中构建SqlSessionFactory
			reader = Resources.getResourceAsReader(resource);
			sqlMapperFactory = new SqlSessionFactoryBuilder().build(reader);

			// 2. 从SqlSessionFactory中获取SqlSession
			sqlSession = sqlMapperFactory.openSession();
			
			Map map = new HashMap();
			map.put("id", 1);
			sqlSession.update("UserInfoMapper.updateAgeToNull", map);
			
			sqlSession.commit();
			
			sqlSession.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	
	}
	
}
