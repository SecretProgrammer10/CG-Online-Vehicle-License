package com.capgemini.onlinevehiclelicense.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.exception.AddressNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Address;

public interface IAddressService {
	public ResponseEntity<Address> createAddress(Address addr);
	public ResponseEntity<Address> updateAddress(Address addr, String addrId) throws AddressNotFoundException;
	public Address viewAddress(String addrId);
	public ResponseEntity<Object> deleteAddress(String addrId);
	
	
}
