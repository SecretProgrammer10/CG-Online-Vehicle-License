package com.capgemini.onlinevehiclelicense.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.Appointment;
import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.model.License;
import com.capgemini.onlinevehiclelicense.model.RTOOfficer;
import com.capgemini.onlinevehiclelicense.model.TestResult;
import com.capgemini.onlinevehiclelicense.service.ILicenseService;
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
	
	@Autowired
	private ILicenseService licenseService;
	
	@ApiOperation(value = "Add new RTO_Officer")
	@PostMapping("{rtoId}/add-rto-officer")
	public ResponseEntity<String> addRTOOfficer(@PathVariable("rtoId") int rtoId ,@RequestBody RTOOfficer officer){
		return this.rtoOfficerService.addRTOOfficer(rtoId, officer);
	}
	
	@ApiOperation(value = "Login RTO_Officer")
	@PostMapping("/login-rto-officer")
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
	public List<Application> viewAllApprovedApplications( ) 
	{
		return rtoOfficerService.viewAllApprovedApplications();
	}
	
	@ApiOperation(value = "View Application By Id")
	@GetMapping("/view-applicationby-id/{applicationNumber}")
	public Application viewApplicationById(
			@ApiParam(value = "Application Number") @PathVariable("applicationNumber")String applicationNumber)
	{
		return rtoOfficerService.viewApplicationById(applicationNumber);
	}
	
	@ApiOperation(value = "View Challan By Vehicle Number")
	@GetMapping("/view-challanby-vehiclenumber/{vehicleNumber}")
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
	public Page<Appointment> viewAllAppointments(Pageable pageable)
	{
		return rtoOfficerService.viewAllAppointments(pageable);
		
	}
	
	@ApiOperation(value = "View All Applications", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Operation Successful"),
			@ApiResponse(code = 401, message = "You do not have the authorization to access this resource"),
			@ApiResponse(code = 403, message = "Access to this resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource you are looking for does not exist/cannot be found")
	})
	@GetMapping("/view-all-applications")
	public Page<Application> viewAllApplications(Pageable pageable)
	{
		return rtoOfficerService.viewAllApplications(pageable);
		
	}
	
	@ApiOperation(value = "Modify Test Results")
	@PutMapping("/modify-test-results/{testResult}")
	public ResponseEntity<String> modifyTestResults(
			@ApiParam(value = "Application Number") @RequestParam String applicantNumber, 
			@ApiParam(value = "Test Result Enum Value") @PathVariable("testResult") TestResult testResult)
	{
		return rtoOfficerService.modifyTestResultById(applicantNumber, testResult);
	}

	private String sendLicenseMail(String applicationNumber, boolean pass) {
		// TODO Auto-generated method stub
		return rtoOfficerService.emailLicense(applicationNumber, pass);
	}
	
	@ApiOperation(value = "Issue Learner License")
	@PostMapping("/issue-learner-license")
	public ResponseEntity<String> issueLicense(@RequestParam String applicationNumber, @RequestParam int rtoId, 
			@RequestBody License license){
		sendLicenseMail(applicationNumber, true);
		return this.licenseService.issueLearnerLicense(rtoId, applicationNumber, license);
	}
	
	@ApiOperation(value = "Issue Driver License")
	@PostMapping("/issue-driver-license")
	public ResponseEntity<String> issueDriverLicense(@RequestParam String applicationNumber, @RequestParam String licenseNumber){
		sendLicenseMail(applicationNumber, true);
		return this.licenseService.issueDriverLicense(licenseNumber);
	}
	
	@ApiOperation(value = "Renew License")
	@PutMapping("/renew-license")
	public ResponseEntity<String> renewLicense(@RequestParam String applicationNumber, 
			@RequestParam String licenseNumber, @RequestParam Date dateOfIssue, 
			@RequestBody Date validTill){
		sendLicenseMail(applicationNumber, true);
		return this.licenseService.renewLicense(licenseNumber, dateOfIssue, validTill);
	}
	
	@ApiOperation(value = "Delete License")
	@DeleteMapping("/delete-license")
	public ResponseEntity<String> deleteLicense(@RequestParam String licenseNumber){
		return this.licenseService.deleteLicense(licenseNumber);
	}
}