package com.capgemini.onlinevehiclelicense.service;

import java.util.Date;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.Appointment;

public interface IAppointmentService {

	public Appointment viewAppointmentDetails(String appointmentNumber);
	public ResponseEntity<String> deleteAppointment(String appointmentNumber);
	public ResponseEntity<String> createAppointment(String applicationNumber, Appointment appointment, int rtoId);
	public ResponseEntity<String> updateAppointment(Date testDate, Date testDate2, String applicationNumber);

}
