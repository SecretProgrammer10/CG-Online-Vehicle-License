package com.capgemini.onlinevehiclelicense.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;




@Entity
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="address_seq")
	@SequenceGenerator(name="address_seq",sequenceName="address_seq", allocationSize=1)
	private int addrId;
	private String house;
	private String state;
	private String city;
	private String landmark;
	private int pincode;
	
	
	public Address() {
		super();
	}


	public Address(int addrId, String house, String state, String city, String landmark, int pincode) {
		super();
		this.addrId = addrId;
		this.house = house;
		this.state = state;
		this.city = city;
		this.landmark = landmark;
		this.pincode = pincode;
	}


	public int getAddrId() {
		return addrId;
	}


	public String getHouse() {
		return house;
	}


	public void setHouse(String house) {
		this.house = house;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getLandmark() {
		return landmark;
	}


	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", house=" + house + ", state=" + state + ", city=" + city + ", landmark="
				+ landmark + ", pincode=" + pincode + "]";
	}


	
}