package org.mybatis.dao.impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.dao.IPersonDao;
import org.mybatis.dao.vo.Person;

public class PersonDaoImpl implements IPersonDao {
	
	private static String resource = "Configuration.xml";
	private static SqlSessionFactory sqlMapperFactory = null;
	
	static {
		
		try {
			// 从XML中构建SqlSessionFactory
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapperFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public SqlSession getSqlSession() {
		
		// 从SqlSessionFactory中获取SqlSession
		SqlSession sqlSession = sqlMapperFactory.openSession();
		
		return sqlSession;
		
	}

	@Override
	public void addPerson(Person person) {

		SqlSession sqlSession = this.getSqlSession();

		sqlSession.insert("PersonMapper.addPerson");
		
		sqlSession.commit();

		sqlSession.close();

	}

	@Override
	public void deletePersonById(int id) {

		SqlSession sqlSession = this.getSqlSession();

		sqlSession.delete("PersonMapper.deletePersonById", id);

		sqlSession.commit();

		sqlSession.close();

	}

	@Override
	public void deletePerson(Person person) {

		SqlSession sqlSession = this.getSqlSession();

		sqlSession.delete("PersonMapper.deletePersonById", person);

		sqlSession.commit();

		sqlSession.close();
	}

	@Override
	public void updatePerson(Person person) {
		
		SqlSession sqlSession = this.getSqlSession();

		sqlSession.update("PersonMapper.updatePerson", person);

		sqlSession.commit();

		sqlSession.close();
	}

	@Override
	public List<Person> queryPersonByName(String name) {

		SqlSession sqlSession = this.getSqlSession();

		@SuppressWarnings("unchecked")
		List<Person> personList = (List<Person>) sqlSession.selectList(
				"PersonMapper.queryPersonByName", name);

		sqlSession.close();

		return personList;
	}

	@Override
	public Person queryPersonById(String id) {

		SqlSession sqlSession = this.getSqlSession();

		Person person = (Person) sqlSession.selectOne(
				"PersonMapper.queryPersonById", id);

		sqlSession.close();

		return person;
	}


}
