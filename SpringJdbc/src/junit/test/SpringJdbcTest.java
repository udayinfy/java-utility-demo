package junit.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.dao.UserDao;
import demo.model.User;

public class SpringJdbcTest {

	@Test
	public void createTable() {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringJdbcContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDAO");
		userDao.createTable();

	}

	@Test
	public void insert() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringJdbcContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDAO");
		userDao.insertData();
	}

	@Test
	public void delete() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringJdbcContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDAO");
		userDao.deleteData();

	}

	@Test
	public void update() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringJdbcContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDAO");
		userDao.updateData();
	}
	
	@Test
	public void queryById(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringJdbcContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDAO");
		User user = userDao.queryById("1");
		System.out.println(user);
	}

	@Test
	public void queryList() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringJdbcContext.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDAO");
		List<User> userList = userDao.queryList();
		System.out.println(userList);
	}

}
