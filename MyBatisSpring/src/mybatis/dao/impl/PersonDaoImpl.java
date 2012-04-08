package mybatis.dao.impl;

import java.util.List;

import mybatis.dao.IPersonDao;
import mybatis.dao.bean.Person;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PersonDaoImpl extends SqlMapClientDaoSupport implements IPersonDao {

	@Override
	public void addPerson(Person person) {

		getSqlMapClientTemplate().insert("PersonMapper.addPerson", person);

	}

	@Override
	public void deletePersonById(int id) {

		getSqlMapClientTemplate().delete("PersonMapper.deletePersonById", id);

	}

	@Override
	public void deletePerson(Person person) {

		getSqlMapClientTemplate().delete("PersonMapper.deletePerson", person);
		
	}

	@Override
	public void updatePerson(Person person) {

		getSqlMapClientTemplate().update("PersonMapper.updatePerson", person);
		
	}

	@Override
	public List<Person> queryPersonByName(String name) {

		List<Person> personList = (List<Person>)getSqlMapClientTemplate().queryForList("PersonMapper.queryPersonByName", name);
		
		return personList;
		
	}

	@Override
	public Person queryPersonById(String id) {

		Person person = (Person) getSqlMapClientTemplate().queryForObject("PersonMapper.queryPersonById", id);
		
		return person;
		
	}

}
