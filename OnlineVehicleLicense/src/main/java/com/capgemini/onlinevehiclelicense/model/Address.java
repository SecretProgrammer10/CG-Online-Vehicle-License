package com.capgemini.onlinevehiclelicense.model;

public class Address {
	String state;
	String city;
	String house;
	String landmark;
	String pincode;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String state, String city, String house, String landmark, String pincode) {
		super();
		this.state = state;
		this.city = city;
		this.house = house;
		this.landmark = landmark;
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public String getCity() {
		return city;
	}
	public String getHouse() {
		return house;
	}
	public String getLandmark() {
		return landmark;
	}
	public String getPincode() {
		return pincode;
	}
	
}
