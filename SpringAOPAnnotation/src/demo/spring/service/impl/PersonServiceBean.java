package demo.spring.service.impl;

import demo.spring.service.PersonService;

public class PersonServiceBean implements PersonService {
	
	private String user;

	public String getPersonName(Integer id) {
		System.out.println("我是getPersonName()方法");
		return "xxx";
	}

	public void save(String name) {
		throw new RuntimeException("我爱例外");
		//System.out.println("我是save()方法");
	}

	public void update(String name, Integer id) {
		System.out.println("我是update()方法");
	}

	public String getUser() {
		return user;
	}

}
