package com.capgemini.onlinevehiclelicense.model;

import java.util.Date;

public class DivingLicense {
	private String drivingLicenseNumber;
	private Date dateOfIssue;
	private Date validTill;
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
	public void setDrivingLicenseNumber(String drivingLicenseNumber) {
		this.drivingLicenseNumber = drivingLicenseNumber;
	}
	public Date getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public Date getValidTill() {
		return validTill;
	}
	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}
}
