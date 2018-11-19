package com.example.demo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.transaction.annotation.Transactional;

@Document(collection = "abc")
@Transactional
public class SalesOrderModel {

	@Id
	String id;
	int orderId;
	int edit;
	
	public int getEdit() {
		return edit;
	}
	public void setEdit(int edit) {
		this.edit = edit;
	}
	String customerName;
	String date;
	String place;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
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
	public SalesOrderModel(int orderId,int edit, String customerName, String date, String place) {
		super();
		this.orderId = orderId;
		this.edit=edit;
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
