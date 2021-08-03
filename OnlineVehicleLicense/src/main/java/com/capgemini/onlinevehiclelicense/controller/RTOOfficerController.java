package com.capgemini.onlinevehiclelicense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.Appointment;
import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.model.TestResult;
import com.capgemini.onlinevehiclelicense.service.IRTOOfficerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rtoOfficer")
@Api(value = "Online Vehicle License")
@Validated
public class RTOOfficerController {
	
	@Autowired
	private IRTOOfficerService rtoOfficerService;
	
	@ApiOperation(value = "Login RTO_Officer")
	@GetMapping("/loginRtoOfficer")
	@ExceptionHandler(RecordNotFoundException.class)
	public void loginUser(@RequestParam String username, @RequestParam String pass)
	{
		rtoOfficerService.officeLogin(username, pass);
	}
	
	@ApiOperation(value = "View Pending Applications", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Operation Successful"),
			@ApiResponse(code = 401, message = "You do not have the authorization to access this resource"),
			@ApiResponse(code = 403, message = "Access to this resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource you are looking for does not exist/cannot be found")
	})
	@GetMapping("/view-pending-application")
	@ExceptionHandler(RecordNotFoundException.class)
	public List<Application> viewAllPendingApplications() 
	{
		return rtoOfficerService.viewAllPendingApplications();
	}
	
	@ApiOperation(value = "View Rejected Applications", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Operation Successful"),
			@ApiResponse(code = 401, message = "You do not have the authorization to access this resource"),
			@ApiResponse(code = 403, message = "Access to this resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource you are looking for does not exist/cannot be found")
	})
	@GetMapping("/view-rejected-application")
	@ExceptionHandler(RecordNotFoundException.class)
	public List<Application> viewAllRejectedApplications() 
	{
		return rtoOfficerService.viewAllRejectedApplications();
	}
	
	@ApiOperation(value = "View Approved Applications", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Operation Successful"),
			@ApiResponse(code = 401, message = "You do not have the authorization to access this resource"),
			@ApiResponse(code = 403, message = "Access to this resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource you are looking for does not exist/cannot be found")
	})
	@GetMapping("/view-approved-application")
	@ExceptionHandler(RecordNotFoundException.class)
	public List<Application> viewAllApprovedApplications( ) 
	{
		return rtoOfficerService.viewAllApprovedApplications();
	}
	
	@ApiOperation(value = "View Application By Id")
	@GetMapping("/view-applicationby-id/{applicationNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Application viewApplicationById(
			@ApiParam(value = "Application Number") @PathVariable("applicationNumber")String applicationNumber)
	{
		return rtoOfficerService.viewApplicationById(applicationNumber);
	}
	
	@ApiOperation(value = "View Challan By Vehicle Number")
	@GetMapping("/view-challanby-vehiclenumber/{vehicleNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public List<Challan> checkChallanByVehicleNumber(
			@ApiParam(value = "Vehicle Number") @PathVariable("vehicleNumber")String vehicleNumber)
	{
		return rtoOfficerService.checkChallanByVehicleNumber(vehicleNumber);
		
	}
	
	@ApiOperation(value = "View All Challans", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Operation Successful"),
			@ApiResponse(code = 401, message = "You do not have the authorization to access this resource"),
			@ApiResponse(code = 403, message = "Access to this resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource you are looking for does not exist/cannot be found")
	})
	@GetMapping("/check-all-challan")
	public List<Challan> checkAllChallan()
	{
		return rtoOfficerService.checkAllChallan();
	}
	
	@ApiOperation(value = "View All Appointments", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Operation Successful"),
			@ApiResponse(code = 401, message = "You do not have the authorization to access this resource"),
			@ApiResponse(code = 403, message = "Access to this resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource you are looking for does not exist/cannot be found")
	})
	@GetMapping("/view-all-appointment")
	public List<Appointment> viewAllAppointments()
	{
		return rtoOfficerService.viewAllAppointments();
		
	}
	
	@ApiOperation(value = "View All Applications", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Operation Successful"),
			@ApiResponse(code = 401, message = "You do not have the authorization to access this resource"),
			@ApiResponse(code = 403, message = "Access to this resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource you are looking for does not exist/cannot be found")
	})
	@GetMapping("/view-all-applications")
	public List<Application> viewAllApplications()
	{
		return rtoOfficerService.viewAllApplications();
		
	}
	
	@ApiOperation(value = "Modify Test Results")
	@PutMapping("/modify-test-results/{applicationNumber}-{testResult}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Appointment> modifyTestResults(
			@ApiParam(value = "Application Number") @PathVariable("applicationNumber") String applicationNumber, 
			@ApiParam(value = "Test Result Enum Value") @PathVariable("testResult") TestResult testResult)
	{
		if(testResult.toString().equals("PASS"))
			sendLicenseMail(applicationNumber, true);
		else
			sendLicenseMail(applicationNumber, false);
		return rtoOfficerService.modifyTestResultById(applicationNumber, testResult);
	}

	private String sendLicenseMail(String applicationNumber, boolean pass) {
		// TODO Auto-generated method stub
		return rtoOfficerService.emailLicense(applicationNumber, pass);
	}
	
}