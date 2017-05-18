package net.ycod3r.configuration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import net.ycod3r.model.Role;
import net.ycod3r.model.User;
import net.ycod3r.service.RoleService;
import net.ycod3r.service.UserService;

@Component
public class DBInitJob implements CommandLineRunner {

	@Autowired
	private UserService userSvc;

	@Autowired
	private RoleService roleSvc;

	@Override
	public void run(String... arg0) throws Exception {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		Role userRole = new Role("ROLE_USER");
		Role adminRole = new Role("ROLE_ADMIN");
		if (roleSvc.count() == 0)
			roleSvc.save(Arrays.asList(userRole, adminRole));
		System.out.println("------------- Roles créés!! ----------------------");

		User user = new User("user", passwordEncoder.encode("@llianz"), userRole, true);
		User admin = new User("admin", passwordEncoder.encode("@llianz"), adminRole, true);
		if (userSvc.count() == 0)
			userSvc.save(Arrays.asList(user, admin));
		System.out.println("------------- Users créés!! ----------------------");
	}

}
