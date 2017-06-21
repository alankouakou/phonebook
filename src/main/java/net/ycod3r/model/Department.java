package net.ycod3r.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Department implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Size(min=2,message="Nom trop court (min=3 caractères)")
	private String name;
	
	@OneToMany(mappedBy="departement",cascade=CascadeType.PERSIST)
	private List<Employee> employees;

	
	public Department() {
		super();
	}
	
	

	public Department(String name) {
		super();
		this.name = name;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public List<Employee> getEmployees() {
		return employees;
	}



	public void setEmployees(List<Employee> employees) {
		for(Employee e : employees){
			e.setDepartement(this);
		}
		this.employees = employees;
		
	}

}
