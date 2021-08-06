package com.capgemini.onlinevehiclelicense.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.ApplicationStatus;
//import com.capgemini.onlinevehiclelicense.model.ApplicationStatus;
import com.capgemini.onlinevehiclelicense.model.Challan;
//import com.capgemini.onlinevehiclelicense.model.License;
import com.capgemini.onlinevehiclelicense.model.RTOOfficer;
//import com.capgemini.onlinevehiclelicense.model.Users;


@Repository
public interface IRTOOfficerRepository extends JpaRepository<RTOOfficer, String> {
	
	@Query("select r from RTOOfficer r where r.email like ?1 ")
	public Optional<RTOOfficer> findByEmail(String email);
	
	@Query("select a from Application a where a.applicationStatus like ?1")
	public List<Application> viewPendingApplications(ApplicationStatus pending);
	
	@Query("select a from Application a where a.applicationStatus like ?1")
	public List<Application> viewAllRejectedApplications(ApplicationStatus rejected);
	
	@Query("select a from Application a where a.applicationStatus like ?1")
	public List<Application> viewApprovedApplications(ApplicationStatus approved);
	
	@Query("select a from Application a where a.applicationNumber like ?1")
	public List<Application> viewApplicationbyId( String applicationNumber);

	@Query("select c from Challan c where c.vehicleNumber like ?1")
	public List<Challan> checkAllChallanByVehicleNumber(String vehicleNumber);
	
}
