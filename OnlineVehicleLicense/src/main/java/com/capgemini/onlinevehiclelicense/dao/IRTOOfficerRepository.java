package com.capgemini.onlinevehiclelicense.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.License;
import com.capgemini.onlinevehiclelicense.model.RTOOfficer;


@Repository
public interface IRTOOfficerRepository extends JpaRepository<RTOOfficer,Integer> {
	
	public String login(RTOOfficer officer);
	public List<Application> getAllPendingApplications();
	public List<Application> getAllRejectedApplications();
	public List<Application> getAllApprovedApplications();
	public Application getApplicationById(String applicationNumber);
	public Application updateApplicationById(String applicationNumber);
	public License createLearnerLicense(String applicationNumber);
	public License createDrivingLicense(String applicationNumber);
	
	
	
}
