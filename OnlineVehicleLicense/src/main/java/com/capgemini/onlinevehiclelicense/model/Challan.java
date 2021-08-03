package com.capgemini.onlinevehiclelicense.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "applicant_id", nullable = false)
	private Applicant applicant;
	
	public Challan() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param challanNumber
	 * @param vehicleNumber
	 * @param amount
	 * @param status
	 */
	public Challan(@NotEmpty(message = "challan Number should not be empty") String challanNumber,
			@NotEmpty(message = "vehicle number should not be empty") String vehicleNumber,
			@NotEmpty(message = "amount should not be empty") Double amount, String status) {
		super();
		this.challanNumber = challanNumber;
		this.vehicleNumber = vehicleNumber;
		this.amount = amount;
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((challanNumber == null) ? 0 : challanNumber.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((vehicleNumber == null) ? 0 : vehicleNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Challan other = (Challan) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (challanNumber == null) {
			if (other.challanNumber != null)
				return false;
		} else if (!challanNumber.equals(other.challanNumber))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (vehicleNumber == null) {
			if (other.vehicleNumber != null)
				return false;
		} else if (!vehicleNumber.equals(other.vehicleNumber))
			return false;
		return true;
	}

	/**
	 * @return the challanNumber
	 */
	public String getChallanNumber() {
		return challanNumber;
	}

	/**
	 * @param challanNumber the challanNumber to set
	 */
	public void setChallanNumber(String challanNumber) {
		this.challanNumber = challanNumber;
	}

	/**
	 * @return the vehicleNumber
	 */
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	/**
	 * @param vehicleNumber the vehicleNumber to set
	 */
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
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


	@Override
	public String toString() {
		return "Challan [challanNumber=" + challanNumber + ", vehicleNumber=" + vehicleNumber + ", amount=" + amount
				+ ", status=" + status + "]";
	}
	
}
