package com.capgemini.onlinevehiclelicense.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.repository.IChallanRepository;

@Service
public class ChallanService implements IChallanService {

	@Autowired
	private IChallanRepository challanRepository;
	

	@Override
	public String payChallan(String challanNumber) {
		// TODO Auto-generated method stub
		try {
			Challan findChallan = this.challanRepository.findById(challanNumber)
					.orElseThrow(() -> new RecordNotFoundException("Vehicle Does not Exist!!!"));
			findChallan.setStatus("Paid");
			this.challanRepository.save(findChallan);
			return findChallan.getStatus();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public List<Challan> viewAllChallanDetails() {
		// TODO Auto-generated method stub
		return this.challanRepository.findAll();
	}


	@Override
	public List<Challan> getDetailsByVehicleNumber(String vehicleNumber) {
		// TODO Auto-generated method stub
		return this.challanRepository.getDetailsByVehicleNumber(vehicleNumber);
	}
	
}
