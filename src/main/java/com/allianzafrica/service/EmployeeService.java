package com.allianzafrica.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.allianzafrica.model.Employee;
import com.allianzafrica.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;
	
	//@Autowired
	//private DepartmentRepository departmentRepository;

	public void delete(Employee arg0) {
		empRepository.delete(arg0);
	}

	public void delete(Long arg0) {
		empRepository.delete(arg0);
	}

	public List<Employee> findAll() {
		return empRepository.findAll();
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
		// On rajoute simplement la racine (20 00)
		emp.setNumeroLong("2020"+emp.getNumeroCourt());
		return empRepository.save(emp);
	}
	
	@PostConstruct
	private void initData(){
/*
		Department dsi = new Department("DSI");
		Department bancassurance = new Department("Bancassurance");
		Department directionGenerale = new Department("Direction Générale");

		Department risque = new Department("Risques/Prévention");
		departmentRepository.save(risque);
		
		List<Department> departements = Arrays.asList(dsi,bancassurance,directionGenerale);
		
		departmentRepository.save(departements);

		Employee emp0 = new Employee("Alan","KOUAKOU","21002189","2189","09007718");
		Employee emp1 = new Employee("Ambroise","AZOUKOU","21002190","2190","07654876");
		Employee emp2 = new Employee("Patrick","ESSAMA","21002188","2188","87872597");
		
		Employee emp3 = new Employee("Benjamin","DELEMASURE","20002410","2410","89912685");
		
		
		emp0.setDepartement(dsi);
		emp1.setDepartement(dsi);
		emp2.setDepartement(dsi);
		emp3.setDepartement(directionGenerale);
		
		List<Employee> employees = Arrays.asList(emp0,emp1,emp2,emp3);
		empRepository.save(employees);
		*/
	}

}
