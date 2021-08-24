package com.capgemini.onlinevehiclelicense.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

//import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.RTOOffice;

public interface IRTOOfficeService {
	
	public List<RTOOffice> viewAllRtoOffices();
	public RTOOffice findRtoOfficesById(int rto_id);
	public ResponseEntity<String> addRTOOffice(RTOOffice rtoOffice);
	public Map<Integer, String> getRtoOfficeMap();

}
