package com.capgemini.onlinevehiclelicense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.Documents;
import com.capgemini.onlinevehiclelicense.service.ApplicationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("user/{username}/application")
@Api(value = "Online Vehicle License")
@Validated
public class ApplicationController {

	@Autowired
	ApplicationService applicationService;
	
	@ApiOperation(value = "Create application")
	@PostMapping("/createApplication")
	public ResponseEntity<String> createApplication(@PathVariable("username") String username, @RequestBody Application application) {
		return applicationService.createApplication(username, application);
	}
	
	@ApiOperation(value = "View application by id")
	@GetMapping("/viewApplication/{applicationNumber}")
	public Application viewApplicationById(@PathVariable("username") String username,
			@ApiParam(value = "Application Number Param") @PathVariable String applicationNumber) {
		return applicationService.viewApplicationById(applicationNumber);
	}
	
	@ApiOperation(value = "Update application")
	@PutMapping("/updateApplication/{applicationNumber}")
	public ResponseEntity<String> updateApplication(@PathVariable("username") String username, @RequestBody Application application, @PathVariable("applicationNumber") String applicationNumber) {
		return applicationService.updateApplication(application);
	}
	
	@ApiOperation(value = "Remove application")
	@DeleteMapping("/removeApplication/{applicationNumber}")
	public ResponseEntity<String> deleteApplicationById(@PathVariable("username") String username,
			@ApiParam(value = "Application Number Param") @PathVariable String applicationNumber) {
		return applicationService.deleteApplicationById(applicationNumber);
	}
	
	@ApiOperation(value = "Check mode of payment")
	@GetMapping("/paymentMode/{applicationNumber}")
	public String checkModeOfPayment(@PathVariable("username") String username,
			@ApiParam(value = "Application Number Param") @PathVariable String applicationNumber) {
		return applicationService.checkModeOfPayment(applicationNumber);
	}
	@ApiOperation(value = "Pay amount")
	@PutMapping("/payAmount/{applicationNumber}/{amountPaid}")
	public ResponseEntity<String> payAmount(@PathVariable("username") String username,
			@ApiParam(value = "Application Number Param")  @PathVariable String applicationNumber, 
			@ApiParam(value = "Amount to be paid") @PathVariable Double amountPaid) {
		return applicationService.payAmount(applicationNumber, amountPaid);
	}
	@ApiOperation(value = "View payment status")
	@GetMapping("/payAmount/{applicationNumber}")
	public String viewPaymentStatus(@PathVariable("username") String username,
			@ApiParam(value = "Application Number Param") @PathVariable String applicationNumber) {
		return applicationService.viewPaymentStatus(applicationNumber);
	}
}
