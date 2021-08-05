package com.capgemini.onlinevehiclelicense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Applicant;
import com.capgemini.onlinevehiclelicense.model.Challan;
import com.capgemini.onlinevehiclelicense.repository.IApplicantRepository;
import com.capgemini.onlinevehiclelicense.repository.IChallanRepository;

@Service
public class ChallanService implements IChallanService {

	@Autowired
	private IChallanRepository challanRepository;
	
	@Autowired
	private IApplicantRepository applicantRepository;

	@Override
	public String payChallan(String challanNumber) {
		// TODO Auto-generated method stub
		try {
			Optional<Challan> findChallan = this.challanRepository.findById(challanNumber);
			if(findChallan.isPresent()) {
				Challan challan = findChallan.get();
				challan.setStatus("Paid");
				this.challanRepository.save(challan);
				return challan.getStatus();
			}
			else {
				throw new RecordNotFoundException("Challan Does not Exist!!!");
			}
			
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Challan> getChallanByVehicleNumber(String vehicleNumber) {
		// TODO Auto-generated method stub
		return this.challanRepository.getChallanByVehicleNumber(vehicleNumber);
	}


	@Override
	public Page<Challan> viewAllChallanDetails(Pageable pageable) {
		// TODO Auto-generated method stub
		return this.challanRepository.findAll(pageable);
	}

	@Override
	public Challan getChallanDetailsByChallanNumber(String challanNumber) {
		// TODO Auto-generated method stub
		Challan challan;
		try {
			challan = this.challanRepository.findById(challanNumber)
					.orElseThrow(() -> new RecordNotFoundException(challanNumber));
			return challan;
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResponseEntity<String> addChallan(String applicantId, Challan challan) {
		// TODO Auto-generated method stub
		Optional<Applicant> findApplicant = this.applicantRepository.findById(applicantId);
		if(findApplicant.isPresent()) {
			challan.setApplicant(findApplicant.get());
			this.challanRepository.save(challan);
			return new ResponseEntity<String>("Challan Added!", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("Applicant not found!", HttpStatus.NOT_FOUND);
		}
	}
	
}
