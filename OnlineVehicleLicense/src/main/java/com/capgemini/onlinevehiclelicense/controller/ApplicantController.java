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

import com.capgemini.onlinevehiclelicense.model.Applicant;
import com.capgemini.onlinevehiclelicense.service.ApplicantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(value = "Online Vehicle License")
@Validated
public class ApplicantController {
	
	@Autowired
	ApplicantService applicantService;
	
	@ApiOperation(value = "Add applicant profile")
	@PostMapping("/{username}/add-applicant-profile")
	public ResponseEntity<String> addApplicant(@PathVariable("username") String username, @RequestBody Applicant applicant)
	{
		return applicantService.addApplicant(username, applicant);
	}
	
	@ApiOperation(value = "Update applicant profile")
	@PutMapping("/{username}/update-applicant-profile")
	public ResponseEntity<String> updateApplicantDetails(@PathVariable("username") String username, @RequestBody Applicant applicant)
	{
		return applicantService.updateApplicantDetails(username, applicant);
	}
	
	@ApiOperation(value = "Remove applicant profile")
	@DeleteMapping("/{username}/remove-applicant-profile")
	public ResponseEntity<String> removeApplicant(@PathVariable("username") String username)
	{
		return applicantService.removeApplicant(username);
	}
	
	@ApiOperation(value = "View applicant profile by id")
	@GetMapping("/{username}/view-applicant-profile")
	public Applicant viewApplicantById(@PathVariable("username") String username)
	{
		return applicantService.viewApplicantById(username);
	}
}
