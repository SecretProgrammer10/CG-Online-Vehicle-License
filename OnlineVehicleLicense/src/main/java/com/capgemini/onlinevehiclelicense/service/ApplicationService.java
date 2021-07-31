package com.capgemini.onlinevehiclelicense.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
//import com.capgemini.onlinevehiclelicense.model.Applicant;
import com.capgemini.onlinevehiclelicense.model.Application;
//import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.repository.IApplicationRepository;

@Service
public class ApplicationService implements IApplicationService{
	
	@Autowired
	IApplicationRepository applicationRepo;

	@Override
	public ResponseEntity<Application> createApplication(Application application) {
		Optional<Application> findApplication = applicationRepo.findById(application.getApplicationNumber());
		try {
			if(!findApplication.isPresent())
			{
				applicationRepo.save(application);
				return new ResponseEntity<Application>(HttpStatus.OK);
			}
			else
			{
				throw new RecordAlreadyPresentException("Application already exists");
			}
		}
		catch(RecordAlreadyPresentException e)
		{
			return new ResponseEntity<Application>(HttpStatus.ALREADY_REPORTED);
		}
	}

	@Override
	public String viewApplicationById(String applicationNumber) {
		try {		
			Application findUser = applicationRepo.findById(applicationNumber).orElseThrow(() -> new RecordNotFoundException("Application not found"));
				return findUser.toString();
		}
		catch(RecordNotFoundException e)
		{
			return e.getMessage();
		}
	}

	@Override
	public ResponseEntity<Application> updateApplication(Application application) {
		Optional<Application> findUser = applicationRepo.findById(application.getApplicationNumber());
		try {
			if(findUser.isPresent())
			{
				applicationRepo.save(application);
				return new ResponseEntity<Application>(HttpStatus.OK);
			}
			else
			{
				throw new RecordNotFoundException("Application not found");
			}
		}
		catch(RecordNotFoundException e)
		{
			return new ResponseEntity<Application>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<Application> deleteApplicationById(String applicationNumber) {
		try {
				Application findUser = applicationRepo.findById(applicationNumber).orElseThrow(() -> new RecordNotFoundException("Application not found"));
				this.applicationRepo.delete(findUser);
				return new ResponseEntity<Application>(HttpStatus.OK);
		}
		catch(RecordNotFoundException e)
		{
			return new ResponseEntity<Application>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public String checkModeOfPayment(String applicationNumber) {
		try {
			Application findUser = applicationRepo.findById(applicationNumber).orElseThrow(() -> new RecordNotFoundException("Application not found"));
			return findUser.getModeOfPayment();
		}
		catch(RecordNotFoundException e)
		{
			return e.getMessage();
		}
	}

	@Override
	public ResponseEntity<Application> payAmount(String applicationNumber, Double amountPaid) {
		try {
			Application findUser = applicationRepo.findById(applicationNumber).orElseThrow(() -> new RecordNotFoundException("Application not found"));
			findUser.setPaymentStatus("Paid");
			findUser.setAmountPaid(amountPaid);
			return new ResponseEntity<Application>(HttpStatus.OK);
	}
	catch(RecordNotFoundException e)
	{
		return new ResponseEntity<Application>(HttpStatus.NOT_FOUND);
	}
	}

	@Override
	public String viewPaymentStatus(String applicationNumber) {
		try {
			Application findUser = applicationRepo.findById(applicationNumber).orElseThrow(() -> new RecordNotFoundException("Application not found"));
			return findUser.getPaymentStatus(); 
		}
		catch(RecordNotFoundException e)
		{
			return e.getMessage();
		}
	}
	
	
}
