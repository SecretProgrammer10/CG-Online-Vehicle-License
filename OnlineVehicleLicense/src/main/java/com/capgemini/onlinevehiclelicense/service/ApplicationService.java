package com.capgemini.onlinevehiclelicense.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Applicant;
import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.ApplicationStatus;
import com.capgemini.onlinevehiclelicense.model.Documents;
import com.capgemini.onlinevehiclelicense.model.RTOOffice;
import com.capgemini.onlinevehiclelicense.model.Users;
import com.capgemini.onlinevehiclelicense.repository.IApplicantRepository;
import com.capgemini.onlinevehiclelicense.repository.IApplicationRepository;
import com.capgemini.onlinevehiclelicense.repository.IRTOOfficeRepository;
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
	private IRTOOfficeRepository rtoOfficeRepository;

	@Override
	public ResponseEntity<String> createApplication(int rtoId, String username, Application application) {
		RTOOffice rtoofc;
		
		try {
			rtoofc = this.rtoOfficeRepository.findById(rtoId)
					.orElseThrow(() -> new RecordNotFoundException("RTO Office with the RtoId:"+rtoId+" not found"));

		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		Optional<Users> user = this.userRepository.findById(username);
		if(user.isPresent()) {
			Optional<Applicant> applicant = this.applicantRepository.findById(username);
			if(applicant.isPresent()) {
				Documents docs = new Documents();
				if(application.getApplicationType().toString().equals("LL")) {
					application.setApplicationStatus(ApplicationStatus.APPROVED);
					application.setApplicationNumber(username+"LL");
					docs.setId(username+"LL");
				}
				else {
					application.setApplicationStatus(ApplicationStatus.PENDING);
					application.setApplicationNumber(username+"DL");
					docs.setId(username+"DL");
				}
				
				application.setPaymentStatus("PAID");
				application.setRtoOffice(rtoofc);
				application.setApplicant(applicant.get());
				System.out.println(application.getApplicationNumber());

				
				
//				docs.setIdProof(application.getDocs().getIdProof());
//				docs.setPhoto(application.getDocs().getPhoto());
//				docs.setAddressProof(application.getDocs().getAddressProof());
				docs.setApplication(application);
				application.setDocs(docs);
				this.applicationRepository.save(application);

				return new ResponseEntity<String>("Application submitted successfully",HttpStatus.OK);
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
			Application findUser = applicationRepository.findById(applicationNumber).
					orElseThrow(() -> new RecordNotFoundException("Application not found"));
			return findUser;
		}
		catch(RecordNotFoundException e)
		{
			e.getMessage();
			return null;
		}
	}

/*	@Override
	public ResponseEntity<String> updateApplication(Application application, String applicationNumber) {
		Optional<Application> findApplication = applicationRepository.findById(applicationNumber);
		try {
			if(findApplication.isPresent())
			{
				Application app = findApplication.get();
				app.setAmountPaid(null);
				app.app
				applicationRepository.save(application);
				return new ResponseEntity<String>("Application updated successfully",HttpStatus.OK);
			}
			else
			{
				throw new RecordNotFoundException("Application not found");
			}
		}
		catch(RecordNotFoundException e)
		{
			return new ResponseEntity<String>(e.getMessage() ,HttpStatus.NOT_FOUND);
		}
	}
*/
	@Override
	public ResponseEntity<String> deleteApplicationById(String applicationNumber) {
		try {
			Application findApplication = applicationRepository.findById(applicationNumber).orElseThrow(() -> new RecordNotFoundException("Application not found"));
			this.applicationRepository.delete(findApplication);
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
			Application findApplication = applicationRepository.findById(applicationNumber).orElseThrow(() -> new RecordNotFoundException("Application not found"));
			return findApplication.getModeOfPayment();
		}
		catch(RecordNotFoundException e)
		{
			return e.getMessage();
		}
	}

	@Override
	public ResponseEntity<String> payAmount(String applicationNumber, Double amountPaid) {
		try {
			Application findApplication = applicationRepository.findById(applicationNumber).orElseThrow(() -> new RecordNotFoundException("Application not found"));
			findApplication.setPaymentStatus("Paid");
			findApplication.setAmountPaid(amountPaid);
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
			Application findApplication = applicationRepository.findById(applicationNumber).orElseThrow(() -> new RecordNotFoundException("Application not found"));
			return findApplication.getPaymentStatus(); 
		}
		catch(RecordNotFoundException e)
		{
			return e.getMessage();
		}
	}
	
	@Override
	public Application viewLLApplicationById(String username) {
		try {
			Application findLLApplication = applicationRepository.findById(username).orElseThrow(() -> new RecordNotFoundException("Application not found"));
			return findLLApplication;
		} catch(RecordNotFoundException e) {
			e.getMessage();
			return null;
		}
	}
	
	@Override
	public Application viewDLApplicationById(String username) {
		try {
			Application findDLApplication = applicationRepository.findById(username).orElseThrow(() -> new RecordNotFoundException("Application not found"));
			return findDLApplication;
		} catch(RecordNotFoundException e) {
			e.getMessage();
			return null;
		}
	}

}
