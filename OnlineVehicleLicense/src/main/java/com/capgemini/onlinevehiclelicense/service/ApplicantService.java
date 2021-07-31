package com.capgemini.onlinevehiclelicense.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Applicant;
//import com.capgemini.onlinevehiclelicense.model.Application;
//import com.capgemini.onlinevehiclelicense.model.Users;
import com.capgemini.onlinevehiclelicense.repository.IApplicantRepository;

@Service
public class ApplicantService implements IApplicantService{
	@Autowired
	IApplicantRepository applicantRepo;
	@Override
	public ResponseEntity<Applicant> addApplicant(Applicant applicant){
		Optional<Applicant> findUser = applicantRepo.findById(applicant.getApplicantNumber());
		try {
			if(!findUser.isPresent())
			{
				applicantRepo.save(applicant);
				return new ResponseEntity<Applicant>(HttpStatus.OK);
			}
			else
			{
				throw new RecordAlreadyPresentException("This applicant profile is already in use");
			}
		}
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<Applicant>(HttpStatus.ALREADY_REPORTED);
		}
	}
	@Override
	public ResponseEntity<Applicant> updateApplicantDetails(Applicant applicant) {
		Optional<Applicant> findUser = applicantRepo.findById(applicant.getApplicantNumber());
		try {
			if(!findUser.isPresent())
			{
				applicantRepo.save(applicant);
				return new ResponseEntity<Applicant>(HttpStatus.OK);
			}
			else
			{
				throw new RecordNotFoundException("Applicant profile not found");
			}
		}
		catch(RecordNotFoundException e)
		{
			return new ResponseEntity<Applicant>(HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public ResponseEntity<Applicant> removeApplicant(String applicantNumber) {
		
		try {
				Applicant findUser = applicantRepo.findById(applicantNumber).orElseThrow(() -> new RecordNotFoundException("Application not found"));
				this.applicantRepo.delete(findUser);
				return new ResponseEntity<Applicant>(HttpStatus.OK);
		}
		catch(RecordNotFoundException e)
		{
			return new ResponseEntity<Applicant>(HttpStatus.NOT_FOUND);
		}
	}
	@Override
	public String viewApplicantById(String applicantNumber) {
		try {		
			Applicant findUser = applicantRepo.findById(applicantNumber).orElseThrow(() -> new RecordNotFoundException("Applicant profile not found"));
				return findUser.toString();
		}
		catch(RecordNotFoundException e)
		{
			return e.getMessage();
		}
	}

}
