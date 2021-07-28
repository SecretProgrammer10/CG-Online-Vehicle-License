package com.capgemini.onlinevehiclelicense.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Appointment")
public class Appointment {
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "rto_id")
	
	@Id
	@Column(name = "appplication_number")
	private String applicationNumber;
	
	@Column(name = "appointment_number")
	private String appointmentNumber;
	
	@Column(name = "rto_id")
	private Date rtoId;
	
	@Column(name = "test_date")
	private Date testDate;
	
	@Column(name = "time_slot")
	private String timeSlot;
	
	@Column(name = "test_result")
	private String testResult;
	
	
    public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

    public Appointment(String applicationNumber, String appointmentNumber, Date rtoId, Date testDate, String timeSlot,
			String testResult) {
		super();
		this.applicationNumber = applicationNumber;
		this.appointmentNumber = appointmentNumber;
		this.rtoId = rtoId;
		this.testDate = testDate;
		this.timeSlot = timeSlot;
		this.testResult = testResult;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getAppointmentNumber() {
		return appointmentNumber;
	}

	public void setAppointmentNumber(String appointmentNumber) {
		this.appointmentNumber = appointmentNumber;
	}

	public Date getRtoId() {
		return rtoId;
	}

	public void setRtoId(Date rtoId) {
		this.rtoId = rtoId;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	@Override
	public String toString() {
		return "Appointment [applicationNumber=" + applicationNumber + ", appointmentNumber=" + appointmentNumber
				+ ", rtoId=" + rtoId + ", testDate=" + testDate + ", timeSlot=" + timeSlot + ", testResult="
				+ testResult + "]";
	}
	
	
	
}
