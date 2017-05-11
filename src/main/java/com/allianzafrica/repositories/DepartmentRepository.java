package com.allianzafrica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allianzafrica.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
