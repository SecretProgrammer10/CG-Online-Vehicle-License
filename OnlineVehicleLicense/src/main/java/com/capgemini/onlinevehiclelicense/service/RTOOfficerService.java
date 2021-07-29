package com.capgemini.onlinevehiclelicense.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.exception.ApplicationNotFoundException;
import com.capgemini.onlinevehiclelicense.exception.ChallanNotFoundException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.model.License;
import com.capgemini.onlinevehiclelicense.model.RTOOfficer;
import com.capgemini.onlinevehiclelicense.repository.IApplicationRepository;
import com.capgemini.onlinevehiclelicense.repository.IChallanRepository;
import com.capgemini.onlinevehiclelicense.repository.ILicenseRepository;
import com.capgemini.onlinevehiclelicense.repository.IRTOOfficerRepository;

public class RTOOfficerService implements IRTOOfficerService {

	IRTOOfficerRepository rtoofficerRepo;
	IApplicationRepository appRepo;
	IChallanRepository challanRepo;
	ILicenseRepository licenseRepo;
	@Override
	public ResponseEntity<RTOOfficer> officeLogin(RTOOfficer officer) {
		// TODO Auto-generated method stub
		Optional<RTOOfficer> findOfficer = rtoofficerRepo.findByEmail(officer.getEmail());
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
	public ResponseEntity<Application> viewAllPendingApplications() {
		// TODO Auto-generated method stub
		try {
			List<Application> pendingApplication=this.rtoofficerRepo.viewPendingApplications();
			if(pendingApplication!=null) {
				pendingApplication.forEach((application)->System.out.println(application));
				return new ResponseEntity<Application>(HttpStatus.OK);

			}

			else
				throw new ApplicationNotFoundException("No Application Found!!");
		}catch(ApplicationNotFoundException e)
		{
			return  new ResponseEntity<Application>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<Application> viewAllRejectedApplications() {
		// TODO Auto-generated method stub
		try {
			List<Application> rejectedApplication=this.rtoofficerRepo.viewAllRejectedApplications();
			if(rejectedApplication!=null) {
				rejectedApplication.forEach((application)->System.out.println(application));
				return new ResponseEntity<Application>(HttpStatus.OK);

			}

			else
				throw new ApplicationNotFoundException("No Application Found!!");
		}catch(ApplicationNotFoundException e)
		{
			return  new ResponseEntity<Application>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<Application> viewAllApprovedApplications() {

		try {
			List<Application> approvedApplication=this.rtoofficerRepo.viewApprovedApplications();
			if(approvedApplication!=null) {
				approvedApplication.forEach((application)->System.out.println(application));
				return new ResponseEntity<Application>(HttpStatus.OK);

			}

			else
				throw new ApplicationNotFoundException("No Application Found!!");
		}catch(ApplicationNotFoundException e)
		{
			return  new ResponseEntity<Application>(HttpStatus.NOT_FOUND);
		}
		// TODO Auto-generated method stub

	}

	@Override
	public ResponseEntity<Application> viewApplicationById(String applicationNumber) {
		
		try {
			List<Application> approvedApplication=this.rtoofficerRepo.viewApplicationbyId();
			if(approvedApplication!=null) {
				approvedApplication.forEach((application)->System.out.println(application));
				return new ResponseEntity<Application>(HttpStatus.OK);

			}

			else
				throw new ApplicationNotFoundException("No Application Found!!");
		}catch(ApplicationNotFoundException e)
		{
			return  new ResponseEntity<Application>(HttpStatus.NOT_FOUND);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseEntity<Challan> checkChallanByVehicleNumber(String vehicleNumber) {
		// TODO Auto-generated method stub
		try {
			List<Challan> challanByVehicleNumber = this.challanRepo.getDetailsByVehicleNumber(vehicleNumber);
			if(challanByVehicleNumber != null) {
				challanByVehicleNumber.forEach((ch) -> System.out.println(ch));
				//System.out.println(challanByVehicleNumber.toString());
				return new ResponseEntity<Challan>(HttpStatus.OK);
			}
			else
				throw new ChallanNotFoundException("Challans Not Found For this Vehicle Number!!!");
		} catch(ChallanNotFoundException ch) {
			return new ResponseEntity<Challan>(HttpStatus.NOT_FOUND);
		}
		 
	}

	@Override
	public List<Challan> checkAllChallan() {
		// TODO Auto-generated method stub
		return this.challanRepo.findAll();
	}

	@Override
	public Application modifyTestResultById(String applicationNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public License generateLearnerLicense(String applcationNumber) {
		Application matchApplication = this.appRepo.findById(applcationNumber)
				.orElseThrow(() -> new ApplicationNotFoundException("Application Not Found!!!"));
		License license = new License();
		license.setLicenseType("Learner");
		java.util.Date today=new java.util.Date(); 
		license.setDateOfIssue(today);
		Date validity = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 365 *5));
		license.setValidTill(validity);
		if(matchApplication.getStatus().equalsIgnoreCase("approved")) {
			this.licenseRepo.save(license);
		}
		return license;		
	}


	@Override
	public License generateDrivingLicense(String applcationNumber) {
		// TODO Auto-generated method stub
		Application matchApplication = this.appRepo.findById(applcationNumber)
				.orElseThrow(() -> new ApplicationNotFoundException("Application Not Found!!!"));
		License license = new License();
		license.setLicenseType("Driving");
		java.util.Date today=new java.util.Date(); 
		license.setDateOfIssue(today);
		Date validity = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 365 *5));
		license.setValidTill(validity);
		if(matchApplication.getStatus().equalsIgnoreCase("approved")) {
			this.licenseRepo.save(license);
		}
		return license;
	}

	@Override
	public String emailLicense(License license) {
		// TODO Auto-generated method stub
		return null;
	}


}
