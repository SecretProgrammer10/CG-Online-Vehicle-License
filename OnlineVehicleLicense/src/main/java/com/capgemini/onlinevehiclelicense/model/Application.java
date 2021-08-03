package com.capgemini.onlinevehiclelicense.model;

import java.time.LocalDate;
import javax.persistence.*;



@Entity
@Table(name="Application")
public class Application {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="application_seq")
	@SequenceGenerator(name="application_seq",sequenceName="application_seq", allocationSize=1)
	@Column(name="application_number")
	private String applicationNumber;
	
/*	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="applicant_id")
	private Applicant applicant;
*/	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "applicant_id", nullable = false)
	private Applicant applicant;
		
	@Column(name="application_date")
	private LocalDate applicationDate=LocalDate.now();
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
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
	
	
	
	
	public Application(String applicationNumber, Applicant applicant, LocalDate applicationDate, RTOOffice rtoOffice,
			Documents documents, String modeOfPayment, double amountPaid, String paymentStatus,
			Appointment appointment, String remarks, LicenseType applicationType, ApplicationStatus applicationStatus) {
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
	public LicenseType getType() {
		return applicationType;
	}
	public void setType(LicenseType type) {
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
	public ApplicationStatus getStatus() {
		return applicationStatus;
	}
	public void setStatus(ApplicationStatus status) {
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
