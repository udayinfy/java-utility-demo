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
import org.mybatis.dao.factory.SessionFactory;
import org.mybatis.dao.vo.Person;

public class PersonDaoImpl implements IPersonDao {

	@Override
	public void addPerson(Person person) {

		SqlSession sqlSession = SessionFactory.getSqlSession();

		sqlSession.insert("PersonMapper.addPerson");

		sqlSession.commit();

		sqlSession.close();

	}

	@Override
	public void deletePersonById(int id) {

		SqlSession sqlSession = SessionFactory.getSqlSession();

		sqlSession.delete("PersonMapper.deletePersonById", id);

		sqlSession.commit();

		sqlSession.close();

	}

	@Override
	public void deletePerson(Person person) {

		SqlSession sqlSession = SessionFactory.getSqlSession();

		sqlSession.delete("PersonMapper.deletePersonById", person);

		sqlSession.commit();

		sqlSession.close();
	}

	@Override
	public void updatePerson(Person person) {

		SqlSession sqlSession = SessionFactory.getSqlSession();

		sqlSession.update("PersonMapper.updatePerson", person);

		sqlSession.commit();

		sqlSession.close();
	}

	@Override
	public List<Person> queryPersonByName(String name) {

		SqlSession sqlSession = SessionFactory.getSqlSession();

		@SuppressWarnings("unchecked")
		List<Person> personList = (List<Person>) sqlSession.selectList("PersonMapper.queryPersonByName", name);

		sqlSession.close();

		return personList;
	}

	@Override
	public Person queryPersonById(String id) {

		SqlSession sqlSession = SessionFactory.getSqlSession();

		Person person = (Person) sqlSession.selectOne("PersonMapper.queryPersonById", id);

		sqlSession.close();

		return person;
	}

}
