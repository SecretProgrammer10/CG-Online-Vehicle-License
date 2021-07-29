package com.capgemini.onlinevehiclelicense.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Appointment")
public class Appointment {
	
	
	@Id
	@Column(name = "appointment_number")
	private String appointmentNumber;
	
	@Column(name = "test_date")
	private LocalDate testDate;
	
	@Column(name = "time_slot")
	private LocalDateTime timeSlot;
	
	@Column(name = "test_result")
	private String testResult;
	
	@OneToOne
	private Application application;
	
	@ManyToOne
	private RTOOfficer rtoOfficer;
	
	
    public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param appointmentNumber
	 * @param testDate
	 * @param timeSlot
	 * @param testResult
	 */
	public Appointment(String appointmentNumber, LocalDate testDate, LocalDateTime timeSlot, String testResult) {
		super();
		this.appointmentNumber = appointmentNumber;
		this.testDate = testDate;
		this.timeSlot = timeSlot;
		this.testResult = testResult;
	}



	/**
	 * @return the appointmentNumber
	 */
	public String getAppointmentNumber() {
		return appointmentNumber;
	}

	/**
	 * @param appointmentNumber the appointmentNumber to set
	 */
	public void setAppointmentNumber(String appointmentNumber) {
		this.appointmentNumber = appointmentNumber;
	}

	/**
	 * @return the testDate
	 */
	public LocalDate getTestDate() {
		return testDate;
	}

	/**
	 * @param testDate the testDate to set
	 */
	public void setTestDate(LocalDate testDate) {
		this.testDate = testDate;
	}

	/**
	 * @return the timeSlot
	 */
	public LocalDateTime getTimeSlot() {
		return timeSlot;
	}

	/**
	 * @param timeSlot the timeSlot to set
	 */
	public void setTimeSlot(LocalDateTime timeSlot) {
		this.timeSlot = timeSlot;
	}

	/**
	 * @return the testResult
	 */
	public String getTestResult() {
		return testResult;
	}

	/**
	 * @param testResult the testResult to set
	 */
	public void setTestResult(String testResult) {
		this.testResult = testResult;
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
	 * @return the rtoOfficer
	 */
	public RTOOfficer getRtoOfficer() {
		return rtoOfficer;
	}

	/**
	 * @param rtoOfficer the rtoOfficer to set
	 */
	public void setRtoOfficer(RTOOfficer rtoOfficer) {
		this.rtoOfficer = rtoOfficer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointmentNumber == null) ? 0 : appointmentNumber.hashCode());
		result = prime * result + ((testDate == null) ? 0 : testDate.hashCode());
		result = prime * result + ((testResult == null) ? 0 : testResult.hashCode());
		result = prime * result + ((timeSlot == null) ? 0 : timeSlot.hashCode());
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
		Appointment other = (Appointment) obj;
		if (appointmentNumber == null) {
			if (other.appointmentNumber != null)
				return false;
		} else if (!appointmentNumber.equals(other.appointmentNumber))
			return false;
		if (testDate == null) {
			if (other.testDate != null)
				return false;
		} else if (!testDate.equals(other.testDate))
			return false;
		if (testResult == null) {
			if (other.testResult != null)
				return false;
		} else if (!testResult.equals(other.testResult))
			return false;
		if (timeSlot == null) {
			if (other.timeSlot != null)
				return false;
		} else if (!timeSlot.equals(other.timeSlot))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentNumber=" + appointmentNumber + ", testDate=" + testDate + ", timeSlot="
				+ timeSlot + ", testResult=" + testResult + ", application=" + application + ", rtoOfficer="
				+ rtoOfficer + "]";
	}
    
}
