package demo.spring.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import demo.spring.bean.Person;
import demo.spring.service.PersonService;

@Transactional
public class PersonServiceBean implements PersonService {
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	// unchecked ,
	// checked
	@Transactional(noRollbackFor=RuntimeException.class)
	public void delete(Integer personid) throws Exception{
		jdbcTemplate.update("delete from person where id=?", new Object[]{personid},
				new int[]{java.sql.Types.INTEGER});
		throw new RuntimeException("运行期例外");
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Person getPerson(Integer personid) {		
		return (Person)jdbcTemplate.queryForObject("select * from person where id=?", new Object[]{personid}, 
				new int[]{java.sql.Types.INTEGER}, new PersonRowMapper());
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Person> getPersons() {
		return (List<Person>)jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	public void save(Person person) {
		jdbcTemplate.update("insert into person(name) values(?)", new Object[]{person.getName()},
				new int[]{java.sql.Types.VARCHAR});
	}

	public void update(Person person) {
		jdbcTemplate.update("update person set name=? where id=?", new Object[]{person.getName(), person.getId()},
				new int[]{java.sql.Types.VARCHAR, java.sql.Types.INTEGER});
	}
}
