package net.ycod3r.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired 
	private BCryptPasswordEncoder passwordEncoder;
	

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	//	auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN")
	//	.and().withUser("user").password("user").roles("USER");
		
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username,password,enabled from user where username=?")
		.authoritiesByUsernameQuery("select username, r.name from user u inner join role r on u.role_id=r.id where username=?")
		.passwordEncoder(passwordEncoder);
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/")
		.authenticated()
		.antMatchers("/departements/**","/employees/**")
		.hasRole("ADMIN")
		.anyRequest().permitAll()
		.and()
		.formLogin().loginPage("/login")
		.and()
		.logout().logoutSuccessUrl("/login?logout")
		.and()
		.exceptionHandling().accessDeniedPage("/403");
	}

}
