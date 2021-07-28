package com.capgemini.onlinevehiclelicense.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.License;
import com.capgemini.onlinevehiclelicense.model.RTOOfficer;
import com.capgemini.onlinevehiclelicense.model.User;


@Repository
public interface IRTOOfficerRepository extends JpaRepository<RTOOfficer,Integer> {
	
	@Query("select r from Rto_officer r where r.email like ?1 ")
	public Optional<RTOOfficer> findByEmail(String email);
	
	@Query("select a from Application a where a.application_status like 'pending'")
	public List<Application> viewPendingApplications();
	
	@Query("select a from Application a where a.application_status like 'rejected'")
	public List<Application> viewAllRejectedApplications();
	
	@Query("select a from Application a where a.application_status like 'approved'")
	public List<Application> viewApprovedApplications();
	
	@Query("select * from Application a where a.application_number like ?1")
	public List<Application> viewApplicationbyId();
	
}
