package dynamicproxy.service.impl;

import dynamicproxy.service.PersonService;

public class PersonServiceBean implements PersonService{
	private String user = null;
	
	public String getUser() {
		return user;
	}

	public PersonServiceBean(){}
	
	public PersonServiceBean(String user){
		this.user = user;
	}

	public String getPersonName(Integer personid) {
		System.out.println("我是getPersonName()方法");
		return "xxx";
	}

	public void save(String name) {
		System.out.println("我是save()方法");
	}

	public void update(String name, Integer personid) {
		System.out.println("我是update()方法");
	}

}
