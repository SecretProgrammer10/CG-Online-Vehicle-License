package com.capgemini.onlinevehiclelicense.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.mail.IMailService;
import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.Appointment;
import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.model.License;
import com.capgemini.onlinevehiclelicense.model.LicenseType;
import com.capgemini.onlinevehiclelicense.model.RTOOfficer;
import com.capgemini.onlinevehiclelicense.model.TestResult;
import com.capgemini.onlinevehiclelicense.repository.IApplicationRepository;
import com.capgemini.onlinevehiclelicense.repository.IAppointmentRepository;
import com.capgemini.onlinevehiclelicense.repository.IChallanRepository;
import com.capgemini.onlinevehiclelicense.repository.ILicenseRepository;
import com.capgemini.onlinevehiclelicense.repository.IRTOOfficerRepository;


@Service
public class RTOOfficerService implements IRTOOfficerService {

	@Autowired
	private IRTOOfficerRepository rtoOfficerRepository;
	@Autowired
	private IApplicationRepository applicationRepository;
	@Autowired
	private IChallanRepository challanRepository;
	@Autowired
	private ILicenseRepository licenseRepository;
	@Autowired
	private IAppointmentRepository appointmentRepository;
	@Autowired
	private IMailService mailService;
	
	@Override
	public ResponseEntity<RTOOfficer> officeLogin(String username, String pass) {
		// TODO Auto-generated method stub
		//Optional<RTOOfficer> findOfficer = rtoOfficerRepository.findById(username);
		try {
			if(username.equals("user"))
			{
				if(pass.equals("pass")) {
					System.out.println("logged in");
					return new ResponseEntity<RTOOfficer>(HttpStatus.OK);
				}
				else
				{
					throw new RecordNotFoundException("Invalid password");
				}
			}
			else
			{
				throw new RecordNotFoundException("Invalid email");
			}
		}
		catch(RecordNotFoundException e)
		{
			System.out.println("Error!!!");
			return  new ResponseEntity<RTOOfficer>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Application> viewAllPendingApplications() {
		// TODO Auto-generated method stub
		return rtoOfficerRepository.viewPendingApplications();
	}

	@Override
	public List<Application> viewAllRejectedApplications() {
		// TODO Auto-generated method stub
		return rtoOfficerRepository.viewAllRejectedApplications();
	}

	@Override
	public List<Application> viewAllApprovedApplications() {
		
		return rtoOfficerRepository.viewApprovedApplications();

	}

	@Override
	public List<Challan> checkAllChallan() {
		// TODO Auto-generated method stub
		return this.challanRepository.findAll();
	}

	@Override
	public ResponseEntity<Appointment> modifyTestResultById(String applicationNumber, TestResult testResult) {
		// TODO Auto-generated method stub
		try {
			Appointment findApplication = this.appointmentRepository.findById(applicationNumber)
					.orElseThrow(() -> new RecordNotFoundException("No such application found!!!"));
			findApplication.setTestResult(testResult);
			this.appointmentRepository.save(findApplication);
			return new ResponseEntity<Appointment>(HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		}
	}

	
	@Override
	public ResponseEntity<License> generateLearnerLicense(String applcationNumber) {
		Application matchApplication;
		try {
			matchApplication = this.applicationRepository.findById(applcationNumber)
					.orElseThrow(() -> new RecordNotFoundException("Application Not Found!!!"));
			
			if(matchApplication.getStatus().toString().equalsIgnoreCase("approved")) {
				License license = new License();
				license.setLicenseType(LicenseType.LL);
				java.util.Date today=new java.util.Date(); 
				license.setDateOfIssue(today);
				Date validity = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 365 * 20));
				license.setValidTill(validity);
				this.licenseRepository.save(license);
			}
			return new ResponseEntity<License>(HttpStatus.CREATED);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<License>(HttpStatus.NOT_FOUND);
		}
				
	}


	@Override
	public ResponseEntity<License> generateDrivingLicense(String applcationNumber) {
		// TODO Auto-generated method stub
		try {
			Appointment matchApplication = this.appointmentRepository.findById(applcationNumber)
					.orElseThrow(() -> new RecordNotFoundException("Application Not Found!!!"));
			if(matchApplication.getTestResult().toString().equalsIgnoreCase("pass")) {
				License license = new License();
				license.setLicenseType(LicenseType.DL);
				java.util.Date today=new java.util.Date(); 
				license.setDateOfIssue(today);
				Date validity = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 365 * 20));
				license.setValidTill(validity);
				this.licenseRepository.save(license);
				return new ResponseEntity<License>(HttpStatus.CREATED);
			}
		} catch(RecordNotFoundException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<License>(HttpStatus.NOT_FOUND);
	}

	@Override
	public String emailLicense(String applicationNumber, boolean pass) {
		// TODO Auto-generated method stub
		String toAddress = this.applicationRepository.findById(applicationNumber)
				.get().getApplicant().getUsers().getEmail();
		String subject = "Your License";
		if(pass == true) {
			String message = "Application Number: " + applicationNumber + "\nYou have Successfully "
					+ "passed the License Test.\n Your License has been attached below.";
			mailService.sendMailWithAttachement(toAddress, subject, message, "License.txt");
		}
		else {
			String message = "Application Number: " + applicationNumber + "\nWe regret to inform you that "
					+ "you have not passed your license exam.";
			mailService.sendNormalMail(toAddress, subject, message);
		}
		return applicationNumber;
	}

	@Override
	public Application viewApplicationById(String applicationNumber) {
		// TODO Auto-generated method stub
		try {
			return this.applicationRepository.findById(applicationNumber)
					.orElseThrow(() -> new RecordNotFoundException("Application does not exist!!!"));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Challan> checkChallanByVehicleNumber(String vehicleNumber) {
		// TODO Auto-generated method stub
		try {
			List<Challan> findChallan = this.rtoOfficerRepository.checkAllChallanByVehicleNumber(vehicleNumber);

			if(findChallan != null) {
				return findChallan;
			}
			else
				throw new RecordNotFoundException("Vehicle Number Does not Match");
		}catch(RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Appointment> viewAllAppointments() {
		// TODO Auto-generated method stub
		
		return this.appointmentRepository.findAll();
	}
	
	@Override
	public List<Application> viewAllApplications() {
		// TODO Auto-generated method stub
		return this.applicationRepository.findAll();
	}

	
}