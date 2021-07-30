package com.capgemini.onlinevehiclelicense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Appointment;
import com.capgemini.onlinevehiclelicense.service.IAppointmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/appointment")
@Api(value = "Online Vehicle License")
@Validated
public class AppointmentController {

	@Autowired
	private IAppointmentService appointmentService;
	
	@ApiOperation(value = "Create Appointment")
	@PostMapping("/create-appointment")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<Appointment> createAppointment(
			@ApiParam(value = "Create an Appointment") @RequestBody Appointment appointment) {
				return this.appointmentService.createAppointment(appointment);
	}
	
	@ApiOperation(value = "Reschedule Appointment")
	@PutMapping("/reschedule-appointment")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Appointment> updateAppointment(
			@ApiParam(value = "Reschedule an Appointment") @RequestBody Appointment appointment) {
		return this.appointmentService.updateAppointment(appointment);
	}
	
	@ApiOperation(value = "View Appointment Details")
	@GetMapping("/appointment-details/{appointmentNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Appointment viewAppointmentDetails(
			@ApiParam(value = "Appointment Number") @PathVariable("appointmentNumber") String appointmentNumber) {
		return this.appointmentService.viewAppointmentDetails(appointmentNumber);
	}
	
	@ApiOperation(value = "Cancel Appointment")
	@GetMapping("/cancel-appointment/{appointmentNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Appointment> cancelAppointment(
			@ApiParam(value = "Appointment Number") @PathVariable("appointmentNumber") String appointmentNumber) {
		return this.appointmentService.deleteAppointment(appointmentNumber);
	}
	
}
