package demo.xstream.xstream3;

import java.util.List;

public class Person {
	private String name;
	private String age;
	private Profile profile;
	private List<Address> addList;

	public Person(String name, String age, Profile profile,
			List<Address> addList) {
		this.name = name;
		this.age = age;
		this.profile = profile;
		this.addList = addList;
	}

	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", age='" + age + '\''
				+ ", profile=" + profile + ", addlist=" + addList + '}';
	}
}