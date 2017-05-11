package net.ycod3r.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ycod3r.model.Department;
import net.ycod3r.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByDepartement(Department dept);

	int countByDepartement(Department dept);

}
