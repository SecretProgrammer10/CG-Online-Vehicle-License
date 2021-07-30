package com.capgemini.onlinevehiclelicense.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.Appointment;
import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.model.License;
import com.capgemini.onlinevehiclelicense.model.RTOOfficer;
import com.capgemini.onlinevehiclelicense.repository.IApplicationRepository;
import com.capgemini.onlinevehiclelicense.repository.IAppointmentRepository;
import com.capgemini.onlinevehiclelicense.repository.IChallanRepository;
import com.capgemini.onlinevehiclelicense.repository.ILicenseRepository;
import com.capgemini.onlinevehiclelicense.repository.IRTOOfficerRepository;


@Service
public class RTOOfficerService implements IRTOOfficerService {

	@Autowired
	IRTOOfficerRepository rtoOfficerRepository;
	@Autowired
	IApplicationRepository applicationRepository;
	@Autowired
	IChallanRepository challanRepository;
	@Autowired
	ILicenseRepository licenseRepository;
	@Autowired
	IAppointmentRepository appointmentRepository;
	
	@Override
	public ResponseEntity<RTOOfficer> officeLogin(RTOOfficer officer) {
		// TODO Auto-generated method stub
		Optional<RTOOfficer> findOfficer = rtoOfficerRepository.findByEmail(officer.getEmail());
		try {
			if(findOfficer.isPresent())
			{
				System.out.println("logged in");
				return new ResponseEntity<RTOOfficer>(HttpStatus.OK);
			}
			else
			{
				throw new RecordNotFoundException("Invalid email or password");
			}
		}
		catch(RecordNotFoundException e)
		{
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
	public ResponseEntity<Appointment> modifyTestResultById(String applicationNumber, String testResult) {
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
			
			if(matchApplication.getStatus().equalsIgnoreCase("approved")) {
				License license = new License();
				license.setLicenseType("Learner");
				java.util.Date today=new java.util.Date(); 
				license.setDateOfIssue(today);
				Date validity = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 365 *5));
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
			if(matchApplication.getTestResult().equalsIgnoreCase("pass")) {
				License license = new License();
				license.setLicenseType("Driving");
				java.util.Date today=new java.util.Date(); 
				license.setDateOfIssue(today);
				Date validity = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 365 *5));
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
	public String emailLicense(License license) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Application viewApplicationById(String applicationNumber) {
		// TODO Auto-generated method stub
		try {
			return this.applicationRepository.findById(applicationNumber)
					.orElseThrow(() -> new RecordNotFoundException("Application does not Exist!!!"));
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