package com.capgemini.onlinevehiclelicense.service;

import java.util.List;

import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.License;
import com.capgemini.onlinevehiclelicense.model.RTOOfficer;

public interface IRTOOfficerService {


	public String officeLogin(RTOOfficer officer);
	public List<Application> viewAllPendingApplications();
	public List<Application> viewAllRejectedApplications();
	public List<Application> viewAllApprovedApplications();
	public Application viewApplicationById(String applicationNumber);
	public String checkChallanByVehicleNumber(String vehicleNumber);
	public String checkAllChallan();
	public Application modifyTestResultById(String applicationNumber);
	public License generateLearnerLicense(String applcationNumber);
	public License generateDrivingLicense(String applcationNumber);
	public String emailLicense(License license);
}
