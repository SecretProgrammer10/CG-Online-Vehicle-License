package com.capgemini.onlinevehiclelicense.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.Appointment;

@Repository
public interface IApplicationRepository extends JpaRepository<Application, String> {

	@Query("select a from Application a where a.applicationNumber like ?1")
	Application getApplicationByNumber(String applicationNumber);

	@Query("select a from Application a where a.rtoOffice.rtoId like ?1")
	Set<Application> getApplications(int rtoId);

}
