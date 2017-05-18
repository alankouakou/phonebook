package net.ycod3r.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ycod3r.model.Role;
import net.ycod3r.repositories.RoleRepository;

@Service 
@Transactional
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepo;
	
	public void save(Collection<Role> roles){
		roleRepo.save(roles);
	}

	public long count() {
		// TODO Auto-generated method stub
		return roleRepo.count();
	}

}
