package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import OrderDetails.orderDetails;

@RestController
public class MyRESTController {

	public orderDetails orderdetails=new orderDetails();
	/**
	 * This returns Hello World string
	 * 
	 * @return
	 */
	@RequestMapping("/create")
	public String createWithParams(@RequestParam(value = "customerName", defaultValue = "Not Found")String customerName,@RequestParam(value = "date", defaultValue = "Not Found")String date,@RequestParam(value = "place", defaultValue = "Not Found")String place) {
		System.out.println("Customer Name"+customerName);
		System.out.println("Date"+date);
		System.out.println("place"+place);
		//create(id,customerName,date,place) return : succesful or unsuccesful  type:boolean
		return "Hello " + customerName + date +place;
	}
	@RequestMapping("/update")
	public String updateWithParams(@RequestParam(value = "customerName", defaultValue = "Not Found")String customerName,@RequestParam(value = "date", defaultValue = "Not Found")String date,@RequestParam(value = "place", defaultValue = "Not Found")String place) {
		//update(id,customerName,date,place) return : succesful or unsuccesful  type:boolean
		return "update " + customerName + date +place;
	}
	@RequestMapping("/retrive")
	public String retriveWithParams(@RequestParam(value = "id", defaultValue = "")int id) {
		//retrive(id) return : row with id type:String  
		return "retrive ";
	}
	@RequestMapping("/delete")
	public String deleteWithParams(@RequestParam(value = "id", defaultValue = "")int id) {
		//delete(id)  return : succesful or unsuccesful  type:boolean
		return "delete";
	}
}
