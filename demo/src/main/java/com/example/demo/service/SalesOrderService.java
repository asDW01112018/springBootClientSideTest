package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.SalesOrderModel;
import com.example.demo.repository.SalesOrderReposoitry;

@Service
public class SalesOrderService {
	@Autowired
	private SalesOrderReposoitry salesOrderRepository;

	public SalesOrderModel create(String orderId, String customerName, String date, String place) {
		return salesOrderRepository.save(new SalesOrderModel(orderId, customerName, date, place));
	}

	public SalesOrderModel update(String orderId, String customerName, String date, String place) {
		SalesOrderModel SOM = salesOrderRepository.findByOrderId(orderId);
		SOM.setOrderId(orderId);
		SOM.setCustomerName(customerName);
		SOM.setDate(date);
		SOM.setPlace(place);
		return salesOrderRepository.save(SOM);
	}

	public List<SalesOrderModel> retrive() {
		return salesOrderRepository.findAll();
	}

	public SalesOrderModel retrive(String orderId) {
		return salesOrderRepository.findByOrderId(orderId);
	}

	public void delete(String orderId) {
		SalesOrderModel SOM = salesOrderRepository.findByOrderId(orderId);
		salesOrderRepository.delete(SOM);
	}
}
