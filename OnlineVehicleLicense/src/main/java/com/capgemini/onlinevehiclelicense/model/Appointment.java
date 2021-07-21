package com.capgemini.onlinevehiclelicense.model;

import java.util.Date;

public class Appointment {
	String appointmentNumber;
	Date testDate;
	String timeSlot;
	String testResult;
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
	public Date getTestDate() {
		return testDate;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public String getTestResult() {
		return testResult;
	}
}
