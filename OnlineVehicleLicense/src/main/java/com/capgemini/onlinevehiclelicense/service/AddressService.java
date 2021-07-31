/**
 * 
 */
package com.capgemini.onlinevehiclelicense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Address;
import com.capgemini.onlinevehiclelicense.repository.IAddressRepository;

@Service
public class AddressService implements IAddressService{

	@Autowired
	private IAddressRepository addressRepository;
	
	@Override
	public ResponseEntity<Address> createAddress(Address addr) {
		// TODO Auto-generated method stub
		this.addressRepository.save(addr);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Address> updateAddress(Address addr, String addrId) {
		// TODO Auto-generated method stub
		Address matchAddress;
		try {
			matchAddress = this.addressRepository.findById(addrId)
					.orElseThrow(() -> new RecordNotFoundException("Address Not Found"));
			matchAddress.setApplicant(addr.getApplicant());
			matchAddress.setCity(addr.getCity());
			matchAddress.setHouse(addr.getHouse());
			matchAddress.setLandmark(addr.getLandmark());
			matchAddress.setPincode(addr.getPincode());
			matchAddress.setState(addr.getHouse());
			this.addressRepository.save(matchAddress);
			return ResponseEntity.ok().build();
			
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			return  new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	

	@Override
	public Address viewAddress(String addrId) {
		// TODO Auto-generated method stub
		try {
			return this.addressRepository.findById(addrId)
					.orElseThrow(() -> new RecordNotFoundException("Address Not Found"));
			
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public ResponseEntity<Address> deleteAddress(String addrId) {
		// TODO Auto-generated method stub
		Address matchAddress;
		try {
			matchAddress = this.addressRepository.findById(addrId)
					.orElseThrow(() -> new RecordNotFoundException("Address Not Found"));
			this.addressRepository.delete(matchAddress);
			return ResponseEntity.ok().build();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			return  new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
		}
		
	}
/*
	@Override
	public String viewAddressByType(Applicant appl , String type) {
		// TODO Auto-generated method stub
		Applicant matchApplicant = this.addressRepository.findAll();
		return null;
	}
*/
}
