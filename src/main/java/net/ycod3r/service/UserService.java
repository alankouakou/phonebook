package net.ycod3r.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ycod3r.model.User;
import net.ycod3r.repositories.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public void save(Collection<User> users){
		userRepo.save(users);
	}

	public long count() {
		// TODO Auto-generated method stub
		return userRepo.count();
	}
}
