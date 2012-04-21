package anno.hibernate.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TEATHER",schema="ZHC")
public class Teather implements Serializable{
	
	private static final long serialVersionUID = 3596601179091223185L;
	
	private int id;
	private String name;
	private Set<Student> students;
	
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
	@ManyToMany(targetEntity=Student.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name="TEATHER_STUDENT", 
			joinColumns=@JoinColumn(name="TEATHER_ID"),
			inverseJoinColumns=@JoinColumn(name="STUDENT_ID")
	)
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
	
	
	

}
