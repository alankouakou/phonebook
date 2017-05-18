package net.ycod3r.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ycod3r.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
