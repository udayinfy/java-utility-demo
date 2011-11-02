package org.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.dao.impl.PersonDaoImpl;
import org.mybatis.dao.vo.Person;

public class MyBatisDemo {

	public static void main(String[] args) {

		/*String resource = "Configuration.xml";
		Reader reader = null;
		SqlSession sqlSession = null;
		SqlSessionFactory sqlMapperFactory = null;
		try {
			// 1. ��XML�й���SqlSessionFactory
			reader = Resources.getResourceAsReader(resource);
			sqlMapperFactory = new SqlSessionFactoryBuilder().build(reader);
		
			// 2. ��SqlSessionFactory�л�ȡSqlSession
			sqlSession = sqlMapperFactory.openSession();
		
			Person person = (Person) sqlSession.selectOne(
					"org.mybatis.dao.vo.PersonMapper.queryPersonById", 1);
			System.out.println(person);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}*/
		
		PersonDaoImpl impl = new PersonDaoImpl();
//		org.apache.ibatis.type.JdbcType
		
		// add with some problems
//		Person person = new Person();
//		person.setPid(99);
//		person.setPname("��");
//		person.setAge(23);
//		person.setBirthday(Date.valueOf("2009-09-09"));
//		
//		impl.addPerson(person);
		
		 // delete
//		 Person person = new Person();
//		 person.setPid(24);
//		 person.setPname("��");
//		 person.setAge(23);
//		 person.setBirthday(Date.valueOf("2009-09-09"));
//		 
//		 impl.deletePerson(person);
//		 
//		 impl.deletePersonById(23);
		
		// query
//		List<Person> list = impl.queryPersonByName("˫");
//		for (Iterator<Person> iterator = list.iterator(); iterator.hasNext();) {
//			Person person = (Person) iterator.next();
//			System.out.println(person);
//		}
		
//		Person person = impl.queryPersonById("21");
//		System.out.println(person); 
		
//		  update
//		 Person person = new Person();
////		 person.setPid(21);
//		 person.setPname("��˫˫");
//		 person.setAge(23);
////		 person.setBirthday(Date.valueOf("2009-09-09"));
//		 
//		 impl.updatePerson(person);
		


	}

}
