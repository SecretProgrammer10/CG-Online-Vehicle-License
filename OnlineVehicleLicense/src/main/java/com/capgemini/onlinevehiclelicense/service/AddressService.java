/**
 * 
 */
package com.capgemini.onlinevehiclelicense.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Address;
import com.capgemini.onlinevehiclelicense.model.AddressType;
import com.capgemini.onlinevehiclelicense.model.Applicant;
import com.capgemini.onlinevehiclelicense.model.TemporaryAddress;
import com.capgemini.onlinevehiclelicense.model.Users;
import com.capgemini.onlinevehiclelicense.repository.IAddressRepository;
import com.capgemini.onlinevehiclelicense.repository.IApplicantRepository;
import com.capgemini.onlinevehiclelicense.repository.ITemporaryAddressRepository;
import com.capgemini.onlinevehiclelicense.repository.IUserRepository;

@Service
public class AddressService implements IAddressService{

	@Autowired
	private IAddressRepository addressRepository;
	
	@Autowired
	private ITemporaryAddressRepository temporaryAddressRepository;
	
	@Autowired
	private IApplicantRepository applicantRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	static private boolean flag = false;
	@Override
	public ResponseEntity<String> addAddress(String username, Address addr, boolean same) {
		// TODO Auto-generated method stub
		try {
			Optional<Users> u = this.userRepository.findById(username);
			if(!u.isPresent()) {
				throw new RecordNotFoundException("User with username: "+username+" not found");
			}
			Applicant applicant = this.applicantRepository.findById(username)
					.orElseThrow(() -> new RecordNotFoundException("Applicant profile for "+username+" does not exist"));
			addr.setAddrId(username);
			addr.setApplicant(applicant);
			if(same) {
				flag = true;
				TemporaryAddress tempAddr = new TemporaryAddress();
				tempAddr.setAddrId(username);
				tempAddr.setApplicant(applicant);
				tempAddr.setCity(addr.getCity());
				tempAddr.setHouse(addr.getHouse());
				tempAddr.setLandmark(addr.getLandmark());
				tempAddr.setPincode(addr.getPincode());
				tempAddr.setState(addr.getState());
				this.temporaryAddressRepository.save(tempAddr);
			}
			this.addressRepository.save(addr);
			return new ResponseEntity<String>("Successfully saved address!",HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}	
	}
	
	@Override
	public ResponseEntity<String> addTemporaryAddress(String username, TemporaryAddress addr) {
		// TODO Auto-generated method stub
		if(!flag) {
			try {
				Optional<Users> u = this.userRepository.findById(username);
				if(!u.isPresent()) {
					throw new RecordNotFoundException("User with username: "+username+" not found");
				}
				Applicant applicant = this.applicantRepository.findById(username)
						.orElseThrow(() -> new RecordNotFoundException("Applicant profile for "+username+" does not exist"));
				addr.setAddrId(username);
				addr.setApplicant(applicant);
				this.temporaryAddressRepository.save(addr);
				return new ResponseEntity<String>("Successfully saved address!",HttpStatus.OK);
			} catch (RecordNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<String>("Temporary Address is same as Permanent Address",HttpStatus.FORBIDDEN);
		}
			
	}

	@Override
	public ResponseEntity<String> updateAddress(String username, Address addr, AddressType addrType) {
		// TODO Auto-generated method stub
		try {
			Optional<Users> u = this.userRepository.findById(username);
			if(!u.isPresent()) {
				throw new RecordNotFoundException("User with username: "+username+" not found");
			}				
			Address matchAddress;
			TemporaryAddress tmatchAddress;
			try {
				if(addrType==AddressType.PERMANENT) {
					matchAddress = this.addressRepository.findById(username)
							.orElseThrow(() -> new RecordNotFoundException(addrType+" address does not exist"));
					matchAddress.setApplicant(addr.getApplicant());
					matchAddress.setCity(addr.getCity());
					matchAddress.setHouse(addr.getHouse());
					matchAddress.setLandmark(addr.getLandmark());
					matchAddress.setPincode(addr.getPincode());
					matchAddress.setState(addr.getState());
					this.addressRepository.save(matchAddress);
					return new ResponseEntity<String>("Permanent Address updated successfully",HttpStatus.OK);
				}
				else {
					tmatchAddress = this.temporaryAddressRepository.findById(username)
							.orElseThrow(() -> new RecordNotFoundException(addrType+" address does not exist"));
					tmatchAddress.setApplicant(addr.getApplicant());
					tmatchAddress.setCity(addr.getCity());
					tmatchAddress.setHouse(addr.getHouse());
					tmatchAddress.setLandmark(addr.getLandmark());
					tmatchAddress.setPincode(addr.getPincode());
					tmatchAddress.setState(addr.getState());
					this.temporaryAddressRepository.save(tmatchAddress);
					return new ResponseEntity<String>("Temporary Address updated successfully",HttpStatus.OK);
				}
								
			} catch (RecordNotFoundException e) {
				// TODO Auto-generated catch block
				return  new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
		} catch (RecordNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return new ResponseEntity<String>(e1.getMessage(),HttpStatus.NOT_FOUND);
		}
			
	}
	

	@Override
	public Address viewAddress(String username) {
		// TODO Auto-generated method stub
		try {
			return this.addressRepository.findById(username)
					.orElseThrow(() -> new RecordNotFoundException("Address Not Found"));
			
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	@Override
	public TemporaryAddress viewPresentAddress(String username) {
		// TODO Auto-generated method stub
		try {
			return this.temporaryAddressRepository.findById(username)
					.orElseThrow(() -> new RecordNotFoundException("Address Not Found"));
			
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public ResponseEntity<String> deleteAddress(String username, AddressType addrType) {
		// TODO Auto-generated method stub
		Optional<Users> u = this.userRepository.findById(username);
		try {
			if(!u.isPresent()) {
				throw new RecordNotFoundException("User with username: "+username+" not found");
			}
			Address matchAddress;
			TemporaryAddress tempMatchAddress;
			try {
				if(addrType == AddressType.PERMANENT) {
					matchAddress = this.addressRepository.findById(username)
							.orElseThrow(() -> new RecordNotFoundException("Address Not Found"));
					this.addressRepository.delete(matchAddress);
					return new ResponseEntity<String>("Deleted",HttpStatus.OK);
				} else {
					tempMatchAddress = this.temporaryAddressRepository.findById(username)
							.orElseThrow(() -> new RecordNotFoundException("Address Not Found"));
					this.temporaryAddressRepository.delete(tempMatchAddress);
					return new ResponseEntity<String>("Deleted",HttpStatus.OK);
				}
				
			} catch (RecordNotFoundException e) {
				// TODO Auto-generated catch block
				return  new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
			
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
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
