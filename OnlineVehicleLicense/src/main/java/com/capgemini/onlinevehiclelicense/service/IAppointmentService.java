package com.capgemini.onlinevehiclelicense.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.Appointment;

public interface IAppointmentService {
	   
	public ResponseEntity<Appointment> createAppointment(Appointment appointment);
	public Appointment viewAppointmentDetails(String appointmentNumber);
	public ResponseEntity<Appointment> updateAppointment(Appointment appointment);
	public ResponseEntity<Appointment> deleteAppointment(String appointmentNumber);

}
