package com.capgemini.onlinevehiclelicense.service;

import com.capgemini.onlinevehiclelicense.model.Applicant;
import com.capgemini.onlinevehiclelicense.model.User;

public interface IApplicantService {

	public String addApplicant(Applicant applicant);
	public String updateApplicantDetails(Applicant applicant);
	public String removeApplicant(Applicant applicant);
	public String viewApplicantDetails(Applicant applicant);
}
