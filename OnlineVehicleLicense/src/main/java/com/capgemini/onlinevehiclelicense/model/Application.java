package com.capgemini.onlinevehiclelicense.model;

import java.util.Date;

public class Application {
	String applicationNumber;
	Date applicationDate;
	String modeOfPayment;
	Double amountPaid;
	String paymentStatus;
	String remarks;
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
	public Date getApplicationDate() {
		return applicationDate;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public Double getAmountPaid() {
		return amountPaid;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public String getRemarks() {
		return remarks;
	}
}
