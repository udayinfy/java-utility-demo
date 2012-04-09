package mybatis.dao.impl;

import java.util.List;

import mybatis.dao.IPersonDao;
import mybatis.dao.bean.Person;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class PersonDaoImpl extends SqlSessionDaoSupport implements IPersonDao {

	@Override
	public void addPerson(Person person) {

		getSqlSession().insert("PersonMapper.addPerson", person);
		
		getSqlSession().insert("PersonMapper.addPerson", person);
		
		throw new RuntimeException("这是一个运行时异常。");
		
	}

	@Override
	public void deletePersonById(int id) {

		getSqlSession().delete("PersonMapper.deletePersonById", id);

	}

	@Override
	public void deletePerson(Person person) {

		getSqlSession().delete("PersonMapper.deletePerson", person);
		
	}

	@Override
	public void updatePerson(Person person) {

		getSqlSession().update("PersonMapper.updatePerson", person);
		
	}

	@Override
	public List<Person> queryPersonByName(String name) {

		List<Person> personList = getSqlSession().selectList("PersonMapper.queryPersonByName", name);
		
		return personList;
		
	}

	@Override
	public Person queryPersonById(String id) {

		Person person = (Person) getSqlSession().selectOne("PersonMapper.queryPersonById", id);
		
		return person;
		
	}

}
