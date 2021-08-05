package com.capgemini.onlinevehiclelicense.model;


import java.text.SimpleDateFormat;
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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.capgemini.onlinevehiclelicense.util.AppointmentIdGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Appointment")
public class Appointment {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
	@GenericGenerator(name = "appointment_seq", 
    strategy = "com.capgemini.onlinevehiclelicense.util.AppointmentIdGenerator", 
    parameters = { @Parameter(name = AppointmentIdGenerator.INCREMENT_PARAM, value = "1"),
        @Parameter(name = AppointmentIdGenerator.VALUE_PREFIX_PARAMETER, value = "APP_"),
        @Parameter(name = AppointmentIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%08d") })
	@Column(name = "appointment_number")
	private String appointmentNumber;
	
	@NotNull(message = "Test date cannot be null")
	@ApiModelProperty(notes = "Test Date", example = "10-10-2021")
	@Column(name = "test_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date testDate;
	
	@NotNull(message = "Test slot cannot be null")
	@ApiModelProperty(notes = "Test Slot", example = "12:30")
	@Column(name = "time_slot")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm")
	private Date timeSlot;
	
	@NotNull(message = "Application date cannot be null")
	@ApiModelProperty(notes = "Test Result")
	@Enumerated(EnumType.STRING)
	@Column(name = "test_result")
	private TestResult testResult;
	
/*	@OneToOne
	private Application application;
*/	
	@OneToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name = "application_id", nullable = false)
	@JsonIgnore
	private Application application;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "rto_office_Id", nullable=false)
	@JsonIgnore
	private RTOOffice rtoOffice;

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
	public Appointment(String appointmentNumber, Date testDate, Date timeSlot, TestResult testResult) {
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
	public Date getTestDate() {
		return testDate;
	}

	/**
	 * @param testDate the testDate to set
	 */
	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	/**
	 * @return the timeSlot
	 */
	public Date getTimeSlot() {
		return timeSlot;
	}

	/**
	 * @param timeSlot the timeSlot to set
	 */
	public void setTimeSlot(Date timeSlot) {
		this.timeSlot = timeSlot;
	}

	/**
	 * @return the testResult
	 */
	public TestResult getTestResult() {
		return testResult;
	}

	/**
	 * @param testResult the testResult to set
	 */
	public void setTestResult(TestResult testResult) {
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
	public RTOOffice getRtoOffice() {
		return rtoOffice;
	}

	/**
	 * @param rtoOfficer the rtoOfficer to set
	 */
	public void setRtoOffice(RTOOffice rtoOffice) {
		this.rtoOffice = rtoOffice;
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
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat=new SimpleDateFormat("HH:mm:ss");
		return "Appointment [appointmentNumber=" + appointmentNumber + ", testDate=" + sdf.format(testDate) + ", timeSlot="
				+ timeFormat.format(timeSlot) + ", testResult=" + testResult + ", application=" + application + ", rtoOfficer="
				+ rtoOffice + "]";
	}
    
}
