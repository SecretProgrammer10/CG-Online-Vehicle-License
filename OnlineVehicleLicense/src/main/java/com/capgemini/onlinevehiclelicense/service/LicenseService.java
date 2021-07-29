package com.capgemini.onlinevehiclelicense.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.LicenseNotFoundException;
import com.capgemini.onlinevehiclelicense.model.License;
import com.capgemini.onlinevehiclelicense.repository.ILicenseRepository;


@Service
public class LicenseService implements ILicenseService {

	@Autowired
	private ILicenseRepository licenseRepository;

	@Override
	public ResponseEntity<License> addLicense(License license) {
		// TODO Auto-generated method stub
		this.licenseRepository.save(license);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<License> renewLicense(License license, String licenseNumber) {
		// TODO Auto-generated method stub
		License matchLicense = this.licenseRepository.viewLicenseByNumber(licenseNumber)
				.orElseThrow(() -> new LicenseNotFoundException("License Not Found!!!"));
		matchLicense.setDateOfIssue(license.getDateOfIssue());
		matchLicense.setValidTill(license.getValidTill());
		this.licenseRepository.save(matchLicense);
		return ResponseEntity.ok().build();
	}

	@Override
	public List<License> viewAllLicense() {
		// TODO Auto-generated method stub
		return this.licenseRepository.findAll();
	}

	@Override
	public License viewLicenseByNumber(String licenseNumber) {
		// TODO Auto-generated method stub
		return this.licenseRepository.viewLicenseByNumber(licenseNumber)
				.orElseThrow(() -> new LicenseNotFoundException("License Not Found!!!"));
	}

	@Override
	public ResponseEntity<License> viewLicenseByType(String licenseType) {
		// TODO Auto-generated method stub
		try {
			List<License> licenseByTypeList = this.licenseRepository.viewLicenseByType(licenseType);
			if(licenseByTypeList != null) {
				//System.out.println(licenseByTypeList.toString());
				licenseByTypeList.forEach((license) -> System.out.println(license));
				return new ResponseEntity<License>(HttpStatus.OK);
			}
			else
				throw new LicenseNotFoundException("No Licenses found for this License Type");
		} catch (LicenseNotFoundException le){
			return new ResponseEntity<License>(HttpStatus.NOT_FOUND); 
		}
	}

	@Override
	public ResponseEntity<License> deleteLicense(String licenseNumber) {
		// TODO Auto-generated method stub
		License matchLicense = this.licenseRepository.viewLicenseByNumber(licenseNumber)
				.orElseThrow(() -> new LicenseNotFoundException("License Not Found!!!"));
		this.licenseRepository.delete(matchLicense);
		return ResponseEntity.ok().build();
	}
	
}
