package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SalesOrderModel;

@Repository
public interface SalesOrderReposoitry extends MongoRepository<SalesOrderModel, String>{
	public SalesOrderModel  findByOrderId(int orderId);
}
