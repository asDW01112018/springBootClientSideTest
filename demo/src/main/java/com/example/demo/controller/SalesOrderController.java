package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value = "/request", method = RequestMethod.POST)
	public SalesOrderModel createWithParams(@RequestParam(value = "orderid", defaultValue = "Not Found") String orderId,
			@RequestParam(value = "customerName", defaultValue = "Not Found") String customerName,
			@RequestParam(value = "date", defaultValue = "Not Found") String date,
			@RequestParam(value = "place", defaultValue = "Not Found") String place) {
		return salesOrderService.create(orderId, customerName, date, place);
	}

	@RequestMapping(value = "/request", method = RequestMethod.PUT)
	public SalesOrderModel updateWithParams(@RequestParam(value = "orderId", defaultValue = "Not Found") String orderId,
			@RequestParam(value = "customerName", defaultValue = "Not Found") String customerName,
			@RequestParam(value = "date", defaultValue = "Not Found") String date,
			@RequestParam(value = "place", defaultValue = "Not Found") String place) {
		SalesOrderModel SOM = salesOrderService.update(orderId, customerName, date, place);
		return SOM;
	}

	@RequestMapping(value = "/request", method = RequestMethod.GET)

	public SalesOrderModel retriveWithParams(
			@RequestParam(value = "orderId", defaultValue = "Not Found") String orderId) {
		return salesOrderService.retrive(orderId);
	}

	public List<SalesOrderModel> retriveWithParams() {
		return salesOrderService.retrive();
	}

	@RequestMapping(value = "/request", method = RequestMethod.DELETE)
	public String deleteWithParams(@RequestParam(value = "orderId", defaultValue = "") String orderId) {
		salesOrderService.delete(orderId);
		return "Delete " + orderId;
	}
}
