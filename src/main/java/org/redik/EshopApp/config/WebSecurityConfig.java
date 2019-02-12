package org.redik.EshopApp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource secure_dataSource;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.jdbcAuthentication().dataSource(secure_dataSource)
	        .usersByUsernameQuery("select username, password, enabled"
	            + " from users where username=?")
	        .authoritiesByUsernameQuery("select username, authority "
	            + "from authorities where username=?")
	        .passwordEncoder(new BCryptPasswordEncoder());
	  }
		
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
	    .and()
	    .httpBasic(); // Authenticate users with HTTP basic authentication
	  }
	
}
