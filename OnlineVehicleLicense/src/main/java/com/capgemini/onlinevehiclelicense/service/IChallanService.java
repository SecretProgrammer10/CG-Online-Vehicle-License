package com.capgemini.onlinevehiclelicense.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.capgemini.onlinevehiclelicense.model.Challan;

public interface IChallanService {

	public Page<Challan> viewAllChallanDetails(Pageable pageable);
	public List<Challan> getChallanByVehicleNumber(String vehicleNumber);
	public Challan getChallanDetailsByChallanNumber(String challanNumber);
	public String payChallan(String challanNumber);
	
}
