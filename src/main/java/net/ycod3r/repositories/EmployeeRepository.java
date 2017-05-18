package net.ycod3r.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ycod3r.model.Department;
import net.ycod3r.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByDepartement(Department dept);

	int countByDepartement(Department dept);

}
