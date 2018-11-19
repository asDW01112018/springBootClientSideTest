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
	@RequestMapping(value = "/requestAdd")
	public SalesOrderModel createWithParams(@RequestParam(value = "orderId") String orderId,
			@RequestParam(value = "customerName", defaultValue = "Not Found") String customerName,
			@RequestParam(value = "date", defaultValue = "Not Found") String date,
			@RequestParam(value = "place", defaultValue = "Not Found") String place) {
		return salesOrderService.create(Integer.parseInt(orderId), customerName, date, place);
	}

	@RequestMapping(value = "/requestUpdate")
	public SalesOrderModel updateWithParams(@RequestParam(value = "orderId") int orderId,
			@RequestParam(value = "customerName", defaultValue = "Not Found") String customerName,
			@RequestParam(value = "date", defaultValue = "Not Found") String date,
			@RequestParam(value = "place", defaultValue = "Not Found") String place) {
		SalesOrderModel SOM = salesOrderService.update(orderId, customerName, date, place);
		return SOM;
	}

	@RequestMapping(value = "/requestAll")
	public List<SalesOrderModel> retriveWithParams() {
		return salesOrderService.retrive();
	}

	@RequestMapping(value = "/request")
	public String deleteWithParams(@RequestParam(value = "orderId") int orderId) {
		salesOrderService.delete(orderId);
		return "Delete " + orderId;
	}
}
