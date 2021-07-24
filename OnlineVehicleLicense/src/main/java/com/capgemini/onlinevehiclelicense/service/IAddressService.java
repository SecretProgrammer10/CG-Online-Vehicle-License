package com.capgemini.onlinevehiclelicense.service;

import com.capgemini.onlinevehiclelicense.model.Address;

public interface IAddressService {
	public String enterState(Address addr_state);
	public String enterCity(Address addr_city);
	public String enterHouse(Address addr_house);
	public String enterLandmark(Address addr_landmark);
	public String enterPincode(Address addr_pincode);
	public String updateAddress(Address addr);
	public String viewAddress(Address addr);
	public String deleteAddress(Address addr);

}
