package com.capgemini.onlinevehiclelicense.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.model.License;
import com.capgemini.onlinevehiclelicense.service.ILicenseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/license")
@Api(value = "Online Vehicle License")
@Validated
public class LicenseController {

	@Autowired
	private ILicenseService licenseService;
	
	@ApiOperation(value = "View Page of All Licenses", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Operation Successful"),
			@ApiResponse(code = 401, message = "You do not have the authorization to access this resource"),
			@ApiResponse(code = 403, message = "Access to this resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource you are looking for does not exist/cannot be found")
	})
	@GetMapping("/view-all-licenses")
	public Page<License> viewAllLicense(Pageable pageable) {
		return licenseService.viewAllLicense(pageable);
	}
	
	@ApiOperation(value = "View License By License Number")
	@GetMapping("/view-license/{licenseNumber}")
	public License viewLicenseByLicenseNumber(
			@ApiParam(value = "License Type Based on which to retrieve license details") @PathVariable("licenseNumber") String licenseNumber) {
		return licenseService.viewLicenseByNumber(licenseNumber);
	}
	
	@ApiOperation(value = "View License By Type")
	@GetMapping("/view-license-by-type/{licenseType}")
	public License viewLicenseByType(
			@ApiParam(value = "License Type Based on which to retrieve license details") @PathVariable("licenseType") String licenseType) {
		return licenseService.viewLicenseByType(licenseType);
	}
}
