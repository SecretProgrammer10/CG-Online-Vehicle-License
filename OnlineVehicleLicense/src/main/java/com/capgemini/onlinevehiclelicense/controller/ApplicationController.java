package com.capgemini.onlinevehiclelicense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.service.ApplicationService;

@RestController
@RequestMapping("/application")
public class ApplicationController {

	@Autowired
	ApplicationService applicationService;
	
	@PostMapping("/createApplication")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void createApplication(@RequestBody Application application) {
		applicationService.createApplication(application);
	}
	@GetMapping("/viewApplication/{applicationNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void viewApplicationById(@PathVariable String applicationNumber) {
		applicationService.viewApplicationById(applicationNumber);
	}
	@PutMapping("/updateApplication")
	@ExceptionHandler(RecordNotFoundException.class)
	public void updateApplication(@RequestBody Application application) {
		applicationService.updateApplication(application);
	}
	@DeleteMapping("/removeApplication/{applicationNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void deleteApplicationById(@PathVariable String applicationNumber) {
		applicationService.deleteApplicationById(applicationNumber);
	}
	@GetMapping("/paymentMode/{applicationNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void checkModeOfPayment(@PathVariable String applicationNumber) {
		applicationService.checkModeOfPayment(applicationNumber);
	}
	@PutMapping("/payAmount/{applicationNumber}/{amountPaid}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void payAmount(@PathVariable String applicationNumber, @PathVariable Double amountPaid) {
		applicationService.payAmount(applicationNumber, amountPaid);
	}
	@GetMapping("/payAmount/{applicationNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void viewPaymentStatus(@PathVariable String applicationNumber) {
		applicationService.viewPaymentStatus(applicationNumber);
	}
}
