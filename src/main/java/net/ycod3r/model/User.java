package net.ycod3r.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {

	@Id
	private String username;
	private String email;
	private String password;
	private Boolean enabled;
	
	@ManyToOne
	private Role role;
	
	public User(){}

	public User(String username, String password, Role role, boolean enabled) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
