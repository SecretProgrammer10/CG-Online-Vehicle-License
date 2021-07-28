package com.capgemini.onlinevehiclelicense.service;

import com.capgemini.onlinevehiclelicense.model.Address;

public interface IAddressService {
	public String createAddress(Address addr);
	public String updateAddress(Address addr);
	public String viewAddress(Address addr);
	
}
