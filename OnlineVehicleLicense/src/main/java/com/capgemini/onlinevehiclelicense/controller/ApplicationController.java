package com.capgemini.onlinevehiclelicense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.service.ApplicationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins = "http://localhost:4205")
@RestController
@RequestMapping("/user")
@Api(value = "Online Vehicle License")
@Validated
public class ApplicationController {

	@Autowired
	ApplicationService applicationService;
	
	@ApiOperation(value = "Create application")
	@PostMapping("/{username}/application/{rtoOffice}/createApplication")
	public ResponseEntity<String> createApplication(@PathVariable("rtoOffice") int rtoId, @PathVariable("username") String username, @RequestBody Application application) {
		return applicationService.createApplication(rtoId, username, application);
	}
	
	@ApiOperation(value = "View application by id")
	@GetMapping("/viewApplication/{applicationNumber}")
	public Application viewApplicationById(
			@ApiParam(value = "Application Number Param") @PathVariable("applicationNumber") String applicationNumber) {
		return applicationService.viewApplicationById(applicationNumber);
	}
/*	
	@ApiOperation(value = "Update application")
	@PutMapping("/updateApplication/{applicationNumber}")
	public ResponseEntity<String> updateApplication(@RequestBody Application application, @PathVariable("applicationNumber") String applicationNumber) {
		return applicationService.updateApplication(application,applicationNumber);
	}
*/	
	@ApiOperation(value = "Remove application")
	@DeleteMapping("/removeApplication/{applicationNumber}")
	public ResponseEntity<String> deleteApplicationById(
			@ApiParam(value = "Application Number Param") @PathVariable("applicationNumber") String applicationNumber) {
		return applicationService.deleteApplicationById(applicationNumber);
	}
	
	@ApiOperation(value = "Check mode of payment")
	@GetMapping("/paymentMode/{applicationNumber}")
	public String checkModeOfPayment(
			@ApiParam(value = "Application Number Param") @PathVariable("applicationNumber") String applicationNumber) {
		return applicationService.checkModeOfPayment(applicationNumber);
	}
	@ApiOperation(value = "Pay amount")
	@PutMapping("/payAmount/{applicationNumber}/{amountPaid}")
	public ResponseEntity<String> payAmount(
			@ApiParam(value = "Application Number Param")  @PathVariable("applicationNumber") String applicationNumber, 
			@ApiParam(value = "Amount to be paid") @PathVariable Double amountPaid) {
		return applicationService.payAmount(applicationNumber, amountPaid);
	}
	@ApiOperation(value = "View payment status")
	@GetMapping("/payAmount/{applicationNumber}")
	public String viewPaymentStatus(
			@ApiParam(value = "Application Number Param") @PathVariable("applicationNumber") String applicationNumber) {
		return applicationService.viewPaymentStatus(applicationNumber);
	}
	@GetMapping("/application/view-application/{applicationNumber}")
	public Application viewLLApplicationById(@PathVariable("applicationNumber") String username) {
		return applicationService.viewLLApplicationById(username);
	}
	@GetMapping("/application/view-application/{applicationNumber}")
	public Application viewDLApplicationById(@PathVariable("applicationNumber") String username) {
		return applicationService.viewDLApplicationById(username);
	}
	
}
