package anno.hibernate.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT", schema="ZHC" )
public class Student implements Serializable{
	
	private static final long serialVersionUID = 2854542003097193915L;
	
	private int id;
	private String name;
	private Set<Teather> teathers;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="NAME", length=255)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@ManyToMany(targetEntity=Teather.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="students")
	public Set<Teather> getTeathers() {
		return teathers;
	}
	public void setTeathers(Set<Teather> teathers) {
		this.teathers = teathers;
	}
	
	

}
