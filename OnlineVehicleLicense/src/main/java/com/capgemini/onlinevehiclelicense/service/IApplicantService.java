package com.capgemini.onlinevehiclelicense.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.Applicant;
//import com.capgemini.onlinevehiclelicense.model.Users;

public interface IApplicantService {

	public ResponseEntity<String> addApplicant(String username, Applicant applicant);
	public ResponseEntity<String> updateApplicantDetails(String username, Applicant applicant);
	public ResponseEntity<String> removeApplicant(String applicantNumber);
	public Applicant viewApplicantById(String applicantNumber);
}
