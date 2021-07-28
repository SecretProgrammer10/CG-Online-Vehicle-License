package com.capgemini.onlinevehiclelicense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.model.License;
import com.capgemini.onlinevehiclelicense.service.ILicenseService;

@RestController
@RequestMapping("/license")
public class LicenseController {

	@Autowired
	private ILicenseService licenseService;
	
	@RequestMapping("/add-license")
	public ResponseEntity<License> addLicense(@RequestBody License license) {
		return licenseService.addLicense(license);
	}
	
	@RequestMapping("/renew-license/{licenseNumber}")
	public ResponseEntity<License> renewLicense(@RequestBody License license, @PathVariable("licenseNumber") String licenseNumber) {
		return licenseService.renewLicense(license, licenseNumber);
	}
	
	@RequestMapping("/view-all-licenses")
	public List<License> viewAllLicense() {
		return licenseService.viewAllLicense();
	}
	
	@RequestMapping("/view-license/{licenseNumber}")
	public License viewLicenseByLicenseNumber(@PathVariable("licenseNumber") String licenseNumber) {
		return licenseService.viewLicenseByNumber(licenseNumber);
	}
	
	@RequestMapping("/view-license-by-type/{licenseType}")
	public ResponseEntity<License> viewLicenseByType(@PathVariable("licenseType") String licenseType) {
		return licenseService.viewLicenseByType(licenseType);
	}
	
	@RequestMapping("/delete-license/{licenseNumber}")
	public ResponseEntity<License> deleteLicense(@PathVariable("licenseNumber") String licenseNumber) {
		return licenseService.deleteLicense(licenseNumber);
	}
	
}
