package com.capgemini.onlinevehiclelicense.model;

import java.time.LocalDate;
import javax.persistence.*;



@Entity
public class Application {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="application_seq")
	@SequenceGenerator(name="application_seq",sequenceName="application_seq", allocationSize=1)
	
	@Column(name="application_number")
	private String applicationNumber;
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="applicant_id")
	private Applicant applicant;
		
	@Column(name="application_date")
	private LocalDate applicationDate=LocalDate.now();
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="rto_id")
	private RTOOffice rtoOffice;

	@Column(name="mode_of_payment")
	private String modeOfPayment;
	@Column(name="amount_paid")
	private Double amountPaid;
	@Column(name="payment_status")
	private String paymentStatus;
	@Column(name="remarks")
	private String remarks;
	@Column(name="application_status")
	private String applicationStatus;
	@Column(name="application_type")
	private String applicationType;
	
	
	public Application(String applicationNumber, Applicant applicant, LocalDate applicationDate, RTOOffice rtoOffice,
			ApplicationType type, Documents documents, String modeOfPayment, double amountPaid, String paymentStatus,
			Appointment appointment, ApplicationStatus status, String remarks, String applicationType, String applicationStatus) {
		super();
		this.applicationNumber = applicationNumber;
		this.applicant = applicant;
		this.applicationDate = LocalDate.now();
		this.rtoOffice = rtoOffice;
		this.applicationStatus = applicationStatus;
		this.applicationType = applicationType;
		this.modeOfPayment = modeOfPayment;
		this.amountPaid = amountPaid;
		this.paymentStatus = paymentStatus;
		this.remarks = remarks;
	}
	public Application() {
		super();
	}
	public String getApplicationNumber() {
		return applicationNumber;
	}
	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber=applicationNumber;
	}
	public Applicant getApplicant() {
		return applicant;
	}
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	public LocalDate getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = LocalDate.now();
	}
	public RTOOffice getRtoOffice() {
		return rtoOffice;
	}
	public void setRtoOffice(RTOOffice rtoOffice) {
		this.rtoOffice = rtoOffice;
	}
	public String getType() {
		return applicationType;
	}
	public void setType(String type) {
		this.applicationType = type;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getStatus() {
		return applicationStatus;
	}
	public void setStatus(String status) {
		this.applicationStatus = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "Application [applicationNumber=" + applicationNumber + ", applicant=" + applicant + ", applicationDate="
				+ applicationDate + ", rtoOffice=" + rtoOffice + ", type=" + applicationType + ", modeOfPayment=" + modeOfPayment + ", amountPaid=" + amountPaid + ", paymentStatus=" + paymentStatus
				+ ", status=" + applicationStatus + ", remarks=" + remarks + "]";
	}
	
	
	
}