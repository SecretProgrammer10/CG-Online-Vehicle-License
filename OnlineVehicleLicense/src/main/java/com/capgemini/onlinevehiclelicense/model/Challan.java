package com.capgemini.onlinevehiclelicense.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "challan")
public class Challan {
	
	@Id
	@Column(name = "challan_number")
	private String challanNumber;
	
	@Column(name = "vehicle_number")
	private String vehicleNumber;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "status")
	private String status;
	
	public Challan() {
		super();
	}
	public Challan(String challanNumber, String vehicleNumber, Double amount, String status) {
		super();
		this.challanNumber = challanNumber;
		this.vehicleNumber = vehicleNumber;
		this.amount = amount;
		this.status = status;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Challan [challanNumber=" + challanNumber + ", vehicleNumber=" + vehicleNumber + ", amount=" + amount
				+ ", status=" + status + "]";
	}
}
