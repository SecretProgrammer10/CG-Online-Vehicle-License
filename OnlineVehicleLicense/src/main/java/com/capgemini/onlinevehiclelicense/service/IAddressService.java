package com.capgemini.onlinevehiclelicense.service;

public interface IAddressService {
	public String createAddress(String addr_id);
	public String updateAddress(String addr_id);
	public String viewAddress(String addr_id);
	public String deleteAddress(String addr_id);
	
}
