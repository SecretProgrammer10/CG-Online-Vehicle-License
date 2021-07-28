package com.capgemini.onlinevehiclelicense.service;

import com.capgemini.onlinevehiclelicense.model.Address;

public interface IAddressService {
	public String createAddress(Address addr);
	public String updateAddress(Address addr, String addr_id);
	public String viewAddress(String addr_id);
	public String deleteAddress(String addr_id);
	
}
