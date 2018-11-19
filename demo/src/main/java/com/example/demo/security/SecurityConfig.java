package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.demo.service.UserAuthDetailsServices;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled=true)
// @formatter:off
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// Define your users and their roles here
	@Autowired
	private UserAuthDetailsServices userDetailsService;	
	
	@Autowired
	private SalesOrderAuthenticationEntryPoint salesOrderAuthenticationEntryPoint;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().and()
		    .authorizeRequests()
		  	.antMatchers("/").hasAnyRole("ADMIN","USER")
			.and().httpBasic().realmName("Topic security application Realm")
			.authenticationEntryPoint(salesOrderAuthenticationEntryPoint);
	} 

	// Define which paths are accessible to which roles here
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
       auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
}
// @formatter: on