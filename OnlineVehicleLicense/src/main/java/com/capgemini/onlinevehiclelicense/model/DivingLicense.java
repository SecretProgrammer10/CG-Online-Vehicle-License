package com.capgemini.onlinevehiclelicense.model;

import java.util.Date;

public class DivingLicense {
	String drivingLicenseNumber;
	Date dateOfIssue;
	Date validTill;
	public DivingLicense() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DivingLicense(String drivingLicenseNumber, Date dateOfIssue, Date validTill) {
		super();
		this.drivingLicenseNumber = drivingLicenseNumber;
		this.dateOfIssue = dateOfIssue;
		this.validTill = validTill;
	}
	public String getDrivingLicenseNumber() {
		return drivingLicenseNumber;
	}
	public Date getDateOfIssue() {
		return dateOfIssue;
	}
	public Date getValidTill() {
		return validTill;
	}
	
}
