package com.capgemini.onlinevehiclelicense.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "license")
public class License {
	
	@Id
	@Column(name = "license_number")
	@Pattern(regexp="^(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$")
	private String licenseNumber;
	
	@Column(name = "license_type")
	@NotEmpty(message="license type should not be empty")
	private String licenseType;
	
	@Column(name = "date_of_issue")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotEmpty(message="date of issue should not be empty")
	private Date dateOfIssue;
	
	@Column(name = "valid_till")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotEmpty(message="validity should not be empty")
	private Date validTill;
	
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

	@Override
	public String toString() {
		return "License [licenseType=" + licenseType + ", licenseNumber=" + licenseNumber + ", dateOfIssue="
				+ dateOfIssue + ", validTill=" + validTill + "]";
	}
}
