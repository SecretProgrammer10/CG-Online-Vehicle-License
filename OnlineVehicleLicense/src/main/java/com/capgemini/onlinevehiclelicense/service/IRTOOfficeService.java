package com.capgemini.onlinevehiclelicense.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.RTOOffice;

public interface IRTOOfficeService {
	
	public List<RTOOffice> viewAllRtoOffices();
	public ResponseEntity<RTOOffice> findRtoOfficesById(int rto_id);

}
