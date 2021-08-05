package com.capgemini.onlinevehiclelicense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.repository.IRTOOfficeRepository;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.RTOOffice;

@Service
public class RTOOfficeService implements IRTOOfficeService{
	
	@Autowired
	IRTOOfficeRepository rtoofficeRepo;
	@Override
	public List<RTOOffice> viewAllRtoOffices() {
		// TODO Auto-generated method stub
		
		return rtoofficeRepo.findAll();
	}

	@Override
	public RTOOffice findRtoOfficesById(int rto_id) {
		// TODO Auto-generated method stub
		try {
			RTOOffice  rtooffice= rtoofficeRepo.findById(rto_id)
					.orElseThrow(() -> new RecordNotFoundException("RTO Office Not Found!!!"));
			return rtooffice;
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	
	@Override
	public ResponseEntity<String> addRTOOffice(RTOOffice rtoOffice){
		Optional<RTOOffice> rtoOfc = this.rtoofficeRepo.findById(rtoOffice.getRtoId());
		if(!rtoOfc.isPresent()) {
			this.rtoofficeRepo.save(rtoOffice);
			return new ResponseEntity<String>("RTO Office added",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("RTO office alraedy present",HttpStatus.ALREADY_REPORTED);
		}
	}
	

}
