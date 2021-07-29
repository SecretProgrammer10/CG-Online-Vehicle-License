package com.capgemini.onlinevehiclelicense.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;




@Entity
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="address_seq")
	@SequenceGenerator(name="address_seq",sequenceName="address_seq", allocationSize=1)
	@Column(name="addr_id")
	private String addrId;
	@Column(name="house")
	private String house;
	@Column(name="state")
	private String state;
	@Column(name="city")
	private String city;
	@Column(name="landmark")
	private String landmark;
	@Column(name="pincode")
	private int pincode;
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="applicant_id")
	private Applicant applicant;
//	@Column(name="type")
//	private String type;
	
	public Address() {
		super();
	}


	public Address(String addrId, String house, String state, String city, String landmark, int pincode, Applicant applicant) {
		super();
		this.addrId = addrId;
		this.house = house;
		this.state = state;
		this.city = city;
		this.landmark = landmark;
		this.pincode = pincode;
		this.applicant = applicant;
	}


	public String getAddrId() {
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
	
	public Applicant getApplicant() {
		return applicant;
	}
	
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", house=" + house + ", state=" + state + ", city=" + city + ", landmark="
				+ landmark + ", pincode=" + pincode + ", applicant=" + applicant + "]";
	}


	
}