package com.capgemini.onlinevehiclelicense.service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.Appointment;
import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.model.RTOOfficer;
import com.capgemini.onlinevehiclelicense.model.TestResult;

public interface IRTOOfficerService {

	public ResponseEntity<String> addRTOOfficer(int rtoId, RTOOfficer officer);
	public ResponseEntity<String> officeLogin(String username, String pass);
	public List<Application> viewAllPendingApplications();
	public List<Application> viewAllRejectedApplications();
	public List<Application> viewAllApprovedApplications();
	public Application viewApplicationById(String applicationNumber);
	public List<Challan> checkChallanByVehicleNumber(String vehicleNumber);
	public List<Challan> checkAllChallan();
	public ResponseEntity<String> modifyTestResultById(String applicantNumber, TestResult testResult);
	public String emailLicense(String applicationNumber, boolean pass);
	public Page<Appointment> viewAllAppointments(Pageable pageable);
	public Page<Application> viewAllApplications(Pageable pageable);
	
}
