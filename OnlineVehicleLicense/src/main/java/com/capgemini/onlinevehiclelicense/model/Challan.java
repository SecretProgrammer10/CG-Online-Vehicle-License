package com.capgemini.onlinevehiclelicense.model;

public class Challan {
	private String challanNumber;
	private String vehicleNumber;
	private Double amount;
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
	public void setChallanNumber(String challanNumber) {
		this.challanNumber = challanNumber;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
