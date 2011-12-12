package demo.service.impl;

import demo.service.PersonService;

public class PersonServiceBean implements PersonService {

	public void save(){
		System.out.println("the save method has been invoked.");
	}
}
