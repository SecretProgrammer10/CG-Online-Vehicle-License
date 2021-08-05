package com.capgemini.onlinevehiclelicense.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.License;
import com.capgemini.onlinevehiclelicense.model.LicenseType;
import com.capgemini.onlinevehiclelicense.model.RTOOffice;
import com.capgemini.onlinevehiclelicense.repository.IApplicationRepository;
import com.capgemini.onlinevehiclelicense.repository.ILicenseRepository;
import com.capgemini.onlinevehiclelicense.repository.IRTOOfficeRepository;


@Service
public class LicenseService implements ILicenseService {

	@Autowired
	private ILicenseRepository licenseRepository;
	
	@Autowired
	private IApplicationRepository applicationRepository;
	
	@Autowired
	private IRTOOfficeRepository rtoOfficeRepository;

	@Override
	public ResponseEntity<String> issueLearnerLicense(int rtoId, String applicationNumber, License license) {
		// TODO Auto-generated method stub
		Application application = this.applicationRepository.getApplicationByNumber(applicationNumber);
		Optional<License> findLicense = this.licenseRepository.findById(license.getLicenseNumber());
		RTOOffice rtoOffice;
		if(application.getApplicationStatus().toString().equalsIgnoreCase("approved")) {
			try {
				if(!findLicense.isPresent()) {
					rtoOffice = this.rtoOfficeRepository.findById(rtoId)
							.orElseThrow(() -> new RecordNotFoundException("No Matching RTOOffice found!"));
					license.setApplication(application);
					license.setRtoOffice(rtoOffice);
					license.setLicenseType(LicenseType.LL);
					this.licenseRepository.save(license);
					return new ResponseEntity<String>("License Issued Successfully!", HttpStatus.CREATED);
				}
				else
					throw new RecordAlreadyPresentException("Learner License Already Issued to Users!!!");
			} catch (RecordNotFoundException e1) {
			// TODO Auto-generated catch block
				e1.printStackTrace();
				return new ResponseEntity<String>("No Matching RTOOffice found!", HttpStatus.NOT_FOUND);
			} catch (RecordAlreadyPresentException e) {
				e.printStackTrace();
				return new ResponseEntity<String>("License Already Issued to User!", HttpStatus.ALREADY_REPORTED);
			}
		}
		else {
			return new ResponseEntity<String>("Application Status is not Approved!", HttpStatus.FORBIDDEN);
		}
	}
	
	public ResponseEntity<String> issueDriverLicense(String licenseNumber) {
		// TODO Auto-generated method stub
		Optional<License> findLicense = this.licenseRepository.findById(licenseNumber);
		try {
			if(findLicense.isPresent() && findLicense.get().getLicenseType().equals(LicenseType.LL)) {
				License license = findLicense.get();
				license.setLicenseType(LicenseType.DL);
				this.licenseRepository.save(license);
				return new ResponseEntity<String>("License Issued Successfully!", HttpStatus.CREATED);
			}
			else
				throw new RecordAlreadyPresentException("License Already Issued!");
		} catch (RecordAlreadyPresentException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("License Already Issued to User!", HttpStatus.ALREADY_REPORTED);
		}
	}

	@Override
	public ResponseEntity<String> renewLicense(String licenseNumber, Date dateOfIssue, Date validTill) {
		// TODO Auto-generated method stub
		License matchLicense;
		try {
			matchLicense = this.licenseRepository.findById(licenseNumber)
					.orElseThrow(() -> new RecordNotFoundException("License Not Found!!!"));
			matchLicense.setDateOfIssue(dateOfIssue);
			matchLicense.setValidTill(validTill);
			this.licenseRepository.save(matchLicense);
			return new ResponseEntity<String>("License Renewed Successfully", HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("No such License Found", HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Page<License> viewAllLicense(Pageable pageable) {
		// TODO Auto-generated method stub
		return this.licenseRepository.findAll(pageable);
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
	public ResponseEntity<String> deleteLicense(String licenseNumber) {
		// TODO Auto-generated method stub
		License matchLicense;
		try {
			matchLicense = this.licenseRepository.findById(licenseNumber)
					.orElseThrow(() -> new RecordNotFoundException("License Not Found!!!"));
			this.licenseRepository.delete(matchLicense);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
