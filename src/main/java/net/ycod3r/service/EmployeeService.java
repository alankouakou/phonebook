package net.ycod3r.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import net.ycod3r.model.Department;
import net.ycod3r.model.Employee;
import net.ycod3r.repositories.DepartmentRepository;
import net.ycod3r.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	//@Autowired
	//private DepartmentRepository departmentRepository;

	public void delete(Employee arg0) {
		empRepository.delete(arg0);
	}

	public void delete(Long arg0) {
		empRepository.delete(arg0);
	}

	public List<Employee> findAll() {
		return empRepository.findAll(new Sort(Direction.ASC,"nom"));
	}

	public <S extends Employee> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		return empRepository.findAll(arg0, arg1);
	}

	public <S extends Employee> List<S> findAll(Example<S> arg0, Sort arg1) {
		return empRepository.findAll(arg0, arg1);
	}

	public Page<Employee> findAll(Pageable arg0) {
		return empRepository.findAll(arg0);
	}

	public List<Employee> findAll(Sort arg0) {
		return empRepository.findAll(arg0);
	}

	public Employee findOne(Long arg0) {
		return empRepository.findOne(arg0);
	}

	public <S extends Employee> List<S> save(Iterable<S> arg0) {
		return empRepository.save(arg0);
	}

	public <S extends Employee> S save(S emp) {
		return empRepository.save(emp);
	}
	
	public Long count(){
		return empRepository.count();
	}
	
	@PostConstruct
	private void initData(){

		Department dsi = new Department("Informatique");
		Department bancassurance = new Department("Bancassurance");
		Department directionGenerale = new Department("Direction Générale");

		Department risque = new Department("Conformité");
		
		List<Department> departements = Arrays.asList(risque,dsi,bancassurance,directionGenerale);
		

		Employee emp0 = new Employee("alan","kouakou","4232","09007718");
		Employee emp1 = new Employee("ambroise","azoukou","4233","09056600");
		Employee emp2 = new Employee("patrick","essama","4231","87872597");
		
		Employee emp3 = new Employee("pascal","pelerin","4230","79791978");
		
		Employee emp4 = new Employee("jean philippe","boni","4200","88397447");
		Employee emp5 = new Employee("kouda","kaba","4235","77872287");
		Employee emp6 = new Employee("mathias","attiegoua","4236","04510510");
		Employee emp7 = new Employee("irène", "foua","","48233866");
		Employee emp8 = new Employee("anicet","dobé","","57403097");
		Employee emp9 = new Employee("karamoko","touré","","48732990");
		Employee emp10= new Employee("noël","blague","","08494836");
		Employee emp11= new Employee("edmond","adon","","07930669");
		Employee emp12= new Employee("yvan","nguewo","","58333816");
		Employee emp13 = new Employee("désiré","blé","","59327725");
		
		Employee emp14 = new Employee("jean-yves","allou","","08160965");
		
		Employee emp99 = new Employee("Benjamin","DELEMASURE","","89912685");
		
		List<Employee> informaticiens = Arrays.asList(emp0,emp1,emp2,emp3,emp4,emp5,emp6,emp7,emp8,emp9,emp10,emp11,emp12,emp13,emp14);
		
		
		dsi.setEmployees(informaticiens);
		departmentRepository.save(departements);
		
		//empRepository.save(informaticiens);
	}

}
