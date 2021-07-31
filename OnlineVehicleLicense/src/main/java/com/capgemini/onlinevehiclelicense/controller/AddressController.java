package com.capgemini.onlinevehiclelicense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Address;
import com.capgemini.onlinevehiclelicense.service.IAddressService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private IAddressService addressService;
	
	@ApiOperation("Add Address")
	@PostMapping("/add-address")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<Address> createAddress(@RequestBody Address addr){
		return this.addressService.createAddress(addr);
	}
	
	@ApiOperation("Update Operation")
	@PutMapping("/update-address/{addressId}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Address> updateAddress(@RequestBody Address addr,@PathVariable("addressId") String addrId){
		return this.addressService.updateAddress(addr, addrId);
	}
	
	@ApiOperation("View Address")
	@GetMapping("/view-address/{addressId}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Address viewAddress(@PathVariable("addressId") String addrId) {
		return this.addressService.viewAddress(addrId);
	}
	
	@ApiOperation("Delete Address")
	@DeleteMapping("/delete-address/{addressId}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Address> deleteAddress(@PathVariable("addressId") String addrId){
		return this.addressService.deleteAddress(addrId);
	}
}
