package com.allianzafrica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allianzafrica.model.Department;
import com.allianzafrica.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByDepartement(Department dept);

	int countByDepartement(Department dept);

}
