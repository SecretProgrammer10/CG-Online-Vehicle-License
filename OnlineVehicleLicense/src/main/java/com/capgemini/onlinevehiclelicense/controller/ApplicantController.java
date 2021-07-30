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
import com.capgemini.onlinevehiclelicense.model.Applicant;
import com.capgemini.onlinevehiclelicense.service.ApplicantService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
	
	@Autowired
	ApplicantService applicantService;
	@ApiOperation(value = "Add applicant profile")
	@PostMapping("/addApplicant")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<Applicant> addApplicant(@RequestBody Applicant applicant)
	{
		return applicantService.addApplicant(applicant);
	}
	@ApiOperation(value = "Update applicant profile")
	@PutMapping("/updateApplicant")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Applicant> updateApplicantDetails(@RequestBody Applicant applicant)
	{
		return applicantService.updateApplicantDetails(applicant);
	}
	@ApiOperation(value = "Remove applicant profile")
	@DeleteMapping("/removeApplicant/{applicantNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Applicant> removeApplicant(@PathVariable String applicantNumber)
	{
		return applicantService.removeApplicant(applicantNumber);
	}
	@ApiOperation(value = "View applicant profile by id")
	@GetMapping("/viewApplicant/{applicantNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public String viewApplicantById(@PathVariable String applicantNumber)
	{
		return applicantService.viewApplicantById(applicantNumber);
	}
}
