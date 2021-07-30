package com.capgemini.onlinevehiclelicense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.License;
import com.capgemini.onlinevehiclelicense.repository.ILicenseRepository;


@Service
public class LicenseService implements ILicenseService {

	@Autowired
	private ILicenseRepository licenseRepository;

	@Override
	public ResponseEntity<License> addLicense(License license) {
		// TODO Auto-generated method stub
		Optional<License> findLicense = this.licenseRepository.findById(license.getLicenseNumber());
		try {
			if(!findLicense.isPresent()) {
				this.licenseRepository.save(license);
				return new ResponseEntity<License>(HttpStatus.CREATED);
			}
			else
				throw new RecordAlreadyPresentException("License Already Issued to User!!!");
		} catch(RecordAlreadyPresentException e) {
			e.printStackTrace();
			return new ResponseEntity<License>(HttpStatus.ALREADY_REPORTED);
		}
		
	}

	@Override
	public ResponseEntity<License> renewLicense(License license, String licenseNumber) {
		// TODO Auto-generated method stub
		License matchLicense;
		try {
			matchLicense = this.licenseRepository.findById(licenseNumber)
					.orElseThrow(() -> new RecordNotFoundException("License Not Found!!!"));
			matchLicense.setDateOfIssue(license.getDateOfIssue());
			matchLicense.setValidTill(license.getValidTill());
			this.licenseRepository.save(matchLicense);
			return new ResponseEntity<License>(HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<License>(HttpStatus.NOT_FOUND);
		}
		
	}

	@Override
	public List<License> viewAllLicense() {
		// TODO Auto-generated method stub
		return this.licenseRepository.findAll();
	}

	@Override
	public License viewLicenseByNumber(String licenseNumber) {
		// TODO Auto-generated method stub
		try {
			return this.licenseRepository.findById(licenseNumber)
					.orElseThrow(() -> new RecordNotFoundException("License Not Found!!!"));
		} catch(RecordNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public License viewLicenseByType(String licenseType) {
		// TODO Auto-generated method stub
		try {
			return this.licenseRepository.viewLicenseByType(licenseType)
					.orElseThrow(() -> new RecordNotFoundException("License does not exist!!!"));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResponseEntity<License> deleteLicense(String licenseNumber) {
		// TODO Auto-generated method stub
		License matchLicense;
		try {
			matchLicense = this.licenseRepository.findById(licenseNumber)
					.orElseThrow(() -> new RecordNotFoundException("License Not Found!!!"));
			this.licenseRepository.delete(matchLicense);
			return new ResponseEntity<License>(HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<License>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
}
