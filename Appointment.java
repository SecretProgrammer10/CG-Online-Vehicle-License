package com.capgemini.onlinevehiclelicense.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="appointment")

public class Appointment {
	@Id
	@Column(name="appointment_number")
	private String appointment_number;
	
	@ManyToOne(cascade=CascadeType.ALL)
	
	@JoinColumn(name="rto_id")
	private RTOOffice rtooffice;
	
	@OneToOne(cascade=CascadeType.ALL)
	
	@JoinColumn(name="application_number")
	private Application application;
	
	@Column(name="test_date")
	private Date testDate;
	
	@Column(name="time_slot")
	private String timeSlot;
	
	@Column(name="test_result")
	private String testResult;
	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Appointment(String appointment_number, RTOOffice rtooffice, Application application, Date testDate,
			String timeSlot, String testResult) {
		super();
		this.appointment_number = appointment_number;
		this.rtooffice = rtooffice;
		this.application = application;
		this.testDate = testDate;
		this.timeSlot = timeSlot;
		this.testResult = testResult;
	}


	@Override
	public String toString() {
		return "Appointment [appointment_number=" + appointment_number + ", rtooffice=" + rtooffice + ", application="
				+ application + ", testDate=" + testDate + ", timeSlot=" + timeSlot + ", testResult=" + testResult
				+ "]";
	}


	public String getAppointment_number() {
		return appointment_number;
	}

	public void setAppointment_number(String appointment_number) {
		this.appointment_number = appointment_number;
	}

	public RTOOffice getRtooffice() {
		return rtooffice;
	}

	public void setRtooffice(RTOOffice rtooffice) {
		this.rtooffice = rtooffice;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
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
	
}
