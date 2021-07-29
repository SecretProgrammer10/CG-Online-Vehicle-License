package com.capgemini.onlinevehiclelicense.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.model.License;
import com.capgemini.onlinevehiclelicense.model.RTOOfficer;

public interface IRTOOfficerService {


	public ResponseEntity<RTOOfficer> officeLogin(RTOOfficer officer);
	public ResponseEntity<Application> viewAllPendingApplications();
	public ResponseEntity<Application> viewAllRejectedApplications();
	public ResponseEntity<Application> viewAllApprovedApplications();
	public ResponseEntity<Application> viewApplicationById(String applicationNumber);
	public ResponseEntity<Challan> checkChallanByVehicleNumber(String vehicleNumber);
	public List<Challan> checkAllChallan();
	public Application modifyTestResultById(String applicationNumber);
	public License generateLearnerLicense(String applcationNumber);
	public License generateDrivingLicense(String applcationNumber);
	public String emailLicense(License license);
	
}
