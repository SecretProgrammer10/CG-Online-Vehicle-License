package com.capgemini.onlinevehiclelicense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.RTOOffice;
import com.capgemini.onlinevehiclelicense.service.IRTOOfficeService;

@RestController
@RequestMapping("/rtoOffice")
public class RTOOfficeController {
	@Autowired
	private IRTOOfficeService rtoofficeService;
	
	@GetMapping("/view-all-rtooffices")
	public List<RTOOffice> viewAllRtoOffices(@RequestBody RTOOffice rtooffice) {
		return rtoofficeService.viewAllRtoOffices();
	}
	
	@GetMapping("/find-rtooffice-byId{rto_id}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<RTOOffice> findRtoOfficesById(@PathVariable("rto_id")int rto_id )
	{
		return rtoofficeService.findRtoOfficesById(rto_id);
		
	}
	

}
