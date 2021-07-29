package com.capgemini.onlinevehiclelicense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.exception.ApplicationNotFoundException;
import com.capgemini.onlinevehiclelicense.exception.ChallanNotFoundException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.model.RTOOfficer;
import com.capgemini.onlinevehiclelicense.service.IRTOOfficerService;

@RestController
@RequestMapping("/rtoOfficer")
public class RTOOfficerController {
	
	@Autowired
	private IRTOOfficerService rtoofficerService;
	
	@GetMapping("/loginRtoOfficer")
	@ExceptionHandler(RecordNotFoundException.class)
	public void loginUser(@RequestBody RTOOfficer rtoofficer)
	{
		rtoofficerService.officeLogin(rtoofficer);
	}
	
	@RequestMapping("/view-pending-application")
	@ExceptionHandler(ApplicationNotFoundException.class)
	public ResponseEntity<Application> viewAllPendingApplications(@RequestBody RTOOfficer rtoofficer) 
	{
		return rtoofficerService.viewAllPendingApplications();
	}
	
	@RequestMapping("/view-rejected-application")
	@ExceptionHandler(ApplicationNotFoundException.class)
	public ResponseEntity<Application> viewAllRejectedApplications(@RequestBody RTOOfficer rtoofficer) 
	{
		return rtoofficerService.viewAllRejectedApplications();
	}
	
	@RequestMapping("/view-approved-application")
	@ExceptionHandler(ApplicationNotFoundException.class)
	public ResponseEntity<Application> viewAllApprovedApplications(@RequestBody RTOOfficer rtoofficer) 
	{
		return rtoofficerService.viewAllApprovedApplications();
	}
	
	@RequestMapping("/view-applicationby-id/{applicationNumber}")
	@ExceptionHandler(ApplicationNotFoundException.class)
	public ResponseEntity<Application> viewApplicationById(@PathVariable("applicationNumber")String applicationNumber)
	{
		return rtoofficerService.viewApplicationById(applicationNumber);
	}
	
	@RequestMapping("/view-challanby-vehiclenumber/{vehicleNumber}")
	@ExceptionHandler(ChallanNotFoundException.class)
	public ResponseEntity<Challan> checkChallanByVehicleNumber(@PathVariable("vehicleNumber")String vehicleNumber)
	{
		return rtoofficerService.checkChallanByVehicleNumber(vehicleNumber);
		
	}
	
	@RequestMapping("/check-all-challan")
	public List<Challan> checkAllChallan(@RequestBody Challan challan)
	{
		return rtoofficerService.checkAllChallan();
	}
	
	
}
