package com.capgemini.onlinevehiclelicense.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.service.IChallanService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/challan")
@Api(value = "Online Vehicle License")
@Validated
public class ChallanController {

	@Autowired
	private IChallanService challanService;
	
	@ApiOperation(value = "View Challans", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Operation Successful"),
			@ApiResponse(code = 401, message = "You do not have the authorization to access this resource"),
			@ApiResponse(code = 403, message = "Access to this resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource you are looking for does not exist/cannot be found")
	})
	@GetMapping("/view-all-challan")
	public List<Challan> viewAllChallan() {
		return challanService.viewAllChallanDetails();
	}
	
	@ApiOperation(value = "View Challan By Vehicle Number")
	@GetMapping("/get-challan-details/{vehicleNumber}")
	public Challan viewChallanDetailsByVehicleNumber(
			@ApiParam(value = "Vehicle Number used to retrive challans") @PathVariable("vehicleNumber") String vehicleNumber) {
		return challanService.getDetailsByVehicleNumber(vehicleNumber);
	}
	
	@PutMapping("/pay-challan/{vehicleNumber}")
	public String payChallanByVehicleNumber(@PathVariable("vehicleNumber") String vehicleNumber) {
		return challanService.payChallanByVehicleNumber(vehicleNumber);
	}
	
}
