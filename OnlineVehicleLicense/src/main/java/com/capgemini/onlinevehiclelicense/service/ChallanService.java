package com.capgemini.onlinevehiclelicense.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.ChallanNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.repository.IChallanRepository;

@Service
public class ChallanService implements IChallanService {

	@Autowired
	private IChallanRepository challanRepository;
	

	@Override
	public String payChallanByVehicleNumber(String vehicleNumber) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Challan> viewAllChallanDetails() {
		// TODO Auto-generated method stub
		return this.challanRepository.findAll();
	}


	@Override
	public ResponseEntity<Challan> getDetailsByVehicleNumber(String vehicleNumber) {
		// TODO Auto-generated method stub
		try {
			List<Challan> challanByVehicleNumber = this.challanRepository.getDetailsByVehicleNumber(vehicleNumber);
			if(challanByVehicleNumber != null) {
				challanByVehicleNumber.forEach((ch) -> System.out.println(ch));
				//System.out.println(challanByVehicleNumber.toString());
				return new ResponseEntity<Challan>(HttpStatus.OK);
			}
			else
				throw new ChallanNotFoundException("Challans Not Found For this Vehicle Number!!!");
		} catch(ChallanNotFoundException ch) {
			return new ResponseEntity<Challan>(HttpStatus.NOT_FOUND);
		}
		 
	}

}
