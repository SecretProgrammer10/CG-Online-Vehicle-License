package com.capgemini.onlinevehiclelicense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Applicant;
import com.capgemini.onlinevehiclelicense.service.ApplicantService;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
	
	@Autowired
	ApplicantService applicantService;
	
	@PostMapping("/addApplicant")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public void addApplicant(@RequestBody Applicant applicant)
	{
		applicantService.addApplicant(applicant);
	}
	@PutMapping("/updateApplicant")
	@ExceptionHandler(RecordNotFoundException.class)
	public void updateApplicantDetails(@RequestBody Applicant applicant)
	{
		applicantService.updateApplicantDetails(applicant);
	}
	@DeleteMapping("/removeApplicant")
	@ExceptionHandler(RecordNotFoundException.class)
	public void removeApplicant(@RequestBody String applicantNumber)
	{
		applicantService.removeApplicant(applicantNumber);
	}
	@GetMapping("/viewApplicant")
	@ExceptionHandler(RecordNotFoundException.class)
	public void viewApplicantById(@RequestBody String applicantNumber)
	{
		applicantService.viewApplicantById(applicantNumber);
	}
}
