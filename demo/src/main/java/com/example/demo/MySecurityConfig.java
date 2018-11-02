//package com.example.demo;

/*import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
//@formatter:off
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
  //Define your users and their roles here
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    auth
      .inMemoryAuthentication()
      .passwordEncoder(encoder)
      .withUser("admin")
        .password(encoder.encode("admin111"))
        .roles("ADMIN");
  }
  //Define which paths are accessible to which roles here
  protected void configure(HttpSecurity http) throws Exception {
    http
      .formLogin()
        .and()
      .authorizeRequests()
        .antMatchers("/**")
        .hasRole("ADMIN");
  }
}
// @formatter: on
*/