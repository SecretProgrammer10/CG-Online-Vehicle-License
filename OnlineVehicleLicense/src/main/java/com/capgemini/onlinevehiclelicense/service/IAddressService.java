package com.capgemini.onlinevehiclelicense.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.Address;
import com.capgemini.onlinevehiclelicense.model.AddressType;
import com.capgemini.onlinevehiclelicense.model.TemporaryAddress;

public interface IAddressService {
	public ResponseEntity<String> addAddress(String username,Address addr);
	public ResponseEntity<String> addTemporaryAddress(String username, TemporaryAddress addr, boolean same);
	public ResponseEntity<String> updateAddress(String username, Address addr, AddressType addrId);
	public Address viewAddress(String username);
	public ResponseEntity<String> deleteAddress(String username, AddressType addrId);
	public TemporaryAddress viewPresentAddress(String username);
	
}
