package com.capgemini.onlinevehiclelicense.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "license")
public class License {
	
	@Id
	private String licenseNumber;
	
	@Column(name = "license_type")
	private String licenseType;
	
	@Column(name = "date_of_issue")
	private Date dateOfIssue;
	
	@Column(name = "valid_till")
	private Date validTill;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "application_number")
	private Application application;
	
	public License() {
		super();
	}
	
	public License(String licenseType, String licenseNumber, Date dateOfIssue, Date validTill) {
		super();
		this.licenseType = licenseType;
		this.licenseNumber = licenseNumber;
		this.dateOfIssue = dateOfIssue;
		this.validTill = validTill;
	}
	
	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
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
	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	@Override
	public String toString() {
		return "License [licenseType=" + licenseType + ", licenseNumber=" + licenseNumber + ", dateOfIssue="
				+ dateOfIssue + ", validTill=" + validTill + "]";
	}
}
