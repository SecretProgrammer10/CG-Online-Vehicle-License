package com.capgemini.onlinevehiclelicense.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.service.IChallanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4205")
@RestController
@RequestMapping("/challan")
@Api(value = "Online Vehicle License")
@Validated
public class ChallanController {

	@Autowired
	private IChallanService challanService;
	
	@ApiOperation(value = "Add Challans", response = List.class)
	@PostMapping("/add-challan")
	public ResponseEntity<String> addChallan(
			@ApiParam("Applicant ID") @RequestParam String applicantId, 
			@ApiParam("Challan Details") @RequestBody Challan challan){
		return this.challanService.addChallan(applicantId, challan);
	}
	
	@ApiOperation(value = "View Challans", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Operation Successful"),
			@ApiResponse(code = 401, message = "You do not have the authorization to access this resource"),
			@ApiResponse(code = 403, message = "Access to this resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource you are looking for does not exist/cannot be found")
	})
	@GetMapping("/view-all-challan")
	public Page<Challan> viewAllChallan(Pageable pageable) {
		return challanService.viewAllChallanDetails(pageable);
	}
	
	@ApiOperation(value = "View Challan By Vehicle Number")
	@GetMapping("/view-challan")
	public List<Challan> viewChallanByVehicleNumber(
			@ApiParam(value = "Vehicle Number used to retrive challans") @RequestParam String vehicleNumber) {
		return challanService.getChallanByVehicleNumber(vehicleNumber);
	}
	
	@ApiOperation(value = "Pay Challan")
	@PutMapping("/pay-challan/{challanNumber}")
	public String payChallan(
			@ApiParam(value = "Challan Number") @PathVariable("challanNumber") String challanNumber) {
		return challanService.payChallan(challanNumber);
	}
	
	@ApiOperation(value = "View Challan Details By Challan Number")
	@GetMapping("/view-challan-details")
	public Challan viewChallanDetailsByChallanNumber(
			@ApiParam(value = "Challan Number") @RequestParam String challanNumber) {
		return this.challanService.getChallanDetailsByChallanNumber(challanNumber);
	}
	
}
