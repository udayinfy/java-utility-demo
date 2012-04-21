package xml.hibernate.domain;

import java.util.Set;

public class Student {
	
	private int id;
	private String name;
	private Set<Teather> teathers;
	
	
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
	public Set<Teather> getTeathers() {
		return teathers;
	}
	public void setTeathers(Set<Teather> teathers) {
		this.teathers = teathers;
	}
	
	

}
