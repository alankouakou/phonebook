package net.ycod3r.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ycod3r.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
