package com.capgemini.onlinevehiclelicense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.model.Address;
import com.capgemini.onlinevehiclelicense.model.AddressType;
import com.capgemini.onlinevehiclelicense.model.TemporaryAddress;
import com.capgemini.onlinevehiclelicense.service.IAddressService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4205")
@RestController
@RequestMapping("user/{username}/address")
public class AddressController {
	
	@Autowired
	private IAddressService addressService;
	
	@ApiOperation("Add Address")
	@PostMapping("/add-address")
	public ResponseEntity<String> addAddress(@PathVariable("username") String username, @RequestBody Address addr){
		return this.addressService.addAddress(username, addr);
	}
	
	@ApiOperation("Add Temporary Address")
	@PostMapping("/add-temporary-address/{same}")
	public ResponseEntity<String> addTemporaryAddress(@PathVariable("username") String username,@RequestBody TemporaryAddress tempAddr,
			@PathVariable("same") boolean same){
		return this.addressService.addTemporaryAddress(username, tempAddr, same);
	}
	
	@ApiOperation("Update Operation")
	@PutMapping("/update-address/{addressType}")
	public ResponseEntity<String> updateAddress(@PathVariable("username") String username,@RequestBody Address addr,
			@PathVariable("addressType") AddressType addrType){
		return this.addressService.updateAddress(username, addr, addrType);
	}
	
	@ApiOperation("View Permanent Address")
	@GetMapping("/view-permanent-address")
	public Address viewAddress(@PathVariable("username") String username) {
		return this.addressService.viewAddress(username);
	}
	
	@ApiOperation("View Present Address")
	@GetMapping("/view-present-address")
	public TemporaryAddress viewPresentAddress(@PathVariable("username") String username) {
		return this.addressService.viewPresentAddress(username);
	}
	
	@ApiOperation("Delete Address")
	@DeleteMapping("/delete-address/{addressType}")
	public ResponseEntity<String> deleteAddress(@PathVariable("username") String username, @PathVariable("addressType") AddressType addrType){
		return this.addressService.deleteAddress(username, addrType);
	}
}
