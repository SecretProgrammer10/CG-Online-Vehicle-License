package com.capgemini.onlinevehiclelicense.service;

import java.util.List;


import com.capgemini.onlinevehiclelicense.model.Challan;

public interface IChallanService {

	public List<Challan> viewAllChallanDetails();
	public List<Challan> getDetailsByVehicleNumber(String vehicleNumber);
	public String payChallan(String challanNumber);
	
}
