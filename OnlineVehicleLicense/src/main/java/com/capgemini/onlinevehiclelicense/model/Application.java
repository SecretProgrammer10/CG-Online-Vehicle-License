package com.capgemini.onlinevehiclelicense.model;

import java.util.Date;

public class Application {
	private String applicationNumber;
	private Date applicationDate;
	private String modeOfPayment;
	private Double amountPaid;
	private String paymentStatus;
	private String remarks;
	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Application(String applicationNumber, Date applicationDate, String modeOfPayment, Double amountPaid,
			String paymentStatus, String remarks) {
		super();
		this.applicationNumber = applicationNumber;
		this.applicationDate = applicationDate;
		this.modeOfPayment = modeOfPayment;
		this.amountPaid = amountPaid;
		this.paymentStatus = paymentStatus;
		this.remarks = remarks;
	}
	public String getApplicationNumber() {
		return applicationNumber;
	}
	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public Double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
