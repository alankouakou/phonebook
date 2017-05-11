package net.ycod3r.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ycod3r.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
