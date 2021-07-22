package com.capgemini.onlinevehiclelicense.model;

import java.util.Date;

public class Appointment {
	private String appointmentNumber;
	private Date testDate;
	private String timeSlot;
	private String testResult;
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(String appointmentNumber, Date testDate, String timeSlot, String testResult) {
		super();
		this.appointmentNumber = appointmentNumber;
		this.testDate = testDate;
		this.timeSlot = timeSlot;
		this.testResult = testResult;
	}
	public String getAppointmentNumber() {
		return appointmentNumber;
	}
	public void setAppointmentNumber(String appointmentNumber) {
		this.appointmentNumber = appointmentNumber;
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
