package com.capgemini.onlinevehiclelicense.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.License;

public interface ILicenseService {

	public ResponseEntity<License> addLicense(License license);
	public ResponseEntity<License> renewLicense(License license, String licenseNumber);
	public List<License> viewAllLicense();
	public License viewLicenseByNumber(String licenseNumber);
	public ResponseEntity<License> viewLicenseByType(String licenseType);
	public ResponseEntity<License> deleteLicense(String licenseNumber);
	
}
