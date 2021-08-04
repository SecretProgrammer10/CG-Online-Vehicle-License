package com.capgemini.onlinevehiclelicense.model;

import java.time.LocalDate;

import java.util.Date;

import javax.persistence.*;



import javax.persistence.CascadeType;
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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.capgemini.onlinevehiclelicense.util.ApplicationIdGenerator;

@Entity
@Table(name="Application")
public class Application {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_seq")
    @GenericGenerator(
            name = "application_seq", 
            strategy = "com.capgemini.onlinevehiclelicense.util.ApplicationIdGenerator", 
            parameters = { 
                    @Parameter(name = ApplicationIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = ApplicationIdGenerator.CODE_NUMBER_SEPARATOR_PARAMETER, value = "_"), 
                    @Parameter(name = ApplicationIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d")})
    private String id;


	@Column(name="application_number")
	private String applicationNumber;
		
	@Column(name="application_date")
	private Date applicationDate;

	@Column(name="mode_of_payment")
	private String modeOfPayment;
	
	@Column(name="amount_paid")
	private Double amountPaid;
	
	@Column(name="payment_status")
	private String paymentStatus;
	
	@Column(name="remarks")
	private String remarks;
	
	@Enumerated(EnumType.STRING)
	@Column(name="application_status")
	private ApplicationStatus applicationStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(name="application_type")
	private LicenseType applicationType;
	
	@OneToOne(mappedBy = "application", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Documents docs;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="application")
	private License license;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="application")
	private Appointment appointment;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="rto_id", nullable = false)
	private RTOOffice rtoOffice;
	

/*	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="applicant_id")
	private Applicant applicant;
*/	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "applicant_id", nullable = false)
	private Applicant applicant;


	/**
	 * 
	 */
	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param applicationNumber
	 * @param localDate.now()
	 * @param modeOfPayment
	 * @param amountPaid
	 * @param paymentStatus
	 * @param remarks
	 * @param applicationStatus
	 * @param applicationType
	 */
	public Application(String applicationNumber, Date date, String modeOfPayment, Double amountPaid,
			String paymentStatus, String remarks, ApplicationStatus applicationStatus, LicenseType applicationType) {
		super();
		this.applicationNumber = applicationNumber;
	    this.applicationDate=date;
		this.modeOfPayment = modeOfPayment;
		this.amountPaid = amountPaid;
		this.paymentStatus = paymentStatus;
		this.remarks = remarks;
		this.applicationStatus = applicationStatus;
		this.applicationType = applicationType;
	}


	/**
	 * @return the applicationNumber
	 */
	public String getApplicationNumber() {
		return applicationNumber;
	}


	/**
	 * @param applicationNumber the applicationNumber to set
	 */
	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}


	/**
	 * @return the applicationDate
	 */
	public Date getApplicationDate() {
		return applicationDate;
	}


	/**
	 * @param applicationDate the applicationDate to set
	 */
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}


	/**
	 * @return the modeOfPayment
	 */
	public String getModeOfPayment() {
		return modeOfPayment;
	}


	/**
	 * @param modeOfPayment the modeOfPayment to set
	 */
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}


	/**
	 * @return the amountPaid
	 */
	public Double getAmountPaid() {
		return amountPaid;
	}


	/**
	 * @param amountPaid the amountPaid to set
	 */
	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}


	/**
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}


	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}


	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	/**
	 * @return the applicationStatus
	 */
	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}


	/**
	 * @param applicationStatus the applicationStatus to set
	 */
	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}


	/**
	 * @return the applicationType
	 */
	public LicenseType getApplicationType() {
		return applicationType;
	}


	/**
	 * @param applicationType the applicationType to set
	 */
	public void setApplicationType(LicenseType applicationType) {
		this.applicationType = applicationType;
	}


	/**
	 * @return the docs
	 */
	public Documents getDocs() {
		return docs;
	}


	/**
	 * @param docs the docs to set
	 */
	public void setDocs(Documents docs) {
		this.docs = docs;
	}


	/**
	 * @return the license
	 */
	public License getLicense() {
		return license;
	}


	/**
	 * @param license the license to set
	 */
	public void setLicense(License license) {
		this.license = license;
	}


	/**
	 * @return the appointment
	 */
	public Appointment getAppointment() {
		return appointment;
	}


	/**
	 * @param appointment the appointment to set
	 */
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
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


	/**
	 * @return the applicant
	 */
	public Applicant getApplicant() {
		return applicant;
	}


	/**
	 * @param applicant the applicant to set
	 */
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountPaid == null) ? 0 : amountPaid.hashCode());
		result = prime * result + ((applicationDate == null) ? 0 : applicationDate.hashCode());
		result = prime * result + ((applicationNumber == null) ? 0 : applicationNumber.hashCode());
		result = prime * result + ((applicationStatus == null) ? 0 : applicationStatus.hashCode());
		result = prime * result + ((applicationType == null) ? 0 : applicationType.hashCode());
		result = prime * result + ((modeOfPayment == null) ? 0 : modeOfPayment.hashCode());
		result = prime * result + ((paymentStatus == null) ? 0 : paymentStatus.hashCode());
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
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
		Application other = (Application) obj;
		if (amountPaid == null) {
			if (other.amountPaid != null)
				return false;
		} else if (!amountPaid.equals(other.amountPaid))
			return false;
		if (applicationDate == null) {
			if (other.applicationDate != null)
				return false;
		} else if (!applicationDate.equals(other.applicationDate))
			return false;
		if (applicationNumber == null) {
			if (other.applicationNumber != null)
				return false;
		} else if (!applicationNumber.equals(other.applicationNumber))
			return false;
		if (applicationStatus != other.applicationStatus)
			return false;
		if (applicationType != other.applicationType)
			return false;
		if (modeOfPayment == null) {
			if (other.modeOfPayment != null)
				return false;
		} else if (!modeOfPayment.equals(other.modeOfPayment))
			return false;
		if (paymentStatus == null) {
			if (other.paymentStatus != null)
				return false;
		} else if (!paymentStatus.equals(other.paymentStatus))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Application [applicationNumber=" + applicationNumber + ", applicationDate=" + applicationDate
				+ ", modeOfPayment=" + modeOfPayment + ", amountPaid=" + amountPaid + ", paymentStatus=" + paymentStatus
				+ ", remarks=" + remarks + ", applicationStatus=" + applicationStatus + ", applicationType="
				+ applicationType + ", docs=" + docs + ", license=" + license + ", appointment=" + appointment
				+ ", rtoOffice=" + rtoOffice + ", applicant=" + applicant + "]";
	}
	
	
}
