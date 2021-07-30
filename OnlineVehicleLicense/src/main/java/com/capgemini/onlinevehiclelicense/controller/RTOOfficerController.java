package com.capgemini.onlinevehiclelicense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.Appointment;
import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.model.RTOOfficer;
import com.capgemini.onlinevehiclelicense.service.IRTOOfficerService;

@RestController
@RequestMapping("/rtoOfficer")
public class RTOOfficerController {
	
	@Autowired
	private IRTOOfficerService rtoOfficerService;
	
	@GetMapping("/loginRtoOfficer")
	@ExceptionHandler(RecordNotFoundException.class)
	public void loginUser(@RequestBody RTOOfficer rtoofficer)
	{
		rtoOfficerService.officeLogin(rtoofficer);
	}
	
	@GetMapping("/view-pending-application")
	@ExceptionHandler(RecordNotFoundException.class)
	public List<Application> viewAllPendingApplications() 
	{
		return rtoOfficerService.viewAllPendingApplications();
	}
	
	@GetMapping("/view-rejected-application")
	@ExceptionHandler(RecordNotFoundException.class)
	public List<Application> viewAllRejectedApplications() 
	{
		return rtoOfficerService.viewAllRejectedApplications();
	}
	
	@GetMapping("/view-approved-application")
	@ExceptionHandler(RecordNotFoundException.class)
	public List<Application> viewAllApprovedApplications( ) 
	{
		return rtoOfficerService.viewAllApprovedApplications();
	}
	
	@GetMapping("/view-applicationby-id/{applicationNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Application viewApplicationById(@PathVariable("applicationNumber")String applicationNumber)
	{
		return rtoOfficerService.viewApplicationById(applicationNumber);
	}
	
	@GetMapping("/view-challanby-vehiclenumber/{vehicleNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public List<Challan> checkChallanByVehicleNumber(@PathVariable("vehicleNumber")String vehicleNumber)
	{
		return rtoOfficerService.checkChallanByVehicleNumber(vehicleNumber);
		
	}
	
	@GetMapping("/check-all-challan")
	public List<Challan> checkAllChallan()
	{
		return rtoOfficerService.checkAllChallan();
	}
	
	@GetMapping("/view-all-appointment")
	public List<Appointment> viewAllappointment()
	{
		return rtoOfficerService.viewAllAppointments();
		
	}
	
	@PutMapping("/modify-test-results/{applicationNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Appointment> modifyTestResults(@PathVariable("applicationNumber") String applicationNumber)
	{
		return rtoOfficerService.modifyTestResultById(applicationNumber, "Pass");
	}
	
}