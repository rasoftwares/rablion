package com.ra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	
	//@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("robin").password("password").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("password").roles("USER");
		auth.inMemoryAuthentication().withUser("rablion").password("password").roles("USER");
	}
	
	//@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.logout();
		http.authorizeRequests()
			.antMatchers("/**").authenticated()
			.and().formLogin();
			
	}
	
	

}
