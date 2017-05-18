package net.ycod3r.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ycod3r.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
