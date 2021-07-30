package com.capgemini.onlinevehiclelicense.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.Applicant;
import com.capgemini.onlinevehiclelicense.model.User;

public interface IApplicantService {

	public ResponseEntity<Applicant> addApplicant(Applicant applicant);
	public ResponseEntity<Applicant> updateApplicantDetails(Applicant applicant);
	public ResponseEntity<Applicant> removeApplicant(String applicantNumber);
	public String viewApplicantById(String applicantNumber);
}
