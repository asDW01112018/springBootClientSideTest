package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SalesOrderModel;
import com.example.demo.service.SalesOrderService;

@RestController
public class SalesOrderController {
	@Autowired
	private SalesOrderService salesOrderService;

	/**
	 * This returns Hello World string
	 * 
	 * @return
	 */
	


	@RequestMapping(value = "/requestAll")
	
	public List<SalesOrderModel> retriveWithParams() {
		return salesOrderService.retrive();
	}


}
