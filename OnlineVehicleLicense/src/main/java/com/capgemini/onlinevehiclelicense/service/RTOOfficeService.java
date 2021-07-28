package com.capgemini.onlinevehiclelicense.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.RTOOffice;
import com.capgemini.onlinevehiclelicense.repository.IRTOOfficeRepository;

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
	public ResponseEntity<RTOOffice> findRtoOfficesById(int rto_id) {
		// TODO Auto-generated method stub
		Optional<RTOOffice> findById = rtoofficeRepo.findById(rto_id);
		try {
			if (findById.isPresent()) {
				RTOOffice findOffice = findById.get();
				return new ResponseEntity<RTOOffice>(findOffice, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + rto_id);
		} catch (RecordNotFoundException e) {
			
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}
	

}
