package com.capgemini.onlinevehiclelicense.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.Challan;

public interface IChallanService {

	public List<Challan> viewAllChallanDetails();
	public ResponseEntity<Challan> getDetailsByVehicleNumber(String vehicleNumber);
	public String payChallanByVehicleNumber(String vehicleNumber);
	
}
