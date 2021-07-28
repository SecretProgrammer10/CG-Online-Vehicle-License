package com.capgemini.onlinevehiclelicense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.service.IChallanService;

@RestController
@RequestMapping("/challan")
public class ChallanController {

	@Autowired
	private IChallanService challanService;
	
	@RequestMapping("/view-all-challan")
	public List<Challan> viewAllChallan() {
		return challanService.viewAllChallanDetails();
	}
	
	@RequestMapping("/get-challan-details/{vehicleNumber}")
	public ResponseEntity<Challan> viewChallanDetailByVehicleNumber(@PathVariable("vehicleNumber") String vehicleNumber) {
		return challanService.getDetailsByVehicleNumber(vehicleNumber);
	}
	
	@RequestMapping("/pay-challan/{vehicleNumber}")
	public String payChallanByVehicleNumber(@PathVariable("vehicleNumber") String vehicleNumber) {
		return challanService.payChallanByVehicleNumber(vehicleNumber);
	}
	
}
