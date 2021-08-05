package com.capgemini.onlinevehiclelicense.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Applicant;
//import com.capgemini.onlinevehiclelicense.model.Applicant;
import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.ApplicationStatus;
import com.capgemini.onlinevehiclelicense.model.Documents;
import com.capgemini.onlinevehiclelicense.model.Users;
import com.capgemini.onlinevehiclelicense.repository.IApplicantRepository;
//import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.repository.IApplicationRepository;
import com.capgemini.onlinevehiclelicense.repository.IDocumentsRepository;
import com.capgemini.onlinevehiclelicense.repository.IUserRepository;

@Service
public class ApplicationService implements IApplicationService{
	
	@Autowired
	private IApplicationRepository applicationRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IApplicantRepository applicantRepository;
	
	@Autowired
	private IDocumentsRepository documentsRepository;
	
	@Override
	public ResponseEntity<String> createApplication(String username, Application application) {
		Optional<Users> user = this.userRepository.findById(username);
		if(user.isPresent()) {
			Optional<Applicant> applicant = this.applicantRepository.findById(username);
			if(applicant.isPresent()) {
				//Optional<Application> findApplication = applicationRepository.findById(application.getApplicationNumber());
				//try {
					//if(/*!findApplication.isPresent()*/true)
					//{
						application.setApplicationStatus(ApplicationStatus.PENDING);
						application.setApplicationNumber(username);
						
						Documents docs = new Documents();
						docs.setId(username);
						docs.setIdProof(application.getDocs().getIdProof());
						docs.setPhoto(application.getDocs().getPhoto());
						docs.setAddressProof(application.getDocs().getAddressProof());
						docs.setApplication(application);
						application.setDocs(docs);
						this.applicationRepository.save(application);
						
						this.documentsRepository.save(docs);
						/*Documents docs = new Documents();
						if(application.getApplicationNumber()==null) {
							System.out.println("null");
						}
						else {
							System.out.println("else");
						}
						docs.setId(application.getApplicationNumber());
						docs.setIdProof(application.getDocs().getIdProof());
						docs.setPhoto(application.getDocs().getPhoto());
						docs.setAddressProof(application.getDocs().getAddressProof());
						docs.setApplication(application);
						this.documentsRepository.save(docs);*/
						return new ResponseEntity<String>("Application submitted successfully\nApplication number: +application.getApplicationNumber()+\nDocuments Id: +docs.getId()",HttpStatus.OK);
					//}
				/*	else
					{
						throw new RecordAlreadyPresentException("Application already exists");
					}
				}
				catch(RecordAlreadyPresentException e)
				{
					return new ResponseEntity<String>(e.getMessage(),HttpStatus.ALREADY_REPORTED);
				}*/
			} else {
				return new ResponseEntity<String>("Applicant profile for the username:"+username+" not found",HttpStatus.NOT_FOUND); 
			}		
		}
		else {
			return new ResponseEntity<String>("User with the username:"+username+" not found",HttpStatus.NOT_FOUND);
		}	
	}

	@Override
	public Application viewApplicationById(String applicationNumber) {
		try {		
			Application findUser = applicationRepository.findById(applicationNumber).orElseThrow(() -> new RecordNotFoundException("Application not found"));
				return findUser;
		}
		catch(RecordNotFoundException e)
		{
			e.getMessage();
			return null;
		}
	}

	@Override
	public ResponseEntity<String> updateApplication(Application application) {
		Optional<Application> findUser = applicationRepository.findById(application.getApplicationNumber());
		try {
			if(findUser.isPresent())
			{
				applicationRepository.save(application);
				return new ResponseEntity<String>(HttpStatus.OK);
			}
			else
			{
				throw new RecordNotFoundException("Application not found");
			}
		}
		catch(RecordNotFoundException e)
		{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<String> deleteApplicationById(String applicationNumber) {
		try {
				Application findUser = applicationRepository.findById(applicationNumber).orElseThrow(() -> new RecordNotFoundException("Application not found"));
				this.applicationRepository.delete(findUser);
				return new ResponseEntity<String>(HttpStatus.OK);
		}
		catch(RecordNotFoundException e)
		{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public String checkModeOfPayment(String applicationNumber) {
		try {
			Application findUser = applicationRepository.findById(applicationNumber).orElseThrow(() -> new RecordNotFoundException("Application not found"));
			return findUser.getModeOfPayment();
		}
		catch(RecordNotFoundException e)
		{
			return e.getMessage();
		}
	}

	@Override
	public ResponseEntity<String> payAmount(String applicationNumber, Double amountPaid) {
		try {
			Application findUser = applicationRepository.findById(applicationNumber).orElseThrow(() -> new RecordNotFoundException("Application not found"));
			findUser.setPaymentStatus("Paid");
			findUser.setAmountPaid(amountPaid);
			return new ResponseEntity<String>(HttpStatus.OK);
	}
	catch(RecordNotFoundException e)
	{
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	}

	@Override
	public String viewPaymentStatus(String applicationNumber) {
		try {
			Application findUser = applicationRepository.findById(applicationNumber).orElseThrow(() -> new RecordNotFoundException("Application not found"));
			return findUser.getPaymentStatus(); 
		}
		catch(RecordNotFoundException e)
		{
			return e.getMessage();
		}
	}
	
	
}
