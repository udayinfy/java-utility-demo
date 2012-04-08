package mybatis.dao;

import java.util.List;

import mybatis.dao.bean.Person;

public interface IPersonDao {

	public void addPerson(Person person);
	
	public void deletePerson(Person person);
	public void deletePersonById(int id);
	
	public void updatePerson(Person person);
	
	public List<Person> queryPersonByName(String name);
	public Person queryPersonById(String id);
	
	
	
}
