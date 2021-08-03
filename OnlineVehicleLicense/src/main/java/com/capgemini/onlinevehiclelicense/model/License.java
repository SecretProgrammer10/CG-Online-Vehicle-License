package com.capgemini.onlinevehiclelicense.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.capgemini.onlinevehiclelicense.util.LicenseIdGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "license")
public class License {
	
	@Id
	@Column(name = "license_number")
	@Pattern(regexp="^(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "license_seq")
	@GenericGenerator(name = "license_seq", 
			    strategy = "com.capgemini.onlinevehiclelicense.util.LicenseIdGenerator", 
			    parameters = { @Parameter(name = LicenseIdGenerator.INCREMENT_PARAM, value = "1"),
			        @Parameter(name = LicenseIdGenerator.VALUE_PREFIX_PARAMETER, value = "MH_"),
			        @Parameter(name = LicenseIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d") })
	private String licenseNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "license_type")
	@NotEmpty(message="license type should not be empty")
	private LicenseType licenseType;
	
	@Column(name = "date_of_issue")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotEmpty(message="date of issue should not be empty")
	private Date dateOfIssue;
	
	@Column(name = "valid_till")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotEmpty(message="validity should not be empty")
	private Date validTill;
	
	@OneToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name = "application_id", nullable = false)
	private Application application;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "rto_id", nullable = false)
	private RTOOffice rtoOffice;

	/**
	 * 
	 */
	public License() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param licenseNumber
	 * @param licenseType
	 * @param dateOfIssue
	 * @param validTill
	 */
	public License(
			@Pattern(regexp = "^(([A-Z]{2}[0-9]{2})( )|([A-Z]{2}-[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$") String licenseNumber,
			@NotEmpty(message = "license type should not be empty") LicenseType licenseType,
			@NotEmpty(message = "date of issue should not be empty") Date dateOfIssue,
			@NotEmpty(message = "validity should not be empty") Date validTill) {
		super();
		this.licenseNumber = licenseNumber;
		this.licenseType = licenseType;
		this.dateOfIssue = dateOfIssue;
		this.validTill = validTill;
	}

	/**
	 * @return the licenseNumber
	 */
	public String getLicenseNumber() {
		return licenseNumber;
	}

	/**
	 * @param licenseNumber the licenseNumber to set
	 */
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	/**
	 * @return the licenseType
	 */
	public LicenseType getLicenseType() {
		return licenseType;
	}

	/**
	 * @param licenseType the licenseType to set
	 */
	public void setLicenseType(LicenseType licenseType) {
		this.licenseType = licenseType;
	}

	/**
	 * @return the dateOfIssue
	 */
	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	/**
	 * @param dateOfIssue the dateOfIssue to set
	 */
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	/**
	 * @return the validTill
	 */
	public Date getValidTill() {
		return validTill;
	}

	/**
	 * @param validTill the validTill to set
	 */
	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	/**
	 * @return the application
	 */
	public Application getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	public void setApplication(Application application) {
		this.application = application;
	}

	/**
	 * @return the rtoOffice
	 */
	public RTOOffice getRtoOffice() {
		return rtoOffice;
	}

	/**
	 * @param rtoOffice the rtoOffice to set
	 */
	public void setRtoOffice(RTOOffice rtoOffice) {
		this.rtoOffice = rtoOffice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((application == null) ? 0 : application.hashCode());
		result = prime * result + ((dateOfIssue == null) ? 0 : dateOfIssue.hashCode());
		result = prime * result + ((licenseNumber == null) ? 0 : licenseNumber.hashCode());
		result = prime * result + ((licenseType == null) ? 0 : licenseType.hashCode());
		result = prime * result + ((rtoOffice == null) ? 0 : rtoOffice.hashCode());
		result = prime * result + ((validTill == null) ? 0 : validTill.hashCode());
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
		License other = (License) obj;
		if (application == null) {
			if (other.application != null)
				return false;
		} else if (!application.equals(other.application))
			return false;
		if (dateOfIssue == null) {
			if (other.dateOfIssue != null)
				return false;
		} else if (!dateOfIssue.equals(other.dateOfIssue))
			return false;
		if (licenseNumber == null) {
			if (other.licenseNumber != null)
				return false;
		} else if (!licenseNumber.equals(other.licenseNumber))
			return false;
		if (licenseType != other.licenseType)
			return false;
		if (rtoOffice == null) {
			if (other.rtoOffice != null)
				return false;
		} else if (!rtoOffice.equals(other.rtoOffice))
			return false;
		if (validTill == null) {
			if (other.validTill != null)
				return false;
		} else if (!validTill.equals(other.validTill))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "License [licenseNumber=" + licenseNumber + ", licenseType=" + licenseType + ", dateOfIssue="
				+ dateOfIssue + ", validTill=" + validTill + ", application=" + application + ", rtoOffice=" + rtoOffice
				+ "]";
	}
	
}
