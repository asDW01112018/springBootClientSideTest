package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.SalesOrderModel;
import com.example.demo.repository.SalesOrderReposoitry;
import org.springframework.security.access.annotation.Secured;

@Service
public class SalesOrderService {
	@Autowired
	private SalesOrderReposoitry salesOrderRepository;
	
	@Secured(value = { "ROLE_ADMIN"})
	public SalesOrderModel create(int orderId, String customerName, String date, String place) {
		return salesOrderRepository.save(new SalesOrderModel(orderId,0, customerName, date, place));
	}

	@Secured(value = { "ROLE_ADMIN"})
	public SalesOrderModel update(int orderId, String customerName, String date, String place) {
		SalesOrderModel SOM = salesOrderRepository.findByOrderId(orderId);
		SOM.setOrderId(orderId);
		SOM.setCustomerName(customerName);
		SOM.setDate(date);
		SOM.setPlace(place);
		return salesOrderRepository.save(SOM);
	}
	
	
	@Secured(value = { "ROLE_ADMIN","ROLE_USER" })
	public List<SalesOrderModel> retrive() {
		return salesOrderRepository.findAll();
	}

	@Secured(value = { "ROLE_ADMIN","ROLE_USER" })
	public SalesOrderModel retrive(int orderId) {
		return salesOrderRepository.findByOrderId(orderId);
	}

	@Secured(value = { "ROLE_ADMIN"})
	public void delete(int orderId) {
		SalesOrderModel SOM = salesOrderRepository.findByOrderId(orderId);
		salesOrderRepository.delete(SOM);
	}
}
