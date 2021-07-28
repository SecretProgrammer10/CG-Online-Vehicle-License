package com.capgemini.onlinevehiclelicense.service;

import com.capgemini.onlinevehiclelicense.model.Appointment;

public interface IAppointmentService {
	   
	public String createAppointment(Appointment AP);
	public String viewAppointment(Appointment AP);
	public String updateAppointment(Appointment AP,String appointment_number);
	public String deleteAppointment(Appointment AP);

}
