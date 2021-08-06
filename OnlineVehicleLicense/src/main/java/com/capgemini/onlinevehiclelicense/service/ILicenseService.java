package com.capgemini.onlinevehiclelicense.service;


import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.License;
import com.capgemini.onlinevehiclelicense.model.LicenseType;

public interface ILicenseService {

	public ResponseEntity<String> issueLearnerLicense(int rtoId, String applicationNumber, License license);
	public ResponseEntity<String> issueDriverLicense(String applicationNumber, String licenseNumber);
	public ResponseEntity<String> renewLicense(String licenseNumber, Date dateOfIssue, Date validTill);
	public Page<License> viewAllLicense(Pageable pageable);
	public License viewLicenseByNumber(String licenseNumber);
	public License viewLicenseByType(LicenseType licenseType);
	public ResponseEntity<String> deleteLicense(String licenseNumber);
	
}
