package net.ycod3r.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.ycod3r.model.Department;
import net.ycod3r.repositories.DepartmentRepository;
import net.ycod3r.repositories.EmployeeRepository;

@Service
public class GroupService {
	
	@Autowired
	private DepartmentRepository deptRepository;
	
	@Autowired
	private EmployeeRepository empRepository;

	public long count() {
		return deptRepository.count();
	}
	
	
	public void delete(Long id){
		Department dept = deptRepository.findOne(id);
				
		if(empRepository.countByDepartement(dept) == 0){
			deptRepository.delete(id);
		}
	}

	public void deleteAll() {
		deptRepository.deleteAll();
	}

	public List<Department> findAll() {
		return deptRepository.findAll();
	}

	public Page<Department> findAll(Pageable arg0) {
		return deptRepository.findAll(arg0);
	}

	public List<Department> findAll(Sort arg0) {
		return deptRepository.findAll(arg0);
	}

	public <S extends Department> S save(S arg0) {
		return deptRepository.save(arg0);
	}

	public Department findOne(long parseLong) {
		return deptRepository.findOne(parseLong);
	}

	
}
