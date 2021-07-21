package com.capgemini.onlinevehiclelicense.model;

public class Challan {
	String challanNumber;
	String vehicleNumber;
	Double amount;
	public Challan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Challan(String challanNumber, String vehicleNumber, Double amount) {
		super();
		this.challanNumber = challanNumber;
		this.vehicleNumber = vehicleNumber;
		this.amount = amount;
	}
	public String getChallanNumber() {
		return challanNumber;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public Double getAmount() {
		return amount;
	}
}
