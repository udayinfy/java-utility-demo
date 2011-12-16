package demo.xstream.xstream1;

public class Person {

	private String name;
	private String gender;
	private String sal;
	private Birthday birthday;

	public Person(String name, String gender, String sal, Birthday birthday) {
		super();
		this.name = name;
		this.gender = gender;
		this.sal = sal;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public Birthday getBirthday() {
		return birthday;
	}

	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}


}
