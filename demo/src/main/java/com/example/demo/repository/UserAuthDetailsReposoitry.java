package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.UserAuthDetails;

@Repository
@Transactional
public interface UserAuthDetailsReposoitry extends MongoRepository<UserAuthDetails, String> {
	
	public  UserAuthDetails  findByUserName(String userName); 
}
