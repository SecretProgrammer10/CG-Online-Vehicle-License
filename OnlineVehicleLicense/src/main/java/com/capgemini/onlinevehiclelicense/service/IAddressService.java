package com.capgemini.onlinevehiclelicense.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.Address;
import com.capgemini.onlinevehiclelicense.model.TemporaryAddress;

public interface IAddressService {
	public ResponseEntity<String> addAddress(String username,Address addr);
	public ResponseEntity<String> addTemporaryAddress(String username, TemporaryAddress addr);
	public ResponseEntity<String> updateAddress(String username, Address addr, String addrId);
	public Address viewAddress(String username, String addrId);
	public ResponseEntity<String> deleteAddress(String username, String addrId);
	
}
