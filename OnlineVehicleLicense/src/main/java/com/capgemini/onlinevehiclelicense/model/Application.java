package com.capgemini.onlinevehiclelicense.model;

import java.time.LocalDate;
import javax.persistence.*;



@Entity
public class Application {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="application_seq")
	@SequenceGenerator(name="application_seq",sequenceName="application_seq", allocationSize=1)
	private int applicationNumber;
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private Applicant applicant;
	
	private LocalDate applicationDate=LocalDate.now();
	@OneToOne
	private RTOOffice rtoOffice;
	@Enumerated(value=EnumType.STRING)
	private ApplicationType type;

	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="docid")
	private Documents documents=null;
	
	private String modeOfPayment;
	private double amountPaid;
	private String paymentStatus;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="appointmentnumber")
	
	private Appointment appointment;
	
	@Enumerated(value=EnumType.STRING)
	private ApplicationStatus status;
	private String remarks;
	public Application(int applicationNumber, Applicant applicant, LocalDate applicationDate, RTOOffice rtoOffice,
			ApplicationType type, Documents documents, String modeOfPayment, double amountPaid, String paymentStatus,
			Appointment appointment, ApplicationStatus status, String remarks) {
		super();
		this.applicationNumber = applicationNumber;
		this.applicant = applicant;
		this.applicationDate = LocalDate.now();
		this.rtoOffice = rtoOffice;
		this.type = type;
		this.documents = documents;
		this.modeOfPayment = modeOfPayment;
		this.amountPaid = amountPaid;
		this.paymentStatus = paymentStatus;
		this.appointment = appointment;
		this.status = status;
		this.remarks = remarks;
	}
	public Application() {
		super();
	}
	public int getApplicationNumber() {
		return applicationNumber;
	}
	public void setApplicationNumber(int applicationNumber) {
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
	public ApplicationType getType() {
		return type;
	}
	public void setType(ApplicationType type) {
		this.type = type;
	}
	public Documents getDocuments() {
		return documents;
	}
	public void setDocuments(Documents documents) {
		this.documents = documents;
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
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public ApplicationStatus getStatus() {
		return status;
	}
	public void setStatus(ApplicationStatus status) {
		this.status = status;
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
				+ applicationDate + ", rtoOffice=" + rtoOffice + ", type=" + type + ", documents=" + documents
				+ ", modeOfPayment=" + modeOfPayment + ", amountPaid=" + amountPaid + ", paymentStatus=" + paymentStatus
				+ ", appointment=" + appointment + ", status=" + status + ", remarks=" + remarks + "]";
	}
	
	
	
}