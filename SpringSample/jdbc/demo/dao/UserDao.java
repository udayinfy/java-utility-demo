package demo.dao;

import java.util.List;

import demo.model.User;

public interface UserDao {
	
	public void createTable();
	
	public void insertData();
	
	public void deleteData();
	
	public void updateData();
	
	public List<User> queryList();
	
	public User queryById(String id);

}
