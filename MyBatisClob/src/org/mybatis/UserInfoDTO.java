package org.mybatis;

public class UserInfoDTO {
	
	private int id;
	private String name;
	private int age;
	private java.sql.Timestamp birthday;
	private String memo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public java.sql.Timestamp getBirthday() {
		return birthday;
	}
	public void setBirthday(java.sql.Timestamp birthday) {
		this.birthday = birthday;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
