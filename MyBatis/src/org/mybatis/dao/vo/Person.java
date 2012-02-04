package org.mybatis.dao.vo;

import java.util.Date;

public class Person {

	private int pid;
	private String pname;
	private int age;
	private Date birthday;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String toString() {
		return "pid:" + pid + "    pname:" + pname + "    age:" + age
				+ "    birthday:" + birthday;
	}

}
