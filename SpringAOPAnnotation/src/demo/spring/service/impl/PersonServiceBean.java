package demo.spring.service.impl;

import demo.spring.service.PersonService;

public class PersonServiceBean implements PersonService {
	
	private String user;

	public String getPersonName(Integer id) {
		System.out.println("����getPersonName()����");
		return "xxx";
	}

	public void save(String name) {
		throw new RuntimeException("�Ұ�����");
		//System.out.println("����save()����");
	}

	public void update(String name, Integer id) {
		System.out.println("����update()����");
	}

	public String getUser() {
		return user;
	}

}
