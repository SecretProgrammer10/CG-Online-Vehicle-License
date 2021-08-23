package com.capgemini.onlinevehiclelicense.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.model.RTOOffice;
import com.capgemini.onlinevehiclelicense.service.IRTOOfficeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4205")
@RestController
@RequestMapping("/rtoOffice")
@Api(value = "Online Vehicle License")
@Validated
public class RTOOfficeController {
	@Autowired
	private IRTOOfficeService rtoofficeService;
	
	@ApiOperation(value = "View RTOOffices", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Operation Successful"),
			@ApiResponse(code = 401, message = "You do not have the authorization to access this resource"),
			@ApiResponse(code = 403, message = "Access to this resource is forbidden"),
			@ApiResponse(code = 404, message = "The resource you are looking for does not exist/cannot be found")
	})
	@GetMapping("/view-all-rtooffices")
	public List<RTOOffice> viewAllRtoOffices() {
		return rtoofficeService.viewAllRtoOffices();
	}
	
	@ApiOperation(value = "View RTOOffice By rto_id")
	@GetMapping("/find-rtooffice-byId/{rto_id}")
	public RTOOffice findRtoOfficeById(
			@ApiParam(value = "rto_id param") @PathVariable("rto_id")int rto_id )
	{
		return rtoofficeService.findRtoOfficesById(rto_id);
		
	}
	
	@ApiOperation(value = "Add RTOOffice")
	@PostMapping("/add-rto-office")
	public ResponseEntity<String> addRTOOffice(@RequestBody RTOOffice rtoOffice){
		return this.rtoofficeService.addRTOOffice(rtoOffice);
	}
	
	@ApiOperation(value = "Get RTO Office Map")
	@GetMapping("/get-rto-office-map")
	public Map<Integer, String> getRtoOfficeMap(){
		return this.rtoofficeService.getRtoOfficeMap();
	}

}
