package com.capgemini.onlinevehiclelicense.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.Address;

public interface IAddressService {
	public ResponseEntity<Address> createAddress(Address addr);
	public ResponseEntity<Address> updateAddress(Address addr, String addrId);
	public Address viewAddress(String addrId);
	public ResponseEntity<Address> deleteAddress(String addrId);
	
	
}
