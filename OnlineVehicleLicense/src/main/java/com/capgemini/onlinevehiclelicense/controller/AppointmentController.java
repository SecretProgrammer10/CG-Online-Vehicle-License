package com.capgemini.onlinevehiclelicense.controller;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.model.Appointment;
import com.capgemini.onlinevehiclelicense.service.IAppointmentService;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/appointment")
@Api(value = "Online Vehicle License")
@Validated
public class AppointmentController {

	@Autowired
	private IAppointmentService appointmentService;
	
	@ApiOperation(value = "Create Appointment")
	@PostMapping("/create-appointment")
	public ResponseEntity<String> createAppointment(
			@RequestParam String applicationNumber,
			@ApiParam(value = "New Appointment Details") @RequestBody Appointment appointment,
			@RequestParam int rtoId) {
				return this.appointmentService.createAppointment(applicationNumber, appointment, rtoId);
	}
	
	@ApiOperation(value = "Reschedule Appointment")
	@PutMapping("/reschedule-appointment")
	public ResponseEntity<String> updateAppointment(
			@ApiParam(value = "New Test Date") @RequestParam @DateTimeFormat(pattern="dd-MM-yyyy") Date testDate, 
			@ApiParam(value = "New Test Date and time Slot") @RequestParam @DateTimeFormat(pattern="dd-MM-yyyy HH:mm") Date testSlot,
			@ApiParam(value = "Application Number") @RequestParam String applicationNumber) {
		return this.appointmentService.updateAppointment(testDate, testSlot, applicationNumber);
	}
	
	@ApiOperation(value = "View Appointment Details")
	@GetMapping("application/{applicationNumber}/appointment-details")
	public Appointment viewAppointmentDetails(
			@ApiParam(value = "Appointment Number") @PathVariable("applicationNumber") String applicationNumber) {
		return this.appointmentService.viewAppointmentDetails(applicationNumber);
	}
	
	@ApiOperation(value = "Cancel Appointment")
	@DeleteMapping("application/{applicationNumber}/cancel-appointment")
	public ResponseEntity<String> cancelAppointment(
			@ApiParam(value = "Application Number") @PathVariable("applicationNumber") String applicationNumber) {
		return this.appointmentService.deleteAppointment(applicationNumber);
	}
	
}
