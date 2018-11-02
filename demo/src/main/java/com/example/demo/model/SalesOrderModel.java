package com.example.demo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "abc")
public class SalesOrderModel {

	@Id
	String id;
	String orderId;
	String customerName;
	String date;
	String place;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public SalesOrderModel(String id, String customerName, String date, String place) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.date = date;
		this.place = place;
	}
	@Override
	public String toString() {
		return "SalesOrderModel [id=" + id + ", customerName=" + customerName + ", date=" + date + ", place=" + place
				+ "]";
	}
}
