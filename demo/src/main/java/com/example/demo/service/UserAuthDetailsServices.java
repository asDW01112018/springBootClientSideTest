package com.example.demo.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.UserAuthDetails;
import com.example.demo.repository.UserAuthDetailsReposoitry;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserAuthDetailsServices implements UserDetailsService {
	
	@Autowired
	private UserAuthDetailsReposoitry userAuthDetailsRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserAuthDetails UAD = userAuthDetailsRepository.findByUserName(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(UAD.getRole());
		User user = new User(UAD.getUserName(),UAD.getPassword(),Arrays.asList(authority));
		UserDetails userDetails = (UserDetails)user;
		return userDetails;
	}

}
