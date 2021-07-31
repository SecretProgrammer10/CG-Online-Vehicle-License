package com.capgemini.onlinevehiclelicense.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinevehiclelicense.model.License;

@Repository
public interface ILicenseRepository extends JpaRepository<License, String> {
	
	@Query("select l from License l where l.licenseType like ?1")
	public Optional<License> viewLicenseByType(String licenseType);
	
}
