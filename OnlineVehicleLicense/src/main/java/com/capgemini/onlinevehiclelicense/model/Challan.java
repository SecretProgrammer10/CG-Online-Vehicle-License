package com.capgemini.onlinevehiclelicense.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "challan")
public class Challan {
	
	@Id
	@Column(name = "challan_number")
	@NotEmpty(message="challan Number should not be empty")
	private String challanNumber;
	
	@Column(name = "vehicle_number")
	@NotEmpty(message="vehicle number should not be empty")
	private String vehicleNumber;
	
	@Column(name = "amount")
	@NotEmpty(message="amount should not be empty")
	private Double amount;
	
	@Column(name = "status")
	private String status;
	
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
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
