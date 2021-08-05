package com.capgemini.onlinevehiclelicense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.mail.IMailService;
import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.ApplicationStatus;
import com.capgemini.onlinevehiclelicense.model.Appointment;
import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.model.RTOOffice;
import com.capgemini.onlinevehiclelicense.model.RTOOfficer;
import com.capgemini.onlinevehiclelicense.model.TestResult;
import com.capgemini.onlinevehiclelicense.repository.IApplicationRepository;
import com.capgemini.onlinevehiclelicense.repository.IAppointmentRepository;
import com.capgemini.onlinevehiclelicense.repository.IChallanRepository;
import com.capgemini.onlinevehiclelicense.repository.IRTOOfficeRepository;
import com.capgemini.onlinevehiclelicense.repository.IRTOOfficerRepository;
import org.springframework.data.domain.Pageable;


@Service
public class RTOOfficerService implements IRTOOfficerService {

	@Autowired
	private IRTOOfficerRepository rtoOfficerRepository;
	@Autowired
	private IApplicationRepository applicationRepository;
	@Autowired
	private IChallanRepository challanRepository;
	@Autowired
	private IAppointmentRepository appointmentRepository;
	@Autowired
	private IMailService mailService;
	@Autowired
	private IRTOOfficeRepository rtoOfficeRepository;
	
	@Override
	public ResponseEntity<String> officeLogin(String username, String pass) {
		// TODO Auto-generated method stub
		//Optional<RTOOfficer> findOfficer = rtoOfficerRepository.findById(username);
		try {
			if(username.equals("user"))
			{
				if(pass.equals("pass")) {
					return new ResponseEntity<String>("Logged In!", HttpStatus.OK);
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
			return  new ResponseEntity<String>("Email or Password is incorrect!!", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Application> viewAllPendingApplications() {
		// TODO Auto-generated method stub
		return rtoOfficerRepository.viewPendingApplications(ApplicationStatus.PENDING);
	}

	@Override
	public List<Application> viewAllRejectedApplications() {
		// TODO Auto-generated method stub
		return rtoOfficerRepository.viewAllRejectedApplications(ApplicationStatus.REJECTED);
	}

	@Override
	public List<Application> viewAllApprovedApplications() {

		return rtoOfficerRepository.viewApprovedApplications(ApplicationStatus.APPROVED);
    
	}

	@Override
	public List<Challan> checkAllChallan() {
		// TODO Auto-generated method stub
		return this.challanRepository.findAll();
	}

	@Override
	public ResponseEntity<String> modifyTestResultById(String applicantNumber, TestResult testResult) {
		// TODO Auto-generated method stub
		try {
			Appointment findAppointment = this.appointmentRepository.findById(applicantNumber)
					.orElseThrow(() -> new RecordNotFoundException("No such appointment found!!!"));
			Application findApplication = this.applicationRepository.findById(findAppointment.getApplication().getApplicationNumber())
					.orElseThrow(() -> new RecordNotFoundException("No such application found!!!"));
			if(testResult.toString().equalsIgnoreCase("pass")) {
				findAppointment.setTestResult(testResult);
				findApplication.setApplicationStatus(ApplicationStatus.APPROVED);
			}
			else {
				findAppointment.setTestResult(testResult);
				findApplication.setApplicationStatus(ApplicationStatus.REJECTED);
			}
			this.appointmentRepository.save(findAppointment);
			return new ResponseEntity<String>("Test Result Set!", HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("No such application/appointment found!", HttpStatus.NOT_FOUND);
		}
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
			mailService.sendMailWithAttachment(toAddress, subject, message, "License.txt");
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
	public Page<Appointment> viewAllAppointments(Pageable pageable) {
		// TODO Auto-generated method stub
		
		return this.appointmentRepository.findAll(pageable);
	}
	
	
	@Override
	public Page<Application> viewAllApplications(Pageable pageable) {
		// TODO Auto-generated method stub
		return this.applicationRepository.findAll(pageable);
	}

	@Override
	public ResponseEntity<String> addRTOOfficer(int rtoId, RTOOfficer officer) {
		// TODO Auto-generated method stub
		Optional<RTOOffice> rtoOffice = this.rtoOfficeRepository.findById(rtoId);
		if(!rtoOffice.isPresent()){
			return new ResponseEntity<String>("RTO office not found",HttpStatus.NOT_FOUND);
		} else {
			Optional<RTOOfficer> rtoOfcr = this.rtoOfficerRepository.findById(officer.getUsername());
			if(!rtoOfcr.isPresent()) {
				officer.setRtoOffice(rtoOffice.get());
				this.rtoOfficerRepository.save(officer);
				return new ResponseEntity<String>("RTO Officer is successfully added",HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("RTO Officer is already present",HttpStatus.ALREADY_REPORTED);
			}
		}	
	}	
}